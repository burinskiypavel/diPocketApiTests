package com.cs.dipocketback.pojo.topUp;

public class TopUpRequest {
    
    private Long dstAccountId;
    private String dstCurrencyCode;
    private Long dstAmount;
    
    private Long srcAccountId;
    private SubType srcAccountSubtype;  
    
    private String feeCurrencyCode;
    private Long feeAmount;
    
    private String note;
    private String cvv; // for PAYVECTOR
    
    public TopUpRequest() {
    }

    public TopUpRequest(Long dstAccountId, String dstCurrencyCode, Long dstAmount, Long srcAccountId, 
                        SubType srcAccountSubtype, String feeCurrencyCode, Long feeAmount,
                        String note, String cvv) {
        this.dstAccountId = dstAccountId;
        this.dstCurrencyCode = dstCurrencyCode;
        this.dstAmount = dstAmount;
        this.srcAccountId = srcAccountId;
        this.srcAccountSubtype = srcAccountSubtype;
        this.feeCurrencyCode = feeCurrencyCode;
        this.feeAmount = feeAmount;
        this.note = note;
        this.cvv = cvv;
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public Long getDstAccountId() {
        return dstAccountId;
    }

    public void setDstCurrencyCode(String dstCurrencyCode) {
        this.dstCurrencyCode = dstCurrencyCode;
    }

    public String getDstCurrencyCode() {
        return dstCurrencyCode;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountSubtype(SubType srcAccountSubtype) {
        this.srcAccountSubtype = srcAccountSubtype;
    }

    public SubType getSrcAccountSubtype() {
        return srcAccountSubtype;
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

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

}
