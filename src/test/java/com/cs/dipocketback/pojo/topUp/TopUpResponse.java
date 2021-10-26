package com.cs.dipocketback.pojo.topUp;

import com.cs.dipocketback.iridium.pojo.PayVectorOutputDataResponse;

public class TopUpResponse {
    
    private String acsURL;
    private String md;
    private String paReq;
    private PayVectorOutputDataResponse.PayVectorStatusResponse status;
    private String token;
    private String returnLink;
    private String successUrl;
    private String errorUrl;
    
    public TopUpResponse() {
    }

    public TopUpResponse(PayVectorOutputDataResponse.PayVectorStatusResponse status) {
        this.status = status;
    }

    public TopUpResponse(String acsURL, String md, String paReq,
                              PayVectorOutputDataResponse.PayVectorStatusResponse status, String token) {
        this.acsURL = acsURL;
        this.md = md;
        this.paReq = paReq;
        this.status = status;
        this.token = token;
    }

    public TopUpResponse(String acsURL, String md, String paReq,
                              PayVectorOutputDataResponse.PayVectorStatusResponse status, String token,
                              String returnLink) {
        this.acsURL = acsURL;
        this.md = md;
        this.paReq = paReq;
        this.status = status;
        this.token = token;
        this.returnLink = returnLink;
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

    public void setReturnLink(String returnLink) {
        this.returnLink = returnLink;
    }

    public String getReturnLink() {
        return returnLink;
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
}
