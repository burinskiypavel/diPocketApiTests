package com.cs.dipocketback.pojo.registration;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class RegInfoAnalytics {
    
    //@JsonProperty("client_id")
    private long clientId;
    //@JsonProperty("action_id")
    private int actionId;
    //@JsonProperty("client_ip")
    private String clientIp;
    //@JsonProperty("os_id")
    private String osType;
    
    public RegInfoAnalytics() {
        
    }

    public RegInfoAnalytics(long clientId, int actionId, String clientIp, String osType) {
        this.clientId = clientId;
        this.actionId = actionId;
        this.clientIp = clientIp;
        this.osType = osType;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public int getActionId() {
        return actionId;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsType() {
        return osType;
    }
}

