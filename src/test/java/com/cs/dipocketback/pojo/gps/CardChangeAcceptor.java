package com.cs.dipocketback.pojo.gps;

public class CardChangeAcceptor {
    
    private Long id;
    private Long wsid;
    private String publicToken;
    private String whiteList;
    private String blackList;
    
    public CardChangeAcceptor() {
    }

    public CardChangeAcceptor(Long id, 
                              Long wsid, 
                              String publicToken, 
                              String whiteList, 
                              String blackList) {
        this.id = id;
        this.wsid = wsid;
        this.publicToken = publicToken;
        this.whiteList = whiteList;
        this.blackList = blackList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setWsid(Long wsid) {
        this.wsid = wsid;
    }

    public Long getWsid() {
        return wsid;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList;
    }

    public String getWhiteList() {
        return whiteList;
    }

    public void setBlackList(String blackList) {
        this.blackList = blackList;
    }

    public String getBlackList() {
        return blackList;
    }
    
}
