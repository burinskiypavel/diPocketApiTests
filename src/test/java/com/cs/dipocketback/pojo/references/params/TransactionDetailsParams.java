package com.cs.dipocketback.pojo.references.params;

public class TransactionDetailsParams {

    private Boolean isCategoryChangeable;
    private Boolean isPaymentsRepeatable;

    public TransactionDetailsParams() {
    }

    public void setIsCategoryChangeable(Boolean isCategoryChangeable) {
        this.isCategoryChangeable = isCategoryChangeable;
    }

    public Boolean getIsCategoryChangeable() {
        return isCategoryChangeable;
    }

    public void setIsPaymentsRepeatable(Boolean isPaymentsRepeatable) {
        this.isPaymentsRepeatable = isPaymentsRepeatable;
    }

    public Boolean getIsPaymentsRepeatable() {
        return isPaymentsRepeatable;
    }

}
