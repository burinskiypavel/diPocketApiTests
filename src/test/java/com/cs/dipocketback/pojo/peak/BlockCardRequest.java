package com.cs.dipocketback.pojo.peak;

public class BlockCardRequest {
    
    private String requestId;
    private String publicToken; //123456789
    private PeakCardStatus reason;
    
    public BlockCardRequest() {
    }

    public BlockCardRequest(String requestId, String publicToken, PeakCardStatus reason) {
        this.requestId = requestId;
        this.publicToken = publicToken;
        this.reason = reason;
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

    public void setReason(PeakCardStatus reason) {
        this.reason = reason;
    }

    public PeakCardStatus getReason() {
        return reason;
    }

}
