package org.gluu.flowless.engine.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedList;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FlowStatus {
    
    private String qname;
    private String templatePath;
    private long startedAt;
    private Object templateDataModel;
    private LinkedList<ParentFlowData> parentsData = new LinkedList<>();
    private String externalRedirectUrl;
    private boolean allowCallbackResume;
    private String continuationHash;
    
    private FlowResult result;

    public Object getTemplateDataModel() {
        return templateDataModel;
    }

    public void setTemplateDataModel(Object templateDataModel) {
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

    public String getExternalRedirectUrl() {
        return externalRedirectUrl;
    }

    public void setExternalRedirectUrl(String externalRedirectUrl) {
        this.externalRedirectUrl = externalRedirectUrl;
    }

    public boolean isAllowCallbackResume() {
        return allowCallbackResume;
    }

    public void setAllowCallbackResume(boolean allowCallbackResume) {
        this.allowCallbackResume = allowCallbackResume;
    }

    public LinkedList<ParentFlowData> getParentsData() {
        return parentsData;
    }

    public void setParentsData(LinkedList<ParentFlowData> parentsData) {
        this.parentsData = parentsData;
    }

    public String getContinuationHash() {
        return continuationHash;
    }

    public void setContinuationHash(String continuationHash) {
        this.continuationHash = continuationHash;
    }

}
