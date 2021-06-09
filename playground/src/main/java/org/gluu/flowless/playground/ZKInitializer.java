package org.gluu.flowless.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppInit;

public class ZKInitializer implements WebAppInit {

    public static final String BASE_PATH_ATTR = "base-path";
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    public void init(WebApp webApp) throws Exception {
        logger.info("PLAYGROUND INITIALIZED");
        webApp.setAttribute(BASE_PATH_ATTR, webApp.getServletContext().getInitParameter(BASE_PATH_ATTR));
    }
    
}
