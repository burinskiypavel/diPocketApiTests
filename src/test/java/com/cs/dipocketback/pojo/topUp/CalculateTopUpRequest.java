package com.cs.dipocketback.pojo.topUp;

public class CalculateTopUpRequest {
    
    private SubType srcAccountSubtype;
    private Long dstAccountId;
    private String currencyCode;
    private Long amount;
    
    public CalculateTopUpRequest() {
    }

    public CalculateTopUpRequest(SubType srcAccountSubtype, Long dstAccountId, String currencyCode, Long amount) {
        this.srcAccountSubtype = srcAccountSubtype;
        this.dstAccountId = dstAccountId;
        this.currencyCode = currencyCode;
        this.amount = amount;
    }

    public void setSrcAccountSubtype(SubType srcAccountSubtype) {
        this.srcAccountSubtype = srcAccountSubtype;
    }

    public SubType getSrcAccountSubtype() {
        return srcAccountSubtype;
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
