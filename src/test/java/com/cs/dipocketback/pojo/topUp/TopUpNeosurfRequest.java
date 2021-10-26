package com.cs.dipocketback.pojo.topUp;

public class TopUpNeosurfRequest {
    
    private Long dstAccountId;
    private Long amount;
    private String feeCurrencyCode;
    private Long feeAmount;
    private String note;
    
    public TopUpNeosurfRequest() {
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public Long getDstAccountId() {
        return dstAccountId;
    }

    public void setAmount(Long dstAmount) {
        this.amount = dstAmount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
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
