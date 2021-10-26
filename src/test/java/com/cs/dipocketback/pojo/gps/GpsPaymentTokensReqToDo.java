package com.cs.dipocketback.pojo.gps;

public class GpsPaymentTokensReqToDo {
    
    private Long wsId;
    private String publicToken;


    public GpsPaymentTokensReqToDo(Long wsId, String publicToken) {
        this.wsId = wsId;
        this.publicToken = publicToken;
    }

    public Long getWsId() {
        return wsId;
    }

    public String getPublicToken() {
        return publicToken;
    }
    
}
