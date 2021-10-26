package com.cs.dipocketback.pojo.payments.f2f;

import com.cs.dipocketback.pojo.payments.PayRequest;

public class F2FComputeSendMoneyResponse {

    private Double dipFXRate;
    private Boolean dipFXRateChanged;
    private Long dstAmount;
    private String fxFixedSide;
    private Boolean isEnoughFunds;
    private Boolean isFeeEnoughFunds;
    private Long srcAccountId;
    private Long srcAmount;
    private Integer srcCurrencyId;
    private Long srcFeeAmount;
    private Integer srcFeeCurrencyId;
    private PayRequest.PayRequestStatus status;

    public Double getDipFXRate() {
        return dipFXRate;
    }

    public void setDipFXRate(Double dipFXRate) {
        this.dipFXRate = dipFXRate;
    }

    public Boolean getDipFXRateChanged() {
        return dipFXRateChanged;
    }

    public void setDipFXRateChanged(Boolean dipFXRateChanged) {
        this.dipFXRateChanged = dipFXRateChanged;
    }

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public String getFxFixedSide() {
        return fxFixedSide;
    }

    public void setFxFixedSide(String fxFixedSide) {
        this.fxFixedSide = fxFixedSide;
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

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Integer getSrcCurrencyId() {
        return srcCurrencyId;
    }

    public void setSrcCurrencyId(Integer srcCurrencyId) {
        this.srcCurrencyId = srcCurrencyId;
    }

    public Long getSrcFeeAmount() {
        return srcFeeAmount;
    }

    public void setSrcFeeAmount(Long srcFeeAmount) {
        this.srcFeeAmount = srcFeeAmount;
    }

    public Integer getSrcFeeCurrencyId() {
        return srcFeeCurrencyId;
    }

    public void setSrcFeeCurrencyId(Integer srcFeeCurrencyId) {
        this.srcFeeCurrencyId = srcFeeCurrencyId;
    }

    public PayRequest.PayRequestStatus getStatus() {
        return status;
    }

    public void setStatus(PayRequest.PayRequestStatus status) {
        this.status = status;
    }
}
