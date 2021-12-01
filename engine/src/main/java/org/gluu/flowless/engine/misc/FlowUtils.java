package org.gluu.flowless.engine.misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.gluu.flowless.engine.model.EngineConfig;

import org.gluu.flowless.engine.model.FlowStatus;
import org.gluu.util.Pair;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContinuationPending;
import org.mozilla.javascript.NativeContinuation;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.serialize.ScriptableInputStream;
import org.mozilla.javascript.serialize.ScriptableOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlowUtils {

    private static Logger LOG = LoggerFactory.getLogger(FlowUtils.class);
    private static ObjectMapper MAPPER = new ObjectMapper();
    
    // NOTE: do not alter this method's signature in order to return void
    // The returned value is injected when the continuation is resumed
    public static Object pauseFlow(String page, Object data) {
        Context cx = Context.enter();
        try {
            ContinuationPending pending = cx.captureContinuation();
            pending.setApplicationState(new Pair<>(page, data));
            throw pending;
        } finally {
            Context.exit();
        }
    }
    
    public static void saveState(String sessionId, FlowStatus fst, NativeContinuation continuation,
            Scriptable scope) throws IOException {
        
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ScriptableOutputStream sos = new ScriptableOutputStream(baos, scope)) {
            
            sos.writeObject(scope);
            sos.writeObject(continuation);

            LOG.debug("Continuation serialized, saving...");
            persistContinuation(sessionId, baos.toByteArray());
            
            LOG.debug("Saving status of current flow");
            persistFlowStatus(sessionId, fst);
        }
        
    }

    /**
     * It is assumed that values in the map are String arrays with at least one element
     * @param map
     * @return
     * @throws JsonProcessingException 
     */
    public static String toJsonString(Map<String, String[]> map) throws JsonProcessingException {
        Map<String, Object> result = new HashMap<>();
        if (map != null) {
            for(String key : map.keySet()) {
                String[] list = map.get(key);
                result.put(key, list.length == 1 ? list[0] : Arrays.asList(list));
            }
        }
        
        //TODO: implement a smarter serialization? example: 
        // if key starts with prefix i: try to convert to int, b: for boolean, etc.
        return MAPPER.writeValueAsString(result);
    }
    
    private static void persistContinuation(String sid, byte[] data) throws IOException {
        //TODO: use gluu persistence here        
        Files.write(continuationPath(sid), data);
        LOG.info("{} bytes written", data.length);
    }
    
    private static void persistFlowStatus(String sid, FlowStatus fst) throws IOException {
        //TODO: use gluu persistence here. See if "working  params" are encoded somehow
        MAPPER.writeValue(flowStatusPath(sid).toFile(), fst);
    }
    
    public static FlowStatus getFlowStatus(String sid) throws IOException {
        Path path = flowStatusPath(sid);
        if (Files.exists(path)) {
            return MAPPER.readValue(path.toFile(), FlowStatus.class);
        } else {
            return null;
        }
    }
    
    public static Pair<Scriptable, NativeContinuation> getContinuation(String sid,
            Scriptable scope) throws IOException {

        Path path = continuationPath(sid);
        if (!Files.exists(path)) return null;
        
        byte[] bytes = Files.readAllBytes(path);
        Pair<Scriptable, NativeContinuation> p = new Pair<>();;
        try (
                ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                ScriptableInputStream sis = new ScriptableInputStream(bais, scope)) {
            
            p.setFirst((Scriptable) sis.readObject());
            p.setSecond((NativeContinuation) sis.readObject());
        } catch (Exception e) {
            LOG.error("An error occurred while deserializing the continuation");
            throw new IOException(e);
        }
        return p;

    } 
    
    private static Path continuationPath(String sid) {
        return Paths.get(EngineConfig.ROOT_DIR, "flows", sid + ".txt");
    }
    private static Path flowStatusPath(String sid) {
        return Paths.get(EngineConfig.ROOT_DIR, "flows", sid + ".st.txt");
    }
    
}
