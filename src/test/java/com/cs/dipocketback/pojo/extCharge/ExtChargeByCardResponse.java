package com.cs.dipocketback.pojo.extCharge;

import com.cs.dipocketback.iridium.pojo.PayVectorOutputDataResponse;
import com.cs.dipocketback.pojo.topUp.TopUpResponse;

public class ExtChargeByCardResponse {

    private String acsURL;
    private String md;
    private String paReq;
    private PayVectorOutputDataResponse.PayVectorStatusResponse status;
    private String token;

    private Long transactionId;

    public ExtChargeByCardResponse() {
    }

    public ExtChargeByCardResponse(Long transactionId, TopUpResponse topUpResponse) {
        this.transactionId = transactionId;
        this.acsURL = topUpResponse.getAcsURL();
        this.md = topUpResponse.getMd();
        this.paReq = topUpResponse.getPaReq();
        this.status = topUpResponse.getStatus();
        this.token = topUpResponse.getToken();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAcsURL() {
        return acsURL;
    }

    public void setAcsURL(String acsURL) {
        this.acsURL = acsURL;
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

    public PayVectorOutputDataResponse.PayVectorStatusResponse getStatus() {
        return status;
    }

    public void setStatus(PayVectorOutputDataResponse.PayVectorStatusResponse status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
