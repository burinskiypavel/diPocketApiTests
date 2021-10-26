package com.cs.dipocketback.pojo.customer;

public class CardUnblockRequest {
    
    private String requestId;
    private String token;
    
    public CardUnblockRequest() {
    }

    public CardUnblockRequest(String requestId, String token) {
        this.requestId = requestId;
        this.token = token;
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

}
