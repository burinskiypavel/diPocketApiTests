package com.cs.dipocketback.pojo.customer.topup;

public class CustomerTopUpRequest extends CustomerBaseTopUpRequest{

    private Long recurringId;
    private Long thirdPartyCardId;

    public Long getRecurringId() {
        return recurringId;
    }

    public void setRecurringId(Long recurringId) {
        this.recurringId = recurringId;
    }

    public Long getThirdPartyCardId() {
        return thirdPartyCardId;
    }

    public void setThirdPartyCardId(Long thirdPartyCardId) {
        this.thirdPartyCardId = thirdPartyCardId;
    }
}
