package com.cs.dipocketback.pojo.bacca;

public class BaccaClientToken {
    
    private String accessToken;
    private String refreshToken;
    private Boolean tokenExpired;
    private String tokenType;
    private String tokenScope;
    private String resetPasswordUrl;
    
    public BaccaClientToken() {
    }

    public BaccaClientToken(String accessToken, 
                            String refreshToken, 
                            Boolean tokenExpired, 
                            String tokenType,
                            String tokenScope, 
                            String resetPasswordUrl) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenExpired = tokenExpired;
        this.tokenType = tokenType;
        this.tokenScope = tokenScope;
        this.resetPasswordUrl = resetPasswordUrl;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setTokenExpired(Boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Boolean getTokenExpired() {
        return tokenExpired;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenScope(String tokenScope) {
        this.tokenScope = tokenScope;
    }

    public String getTokenScope() {
        return tokenScope;
    }

    public void setResetPasswordUrl(String resetPasswordUrl) {
        this.resetPasswordUrl = resetPasswordUrl;
    }

    public String getResetPasswordUrl() {
        return resetPasswordUrl;
    }
    
}
