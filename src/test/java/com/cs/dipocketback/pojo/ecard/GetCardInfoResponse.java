package com.cs.dipocketback.pojo.ecard;

public class GetCardInfoResponse {
    
    private String token;
    private String pan; 
    private String cvv;
    private String expDate;
    
    public GetCardInfoResponse() {
    }

    public GetCardInfoResponse(String token, String pan, String cvv, String expDate) {
        this.token = token;
        this.pan = pan;
        this.cvv = cvv;
        this.expDate = expDate;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }
}
