package org.gluu.flowless.dsl;

import freemarker.ext.dom.NodeModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.transform.Source;

import net.sf.saxon.dom.NodeOverNodeInfo;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.sapling.SaplingDocument;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.gluu.flowless.antlr.AuthnFlowLexer;
import org.gluu.flowless.antlr.AuthnFlowParser;
import org.gluu.flowless.dsl.error.SyntaxException;
import org.gluu.flowless.dsl.error.RecognitionErrorListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Transpiler {

    private static final String FTL_LOCATION = "JSGenerator.ftl";

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String flowId;
    private String flowName;
    private Set<String> flowNames;

    private Processor processor;
    private XPathCompiler xpathCompiler;
    private Template jsGenerator;

    public Transpiler(String flowId, String flowName, List<String> flowNames)
            throws TranspilerException {

        this.flowId = flowId;
        this.flowName = flowName;
        this.flowNames = Optional.ofNullable(flowNames).map(HashSet::new).orElse(null);
        
        if (Stream.of(flowNames, flowId).allMatch(Objects::nonNull)) {
            flowNames.remove(flowId);
        }

        processor = new Processor(false);
        xpathCompiler = processor.newXPathCompiler();
        xpathCompiler.setCaching(true);

        loadFreeMarkerTemplate();

    }
    
    private void loadFreeMarkerTemplate() throws TranspilerException {
        
        try{
            Configuration fmConfig = new Configuration(Configuration.VERSION_2_3_31);
            fmConfig.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "/");
            fmConfig.setDefaultEncoding(UTF_8.toString());
            //TODO: ?
            //fmConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            fmConfig.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
            fmConfig.setLogTemplateExceptions(false);
            fmConfig.setWrapUncheckedExceptions(true);
            fmConfig.setFallbackOnNullLoopVariable(false);
            jsGenerator = fmConfig.getTemplate(FTL_LOCATION);
        } catch (Exception e) {
            throw new TranspilerException("Template loading failed", e);
        }
        
    }

    public SaplingDocument asXML(String DSLCode) throws SyntaxException, TranspilerException {

        InputStream is = new ByteArrayInputStream(DSLCode.getBytes(UTF_8));
        CharStream input = null;

        try {
            logger.debug("Creating ANTLR CharStream from DSL code");
            //fromStream method closes the input stream upon returning
            input = CharStreams.fromStream(is);
        } catch (IOException ioe) {
            throw new TranspilerException(ioe.getMessage(), ioe);
        }

        AuthnFlowLexer lexer = new AuthnFlowLexer(input);
        RecognitionErrorListener lexerErrListener = new RecognitionErrorListener();
        lexer.addErrorListener(lexerErrListener);
        logger.debug("Lexer for grammar '{}' initialized", lexer.getGrammarFileName());
        
        logger.debug("Creating parser");
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AuthnFlowParser parser = new AuthnFlowParser(tokens);
        RecognitionErrorListener parserErrListener = new RecognitionErrorListener();
        parser.addErrorListener(parserErrListener);

        try {
            AuthnFlowParser.FlowContext flowContext = parser.flow();
            SyntaxException syntaxException = Stream.of(lexerErrListener, parserErrListener)
                    .map(RecognitionErrorListener::getError).filter(Objects::nonNull)
                    .findFirst().orElse(null);
            
            if (syntaxException != null) {
                throw syntaxException;
            }

            logger.debug("Traversing parse tree");
            //Generate XML representation

            SaplingDocument document = Visitor.document(flowContext, AuthnFlowParser.RULE_flow, flowId);
            applyValidations(document);
            logXml(document);
            return document;

        } catch (RecognitionException re) {
            Token offender = re.getOffendingToken();
            throw new SyntaxException(re.getMessage(), offender.getText(),
                    offender.getLine(), offender.getCharPositionInLine());
        }

    }

    public List<String> getInputs(Source doc) throws SaxonApiException {
        
        XdmNode node = processor.newDocumentBuilder().build(doc);
        return xpathCompiler.evaluate("/flow/header/inputs/short_var/text()", node)
                    .stream().map(XdmItem::getStringValue).collect(Collectors.toList());
    }
    
    public String generateJS(SaplingDocument doc) throws TranspilerException  {

        try {
            StringWriter sw = new StringWriter();
            NodeModel model = asNodeModel(doc);
            jsGenerator.process(model, sw);
            return sw.toString();
        } catch (IOException | TemplateException | SaxonApiException e) {
            throw new TranspilerException("Transformation failed", e);
        }


    }

    private void applyValidations(SaplingDocument doc) throws TranspilerException {

        try {
            XdmNode node = doc.toXdmNode(processor);
            
            if (flowName != null) {                
                //validate flow name is consistent
                XdmItem itemName = xpathCompiler.evaluateSingle(Visitor.FLOWNAME_XPATH_EXPR, node);
                String name = Optional.ofNullable(itemName).map(XdmItem::getStringValue).orElse("");  
                
                if (!flowName.equals(name)) {
                    throw new TranspilerException(
                        String.format("Expecting flow name '%s', but '%s' was found", flowName, name));
                }
            }
            
            //Ensure only existing flows are referenced
            //TODO: fix xpath expression - should account for extract ALPHANUM or DOTEXPR
            //checkUnknownInvocation("//flow_call/call/qname/ALPHANUM/text()", flowNames, node);

        } catch (SaxonApiException se) {
            throw new TranspilerException("Validation failed", se);
        }
        
    }

    private void checkUnknownInvocation(String xpathExpr, Set<String> known, XdmNode node) 
            throws TranspilerException, SaxonApiException {
        
        if (known != null) {
            List<String> invocations = xpathCompiler.evaluate(xpathExpr, node)
                    .stream().map(XdmItem::getStringValue).collect(Collectors.toList());

            for (String t : invocations) {
                if (!known.contains(t)) {
                    throw new TranspilerException("Invocation of unknown element '" + t + "'");
                }
            }
        }

    }
    
    private void logXml(SaplingDocument doc) {

        try {
            StringWriter sw = new StringWriter();
            Serializer serializer = processor.newSerializer(sw);
            serializer.setOutputProperty(Serializer.Property.INDENT, "true");

            logger.debug("Serializing XML document");
            doc.serialize(serializer);

            logger.debug("\n{}", sw.toString());
        } catch (SaxonApiException e) {
            logger.error(e.getMessage(), e);
        }

    }
    
    private NodeModel asNodeModel(SaplingDocument doc) throws SaxonApiException {
        return NodeModel.wrap(NodeOverNodeInfo.wrap(
                doc.toXdmNode(processor).getUnderlyingNode()));
    }

    public static void main(String... args) throws Exception {
        
        Transpiler tr = new Transpiler("main_test1", "test1"/*org.gluu.Main"*/, null);
        String dslCode = new String(Files.readAllBytes(Paths.get(args[0])), UTF_8);
        SaplingDocument doc = tr.asXML(dslCode);
        System.out.println(tr.getInputs(doc));
        System.out.println("\n" + tr.generateJS(doc));

        //tr.qTest(args[0]+".xml");
    }
    
    public void qTest(String fileName) throws Exception {
        NodeModel model = NodeModel.parse(Paths.get(fileName).toFile());
        jsGenerator.process(model, new OutputStreamWriter(System.out));       
    }

}
