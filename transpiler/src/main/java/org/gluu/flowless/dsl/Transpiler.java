package org.gluu.flowless.dsl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.StaticError;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.Xslt30Transformer;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.sapling.SaplingDocument;
import net.sf.saxon.sapling.Saplings;
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

/**
 *
 */
public class Transpiler {

    private static final Charset utf8 = StandardCharsets.UTF_8;
    private static final String XSL_LOCATION = "JSGenerator.xsl";

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String flowName;
    private Set<String> taskNames;
    private Set<String> flowNames;

    private Processor processor;
    private XsltExecutable stylesheet;
    private XPathCompiler xpathCompiler;

    private void initialize(String flowName,
            List<String> taskNames, List<String> flowNames) throws TranspilerException {

        this.flowName = flowName;
        this.taskNames = Optional.ofNullable(taskNames).map(HashSet::new).orElse(null);
        this.flowNames = Optional.ofNullable(flowNames).map(HashSet::new).orElse(null);
        
        if (Stream.of(flowNames, flowName).allMatch(Objects::nonNull)) {
            flowNames.remove(flowName);
        }

        processor = new Processor(false);
        List<StaticError> errors = new ArrayList<>();

        xpathCompiler = processor.newXPathCompiler();
        xpathCompiler.setCaching(true);
        XsltCompiler xsltCompiler = processor.newXsltCompiler();
        xsltCompiler.setErrorList(errors);

        StreamSource xslSource = new StreamSource(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(XSL_LOCATION), utf8));
        try {
            logger.debug("Compiling XSL");
            stylesheet = xsltCompiler.compile(xslSource);
        } catch (SaxonApiException se) {
            String msg = "XSL compilation failed: ";
            throw new TranspilerException(msg + errors.stream().
                    map(StaticError::getMessage).collect(Collectors.joining("\n")), se);
        }

    }

    public Transpiler() throws TranspilerException {
        initialize(null, null, null);
    }

    public Transpiler(String flowName,
            List<String> taskNames, List<String> flowNames) throws TranspilerException {
        initialize(flowName, taskNames, flowNames);
    }

    public Source asXML(String DSLCode) throws SyntaxException, TranspilerException {

        InputStream is = new ByteArrayInputStream(DSLCode.getBytes(utf8));
        CharStream input = null;

        try {
            logger.debug("Creating ANTLR CharStream from DSL code");
            //fromStream method closes the input stream upon returning
            input = CharStreams.fromStream(is);
        } catch (IOException ioe) {
            throw new TranspilerException(ioe.getMessage(), ioe);
        }

        AuthnFlowLexer lexer = new AuthnFlowLexer(input);
        logger.debug("Lexer for grammar '{}' initialized", lexer.getGrammarFileName());
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        logger.debug("Creating parser");
        AuthnFlowParser parser = new AuthnFlowParser(tokens);
        RecognitionErrorListener errListener = new RecognitionErrorListener();
        parser.addErrorListener(errListener);

        try {
            AuthnFlowParser.FlowContext flowContext = parser.flow();
            SyntaxException syntaxException = errListener.getError();
            if (syntaxException != null) {
                throw syntaxException;
            }

            logger.debug("Traversing parse tree");
            //Generate XML representation
            XmlVisitor visitor = new XmlVisitor();
            SaplingDocument document = Saplings.doc().withChild(visitor.visitFlow(flowContext));

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
        return xpathCompiler.evaluate("/flow/header/inputs/param/text()", node)
                    .stream().map(XdmItem::getStringValue).collect(Collectors.toList());
    }
    
    public String generateJS(Source doc) throws TranspilerException {

        try {
            StringWriter sw = new StringWriter();
            Serializer serializer = processor.newSerializer(sw);

            //Load stylesheet and apply transformation
            logger.debug("Loading transformer");
            Xslt30Transformer transformer = stylesheet.load30();
            logger.debug("Generating code");
            transformer.transform(doc, serializer);

            return sw.toString();

        } catch (SaxonApiException se) {
            throw new TranspilerException("Transformation failed", se);
        }

    }

    private void applyValidations(SaplingDocument doc) throws TranspilerException {

        try {
            XdmNode node = doc.toXdmNode(processor);
            
            if (flowName != null) {                
                //validate flow name is consistent 
                String name = xpathCompiler.evaluateSingle("/flow/header/qname/text()", node)
                        .getStringValue();                
                
                if (!flowName.equals(name)) {
                    throw new TranspilerException(
                        String.format("Expecting flow name '%s', but '%s' was found", flowName, name));
                }
            }
            
            //Ensure only existing flows/tasks are referenced
            checkUnknownInvocation("//invocation[@type=\"task_call\"]/call/qname/text()", taskNames, node);
            checkUnknownInvocation("//invocation[@type=\"flow_call\"]/call/qname/text()", flowNames, node);

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

    public static void main(String... args) throws Exception {
        String dslCode = new String(Files.readAllBytes(Paths.get(args[0])), utf8);
        /*java.util.Arrays.asList("validate", "nss.tigre", "boo")*/
        Transpiler tr = new Transpiler("org.gluu.Main", null, null);
        Source source = tr.asXML(dslCode);
        //System.out.println(tr.getInputs(source));
        //System.out.println("\n" + tr.generateJS(source));
    }

}
