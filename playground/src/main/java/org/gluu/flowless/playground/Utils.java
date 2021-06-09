package org.gluu.flowless.playground;

public class Utils {
    
    public static String filenameExtension(String fileName) {
        int dotAt = fileName.indexOf(".");                
        return dotAt > 0 ? fileName.substring(dotAt + 1) : null;
    }
    
}
