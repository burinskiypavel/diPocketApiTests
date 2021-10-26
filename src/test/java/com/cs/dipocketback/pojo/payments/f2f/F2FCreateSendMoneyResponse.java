package com.cs.dipocketback.pojo.payments.f2f;

import com.cs.dipocketback.pojo.payments.PayRequest;

public class F2FCreateSendMoneyResponse {

    private Integer dstCurrencyId;
    private Long dstAmount;
    private Long srcAccountId;
    private Integer srcCurrencyId;
    private Long srcAmount;
    private Integer srcFeeCurrencyId;
    private Long srcFeeAmount;
    private Boolean isEnoughFunds;
    private Boolean isFeeEnoughFunds;
    private String fxFixedSide;
    private PayRequest.PayRequestStatus status;
    private String qrCode;

    public Integer getDstCurrencyId() {
        return dstCurrencyId;
    }

    public void setDstCurrencyId(Integer dstCurrencyId) {
        this.dstCurrencyId = dstCurrencyId;
    }

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public Integer getSrcCurrencyId() {
        return srcCurrencyId;
    }

    public void setSrcCurrencyId(Integer srcCurrencyId) {
        this.srcCurrencyId = srcCurrencyId;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Integer getSrcFeeCurrencyId() {
        return srcFeeCurrencyId;
    }

    public void setSrcFeeCurrencyId(Integer srcFeeCurrencyId) {
        this.srcFeeCurrencyId = srcFeeCurrencyId;
    }

    public Long getSrcFeeAmount() {
        return srcFeeAmount;
    }

    public void setSrcFeeAmount(Long srcFeeAmount) {
        this.srcFeeAmount = srcFeeAmount;
    }

    public Boolean getIsEnoughFunds() {
        return isEnoughFunds;
    }

    public void setIsEnoughFunds(Boolean enoughFunds) {
        isEnoughFunds = enoughFunds;
    }

    public Boolean getIsFeeEnoughFunds() {
        return isFeeEnoughFunds;
    }

    public void setIsFeeEnoughFunds(Boolean feeEnoughFunds) {
        isFeeEnoughFunds = feeEnoughFunds;
    }

    public String getFxFixedSide() {
        return fxFixedSide;
    }

    public void setFxFixedSide(String fxFixedSide) {
        this.fxFixedSide = fxFixedSide;
    }

    public PayRequest.PayRequestStatus getStatus() {
        return status;
    }

    public void setStatus(PayRequest.PayRequestStatus status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
