package com.cs.dipocketback.pojo.ecard;

public class GetCardInfoRequest {
    
    private String token;
    
    public GetCardInfoRequest() {
    }

    public GetCardInfoRequest(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
