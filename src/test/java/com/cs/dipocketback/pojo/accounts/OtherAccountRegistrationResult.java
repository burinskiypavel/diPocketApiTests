package com.cs.dipocketback.pojo.accounts;


public class OtherAccountRegistrationResult {
    // status code of 0 - means transaction successful
    // status code of 3 - means 3D Secure authentication required

    private Integer statusCode;
    private String paReq;
    private String termUrl;
    private String successUrl;
    private String errorUrl;
    private String crossReference; // MD
    private String acsURL;
    private Long accountId;
    private String token;

    public OtherAccountRegistrationResult() {
    }

    public OtherAccountRegistrationResult(Integer statusCode) {
        this.statusCode = statusCode;
    }
    
    public OtherAccountRegistrationResult(Integer statusCode, Long accountId) {
        this.statusCode = statusCode;
        this.accountId = accountId;
    }
    
    public OtherAccountRegistrationResult(Integer statusCode, String paReq, String termUrl, String acsURL, String crossReference) {
        this.statusCode = statusCode;
        this.paReq = paReq;
        this.termUrl = termUrl;
        this.acsURL = acsURL;
        this.crossReference = crossReference;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setPaReq(String paReq) {
        this.paReq = paReq;
    }

    public String getPaReq() {
        return paReq;
    }

    public void setTermUrl(String termUrl) {
        this.termUrl = termUrl;
    }

    public String getTermUrl() {
        return termUrl;
    }

    public void setAcsURL(String acsURL) {
        this.acsURL = acsURL;
    }

    public String getAcsURL() {
        return acsURL;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
