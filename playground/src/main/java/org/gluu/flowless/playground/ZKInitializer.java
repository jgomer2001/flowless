package org.gluu.flowless.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppInit;

public class ZKInitializer implements WebAppInit {

    private static final String BASE_PATH_ATTR = "base-path";
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static String basePath;
    
    public static String getBasePath() {
        return basePath;
    }
    
    public void init(WebApp webApp) throws Exception {
        logger.info("PLAYGROUND INITIALIZED");
        basePath = webApp.getServletContext().getInitParameter(BASE_PATH_ATTR);
    }
    
}
