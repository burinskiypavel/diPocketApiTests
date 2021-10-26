package com.cs.dipocketback.pojo.ecard;

public class ECardClientThreeDS {
    
    private String token;
    private String redirectUrl;
    private String threeDsMD;
    private String threeDsResult;
    private String threeDsPaReq;
    
    public ECardClientThreeDS() {
    }

    public ECardClientThreeDS(String token, 
                              String redirectUrl, 
                              String threeDsMD, 
                              String threeDsResult,
                              String threeDsPaReq) {
        this.token = token;
        this.redirectUrl = redirectUrl;
        this.threeDsMD = threeDsMD;
        this.threeDsResult = threeDsResult;
        this.threeDsPaReq = threeDsPaReq;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setThreeDsMD(String threeDsMD) {
        this.threeDsMD = threeDsMD;
    }

    public String getThreeDsMD() {
        return threeDsMD;
    }

    public void setThreeDsResult(String threeDsResult) {
        this.threeDsResult = threeDsResult;
    }

    public String getThreeDsResult() {
        return threeDsResult;
    }

    public void setThreeDsPaReq(String threeDsPaReq) {
        this.threeDsPaReq = threeDsPaReq;
    }

    public String getThreeDsPaReq() {
        return threeDsPaReq;
    }
    
}
