package org.gluu.flowless.engine.misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.inject.spi.CDI;

import org.gluu.flowless.engine.model.EngineConfig;
import org.gluu.flowless.engine.model.FlowStatus;
import org.gluu.flowless.engine.serialize.ContinuationSerializer;
import org.gluu.util.Pair;
import org.mozilla.javascript.NativeContinuation;
import org.mozilla.javascript.Scriptable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FlowUtils {

    private static final Logger LOG = LoggerFactory.getLogger(FlowUtils.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    //TODO: use oxcore
    private static final ContinuationSerializer CONT_SER = CDI.current().select(ContinuationSerializer.class).get();

    public static String encode(String name) {
        return Base64.getUrlEncoder().encodeToString(name.getBytes(UTF_8));
    }
    
    public static String decode(String encStr) throws IllegalArgumentException {
        return new String(Base64.getUrlDecoder().decode(encStr), UTF_8);
    }
    
    public static void terminateFlow(String sessionId) throws IOException {
        Files.deleteIfExists(continuationPath(sessionId));
        Files.deleteIfExists(flowStatusPath(sessionId));
    }
    
    public static void saveState(String sessionId, FlowStatus fst, NativeContinuation continuation,
            Scriptable scope) throws IOException {

        byte[] bytes = CONT_SER.save(scope, continuation);
        LOG.debug("Continuation serialized, saving...");
        persistContinuation(sessionId, bytes);

        LOG.debug("Saving status of current flow");
        persistFlowStatus(sessionId, fst);
        
    }
    
    public static Pair<Scriptable, NativeContinuation> getContinuation(String sid)
            throws IOException {

        Path path = continuationPath(sid);
        if (!Files.exists(path)) return null;
        
        LOG.debug("Restoring continuation data...");
        byte[] bytes = Files.readAllBytes(path);

        return CONT_SER.restore(bytes);

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
        // if key starts with prefix i: try to convert to int, b: for boolean, m: map, etc.
        return MAPPER.writeValueAsString(result);
    }
    
    private static void persistContinuation(String sid, byte[] data) throws IOException {
        //TODO: use gluu persistence here, if serialization is disabled (see SerializationConfig)
        //use an in-memory expiring map
        Files.write(continuationPath(sid), data);
        LOG.info("{} bytes written", data.length);
    }
    
    public static void persistFlowStatus(String sid, FlowStatus fst) throws IOException {
        //TODO: use gluu persistence here, if serialization is disabled (see SerializationConfig)
        //use an in-memory expiring map
        MAPPER.writeValue(flowStatusPath(sid).toFile(), fst);
    }
    
    public static FlowStatus getFlowStatus(String sid) throws IOException {
        
        Path path = flowStatusPath(sid);
        return Files.exists(path) ?
                MAPPER.readValue(path.toFile(), FlowStatus.class) : null;

    }

    public static void printScopeIds(Scriptable scope) {
        List<String> scopeIds = Stream.of(scope.getIds()).map(Object::toString).collect(Collectors.toList());
        LOG.trace("Global scope has {} ids: {}", scopeIds.size(), scopeIds);
    }

    public static String fread(String path, String ...more) throws IOException{
        return Files.readString(Paths.get(path, more), UTF_8);    
    }
    
    private static Path continuationPath(String sid) {
        return Paths.get(EngineConfig.ROOT_DIR, "flows", sid + ".txt");
    }

    private static Path flowStatusPath(String sid) {
        return Paths.get(EngineConfig.ROOT_DIR, "flows", sid + ".st.txt");
    }
    
}
