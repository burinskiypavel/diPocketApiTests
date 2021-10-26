package com.cs.dipocketback.pojo.bo;

//import com.cs.dipocketback.base.data.Site;

import com.cs.dipocketback.base.data.Site;

import java.util.Map;

public class EmailBugReportRequest {

    private Long bugReportNumber;
    private Long clientId;
    private Site site;
    private String mainPhone;
    private String device;
    private String email;
    private String state;
    private String ddStatus;
    private String age;
    private String language;
    private String problem;
    private String occurrenceTime;
    private String occurrenceSide;
    private Map<String, String> attachmentsInBase64;

    public EmailBugReportRequest() {
    }

    public EmailBugReportRequest(Long bugReportNumber,  Long clientId, Site site, String mainPhone, String device,
                                 String email, String state, String ddStatus, String age, String language,
                                 String problem, String occurrenceTime, String occurrenceSide, Map<String, String> attachmentsInBase64) {
        this.bugReportNumber = bugReportNumber;
        this.clientId = clientId;
        this.site = site;
        this.mainPhone = mainPhone;
        this.device = device;
        this.email = email;
        this.state = state;
        this.ddStatus = ddStatus;
        this.age = age;
        this.language = language;
        this.problem = problem;
        this.occurrenceTime = occurrenceTime;
        this.occurrenceSide = occurrenceSide;
        this.attachmentsInBase64 = attachmentsInBase64;
    }

    public Long getBugReportNumber() {
        return bugReportNumber;
    }

    public void setBugReportNumber(Long bugReportNumber) {
        this.bugReportNumber = bugReportNumber;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getOccurrenceSide() {
        return occurrenceSide;
    }

    public void setOccurrenceSide(String occurrenceSide) {
        this.occurrenceSide = occurrenceSide;
    }

    public Map<String, String> getAttachmentsInBase64() {
        return attachmentsInBase64;
    }

    public void setAttachmentsInBase64(Map<String, String> attachmentsInBase64) {
        this.attachmentsInBase64 = attachmentsInBase64;
    }
}
