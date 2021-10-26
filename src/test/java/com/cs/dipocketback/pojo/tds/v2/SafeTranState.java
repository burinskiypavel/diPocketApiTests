package com.cs.dipocketback.pojo.tds.v2;

public class SafeTranState {
    private Long clientId;
    private Long tranId;

    public SafeTranState() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }
}
