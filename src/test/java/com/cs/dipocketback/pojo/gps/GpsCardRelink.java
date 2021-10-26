package com.cs.dipocketback.pojo.gps;

public class GpsCardRelink {
    
    private Long wsId;
    private String publicToken;
    private String newPublicToken;

    public GpsCardRelink(Long wsId, String publicToken, String newPublicToken) {
        this.wsId = wsId;
        this.publicToken = publicToken;
        this.newPublicToken = newPublicToken;
    }

    public Long getWsId() {
        return wsId;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public String getNewPublicToken() {
        return newPublicToken;
    }

}
