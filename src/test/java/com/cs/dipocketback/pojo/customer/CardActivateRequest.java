package com.cs.dipocketback.pojo.customer;

import com.cs.dipocketback.pojo.customer.token.TokenContainer;

public class CardActivateRequest implements TokenContainer {
    
    private String requestId;
    private Long clientId;
    private String pan;
    private String token;
    private String publicToken;
    
    public CardActivateRequest() {
    }

    public CardActivateRequest(String requestId, Long clientId, String pan, String token) {
        this.requestId = requestId;
        this.clientId = clientId;
        this.pan = pan;
        this.token = token;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getPublicToken() {
        return publicToken;
    }

    @Override
    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

}
