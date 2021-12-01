package org.gluu.flowless.engine.page;

public class Page {
    
    private String templatePath;
    private Object dataModel;
    
    public Page(String path) {
        this.templatePath = path;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public Object getDataModel() {
        return dataModel;
    }

    public void setDataModel(Object dataModel) {
        this.dataModel = dataModel;
    }

    
}
