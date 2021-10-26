package com.cs.dipocketback.pojo.topUp;

import com.cs.dipocketback.iridium.pojo.PayVectorOutputDataResponse;

public class AddCardWithTopUpResponse {
    
    private String acsURL;
    private String md;
    private String paReq;
    private PayVectorOutputDataResponse.PayVectorStatusResponse status;
    private String token;
    
    public AddCardWithTopUpResponse() {
    }

    public AddCardWithTopUpResponse(PayVectorOutputDataResponse.PayVectorStatusResponse status) {
        this.status = status;
    }

    public void setAcsURL(String acsURL) {
        this.acsURL = acsURL;
    }

    public String getAcsURL() {
        return acsURL;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getMd() {
        return md;
    }

    public void setPaReq(String paReq) {
        this.paReq = paReq;
    }

    public String getPaReq() {
        return paReq;
    }

    public void setStatus(PayVectorOutputDataResponse.PayVectorStatusResponse status) {
        this.status = status;
    }

    public PayVectorOutputDataResponse.PayVectorStatusResponse getStatus() {
        return status;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
