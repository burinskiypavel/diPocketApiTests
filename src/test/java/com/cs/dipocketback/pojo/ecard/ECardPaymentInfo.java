package com.cs.dipocketback.pojo.ecard;

public class ECardPaymentInfo {
    
    private Long clientId;
    private Long tranId;
    
    public ECardPaymentInfo() {
    }

    public ECardPaymentInfo(Long clientId, Long tranId) {
        this.clientId = clientId;
        this.tranId = tranId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }
}
