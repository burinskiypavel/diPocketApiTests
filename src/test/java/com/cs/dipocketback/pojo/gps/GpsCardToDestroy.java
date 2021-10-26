package com.cs.dipocketback.pojo.gps;

public class GpsCardToDestroy {
    
    private Long wsId;
    private Long id;
    private Long accountId;
    private Integer typeId;
    private String publicToken;
    private Integer authType;


    public GpsCardToDestroy(Long wsId, Long id, Long accountId, Integer typeId, String publicToken, Integer authType) {
        this.wsId = wsId;
        this.id = id;
        this.accountId = accountId;
        this.typeId = typeId;
        this.publicToken = publicToken;
        this.authType = authType;
    }

    public Long getWsId() {
        return wsId;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public Integer getAuthType() {
        return authType;
    }
}
