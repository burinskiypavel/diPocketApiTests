package com.cs.dipocketback.pojo.customer;

import com.cs.dipocketback.pojo.gps.CardStatus;

public class CardBlockRequest {
    
    private String requestId;
    private String token;
    private CardStatus reason;
    
    public CardBlockRequest() {
    }

    public CardBlockRequest(String requestId, String token, CardStatus reason) {
        this.requestId = requestId;
        this.token = token;
        this.reason = reason;
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

    public void setReason(CardStatus reason) {
        this.reason = reason;
    }

    public CardStatus getReason() {
        return reason;
    }

}
