package com.cs.dipocketback.pojo.peak;

public class CardSetPinRequest {
    
    private String requestId;
    private String publicToken;
    private String pin;
    
    public CardSetPinRequest() {
    }

    public CardSetPinRequest(String requestId, String publicToken, String pin) {
        this.requestId = requestId;
        this.publicToken = publicToken;
        this.pin = pin;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

}
