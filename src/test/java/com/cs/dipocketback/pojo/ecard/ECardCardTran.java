package com.cs.dipocketback.pojo.ecard;

public class ECardCardTran {

    private Long tranId;
    private String token;
    private ECardPanType panType;

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ECardPanType getPanType() {
        return panType;
    }

    public void setPanType(ECardPanType panType) {
        this.panType = panType;
    }
}
