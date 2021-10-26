package com.cs.dipocketback.pojo.credissimo;

public class LinkAccToClient {

    private String requestId;
    private String token;
    private String phoneNumber;

    public LinkAccToClient() {
    }

    public LinkAccToClient(String requestId, String token, String phoneNumber) {
        this.requestId = requestId;
        this.token = token;
        this.phoneNumber = phoneNumber;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
