package org.gluu.flowless.engine.model;

import java.util.Map;

public class FlowResult {
    
    private boolean aborted;
    private boolean success;
    private String error;
    private Map<String, Object> data;
    private FlowStats stats;

    public boolean isAborted() {
        return aborted;
    }

    public void setAborted(boolean aborted) {
        this.aborted = aborted;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public FlowStats getStats() {
        return stats;
    }

    public void setStats(FlowStats stats) {
        this.stats = stats;
    }
    
}
