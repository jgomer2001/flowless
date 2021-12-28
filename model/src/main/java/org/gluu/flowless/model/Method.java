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
        return Method.class.isInstance(other) && id.equals(((Method) other).getId());
    }
    
    @Override
    public int hashCode() {
        return Optional.ofNullable(id).map(String::hashCode).orElse(0);
    }

}
