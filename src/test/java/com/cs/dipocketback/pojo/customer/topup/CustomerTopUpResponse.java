package com.cs.dipocketback.pojo.customer.topup;



public class CustomerTopUpResponse {


    private Long powId;
    private String acsUrl;
    private String md;
    private String paReq;
    private String topUpToken;
    private Long transactionId;
    private Long feeAmount;
    private String feeCurrencyCode;
    private CustomerTopUpStatus topUpStatus;

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public String getAcsUrl() {
        return acsUrl;
    }

    public void setAcsUrl(String acsUrl) {
        this.acsUrl = acsUrl;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getPaReq() {
        return paReq;
    }

    public void setPaReq(String paReq) {
        this.paReq = paReq;
    }

    public String getTopUpToken() {
        return topUpToken;
    }

    public void setTopUpToken(String topUpToken) {
        this.topUpToken = topUpToken;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public CustomerTopUpStatus getTopUpStatus() {
        return topUpStatus;
    }

    public void setTopUpStatus(CustomerTopUpStatus topUpStatus) {
        this.topUpStatus = topUpStatus;
    }
}
