package com.cs.dipocketback.pojo.ecard;

public class QuickPayPaymentFeeRequest {

    private Long dstAccountId;
    private Integer currencyId;
    private Long amount;
    
    public QuickPayPaymentFeeRequest() {
    }

    public QuickPayPaymentFeeRequest(Long dstAccountId, Integer currencyId, Long amount) {
        this.dstAccountId = dstAccountId;
        this.currencyId = currencyId;
        this.amount = amount;
    }

    public Long getDstAccountId() {
        return dstAccountId;
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }
    
}
