package com.cs.dipocketback.pojo.topUp;

public class CalculateNeosurfRequest {

    private Long dstAccountId;
    private String currencyCode;
    private Long amount;
    
    public CalculateNeosurfRequest() {
    }

    public Long getDstAccountId() {
        return dstAccountId;
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }
}
