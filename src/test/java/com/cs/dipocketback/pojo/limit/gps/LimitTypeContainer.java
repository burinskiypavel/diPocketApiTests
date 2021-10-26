package com.cs.dipocketback.pojo.limit.gps;

public class LimitTypeContainer {
    
    private Limit purchaseLimit;
    private Limit cashLimit;
        
    public LimitTypeContainer() {
    }

    public LimitTypeContainer(Limit purchaseLimit, Limit cashLimit) {
        this.purchaseLimit = purchaseLimit;
        this.cashLimit = cashLimit;
    }

    public void setPurchaseLimit(Limit purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public Limit getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setCashLimit(Limit cashLimit) {
        this.cashLimit = cashLimit;
    }

    public Limit getCashLimit() {
        return cashLimit;
    }

}
