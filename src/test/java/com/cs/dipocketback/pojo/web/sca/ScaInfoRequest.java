package com.cs.dipocketback.pojo.web.sca;

public class ScaInfoRequest {

    private String sessionId;
    private String phone;
    private String site;
    private String sca;

    public ScaInfoRequest() {
    }

    public ScaInfoRequest(String sessionId, String phone, String site, String sca) {
        this.sessionId = sessionId;
        this.phone = phone;
        this.site = site;
        this.sca = sca;
    }

    public ScaInfoRequest(Long sessionId, String phone, String site, String sca) {
        this.sessionId = Long.toString(sessionId);
        this.phone = phone;
        this.site = site;
        this.sca = sca;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSca() {
        return sca;
    }

    public void setSca(String sca) {
        this.sca = sca;
    }

}
