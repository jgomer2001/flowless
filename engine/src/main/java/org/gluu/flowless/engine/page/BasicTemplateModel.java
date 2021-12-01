package org.gluu.flowless.engine.page;

import org.gluu.flowless.engine.servlet.RestartServlet;

public class BasicTemplateModel {

    private String message;
    private String restart = RestartServlet.PATH;

    public BasicTemplateModel(String message) {
        this.message = message;
    }
    
    public String getRestart() {
        return restart;
    }

    public String getMessage() {
        return message;
    }
    
}
