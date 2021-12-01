package org.gluu.flowless.engine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flow {
    
    private String qname;
    private String id;

    @JsonProperty(value="inputs")
    private List<String> inputNames;

    public List<String> getInputNames() {
        return inputNames;
    }

    public void setInputNames(List<String> inputs) {
        this.inputNames = inputs;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
