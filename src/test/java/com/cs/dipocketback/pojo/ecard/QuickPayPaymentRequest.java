package com.cs.dipocketback.pojo.ecard;

public class QuickPayPaymentRequest {
    
    private Long dstAccountId;
    private Integer currencyId;
    private Long amount;
    private String paymentType;
    private Integer feeCurrencyId;
    private Long feeAmount;
    private String note;
    
    public QuickPayPaymentRequest() {
    }

    public QuickPayPaymentRequest(Long dstAccountId, 
                                  Long amount, 
                                  String paymentType, 
                                  Integer feeCurrencyId,
                                  Long feeAmount, 
                                  String note) {
        this.dstAccountId = dstAccountId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.feeCurrencyId = feeCurrencyId;
        this.feeAmount = feeAmount;
        this.note = note;
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public Long getDstAccountId() {
        return dstAccountId;
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

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setFeeCurrencyId(Integer feeCurrencyId) {
        this.feeCurrencyId = feeCurrencyId;
    }

    public Integer getFeeCurrencyId() {
        return feeCurrencyId;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
    
}
