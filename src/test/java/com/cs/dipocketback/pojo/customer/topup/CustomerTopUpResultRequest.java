package com.cs.dipocketback.pojo.customer.topup;

public class CustomerTopUpResultRequest {

    private String topUpToken;
    private String paRes;

    public String getTopUpToken() {
        return topUpToken;
    }

    public void setTopUpToken(String topUpToken) {
        this.topUpToken = topUpToken;
    }

    public String getPaRes() {
        return paRes;
    }

    public void setPaRes(String paRes) {
        this.paRes = paRes;
    }
}
