package org.gluu.flowless.playground.actions;

import javax.lang.model.element.TypeElement;

public class Script {
    
    private String displayName;
    private String contents;
    
    private String getDisplayName() {
        return displayName;
    }
    
    private String getContents() {
        return contents;
    }
    
    public void setDisplayName(String dn) {
        this.displayName = dn;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }
    
}