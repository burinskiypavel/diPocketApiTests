package com.cs.dipocketback.pojo.payvector;

public class PvTDSClientTODO {
    
    private Long id;
    private String token;
    private String crossReference;
    private String acsUrl;
    private String paReq;
    
    public PvTDSClientTODO() {
    }

    public PvTDSClientTODO(Long id, 
                           String token, 
                           String crossReference, 
                           String acsUrl, 
                           String paReq) {
        this.id = id;
        this.token = token;
        this.crossReference = crossReference;
        this.acsUrl = acsUrl;
        this.paReq = paReq;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setAcsUrl(String acsUrl) {
        this.acsUrl = acsUrl;
    }

    public String getAcsUrl() {
        return acsUrl;
    }

    public void setPaReq(String paReq) {
        this.paReq = paReq;
    }

    public String getPaReq() {
        return paReq;
    }
    
}
