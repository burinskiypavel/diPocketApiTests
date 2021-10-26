package com.cs.dipocketback.pojo.customer;

public class CardPinRevealRequest {
    
    private String token;
    private String cvv;
    
    public CardPinRevealRequest() {
    }

    public CardPinRevealRequest(String token, String cvv) {
        this.token = token;
        this.cvv = cvv;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

}
