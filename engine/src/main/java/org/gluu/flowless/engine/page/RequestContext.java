package org.gluu.flowless.engine.page;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.gluu.flowless.engine.servlet.RestartServlet;

@RequestScoped
public class RequestContext {
    
    @Inject
    private HttpServletRequest request;
    
    private String contextPath;

    public String getContextPath() {
        return contextPath;
    }
    
    public String getRestartUrl() {
        return contextPath + RestartServlet.PATH;
    }
    
    @PostConstruct
    private void init() {
        contextPath = request.getContextPath();
    }
    
}
