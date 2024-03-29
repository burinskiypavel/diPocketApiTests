package com.cs.dipocketback.pojo.playit;

public class PlsAuthResponse {

    private String accessToken;
    private String tokenType;
    private String expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "PlsAuthResponse{" + 
               "accessToken='" + accessToken + '\'' + 
               ", tokenType='" + tokenType + '\'' +
               ", expiresIn='" + expiresIn + '\'' + 
            '}';
    }
}
