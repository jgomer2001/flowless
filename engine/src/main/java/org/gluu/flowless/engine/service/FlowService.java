package org.gluu.flowless.engine.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.gluu.flowless.engine.exception.FlowCrashException;
import org.gluu.flowless.engine.exception.FlowTimeoutException;
import org.gluu.flowless.engine.misc.FlowUtils;
import org.gluu.flowless.engine.model.EngineConfig;
import org.gluu.flowless.engine.model.Flow;
import org.gluu.flowless.engine.model.FlowStatus;
import org.gluu.util.Pair;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContinuationPending;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeContinuation;
import org.mozilla.javascript.Scriptable;
import org.slf4j.Logger;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class FlowService {

    private static final String FLOWS_DIR = "flows";
    private static final String SCRIPT_SUFFIX = ".js";
    private static final String METADATA_SUFFIX = ".json";
    private static final String JS_UTIL = "util.js";
    
    @Inject
    private Logger logger;
    
    @Inject
    private ObjectMapper mapper;
    
    @Inject
    private EngineConfig engineConf;
  
    /**
     * Obtains the status of the current flow (if any) for the current user
     * @param sessionId Identifier of the user's browser session
     * @return 
     */
    public FlowStatus getFlowStatus(String sessionId) throws IOException {
        return FlowUtils.getFlowStatus(sessionId);
    }
    
    public boolean existing(String flowName) {
        return Files.exists(getFlowMetadataPath(flowName));
    }
    
    public FlowStatus startFlow(String flowName, String sessionId, String strParams)
            throws FlowCrashException {
        
        FlowStatus status = null;
        try {            
            //retrieve the flow, execute until render/redirect is reached
            Flow fl = getFlowObject(flowName);
            String funcName = fl.getId();
            Object[] params = getFlowParams(fl.getInputNames(), strParams);
            
            String baseCode = FlowUtils.fread(EngineConfig.ROOT_DIR, JS_UTIL);
            String flowCodeFileName = flowName + SCRIPT_SUFFIX;
            String flowCode = FlowUtils.fread(EngineConfig.ROOT_DIR, FLOWS_DIR, flowCodeFileName);

            Context cx = Context.enter();
            Scriptable globalScope = null;
            
            try {
                logger.info("Evaluating flow code");
                globalScope = initContext(cx);
                cx.evaluateString(globalScope, baseCode, JS_UTIL, 1, null);
                printScopeIds(globalScope);
                
                cx.evaluateString(globalScope, flowCode, flowCodeFileName, 1, null);
                printScopeIds(globalScope);

                logger.info("Executing function {}", funcName);
                Function f = (Function) globalScope.get(funcName, globalScope);
                Object result = cx.callFunctionWithContinuations(f, globalScope, params);
                
                status = new FlowStatus();
                status.setResult(FlowUtils.flowResultFrom(result));
                terminateFlow(sessionId);
                
            } catch (ContinuationPending pe) {
                status = processPause(pe, flowName, sessionId, globalScope);

            } catch (Exception e){
                terminateFlow(sessionId);
                //TODO: what kind of exceptions can a rhino script throw?
                logger.error(e.getMessage(), e);
                throw new FlowCrashException("Error executing flow's code", e);
            } finally {
                Context.exit();
            }
            
            //TODO: review exception handling, enable polling if needed
        } catch (JsonProcessingException e) {
            throw new FlowCrashException(e.getMessage(), e);
        } catch (IOException ie) {
            throw new FlowCrashException(ie.getMessage(), ie);
        }  
        
        return status;
        
    }
    
    public void terminateFlow(String sessionId) throws IOException {
        logger.info("Terminating flow");
        FlowUtils.terminateFlow(sessionId);
    }
    
    public FlowStatus continueFlow(String flowName, String sessionId, Map<String, String[]> parameters,
            boolean afterExternalRedirect) throws FlowCrashException, FlowTimeoutException {
        
        FlowStatus status = null;
        try {
            Context cx = Context.enter();
            Scriptable globalScope = null;
            
            try {
                FlowStatus fs = getFlowStatus(sessionId);
                ensureTimeNotExceeded(fs, false);

                Pair<Scriptable, NativeContinuation> pcont = FlowUtils.getContinuation(sessionId);//, globalScope        
                globalScope = pcont.getFirst();
                printScopeIds(globalScope);

                logger.debug("Resuming flow");
                Object result = cx.resumeContinuation(pcont.getSecond(), globalScope, 
                        FlowUtils.toJsonString(parameters));

                status = new FlowStatus();
                status.setResult(FlowUtils.flowResultFrom(result));
                terminateFlow(sessionId);

            } catch (ContinuationPending pe) {
                status = processPause(pe, flowName, sessionId, globalScope);
                
            } catch (FlowTimeoutException te) {
                terminateFlow(sessionId);
                throw te;
            } catch (Exception e) {
                terminateFlow(sessionId);
                logger.error(e.getMessage(), e);
                throw new FlowCrashException("Error executing flow's code", e);
            } finally {
                Context.exit();
            }
        } catch (IOException ie) {
            throw new FlowCrashException(ie.getMessage(), ie);
        }
        return status;
        
    }
    
    private FlowStatus processPause(ContinuationPending pending, String flowName,
            String sessionId, Scriptable globalScope) throws FlowCrashException, IOException {
        
        Pair<String, Object> p = (Pair<String, Object>) pending.getApplicationState();
        String templPath = p.getFirst();

        if (!templPath.contains("."))
            throw new FlowCrashException("Expecting file extension for the template to render: " + templPath);

        FlowStatus status = new FlowStatus();
        status.setStartedAt(System.currentTimeMillis());
        status.setQname(flowName);
        status.setTemplatePath(templPath);
        status.setTemplateDataModel((Map<String, Object>) p.getSecond());

        printScopeIds(globalScope);        
        //Save the state
        FlowUtils.saveState(sessionId, status, (NativeContinuation) pending.getContinuation(), globalScope);

        return status;
        
    }
    
    private void ensureTimeNotExceeded(FlowStatus flstatus, boolean afterExternalRedirect)
            throws FlowTimeoutException {

        int time = afterExternalRedirect ? engineConf.getReturnAfterRedirectTime()
                : engineConf.getInterruptionTime();
        if (System.currentTimeMillis() - flstatus.getStartedAt() > 1000 * time) {
            throw new FlowTimeoutException("Your authentication attempt has run for more than "
                    + time + " seconds", flstatus.getQname());
        }

    }
    
    private Flow getFlowObject(String flowName) throws IOException {        
        return mapper.readValue(getFlowMetadataPath(flowName).toFile(), Flow.class);
    }
    
    private Object[] getFlowParams(List<String> inputNames, String strParams) throws JsonProcessingException {

        List<String> inputs = Optional.ofNullable(inputNames).orElse(Collections.emptyList());
        Object[] params = new Object[inputs.size()];

        if (strParams != null) {
            Map<String, Object> map = mapper.readValue(strParams, new TypeReference<Map<String, Object>>(){});
            for (int i = 0; i < params.length; i++) {
                params[i] = map.get(inputs.get(i));
            }
        }
        for (int i = 0; i < params.length; i++) {
            String input = inputs.get(i);
            if (params[i] == null) {
                logger.warn("Setting parameter '{}' to null", input);
            } else {
                logger.debug("Setting parameter {} to an instance of {}", input, params[i].getClass().getName());
            }
        }
        return params;

    }

    private Path getFlowMetadataPath(String flowName) {
        return Paths.get(EngineConfig.ROOT_DIR, FLOWS_DIR, flowName + METADATA_SUFFIX);
    }
    
    private Scriptable initContext(Context ctx) {
        ctx.setLanguageVersion(Context.VERSION_ES6);
        ctx.setOptimizationLevel(-1);
        return ctx.initStandardObjects();
    }

    private void printScopeIds(Scriptable scope) {
        List<String> scopeIds = Stream.of(scope.getIds()).map(Object::toString).collect(Collectors.toList());
        logger.trace("Global scope has {} ids: {}", scopeIds.size(), scopeIds);
    }
    
    @PostConstruct
    private void init() {        
    }
    
}
