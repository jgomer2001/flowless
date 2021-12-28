package org.gluu.flowless.engine.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;

import java.io.File;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.gluu.flowless.engine.model.EngineConfig;
import org.slf4j.Logger;

@ApplicationScoped
public class ActionService {
    
    private static final String CLASS_SUFFIX = ".groovy";
    private static final int RECOMPILATION_GAP = 3;  //three seconds
    
    //private static final Set<Class<?>> PRIMITIVE_CLASSES = Stream.of(
    //    Boolean.class, Character.class, Byte.class, Short.class, Integer.class,
    //    Long.class, Float.class, Double.class).collect(Collectors.toSet());

    @Inject
    private Logger logger;
    
    private GroovyScriptEngine gse;
    private GroovyShell shell;
    private ObjectMapper mapper;
    
    public String callAction(String actionClassName, String methodName, Object[] arguments) throws Exception {

        String classFilePath = String.format("%s/%s%s", EngineConfig.SCRIPTS_DIR,
                actionClassName.replace('.', File.separatorChar), CLASS_SUFFIX);
        
        Class actionCls = gse.loadScriptByName(classFilePath);
        logger.debug("Got action class {}", actionCls.getName());
        
        int arity = arguments.length;
        //Search for a method matching name and arity
        java.lang.reflect.Method javaMethod = Stream.of(actionCls.getDeclaredMethods())
                .filter(m -> m.getParameterCount() == arity && m.getName().equals(methodName))
                .findFirst().orElse(null);
        
        if (javaMethod == null) {
            String msg = String.format("Unable to find a method called %s with arity %d in class %s",
                    methodName, arity, actionClassName);
            logger.error(msg);
            throw new Exception(msg);
        }
        
        logger.debug("Java method '{}' has been selected", methodName);
        Object[] javaArgs = new Object[arity];
        int i = 0;
        
        logger.debug("Evaluation method call");
        Object result = evaluateMethodCall(actionClassName + "." + methodName, javaArgs);
        
        return mapper.writeValueAsString(result);
        
    }
    
    private Object evaluateMethodCall(String methodPath, Object[] args) {
        
        int arity = args.length;
        String params = "";
        
        //Create bindings based on argument values
        for (int i = 1; i <= arity; i++) {
            String prop = "_" + i;
            shell.setProperty(prop, args[i - 1]);
            params += ", " + prop;
        }
        Object result = shell.evaluate(methodPath + "(" + params.substring(2) + ")",
                methodPath + ".java");
        
        //Clean properties so they do not exist in an upcoming call
        for (int i = 1; i <= arity; i++) {
            shell.setProperty("_" + i, null);
        }
        return result;
        
    }
    
    @PostConstruct
    private void init() throws MalformedURLException {
        
        URL url = new URL("file://" + EngineConfig.SCRIPTS_DIR + "/");
        logger.debug("Creating a Groovy Script Engine based at {}", url.toString());
        
        CompilerConfiguration cc = new CompilerConfiguration();
        cc.setRecompileGroovySource(true);
        cc.setMinimumRecompilationInterval(RECOMPILATION_GAP);
        
        gse = new GroovyScriptEngine(new URL[]{ url });
        gse.setConfig(cc);
        gse.getGroovyClassLoader().setShouldRecompile(true);

        shell = new GroovyShell(gse.getGroovyClassLoader());
        
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            
    }

}
