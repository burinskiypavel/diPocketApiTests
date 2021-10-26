package com.cs.dipocketback.pojo.festival;

import com.cs.dipocketback.iridium.pojo.PayVectorOutputDataResponse;


public class FestivalTopUpRequest {
    
    private String pan;
    private String cvv;
    private String validThru;
    private String postCode;
    private Long accountId;
    private Long amount;
    private String ccy; //default PLN
    private PayVectorOutputDataResponse.PayVectorStatusResponse status;
    private String paReq;
    private String termUrl;
    private String successUrl;
    private String errorUrl;
    private String md; // MD
    private String acsURL;
    private String accountName;
    private String token;
    
    //eCard: payByLink
    private String paymentType;
    private String returnLink;
    private String orderDescription;
    private String ecardUrl;
    private String paRes;
    private Long orderNumber;
    private String ipAddress;
    
    //fee
    private String feeCcy;
    private Long feeAmount;
    
    private Long powId;
    private Boolean doThreeDS;
    private String publicToken;


    private String httpAccept;

    private String httpUserAgent;

    public FestivalTopUpRequest() {
    }

    public FestivalTopUpRequest(PayVectorOutputDataResponse.PayVectorStatusResponse status) {
        this.status = status;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public void setAccountId(Long srcAccountId) {
        this.accountId = srcAccountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setStatus(PayVectorOutputDataResponse.PayVectorStatusResponse status) {
        this.status = status;
    }

    public PayVectorOutputDataResponse.PayVectorStatusResponse getStatus() {
        return status;
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

    public void setMd(String crossReference) {
        this.md = crossReference;
    }

    public String getMd() {
        return md;
    }

    public void setAcsURL(String acsURL) {
        this.acsURL = acsURL;
    }

    public String getAcsURL() {
        return acsURL;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setEcardUrl(String ecardUrl) {
        this.ecardUrl = ecardUrl;
    }

    public String getEcardUrl() {
        return ecardUrl;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setDoThreeDS(Boolean doThreeDS) {
        this.doThreeDS = doThreeDS;
    }

    public Boolean getDoThreeDS() {
        return doThreeDS;
    }

    public void setPaRes(String paRes) {
        this.paRes = paRes;
    }

    public String getPaRes() {
        return paRes;
    }

    public void setReturnLink(String returnLink) {
        this.returnLink = returnLink;
    }

    public String getReturnLink() {
        return returnLink;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setFeeCcy(String feeCcy) {
        this.feeCcy = feeCcy;
    }

    public String getFeeCcy() {
        return feeCcy;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
}
