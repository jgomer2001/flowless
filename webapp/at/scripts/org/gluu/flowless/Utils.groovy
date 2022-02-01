package org.gluu.flowless;

import java.util.*;

import org.gluu.flowless.engine.script.ScriptUtils;
import org.gluu.flowless.engine.service.WebContext;

public class Utils {
    
    public static String getRequestUrl() {
        return ScriptUtils.managedBean(WebContext.class).getRequestUrl();
    }
    
    //TODO: remove the methods below

    public static int myMethod(List<Integer> elements) {
        return elements.stream().mapToInt(x -> x).sum();
    }

}
