package org.gluu.flowless.engine.exception;

public class FlowTimeoutException extends Exception {
    
    private String qname;
    
    public FlowTimeoutException(String message, String flowQname) {
        super(message);
        qname = flowQname;
    }

    public String getQname() {
        return qname;
    }
    
}
