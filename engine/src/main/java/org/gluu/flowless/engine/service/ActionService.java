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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.gluu.flowless.engine.misc.PrimitiveUtils;
import org.gluu.flowless.engine.model.EngineConfig;
import org.slf4j.Logger;

@ApplicationScoped
public class ActionService {
    
    private static final String CLASS_SUFFIX = ".groovy";
    private static final int RECOMPILATION_GAP = 3;  //three seconds
    
    @Inject
    private Logger logger;
    
    private GroovyScriptEngine gse;
    private GroovyShell shell;
    private ObjectMapper mapper;
    
    public Object callAction(String actionClassName, String methodName, Object[] rhinoArgs) throws Exception {

        Class actionCls;
        String classFilePath = actionClassName.replace('.', File.separatorChar) + CLASS_SUFFIX;
        
        if (Files.exists(Paths.get(EngineConfig.SCRIPTS_DIR, classFilePath))) {
            logger.info("Using Script Engine to load class " + actionClassName);
            actionCls = gse.loadScriptByName(classFilePath);
        } else {
            logger.info("Using current classloader to load class " + actionClassName);
            actionCls = Class.forName(actionClassName);   
        }
        
        logger.debug("Got action class " + actionCls.getName());

        int arity = rhinoArgs.length;
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
        Object[] args = getArgsForCall(javaMethod, arity, rhinoArgs);
        
        logger.debug("Performing method call");
        return evaluateMethodCall(actionClassName + "." + methodName, arity, args);
        
    }
    
    private Object[] getArgsForCall(java.lang.reflect.Method javaMethod, int arity, Object[] arguments)
            throws IllegalArgumentException {
        
        Object[] javaArgs = new Object[arity];
        int i = -1;
        
        for (Parameter p : javaMethod.getParameters()) {
            Object arg = arguments[++i];
            Class<?> paramType = p.getType();
            String typeName = paramType.getName();
            logger.debug("Examining argument at index " + i);
            
            if (arg == null) {
                logger.debug("Value is null");
                if (PrimitiveUtils.isPrimitive(paramType, false))
                    throw new IllegalArgumentException("null value passed for a primitive parameter of type "
                            + typeName);
                else continue;
            }
            if (typeName.equals(Object.class.getName())) {
                //This parameter can receive anything :(
                logger.trace("Parameter is a " + typeName);
                javaArgs[i] = arg;
                continue;
            }
            
            Class<?> argClass = arg.getClass();

            //Try to apply cheaper conversions first (in comparison to mapper-based conversion)
            Boolean primCompat = PrimitiveUtils.compatible(argClass, paramType);
            if (primCompat != null) {

                if (primCompat) {
                    logger.trace("Parameter is a primitive (or wrapped) " + typeName);
                    javaArgs[i] = arg;

                } else if (argClass.equals(Double.class)) {
                    //Any numeric literal coming from Javascript code lands as a Double
                    Object number = PrimitiveUtils.primitiveNumberFrom((Double) arg, paramType);
                    
                    if (number != null) {
                        logger.trace("Parameter is a primitive (or wrapped) " + typeName);
                        javaArgs[i] = number;
                        
                    } else mismatchError(argClass, typeName);
                    
                } else mismatchError(argClass, typeName);
                
            } else if (argClass.equals(String.class)) {

                primCompat = PrimitiveUtils.compatible(Character.class, paramType);

                if (Optional.ofNullable(primCompat).orElse(false)) {
                    int len = arg.toString().length();
                    if (len == 0 || len > 1) mismatchError(argClass, typeName);

                    logger.trace("Parameter is a " + typeName);
                    javaArgs[i] = arg.toString().charAt(0);

                } else if (paramType.equals(String.class)) {
                    logger.trace("Parameter is a " + typeName);
                    javaArgs[i] = arg;

                } else mismatchError(argClass, typeName);

            } else {
                //argClass should be NativeArray or NativeObject if the value was not created/derived
                //from a Java call
                String argClassName = argClass.getCanonicalName();
                Type parameterizedType = p.getParameterizedType();
                String ptypeName = parameterizedType.getTypeName();
                
                if (ptypeName.equals(argClassName)) {
                    javaArgs[i] = arg;
                } else {
                    logger.warn("Trying to parse argument of class {} to {}", argClassName, ptypeName);

                    JavaType javaType = mapper.getTypeFactory().constructType(parameterizedType);
                    javaArgs[i] = mapper.convertValue(arguments[i], javaType);
                }
                logger.trace("Parameter is a " + ptypeName);
            }
        }
        return javaArgs;
        
    }
    
    private void mismatchError(Class<?> argClass, String typeName) throws IllegalArgumentException {
        throw new IllegalArgumentException(argClass.getSimpleName() + " passed for a " + typeName);
    }
    
    private Object evaluateMethodCall(String methodPath, int arity, Object[] args) throws Exception {
        
        String params = "";
        
        //Create bindings based on argument values
        for (int i = 1; i <= arity; i++) {
            String prop = "_" + i;
            shell.setProperty(prop, args[i - 1]);
            params += ", " + prop;
        }
        
        if (arity > 0) {
            params = params.substring(2);
        }
        Object result = shell.evaluate(methodPath + "(" + params + ")", methodPath + ".java");
        
        //Unset property for an upcoming call
        for (int i = 1; i <= arity; i++) {
            shell.setProperty("_" + i, null);
        }
        return result;
        
    }
    
    @PostConstruct
    private void init() throws MalformedURLException {
        
        URL url = new URL("file://" + EngineConfig.SCRIPTS_DIR + "/");
        logger.debug("Creating a Groovy Script Engine based at " + url.toString());
        
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
