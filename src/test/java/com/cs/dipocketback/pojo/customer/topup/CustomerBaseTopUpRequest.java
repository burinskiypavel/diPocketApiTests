package com.cs.dipocketback.pojo.customer.topup;

public abstract class CustomerBaseTopUpRequest {

    private String requestId;
    private Long amount;
    private String note;
    private String currencyCode;
    private Boolean setRecurring;
    private Long dstAccountId;
    private Boolean browserJavascriptEnabled;
    private String browserLanguage;
    private Integer browserScreenColorDepth;
    private Integer browserScreenHeight;
    private Integer browserScreenWidth;
    private String browserTimeZone;
    private String httpAccept;
    private String httpUserAgent;
    private String clientIpAddress;
    private String redirectUrl;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Boolean getSetRecurring() {
        return setRecurring;
    }

    public void setSetRecurring(Boolean setRecurring) {
        this.setRecurring = setRecurring;
    }

    public Long getDstAccountId() {
        return dstAccountId;
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public Boolean getBrowserJavascriptEnabled() {
        return browserJavascriptEnabled;
    }

    public void setBrowserJavascriptEnabled(Boolean browserJavascriptEnabled) {
        this.browserJavascriptEnabled = browserJavascriptEnabled;
    }

    public String getBrowserLanguage() {
        return browserLanguage;
    }

    public void setBrowserLanguage(String browserLanguage) {
        this.browserLanguage = browserLanguage;
    }

    public Integer getBrowserScreenColorDepth() {
        return browserScreenColorDepth;
    }

    public void setBrowserScreenColorDepth(Integer browserScreenColorDepth) {
        this.browserScreenColorDepth = browserScreenColorDepth;
    }

    public Integer getBrowserScreenHeight() {
        return browserScreenHeight;
    }

    public void setBrowserScreenHeight(Integer browserScreenHeight) {
        this.browserScreenHeight = browserScreenHeight;
    }

    public Integer getBrowserScreenWidth() {
        return browserScreenWidth;
    }

    public void setBrowserScreenWidth(Integer browserScreenWidth) {
        this.browserScreenWidth = browserScreenWidth;
    }

    public String getBrowserTimeZone() {
        return browserTimeZone;
    }

    public void setBrowserTimeZone(String browserTimeZone) {
        this.browserTimeZone = browserTimeZone;
    }

    public String getHttpAccept() {
        return httpAccept;
    }

    public void setHttpAccept(String httpAccept) {
        this.httpAccept = httpAccept;
    }

    public String getHttpUserAgent() {
        return httpUserAgent;
    }

    public void setHttpUserAgent(String httpUserAgent) {
        this.httpUserAgent = httpUserAgent;
    }

    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

}
