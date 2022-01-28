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
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.gluu.flowless.engine.continuation.PendingException;
import org.gluu.flowless.engine.continuation.PendingRedirectException;
import org.gluu.flowless.engine.continuation.PendingRenderException;
import org.gluu.flowless.engine.exception.FlowCrashException;
import org.gluu.flowless.engine.exception.FlowTimeoutException;
import org.gluu.flowless.engine.misc.FlowUtils;
import org.gluu.flowless.engine.model.EngineConfig;
import org.gluu.flowless.model.Flow;
import org.gluu.flowless.engine.model.FlowResult;
import org.gluu.flowless.engine.model.FlowStatus;
import org.gluu.flowless.engine.model.ParentFlowData;
import org.gluu.util.Pair;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ContinuationPending;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeContinuation;
import org.mozilla.javascript.NativeJavaList;
import org.mozilla.javascript.NativeJavaMap;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.slf4j.Logger;

@RequestScoped
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
    
    @Inject
    private HttpServletRequest request;
    
    private String sessionId;
    private Context scriptCtx;
    private Scriptable globalScope;
    private ParentFlowData parentFlowData;
  
    /**
     * Obtains the status of the current flow (if any) for the current user
     * @return 
     */
    public FlowStatus getRunningFlowStatus() throws IOException {
        return FlowUtils.getFlowStatus(sessionId);
    }
    
    public boolean existing(String flowName) {
        return Files.exists(getFlowMetadataPath(flowName));
    }
    
    public FlowStatus startFlow(String flowName, String strParams) throws FlowCrashException {
        
        FlowStatus status = null;
        try {
            //retrieve the flow, execute until render/redirect is reached
            Flow fl = getFlowObject(flowName);
            String funcName = fl.getId();
            
            String baseCode = FlowUtils.fread(EngineConfig.ROOT_DIR, JS_UTIL);
            String flowCodeFileName = flowName + SCRIPT_SUFFIX;
            String flowCode = FlowUtils.fread(EngineConfig.ROOT_DIR, FLOWS_DIR, flowCodeFileName);

            logger.info("Evaluating flow code");
            
            try {
                globalScope = initContext(scriptCtx);
                scriptCtx.evaluateString(globalScope, baseCode, JS_UTIL, 1, null);
                FlowUtils.printScopeIds(globalScope);
                
                scriptCtx.evaluateString(globalScope, flowCode, flowCodeFileName, 1, null);
                FlowUtils.printScopeIds(globalScope);

                logger.info("Executing function {}", funcName);
                Function f = (Function) globalScope.get(funcName, globalScope);

                Object[] params = getFlowParams(fl.getInputs(), strParams);
                NativeObject result = (NativeObject) scriptCtx.callFunctionWithContinuations(f, globalScope, params);
                
                status = new FlowStatus();
                status.setResult(flowResultFrom(result));
                terminateFlow();
                
            } catch (ContinuationPending pe) {
                status = processPause(pe, null, flowName);

            } catch (Exception e){
                terminateFlow();
                makeCrashException(e);
            }
            
            //TODO: review exception handling, enable polling if needed
        } catch (IOException ie) {
            throw new FlowCrashException(ie.getMessage(), ie);
        }  
        
        return status;
        
    }
    
    public void terminateFlow() throws IOException {
        logger.info("Terminating flow");
        FlowUtils.terminateFlow(sessionId);
    }
    
    public FlowStatus continueFlow(FlowStatus currentFlowSt, String jsonParameters, boolean callbackResume,
            boolean abortSubflow) throws FlowCrashException, FlowTimeoutException {
        
        FlowStatus status = null;
        try {            
            if (callbackResume) {
                //disable usage of callback endpoint
                currentFlowSt.setAllowCallbackResume(false);
                FlowUtils.persistFlowStatus(sessionId, currentFlowSt);
            }
            
            try {
                ensureTimeNotExceeded(currentFlowSt);

                Pair<Scriptable, NativeContinuation> pcont = FlowUtils.getContinuation(sessionId);
                globalScope = pcont.getFirst();
                FlowUtils.printScopeIds(globalScope);

                logger.debug("Resuming flow");
                parentFlowData = currentFlowSt.getParentsData().peekLast();
                NativeObject result = (NativeObject) scriptCtx.resumeContinuation(pcont.getSecond(), 
                        globalScope, new Pair<>(abortSubflow, jsonParameters));

                status = new FlowStatus();
                status.setResult(flowResultFrom(result));
                terminateFlow();

            } catch (ContinuationPending pe) {
                status = processPause(pe, currentFlowSt, null);
                
            } catch (FlowTimeoutException te) {
                terminateFlow();
                throw te;
            } catch (Exception e) {
                terminateFlow();
                makeCrashException(e);
            }
        } catch (IOException ie) {
            throw new FlowCrashException(ie.getMessage(), ie);
        }
        return status;
        
    }
    
    // This is called in the middle of a cx.resumeContinuation invocation (see util.js#_flowCall)
    public Function prepareSubflow(String subflowName, String parentBasepath, String[] pathOverrides)
            throws IOException {
        
        Flow fl = getFlowObject(subflowName);
        String funcName = fl.getId();

        String flowCodeFileName = subflowName + SCRIPT_SUFFIX;
        String flowCode = FlowUtils.fread(EngineConfig.ROOT_DIR, FLOWS_DIR, flowCodeFileName);

        //strangely, scriptCtx is a bit messed at this point so initialization is required again...
        initContext(scriptCtx);

        scriptCtx.evaluateString(globalScope, flowCode, flowCodeFileName, 1, null);
        FlowUtils.printScopeIds(globalScope);

        logger.info("Appending function {} to scope", funcName);
        Function f = (Function) globalScope.get(funcName, globalScope);
        //The values set below are useful when saving the state, see method processPause
        
        ParentFlowData pfd = new ParentFlowData();        
        pfd.setParentBasepath(parentBasepath);
        pfd.setPathOverrides(pathOverrides);
        parentFlowData = pfd;

        logger.info("Evaluating subflow code");
        return f;
        
    }
    
    public void closeSubflow() throws IOException {
        parentFlowData = null;
    }
    
    //TODO: remove?
    //public Scriptable getGlobalScope() {
    //    return globalScope;
    //}
    
    private FlowStatus processPause(ContinuationPending pending, FlowStatus currentFlowSt, 
            String flowName) throws FlowCrashException, IOException {

        FlowStatus status = currentFlowSt;
        if (status == null) {
            status = new FlowStatus();
            status.setQname(flowName);
            status.setStartedAt(System.currentTimeMillis());
        }
        
        PendingException pe = null;
        if (pending instanceof PendingRenderException) {

            PendingRenderException pre = (PendingRenderException) pending;
            String templPath = pre.getTemplatePath();
            
            if (!templPath.contains("."))
                throw new FlowCrashException(
                        "Expecting file extension for the template to render: " + templPath);

            status.setTemplatePath(computeTemplatePath(templPath, parentFlowData));
            status.setTemplateDataModel(pre.getDataModel());
            status.setExternalRedirectUrl(null);
            pe = pre;

        } else if (pending instanceof PendingRedirectException) {
            
            PendingRedirectException pre = (PendingRedirectException) pending;
            
            status.setTemplatePath(null);
            status.setTemplateDataModel(null);
            status.setExternalRedirectUrl(pre.getLocation());
            pe = pre;
            
        } else {
            throw new IllegalArgumentException("Unexpected instance of ContinuationPending");
        }
        
        if (parentFlowData == null) {
            status.getParentsData().pollLast();
        } else {
            status.getParentsData().offer(parentFlowData);
        }
        //TODO: log stmt
        logger.debug("====!{}", status.getParentsData().size());        
        status.setAllowCallbackResume(pe.isAllowCallbackResume());
        //Save the state
        FlowUtils.saveState(sessionId, status, pe.getContinuation(), globalScope);

        return status;
        
    }
    
    private void ensureTimeNotExceeded(FlowStatus flstatus) throws FlowTimeoutException {

        int time = engineConf.getInterruptionTime();
        if (System.currentTimeMillis() - flstatus.getStartedAt() > 1000 * time) {
            throw new FlowTimeoutException("Your authentication attempt has run for more than "
                    + time + " seconds", flstatus.getQname());
        }

    }
    
    private String computeTemplatePath(String path, ParentFlowData pfd) {
        
        String[] overrides = Optional.ofNullable(pfd).map(ParentFlowData::getPathOverrides)
                .orElse(new String[0]);

        if (Stream.of(overrides).anyMatch(path::equals))
            return pfd.getParentBasepath() + "/" + path;
        return path;

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
                logger.debug("Setting parameter '{}' to an instance of {}", input, params[i].getClass().getName());

                //This helps prevent exception "Invalid JavaScript value of type ..."
                //when typeof is applied over this param
                if (Map.class.isInstance(params[i])) {
                    params[i] = new NativeJavaMap(globalScope, params[i]);
                } else if (List.class.isInstance(params[i])) {
                    params[i] = new NativeJavaList(globalScope, params[i]);                    
                }
            }
        }
        return params;

    }
    
    private void makeCrashException(Exception e) throws FlowCrashException {

        String msg;
        if (e instanceof RhinoException) {            
            RhinoException re = (RhinoException) e;
            msg = re.details();
            logger.error(msg + re.getScriptStackTrace());
            //logger.error(re.getMessage());
            msg = "Error executing flow's code - " + msg;
        } else 
            msg = e.getMessage();
        
        throw new FlowCrashException(msg, e);
        
    }

    /**
     * @param result
     * @return 
     */
    public FlowResult flowResultFrom(NativeObject result) throws JsonProcessingException {        
        return mapper.convertValue(result, FlowResult.class);
    }
    
    private Flow getFlowObject(String flowName) throws IOException {
        return mapper.readValue(getFlowMetadataPath(flowName).toFile(), Flow.class);
    }

    private Path getFlowMetadataPath(String flowName) {
        return Paths.get(EngineConfig.ROOT_DIR, FLOWS_DIR, flowName + METADATA_SUFFIX);
    }
    
    private Scriptable initContext(Context ctx) {
        ctx.setLanguageVersion(Context.VERSION_ES6);
        ctx.setOptimizationLevel(-1);
        return ctx.initStandardObjects();
    }
    
    @PostConstruct
    private void init() {
        
        class FlowlessContextFactory extends ContextFactory {
            
            @Override
            protected boolean hasFeature(Context cx, int featureIndex) {
                switch (featureIndex) {
                    case Context.FEATURE_ENABLE_JAVA_MAP_ACCESS: return true;
                }
                return super.hasFeature(cx, featureIndex);
            }
        }
        
        scriptCtx = new FlowlessContextFactory().enterContext();
        sessionId = request.getSession().getId();

    }

    @PreDestroy
    private void finish() {
        Context.exit();
    }

}
