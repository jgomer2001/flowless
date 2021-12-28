package org.gluu.flowless.engine.model;

import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.gluu.util.Pair;

public class EngineConfig {

    public static final String ROOT_DIR = "/home/jgomer/Downloads/jetty/jetty-base/at";
    public static final String SCRIPTS_DIR = EngineConfig.ROOT_DIR + File.separator + "scripts";
    
    private int interruptionTime = 90;
    
    private String pageMismatchErrorPage = "mismatch.ftl";
    private String interruptionErrorPage = "timeout.ftl";  
    private String crashErrorPage = "crash.ftl";
    private String finishedFlowPage = "finished.ftl";
    
    private Map<String, String> defaultResponseHeaders = Stream.of(
                  new Pair<>(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML)
                , new Pair<>(HttpHeaders.EXPIRES, "0")
                //, new Pair<>(HttpHeaders.CACHE_CONTROL, "no-cache")
                //, new Pair<>(HttpHeaders.CACHE_CONTROL, "no-store")
        ).collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
    
    public String getJsonErrorPage(String page) {
        return "json_"+ page;
    }
    
    public int getInterruptionTime() {
        return interruptionTime;
    }

    public void setInterruptionTime(int interruptionTime) {
        this.interruptionTime = interruptionTime;
    }

    public String getInterruptionErrorPage() {
        return interruptionErrorPage;
    }

    public void setInterruptionErrorPage(String interruptionErrorPage) {
        this.interruptionErrorPage = interruptionErrorPage;
    }

    public String getCrashErrorPage() {
        return crashErrorPage;
    }

    public void setCrashErrorPage(String crashErrorPage) {
        this.crashErrorPage = crashErrorPage;
    }

    public String getPageMismatchErrorPage() {
        return pageMismatchErrorPage;
    }

    public void setPageMismatchErrorPage(String pageMismatchErrorPage) {
        this.pageMismatchErrorPage = pageMismatchErrorPage;
    }

    public String getFinishedFlowPage() {
        return finishedFlowPage;
    }

    public void setFinishedFlowPage(String finishedFlowPage) {
        this.finishedFlowPage = finishedFlowPage;
    }

    public Map<String, String> getDefaultResponseHeaders() {
        return defaultResponseHeaders;
    }

    public void setDefaultResponseHeaders(Map<String, String> defaultResponseHeaders) {
        this.defaultResponseHeaders = defaultResponseHeaders;
    }

}
