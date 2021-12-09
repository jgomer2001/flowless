package org.gluu.flowless.engine.script;

import org.gluu.util.Pair;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContinuationPending;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptUtils {

    private static Logger LOG = LoggerFactory.getLogger(ScriptUtils.class);
    
    // NOTE: do not alter this method's signature so that it returns void
    // The returned value is simulated when the continuation is resumed
    public static Object pauseFlow(String page, Object data) {
        
        Context cx = Context.enter();
        try {
            ContinuationPending pending = cx.captureContinuation();
            pending.setApplicationState(new Pair<>(page, data));
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
    
}
