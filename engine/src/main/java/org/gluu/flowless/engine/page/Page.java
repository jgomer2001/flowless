package org.gluu.flowless.engine.page;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.gluu.flowless.engine.service.WebContext;

@RequestScoped
public class Page {
    
    private static final String WEB_CTX_KEY = "webCtx";
    private static final String LABELS_KEY = "msgs";
    
    @Inject
    private WebContext webContext;
    
    @Inject
    private ObjectMapper mapper;
    
    private String templatePath;
    private Map<String, Object> dataModel;
    private Labels labels;
    private Object rawModel;

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public Object getDataModel() {
        
        if (rawModel == null) {
            if (dataModel != null) {
                dataModel.putIfAbsent(WEB_CTX_KEY, webContext);
                dataModel.putIfAbsent(LABELS_KEY, labels);
                return dataModel;
            } else return new Object();
        } else return rawModel;
        
    }

    /**
     * This call is cheaper than setDataModel, but pages won't have access to any
     * contextual data
     * @param object 
     */
    public void setRawDataModel(Object object) {       
        rawModel = object;
        dataModel = null;
    }

    public void setDataModel(Object object) {
        rawModel = null;
        dataModel = mapFromObject(object);
    }
    
    public void appendToDataModel(Object object) {
        if (rawModel != null) {
            rawModel = null;
            dataModel = new HashMap<>();
        }
        dataModel.putAll(mapFromObject(object));
    }
    
    private Map<String, Object> mapFromObject(Object object) {
        return mapper.convertValue(object, new TypeReference<Map<String, Object>>(){});
    }

    @PostConstruct
    private void init() {
        dataModel = new HashMap<>();
        labels = new Labels();
    }
    
}
