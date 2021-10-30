package org.gluu.flowless.playground.actions;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
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
import java.util.stream.Collectors;

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
import org.zkoss.zul.Messagebox;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

public class ActionsVM {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final Charset UTF8 = StandardCharsets.UTF_8;

    private static final String ACTIONS_DIR = "actions";  
    private static final String SCRIPTS_DIR = "scripts";
    private static final String SCRIPT_EXTENSION = "groovy";
    
    private String scriptContents;
    private String scriptsBasePath;
    private ListModelList<String> scriptNames;

    private List<Action> actions;
    private String actionsBasePath;
        
    private List<SimpleMethodDeclaration> methodDeclarations;
    private Action newAction;
    
    private ObjectMapper mapper;
    
    public String getScriptContents() {
        return scriptContents;
    }
    
    public ListModelList<String> getScriptNames() {
        return scriptNames;
    }
    
    public List<Action> getActions() {
        return actions;
    }
    
    public Action getNewAction() {
        return newAction;
    }
    
    public List<SimpleMethodDeclaration> getMethodDeclarations() {
        return methodDeclarations;
    }

    @Init
    public void init() throws IOException {
        
        scriptsBasePath = ZKInitializer.getBasePath() + File.separator + SCRIPTS_DIR;
        actionsBasePath = ZKInitializer.getBasePath() + File.separator + ACTIONS_DIR;
        mapper = new ObjectMapper();
        reloadScripts();
        reloadActions();
        
    }
    
    @NotifyChange({ "scriptContents", "scriptNames" })
    public void reloadScripts() throws IOException {
        scriptContents = null;
        scriptNames = new ListModelList<>(getScriptsList(scriptsBasePath));        
        logger.debug("{} scripts found", scriptNames.size());
    }
    
    public void reloadActions() throws IOException{
        actions = getActions(actionsBasePath);
        logger.debug("{} actions found", actions.size());
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
            event -> {

                Media[] medias = event.getMedias();
                if (medias != null) {
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
                        msg = String.format("%s. There were problems processing: {}." , msg, files.substring(1, msg.length() - 1));
                        msg += " Ensure they are syntactically valid and have a package declaration.";
                    }
                    Messagebox.show(msg, null, Messagebox.OK, Messagebox.NONE);
                    BindUtils.postNotifyChange(ActionsVM.this, "scriptContents", "scriptNames");
                    reloadScripts();
                }

            }
        );
        
    }
    
    public void removeScript() throws IOException {
        
        String selected = scriptNames.getSelection().iterator().next();
        List<String> dependant = actions.stream().filter(a -> a.getId().startsWith(selected))
                .map(Action::getDisplayName).collect(Collectors.toList());
        
        if (!dependant.isEmpty()) {
            String msg = dependant.toString();
            msg = "The following actions depend on this script: " + msg.substring(1, msg.length() - 1);
            Messagebox.show(msg, "Removal error", Messagebox.OK, Messagebox.NONE);
        } else {
            Messagebox.show("Proceed with removal of script " + selected + "?",
                    "Confirm removal", Messagebox.YES | Messagebox.NO, Messagebox.NONE,
                    event -> {
                        if (Messagebox.ON_YES.equals(event.getName())) {
                            Path selectedPath = getScriptPath(selected);            
                            logger.info("Removing {}", selectedPath);
                            Files.delete(selectedPath);

                            scriptNames.remove(selected);
                            scriptContents = null;
                            BindUtils.postNotifyChange(ActionsVM.this, "scriptContents", "scriptNames");
                        }
                    });
        }
        
    }
    
    @NotifyChange({ "scriptContents" })
    public void scriptSelected() throws IOException {
        scriptContents = getScriptContents(scriptNames.getSelection().iterator().next());
        scriptContents = scriptContents.length() == 0 ? "empty file!" : scriptContents;
    }
    
    @NotifyChange({ "methodDeclarations" })
    public void preAddAction() {

        Pair<String, String> pair = JavaUtil.checkJavaSyntaxValidity(scriptContents);
        if (pair.getX() == null) {
            Messagebox.show("Selected class or interface seems to have syntax problems or is missing package declaration",
                    "Error", Messagebox.OK, Messagebox.NONE);
            
        } else if (pair.getY() == null){
            Messagebox.show("Cannot create an action from a non-public class or interface",
                    "Error", Messagebox.OK, Messagebox.NONE);
            
        } else {
            String sel = scriptNames.getSelection().iterator().next();
            
            if (!sel.endsWith("." + pair.getY())) {
                Messagebox.show(String.format("Unexpected script name '%s' for class/interface '%s'", sel, pair.getY()),
                        "Error", Messagebox.OK, Messagebox.NONE);

            } else {
                methodDeclarations = JavaUtil.getPublicStaticMethodDeclarations(scriptContents, sel)
                        .stream().map(SimpleMethodDeclaration::new).collect(Collectors.toList());
                logger.info("{} suitable methods found", methodDeclarations.size());
            }
        }
        
    }
    
    @NotifyChange({ "newAction" })
    public void addAction(int index) {
        String qname = scriptNames.getSelection().iterator().next();
        newAction = methodDeclarations.get(index).makeAction(qname);   
    }
    
    @NotifyChange({ "methodDeclarations", "newAction" })
    public void cancelAddAction(Event event) {
        newAction = null;
        methodDeclarations = null;

        if (event != null && event.getName().equals(Events.ON_CLOSE)) {
            event.stopPropagation();
        }
        
    }
    
    public void saveAction() {
        //logger.debug("{}", newAction.getInputs().stream().map(Input::getName).collect(Collectors.toList()));
    }
    
    private String getScriptContents(String scriptName) throws IOException {
        Path selectedPath = getScriptPath(scriptName);
        return Utils.fileContents(selectedPath);
    }
    
    private Path getScriptPath(String scriptName) {
        return Paths.get(scriptsBasePath, scriptName.replaceAll("\\.", File.separator) + "." + SCRIPT_EXTENSION);
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
    
    private List<Action> getActions(String base) throws IOException {
        
        List<Action> list = new ArrayList<>();
        Path basePath = Paths.get(base);
        
        Files.walkFileTree(basePath, new SimpleFileVisitor<Path>() {
            
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
         
                String ext = Utils.filenameExtension(file.getFileName().toString());
                
                if (ext.toLowerCase().equals("json")) {
                    list.add(mapper.readValue(file.toFile(), Action.class));
                }
                return FileVisitResult.CONTINUE;
                
            }
            
        });
        return list;
        
    }
    
    private Pair<Boolean, Boolean> processJavaFile(byte[] bytes, String fileName) {

        boolean success = false;
        boolean overwritten = false;

        String ext = Utils.filenameExtension(fileName).toLowerCase();
        if (!ext.equals("java")) {
            logger.error("Unexpected file name extension in {}", fileName);
        } else {
            
            Pair<String, String> pair= JavaUtil.checkJavaSyntaxValidity(new String(bytes, UTF8));
            String packageName = pair.getX();
            String publicClassName = pair.getY();
            String extensionless = fileName.substring(0, fileName.length() - ext.length() - 1);
            
            if (packageName == null) {
                logger.error("File does not seem to be Java-valid or does not have a package declaration");
            } else if (publicClassName != null && !publicClassName.equals(extensionless)) {
                logger.error("Expected {} as file name", publicClassName);
            } else {
                String dest = scriptsBasePath + File.separator + 
                        packageName.replaceAll("\\.", File.separator);

                try {
                    Files.createDirectories(Paths.get(dest));
                    String newFileName = extensionless + "." + SCRIPT_EXTENSION;
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

}
