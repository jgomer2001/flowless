package org.gluu.flowless.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;

public class Method {
    
    @JsonIgnore
    private String id;
    
    private String className;
    private String methodName;
    private int arity;

    /**
     * @return the 
     */
    public String getId() {
        if (id == null) {
            id = String.format("%s#%s_%d", getClassName(), getMethodName(), getArity());
        }
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    public int getArity() {
        return arity;
    }

    public void setArity(int arity) {
        this.arity = arity;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object other) {
        
        if (Method.class.isInstance(other)) {
            String thisId = getId();
            String otherId = ((Method) other).getId();
            
            if (thisId == null) {
                return otherId == null;
            }
            return thisId.equals(otherId);
        }
        return false;
        
    }
    
    @Override
    public int hashCode() {
        return Optional.ofNullable(getId()).map(String::hashCode).orElse(0);
    }

}
