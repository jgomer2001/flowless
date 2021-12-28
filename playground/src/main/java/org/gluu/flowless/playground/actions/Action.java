package org.gluu.flowless.playground.actions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

import org.gluu.flowless.model.Name;
import org.gluu.flowless.model.Method;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Action extends Method {
    
    private String author;
    
    private String language = "java";
    private long timestamp;
    
    private Name name = new Name();
    private List<Name> inputs;
    
    private boolean returnsVoid;
    private String output;
    private Map<String, Object> customProps;

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the inputs
     */
    public List<Name> getInputs() {
        return inputs;
    }

    /**
     * @param inputs the inputs to set
     */
    public void setInputs(List<Name> inputs) {
        this.inputs = inputs;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public boolean isReturnsVoid() {
        return returnsVoid;
    }

    public void setReturnsVoid(boolean returnsVoid) {
        this.returnsVoid = returnsVoid;
    }

    public Map<String, Object> getCustomProps() {
        return customProps;
    }

    public void setCustomProps(Map<String, Object> customProps) {
        this.customProps = customProps;
    }

}
