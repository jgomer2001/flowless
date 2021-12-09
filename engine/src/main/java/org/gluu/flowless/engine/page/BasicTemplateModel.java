package org.gluu.flowless.engine.page;

public class BasicTemplateModel {

    private String message;
    private String flowId;

    public BasicTemplateModel(String message) {
        this.message = message;
    }

    public BasicTemplateModel(String message, String flowId) {
        this.message = message;
        this.flowId = flowId;
    }

    public String getMessage() {
        return message;
    }

    public String getFlowId() {
        return flowId;
    }
    
}
