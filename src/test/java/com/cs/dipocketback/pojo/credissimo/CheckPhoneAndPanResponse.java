package com.cs.dipocketback.pojo.credissimo;

public class CheckPhoneAndPanResponse {
    
    private String publicToken;
    
    public CheckPhoneAndPanResponse() {
    }

    public CheckPhoneAndPanResponse(String publicToken) {
        this.publicToken = publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }
}
