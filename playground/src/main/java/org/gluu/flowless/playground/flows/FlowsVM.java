package org.gluu.flowless.playground.flows;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.xml.transform.Source;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import org.gluu.flowless.dsl.Transpiler;
import org.gluu.flowless.dsl.TranspilerException;
import org.gluu.flowless.dsl.error.SyntaxException;
import org.gluu.flowless.playground.FlowElementsService;
import org.gluu.flowless.playground.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.Pair;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

public class FlowsVM {

    private static final String FLOW_TEMPLATE = "flowTemplate";
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Pattern namePat = Pattern.compile("^[a-zA-Z_]\\w*$");
    private final Pattern namespPat = Pattern.compile("^[a-zA-Z_]\\w*(\\.[a-zA-Z_]\\w*)*$");

    private Processor processor = new Processor(false);
    private static String dummyFlowCode;    
    private String basePath;
    
    private ListModelList<String> flows;
    private Flow flow;
    private Flow tmpFlow;

    public ListModelList<String> getFlows() {
        return flows;
    }

    public Flow getFlow() {
        return flow;
    }

    public Flow getTmpFlow() {
        return tmpFlow;
    }

    @Init
    public void init() throws IOException {
        reload();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(FLOW_TEMPLATE), StandardCharsets.UTF_8
        ))) {

            String code = br.lines().reduce("", (a, b) -> a + "\n" + b);
            code = code.substring(1, code.length());
            dummyFlowCode = code + "\n";
        }
        
    }

    @NotifyChange("flow")
    public void selected() throws IOException {

        String name = flows.getSelection().stream().findFirst().get();
        logger.debug("Selected flow {}", name);
        Path path = Paths.get(basePath, name + ".json");
        String taskDetails = Utils.fileContents(path);

        try (StringReader reader = new StringReader(taskDetails)) {
            Gson gson = new Gson();
            flow = gson.fromJson(reader, Flow.class);

            flow.setCode(Utils.fileContents(Paths.get(basePath, name)));
        }

    }

    @NotifyChange({"flow", "flows"})
    public void delete() throws IOException {

        String name = flows.getSelection().stream().findFirst().get();
        logger.debug("Selected flow {}", name);

        List<String> exts = Arrays.asList("json", "xml", "js", null);

        for (String ext : exts) {
            Path path = Paths.get(basePath, name + (ext == null ? "" : ("." + ext)));
            if (Files.deleteIfExists(path)) {
                logger.info("{} deleted", path);
            }
        }
        
        flow = null;
        if (flows.remove(name)) {
            Messagebox.show("Flow {} has been deleted", null, 
                    Messagebox.OK, Messagebox.INFORMATION);
        }
        
    }

    @NotifyChange("tmpFlow")
    public void precreate() {
        tmpFlow = new Flow();
    }

    @NotifyChange("tmpFlow")
    public void cancel(Event event) {
        tmpFlow = null;
        if (event != null && event.getName().equals(Events.ON_CLOSE)) {
            event.stopPropagation();
        }
    }

    @NotifyChange({"flows", "tmpFlow", "flow"})
    public void save() throws IOException {

        String name = tmpFlow.getName();
        String namespace = tmpFlow.getNamespace();
        String description = tmpFlow.getDescription();
        String author = tmpFlow.getAuthor();

        if (Stream.of(name, description, author).anyMatch(Objects::isNull)) {
            Messagebox.show("One or more required fields are empty", null,
                     Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
        if (!namePat.matcher(name).matches()) {
            Messagebox.show("Invalid characters in name. Use letters, digits, or underscores", null,
                    Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
        if (namespace != null && !namespPat.matcher(namespace).matches()) {
            Messagebox.show("Invalid characters in namespace. Use letters, digits, dots, or underscores", null,
                     Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        String qname = (namespace == null ? "" : (namespace + ".")) + name;
        Path path = Paths.get(basePath, qname);

        if (Files.exists(path)) {
            Messagebox.show("The flow '" + path + "' already exists", null,
                     Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        flow = new Flow();
        flow.setName(name);
        flow.setNamespace(namespace);
        flow.setAuthor(author);
        flow.setDescription(description);
        flow.setCode(String.format(dummyFlowCode, qname));

        flow.setTimestamp(System.currentTimeMillis());
        flow.setEditable(true);

        //Save to disk basic flow with its metadata
        store(flow, path);

        flows.add(0, path.getFileName().toString());
        //Simulate click on this new flow
        flows.setSelection(Collections.singletonList(path.getFileName().toString()));
        
        //Simulate clicking on window's cancel
        cancel(null);

        Messagebox.show("The flow was created with a dummy implementation. Click OK to continue working.", null,
                Messagebox.OK, Messagebox.INFORMATION);

    }

    @NotifyChange("flow")
    public void update() throws IOException, SaxonApiException {

        try {
            String qname = flows.getSelection().stream().findFirst().get();
            
            Transpiler tr = new Transpiler(qname,
                    FlowElementsService.getTasksList().getY(), flows.getInnerList());
            Source xml = tr.asXML(flow.getCode());
            
            flow.setInputs(tr.getInputs(xml).toArray(new String[0]));

            String path = basePath + File.separator + qname;            
            logger.debug("Updating basic flow files");
            store(flow, Paths.get(path));
            
            String xmlString = processor.newSerializer().serializeToString(xml);

            logger.info("Saving XML and javascript representations");
            Utils.contentsToFile(Paths.get(path + ".xml"),  xmlString);
            
            String jsString = tr.generateJS(xml);   
            Utils.contentsToFile(Paths.get(path + ".js"),  jsString);
            
        } catch (TranspilerException te) {
            logger.error(te.getMessage(), te);
            Messagebox.show(te.getMessage(), "Transpiler error", Messagebox.OK, Messagebox.EXCLAMATION);
        } catch (SyntaxException se) {
            logger.error(se.getMessage(), se);
            Messagebox.show(se.getMessage(), "Syntax error", Messagebox.OK, Messagebox.EXCLAMATION);
        }
        
    }

    private void reload() throws IOException {

        flow = null;
        Pair<String, List<String>> tmp = FlowElementsService.getFlowsList();

        basePath = tmp.getX();
        flows = new ListModelList<>(tmp.getY());
        logger.debug("{} flows found", flows.size());

    }

    private void store(Flow f, Path dest) throws IOException {

        String code = f.getCode();
        f.setCode(null);

        Gson gson = new Gson();
        Utils.contentsToFile(Paths.get(dest.toString() + ".json"), gson.toJson(f));
        logger.info("Saving {}", dest);
        Utils.contentsToFile(dest, code);
        
        //restore
        f.setCode(code);

    }

}
