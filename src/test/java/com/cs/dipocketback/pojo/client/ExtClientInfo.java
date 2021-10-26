package com.cs.dipocketback.pojo.client;

public class ExtClientInfo {
    
    private String extSystemId;
    private Long clientId;
    private String externalId;
    private String externalPass;
    private String accessToken;
    private String tokenType;
    private String expiresIn;
    private String tokenObtainedAt;
    private String refreshToken;
    
    public ExtClientInfo() {
    }

    public ExtClientInfo(String extSystemId, 
                         Long clientId, 
                         String externalId, 
                         String externalPass, 
                         String accessToken,
                         String tokenType, 
                         String expiresIn, 
                         String tokenObtainedAt, 
                         String refreshToken) {
        this.extSystemId = extSystemId;
        this.clientId = clientId;
        this.externalId = externalId;
        this.externalPass = externalPass;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.tokenObtainedAt = tokenObtainedAt;
        this.refreshToken = refreshToken;
    }

    public void setExtSystemId(String extSystemId) {
        this.extSystemId = extSystemId;
    }

    public String getExtSystemId() {
        return extSystemId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalPass(String externalPass) {
        this.externalPass = externalPass;
    }

    public String getExternalPass() {
        return externalPass;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setTokenObtainedAt(String tokenObtainedAt) {
        this.tokenObtainedAt = tokenObtainedAt;
    }

    public String getTokenObtainedAt() {
        return tokenObtainedAt;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
    
}
