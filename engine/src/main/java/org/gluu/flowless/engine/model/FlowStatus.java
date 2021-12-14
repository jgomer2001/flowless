package org.gluu.flowless.engine.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FlowStatus {
    
    private String qname;
    private String templatePath;
    private long startedAt;
    private Map<String, Object> templateDataModel;
    private ParentFlowData parent;
    private ExternalRedirect externalRedirect;
    
    private FlowResult result;

    public ExternalRedirect getExternalRedirect() {
        return externalRedirect;
    }

    public void setExternalRedirect(ExternalRedirect externalRedirect) {
        this.externalRedirect = externalRedirect;
    }

    public Map<String, Object> getTemplateDataModel() {
        return templateDataModel;
    }

    public void setTemplateDataModel(Map<String, Object> templateDataModel) {
        this.templateDataModel = templateDataModel;
    }

    public FlowResult getResult() {
        return result;
    }

    public void setResult(FlowResult result) {
        this.result = result;
    }

    public long getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(long startedAt) {
        this.startedAt = startedAt;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public ParentFlowData getParent() {
        return parent;
    }

    public void setParent(ParentFlowData parent) {
        this.parent = parent;
    }

}
