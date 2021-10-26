package com.cs.dipocketback.pojo.payup;

import java.util.List;

public class PayUPReconciliation {
    
    private List<PayUpSettlement> settlements;
    
    public PayUPReconciliation() {
    }

    public PayUPReconciliation(List<PayUpSettlement> settlements) {
        this.settlements = settlements;
    }

    public void setSettlements(List<PayUpSettlement> settlements) {
        this.settlements = settlements;
    }

    public List<PayUpSettlement> getSettlements() {
        return settlements;
    }
}
