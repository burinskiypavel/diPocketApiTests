package com.cs.dipocketback.pojo.customer;



public class CardPreorderResponse {

    private String token;

    private Long powId;

    public CardPreorderResponse() {
    }

    public CardPreorderResponse(String token, Long powId) {
        this.token = token;
        this.powId = powId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }
}
