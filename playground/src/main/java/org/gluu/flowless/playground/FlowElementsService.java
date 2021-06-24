package org.gluu.flowless.playground;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.zkoss.util.Pair;

public class FlowElementsService {
    
    private static final String TASKS_DIR = "tasks";    
    private static final String FLOWS_DIR = "flows";
    
    public static Pair<String, List<String>> getTasksList() throws IOException {        
        String base = ZKInitializer.getBasePath() + File.separator + TASKS_DIR;     
        return new Pair<>(base, getList(base));        
    }
    
    public static Pair<String, List<String>> getFlowsList() throws IOException {       
        String base = ZKInitializer.getBasePath() + File.separator + FLOWS_DIR;     
        return new Pair<>(base, getList(base));      
    }
    
    private static List<String> getList(String base) throws IOException {
        return Files.list(Paths.get(base))
                .map(p -> p.getFileName().toString().toLowerCase()).filter(s -> s.endsWith(".json"))
                .map(s -> s.substring(0, s.length() - 5))   //Removes extension
                .sorted().collect(Collectors.toList());
    }
    
}
