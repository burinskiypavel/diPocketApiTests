package com.cs.dipocketback.pojo.payments.diptransfer;

public class DTCalculateDiPTransferRequest {

    private Long dstAmount;
    private Long srcAmount;
    private Integer dstCurrencyId;
    private String fxFixedSide;
    private Long srcAccountId;
    private String dstId;

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Integer getDstCurrencyId() {
        return dstCurrencyId;
    }

    public void setDstCurrencyId(Integer dstCurrencyId) {
        this.dstCurrencyId = dstCurrencyId;
    }

    public String getFxFixedSide() {
        return fxFixedSide;
    }

    public void setFxFixedSide(String fxFixedSide) {
        this.fxFixedSide = fxFixedSide;
    }

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public String getDstId() {
        return dstId;
    }

    public void setDstId(String dstId) {
        this.dstId = dstId;
    }
}
