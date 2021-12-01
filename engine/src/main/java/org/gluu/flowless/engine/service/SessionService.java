package org.gluu.flowless.engine.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.gluu.flowless.engine.model.FlowStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class SessionService {
    
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private HttpServletRequest request;
    
    public String getId() {
        logger.debug("Session id is {}", request.getSession().getId());
        return request.getSession().getId();
    }
    
    
}
