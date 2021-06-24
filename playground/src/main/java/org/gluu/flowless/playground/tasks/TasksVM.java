package org.gluu.flowless.playground.tasks;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.gluu.flowless.playground.FlowElementsService;
import org.gluu.flowless.playground.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.Pair;
import org.zkoss.zul.ListModelList;

public class TasksVM {

    private final Logger logger = LoggerFactory.getLogger(getClass());    

    private String basePath;
    private ListModelList<String> tasks;
    private Task task;

    public ListModelList<String> getTasks() {
        return tasks;
    }
    
    public Task getTask() {
        return task;
    }
    
    @Init
    public void init() throws IOException {

        Pair<String, List<String>> tmp = FlowElementsService.getTasksList();
        basePath = tmp.getX();
        tasks = new ListModelList<>(tmp.getY());        
        logger.debug("{} tasks found", tasks.size());
        
    }
    
    @NotifyChange("task")
    public void selected() throws IOException {
        
        String name = tasks.getSelection().stream().findFirst().get();
        logger.debug("Selected task {}", name);
        Path path = Paths.get(basePath, name + ".json");
        String taskDetails = Utils.fileContents(path);
        
        try(StringReader reader = new StringReader(taskDetails)) {            
            Gson gson = new Gson();
            task = gson.fromJson(reader, Task.class);
            
            task.setCode(Utils.fileContents(Paths.get(basePath, name)));            
        }
        
    }
    
}
