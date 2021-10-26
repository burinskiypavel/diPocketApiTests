package com.cs.dipocketback.pojo.peak;

public class UnblockCardRequest {
    
    private String requestId;
    private String publicToken;
    
    public UnblockCardRequest() {
    }

    public UnblockCardRequest(String requestId, String publicToken) {
        this.requestId = requestId;
        this.publicToken = publicToken;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

}
