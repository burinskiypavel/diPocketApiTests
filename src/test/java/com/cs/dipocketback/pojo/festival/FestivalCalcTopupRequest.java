package com.cs.dipocketback.pojo.festival;

public class FestivalCalcTopupRequest {
    
    private Long accountId;
    private Long amount;
    private String ccy;
    
    public FestivalCalcTopupRequest() {
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }
}
