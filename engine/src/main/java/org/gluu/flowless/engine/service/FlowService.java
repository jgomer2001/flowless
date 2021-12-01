package org.gluu.flowless.engine.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
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
import org.gluu.flowless.engine.exception.TemplateProcessingException;
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

@ApplicationScoped
public class FlowService {

    private static final String FLOWS_DIR = "flows";
    private static final String SCRIPT_SUFFIX = ".js";
    private static final String METADATA_SUFFIX = ".json";
    private static final String JS_TEMPLATE = "JSTemplate.ftl";
    
    @Inject
    private Logger logger;
    
    @Inject
    private ObjectMapper mapper;
    
    @Inject
    private EngineConfig engineConf; 
    
    @Inject
    private TemplatingService templatingService; 
  
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
        
        try {            
            //retrieve the flow, execute until render is reached, and suspend
            Flow fl = getFlowObject(flowName);
            String funcName = fl.getId();
            Object[] params = getFlowParams(fl.getInputNames(), strParams);
            
            String flowCodeFileName = flowName + SCRIPT_SUFFIX;
            Path flowCodePath = Paths.get(EngineConfig.ROOT_DIR, FLOWS_DIR, flowCodeFileName);

            Map<String, String> dataModel = Collections.singletonMap("fun", Files.readString(flowCodePath, UTF_8));
            StringWriter jsCode = new StringWriter();
            templatingService.process(JS_TEMPLATE, dataModel, jsCode, true);
            logger.debug("Generated code:\n{}", jsCode.toString());

            Context cx = Context.enter();
            Scriptable globalScope = null;
            try {
                globalScope = initContext(cx);
                cx.evaluateString(globalScope, jsCode.toString(), flowCodeFileName, 1, null);

                Function f = (Function) globalScope.get(funcName, globalScope);
                logger.info("Executing function {}", funcName);
                cx.callFunctionWithContinuations(f, globalScope, params);
            } catch (ContinuationPending pe) {
                Pair<String, Object> p = (Pair<String, Object>) pe.getApplicationState();
                String templPath = p.getFirst();
                
                if (!templPath.contains("."))
                    throw new FlowCrashException("Expecting file extension for the template to render: " + templPath);
                
                FlowStatus status = new FlowStatus();
                status.setStartedAt(System.currentTimeMillis());
                status.setQname(flowName);
                status.setTemplatePath(templPath);
                status.setTemplateDataModel((Map<String, Object>) p.getSecond());
        
                //Save the state
                FlowUtils.saveState(sessionId, status, (NativeContinuation) pe.getContinuation(), globalScope);
                
                return status;
            } catch (Exception e){
                //TODO: what kind of exceptions can a rhino script throw?
                logger.error(e.getMessage(), e);
                throw new FlowCrashException("Error executing flow's code", e);
            } finally {
                Context.exit();
            }
            
            //TODO: fix exception handling
        } catch (JsonProcessingException e) {
            throw new FlowCrashException(e.getMessage(), e);
        } catch (IOException ie) {
            throw new FlowCrashException(ie.getMessage(), ie);
        } catch (TemplateProcessingException te) {
            throw new FlowCrashException(te.getMessage(), te);
        }
        
        //terminate/clean any existing flow associated to this session        
        //enable polling if needed
        return null;
        
    }
    
    public void removeFlow(String flowId, String sessionId) {
        //TODO
        
    }
    
    public FlowStatus continueFlow(String flowId, String sessionId, Map<String, String[]> parameters,
            boolean afterExternalRedirect) throws FlowCrashException, FlowTimeoutException {
        
        Context cx = Context.enter();
        try {
            Scriptable globalScope = initContext(cx);

            FlowStatus fs = getFlowStatus(sessionId);
            checkTimeExceeded(fs, false);
            
            Pair<Scriptable, NativeContinuation> pcont = FlowUtils.getContinuation(sessionId, globalScope);            
            globalScope = pcont.getFirst();
            cx.resumeContinuation(pcont.getSecond(), globalScope, FlowUtils.toJsonString(parameters));

        } catch (ContinuationPending pe) {
            
        } catch (FlowTimeoutException te) {
            throw te;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlowCrashException("Error executing flow's code", e);
        } finally {
            Context.exit();
        }

        //Persist status to database
        return new FlowStatus();
    }
    
    private void checkTimeExceeded(FlowStatus flstatus, boolean afterExternalRedirect)
            throws FlowTimeoutException {

        int time = afterExternalRedirect ? engineConf.getReturnAfterRedirectTime()
                : engineConf.getInterruptionTime();
        if (System.currentTimeMillis() - flstatus.getStartedAt() > 1000 * time) {
            throw new FlowTimeoutException("This flow has run for more than " + time + " seconds");
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
    
    @PostConstruct
    private void init() {
        
    }
    
}
