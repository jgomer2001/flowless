package org.gluu.flowless.engine.script;

import java.io.IOException;
import java.util.Map;
import javax.enterprise.inject.spi.CDI;

import org.gluu.flowless.engine.continuation.PendingRedirectException;
import org.gluu.flowless.engine.continuation.PendingRenderException;
import org.gluu.flowless.engine.service.ActionService;
import org.gluu.flowless.engine.service.FlowService;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeContinuation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ScriptUtils.class);
    
    // NOTE: do not alter this method's signature so that it returns void. The returned 
    // value is simulated when the continuation is resumed: see 3rd parameter in call
    // to resumeContinuation (FlowService)
    public static Object pauseForRender(String page, boolean allowCallbackResume, Object data)
            throws PendingRenderException {
        
        Context cx = Context.enter();
        try {
            PendingRenderException pending = new PendingRenderException(
                    (NativeContinuation) cx.captureContinuation().getContinuation());
            pending.setTemplatePath(page);
            pending.setDataModel((Map<String, Object>) data);
            pending.setAllowCallbackResume(allowCallbackResume);
            LOG.debug("Pausing flow");
            throw pending;
        } finally {
            Context.exit();
        }

    }
    
    public static Object pauseForExternalRedirect(String url) throws PendingRedirectException {
        
        Context cx = Context.enter();
        try {            
            PendingRedirectException pending = new PendingRedirectException(
                    (NativeContinuation) cx.captureContinuation().getContinuation());
            pending.setLocation(url);
            pending.setAllowCallbackResume(true);
            LOG.debug("Pausing flow");
            throw pending;
        } finally {
            Context.exit();
        }
    }
    
    public static boolean testEquality(Object a, Object b) {
    
        boolean anull = a == null;
        boolean bnull = b == null;
        
        // Same object?
        if (a == b) return true;
        if (!anull && !bnull) {
            
            Class aclass = a.getClass();
            Class bclass = b.getClass();
            if (!aclass.equals(bclass)) {
                LOG.warn("trying to compare instances of {} and {}", aclass.getName(), bclass.getName());
                
            } else if (aclass.equals(String.class) || aclass.isPrimitive()) {
                return a.equals(b);
            }
        }
        return false;
        
    }
    
    //Issue a call to this method only if the request scope is active
    public static Function prepareSubflow(String qname, String parentBasepath, String[] pathOverrides)
            throws IOException {
        return managedBean(FlowService.class).prepareSubflow(qname, parentBasepath, pathOverrides);
        
    }
    
    public static String callAction(String actionClassName, String methodName, Object[] params) throws Exception {
        return managedBean(ActionService.class).callAction(actionClassName, methodName, params);
    }

    //Issue a call to this method only if the request scope is active
    public static void closeSubflow() throws IOException {
        managedBean(FlowService.class).closeSubflow();
    }
    
    private static <T> T managedBean(Class<T> cls) {
        return CDI.current().select(cls).get();
    }

}
