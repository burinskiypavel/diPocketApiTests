package com.cs.dipocketback.pojo.customer;

public class CardSetPinRequest {
    
    private String requestId;
    private String token;
    private String pin;
    
    public CardSetPinRequest() {
    }

    public CardSetPinRequest(String requestId, String token, String pin) {
        this.requestId = requestId;
        this.token = token;
        this.pin = pin;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

}
