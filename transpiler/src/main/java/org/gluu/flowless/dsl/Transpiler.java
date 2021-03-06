package org.gluu.flowless.dsl;

import freemarker.ext.dom.NodeModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private Set<String> flowNames;

    private Processor processor;
    private XPathCompiler xpathCompiler;
    private Template jsGenerator;

    public Transpiler(String flowId, List<String> flowNames)
            throws TranspilerException {

        this.flowId = flowId;
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
            } else if (!lexer._hitEOF) {
                throw new SyntaxException("Unable to process the input code thoroughly",
                        lexer.getText(), lexer.getLine(), lexer.getCharPositionInLine());                
            }

            logger.debug("Traversing parse tree");
            //Generate XML representation

            SaplingDocument document = Visitor.document(flowContext, AuthnFlowParser.RULE_flow, flowId);
            applyValidations(document);
            return document;

        } catch (RecognitionException re) {
            Token offender = re.getOffendingToken();
            throw new SyntaxException(re.getMessage(), offender.getText(),
                    offender.getLine(), offender.getCharPositionInLine());
        }

    }

    public List<String> getInputs(SaplingDocument doc) throws SaxonApiException {
        
        return xpathCompiler
                .evaluate("/flow/header/inputs/short_var/text()", doc.toXdmNode(processor))
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
            
            //Ensure only existing flows are referenced
            checkUnknownInvocation(Visitor.FLOWCALL_XPATH_EXPR, flowNames, node);

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
    
    private void generateFromXml(String fileName, OutputStream out) throws Exception {
        NodeModel model = NodeModel.parse(Paths.get(fileName).toFile());
        jsGenerator.process(model, new OutputStreamWriter(out, UTF_8));       
    }

    public static void main(String... args) throws Exception {
        
        List<String> knownFlows = null;
        int len = args.length;
        
        if (len < 2) {
            System.err.println("Expecting at least 2 params: input file path and flow ID");
            return;
        } else if (len > 2) {

            knownFlows = new ArrayList<>();
            for (int i = 3; i < len; i++) {
                knownFlows.add(args[i]);
            }
        }

        Transpiler tr = new Transpiler(args[1], knownFlows);
        String dslCode = new String(Files.readAllBytes(Paths.get(args[0])), UTF_8);
        
        SaplingDocument doc = tr.asXML(dslCode);
        tr.logXml(doc);
        System.out.println("\nInputs: " + tr.getInputs(doc));
        System.out.println("\n" + tr.generateJS(doc));

        //tr.generateFromXml("Sample.xml", System.out);
    }

}
