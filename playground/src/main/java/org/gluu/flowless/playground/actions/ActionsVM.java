package org.gluu.flowless.playground.actions;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//import org.gluu.flowless.playground.FlowElementsService;
import org.gluu.flowless.playground.Utils;
import org.gluu.flowless.playground.ZKInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.Pair;
import org.zkoss.util.media.Media;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.ListModelList;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;

public class ActionsVM {

    private final Logger logger = LoggerFactory.getLogger(getClass());    
    private static final String ACTIONS_DIR = "actions";  
    private static final String SCRIPTS_DIR = "scripts";
    private static final String SCRIPT_EXTENSION = "groovy";
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final int MAX_CHARS_PACKAGE_SEARCH = 2000;
    
    private String scriptContents;
    private String scriptsBasePath;
    private ListModelList<String> scriptNames;
    
    public String getScriptContents() {
        return scriptContents;
    }
    
    public ListModelList<String> getScriptNames() {
        return scriptNames;
    }
    
    @Init
    public void init() throws IOException {
        scriptsBasePath = ZKInitializer.getBasePath() + File.separator + SCRIPTS_DIR;
        reloadScripts();
    }
    
    @NotifyChange({ "scriptContents", "scriptNames" })
    public void reloadScripts() throws IOException {
        scriptContents = null;
        scriptNames = new ListModelList<>(getScriptsList(scriptsBasePath));        
        logger.debug("{} scripts found", scriptNames.size());
    }
    
    public void upload() {
    
        Fileupload.get(
            new HashMap<String, Object>(),
            "Choose a file: ",
            "Upload java files",
            "text/x-java",   //text/x-java-source,application/java
            10,     //max. of files 
            100,    //max. size (100KB)
            true,
            new EventListener<UploadEvent>() {
                
                public void onEvent(UploadEvent event) throws Exception {
                    
                    Media[] medias = event.getMedias();
                    logger.info("{} files selected", medias.length);
                    
                    int overwritten = 0;
                    List<String> errors = new ArrayList<>();
                    
                    for (Media m : medias) {
                        String name = m.getName();
                        //logger.info("name {}, format {}, content-type {}", name, m.getFormat(), m.getContentType());            
                        Pair<Boolean, Boolean> res = processJavaFile(m.getByteData(), name);
                        if (!res.getX()) {
                            errors.add(name);
                        } else {
                            overwritten+= res.getY() ? 1 : 0;
                        }
                    }
                    String msg = String.format("%d files were uploaded", medias.length - errors.size());
                    if (overwritten > 0) {
                        msg+= String.format(", %d overwritten", overwritten);
                    }
                    if (!errors.isEmpty()) {
                        String files = errors.toString();
                        msg = String.format("%s. There were problems processing: {}" , msg, files.substring(1, msg.length() - 1));
                    }
                    Messagebox.show(msg, null, Messagebox.OK, Messagebox.NONE);
                    BindUtils.postNotifyChange(ActionsVM.this, "scriptContents", "scriptNames");
                    reloadScripts();
                }

            }
        );
        
    }
    
    @NotifyChange({ "scriptContents" })
    public void scriptSelected() throws IOException {
        String selected = scriptNames.getSelection().iterator().next();
        logger.debug("Script {} selected", selected);
        
        Path selectedPath = Paths.get(scriptsBasePath, selected.replaceAll("\\.", File.separator) + "." + SCRIPT_EXTENSION);        
        scriptContents = Utils.fileContents(selectedPath);
        scriptContents = scriptContents.length() == 0 ? "empty file!" : scriptContents;
        
    }
    
    private Set<String> getScriptsList(String base) throws IOException {
        
        Set<String> set = new TreeSet<>();
        Path basePath = Paths.get(base);
        
        Files.walkFileTree(basePath, new SimpleFileVisitor<Path>() {
            
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
         
                String ext = Utils.filenameExtension(file.getFileName().toString());
                if (SCRIPT_EXTENSION.equals(ext.toLowerCase())) {
                    
                    String name = basePath.relativize(file).toString().replaceAll(File.separator, ".");
                    set.add(name.substring(0, name.length() - ext.length() - 1));
                    
                } else {
                    logger.warn("Rejecting {}. File extension '{}' not recognized", file, ext);
                }
                return FileVisitResult.CONTINUE;
                
            }
            
        });
        return set;
    
    }
    
    private Pair<Boolean, Boolean> processJavaFile(byte[] bytes, String fileName) {

        boolean success = false;
        boolean overwritten = false;
        String content = new String(bytes, UTF8);            
        //Only scan a few thousand chars
        String header = content.substring(0, Math.min(content.length(), MAX_CHARS_PACKAGE_SEARCH));                        

        String packageName = Utils.guessQualifiedPackageName(header);
        if (packageName != null) {

            String ext = Utils.filenameExtension(fileName).toLowerCase();
            if (!ext.equals("java")) {
                logger.error("Unexpected file name extension in {}", fileName);
            } else {
                String dest = scriptsBasePath + File.separator + 
                        packageName.replaceAll("\\.", File.separator);
                    
                try {
                    Files.createDirectories(Paths.get(dest));
                    String newFileName = fileName.substring(0, fileName.length() - ext.length()) + SCRIPT_EXTENSION;
                    logger.info("Creating file {} under {}", newFileName, dest);
                    
                    Path path = Paths.get(dest, newFileName);
                    overwritten = Files.exists(path);
                    if (overwritten) {
                        logger.info("File already exists");
                    }
                    Files.write(path, bytes);
                    success = true;
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return new Pair<>(success, overwritten);
        
    }
/*
    private ListModelList<String> tasks;
    private Task task;

    public ListModelList<String> getTasks() {
        return tasks;
    }
    
    public Task getTask() {
        return task;
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
    */
}
