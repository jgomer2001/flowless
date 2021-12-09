package org.gluu.flowless.engine.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;

@RequestScoped
public class SessionService {
    
    @Inject
    private Logger logger;

    @Inject
    private HttpServletRequest request;
    
    public String getId() {
        return request.getSession().getId();
    }
    
}
