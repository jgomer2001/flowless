package org.gluu.flowless.playground.actions;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.gluu.flowless.playground.Utils;

import org.gluu.flowless.playground.ZKInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.QueryParam;

import static org.gluu.flowless.playground.actions.ActionsVM.ACTIONS_DIR;

public class ActionDetailVM {

    private final Logger logger = LoggerFactory.getLogger(getClass());    
    private Action action;
    
    public Action getAction() {
        return action;
    }
    
    @Init
    public void init(@QueryParam("actId") String id) throws IOException {
        
        if (Utils.isNotEmpty(id)) {
            ObjectMapper mapper = new ObjectMapper();
            String actionsBasePath = ZKInitializer.getBasePath() + File.separator + ACTIONS_DIR;

            action = mapper.readValue(Paths.get(actionsBasePath, id + ".json").toFile(), Action.class);
            
            logger.debug("Showing data of action {}", action.getName().getDisplayName());
        }
    }
    
            
}
