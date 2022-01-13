package org.gluu.flowless.playground.flows;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Base64;

import org.gluu.flowless.playground.Utils;
import org.gluu.flowless.playground.ZKInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.QueryParam;

import static org.gluu.flowless.playground.flows.FlowsVM.FLOWS_DIR;

public class FlowDetailVM {
    
    private static final String TEST_SERVER_FLOWS_ROOT = "http://localhost:8080/webapp/fl/";

    private final Logger logger = LoggerFactory.getLogger(getClass()); 
    
    private Flow flow;
    private String launchUrl;

    public Flow getFlow() {
        return flow;
    }

    public String getLaunchUrl() {
        return launchUrl;
    }
    
    @Init
    public void init(@QueryParam("flowId") String qname)  throws IOException {
        
        if (Utils.isNotEmpty(qname)) {
            ObjectMapper mapper = new ObjectMapper();
            String flowsBasePath = ZKInitializer.getBasePath() + File.separator + FLOWS_DIR;

            flow = mapper.readValue(Paths.get(flowsBasePath, qname + ".json").toFile(), Flow.class);
            
            logger.debug("Showing data of flow {}", flow.getQname());
            
            launchUrl = Base64.getUrlEncoder().encodeToString(qname.getBytes(StandardCharsets.UTF_8));
            launchUrl = TEST_SERVER_FLOWS_ROOT + getLaunchUrl() + ".fls";
        }
    }
    
}
