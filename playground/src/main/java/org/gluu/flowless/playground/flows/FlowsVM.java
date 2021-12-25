package org.gluu.flowless.playground.flows;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.gluu.flowless.playground.Utils;
import org.gluu.flowless.playground.ZKInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;

public class FlowsVM {
    
    public static final String FLOWS_DIR = "flows";

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String flowsBasePath;
    
    private Flow selectedFlow;
    private List<Flow> flows;
    private ObjectMapper mapper;
    private String code;
    
    public String getCode() {
        return code;
    }

    public List<Flow> getFlows() {
        return flows;
    }
    
    public Flow getSelectedFlow() {
        return selectedFlow;
    }
    
    @NotifyChange({ "selectedFlow", "code" })
    public void flowSelected(Flow selected) throws IOException {
        selectedFlow = selected;
        code = Files.readString(Paths.get(flowsBasePath, selected.getQname()), StandardCharsets.UTF_8);
    }

    @Init
    public void init() throws IOException {
        flowsBasePath = ZKInitializer.getBasePath() + File.separator + FLOWS_DIR;
        mapper = new ObjectMapper();
        reloadFlows();  
    }

    @NotifyChange({ "flows" })
    public void reloadFlows() throws IOException {
        flows = getFlows(flowsBasePath);
        logger.debug("{} flows found", flows.size());
    }

    public void addFlow() {
        showNotImplemented();
    }

    public void editFlow() {
        showNotImplemented();
    }
    
    public void removeFlow() {
        showNotImplemented();        
    }
    
    private List<Flow> getFlows(String base) throws IOException {
        
        List<Flow> list = new ArrayList<>();
        Path basePath = Paths.get(base);
        
        Files.walkFileTree(basePath, new SimpleFileVisitor<Path>() {
            
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
         
                String ext = Utils.filenameExtension(file.getFileName().toString());
                
                if (ext != null && ext.toLowerCase().equals("json")) {
                    list.add(mapper.readValue(file.toFile(), Flow.class));
                }
                return FileVisitResult.CONTINUE;
                
            }
            
        });
        return list;
        
    }
    
    private void showNotImplemented() {
        Messagebox.show("Sorry, this feature is not implemented", null, Messagebox.OK, Messagebox.INFORMATION);
    }
    
}
