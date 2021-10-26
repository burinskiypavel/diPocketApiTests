package com.cs.dipocketback.pojo.payments.diptransfer;

import com.cs.dipocketback.pojo.payments.PayRequest;

public class DTCreateDipTransferRequest {

    private Double dipFXRateRev;
    private Double dipFXRate;
    private Boolean dipFXRateChanged;
    private Long dstAmount;
    private Integer dstCurrencyId;
    private String dstId;
    private Long fxCalcId;
    private String fxFixedSide;
    private Boolean isEnoughFunds;
    private Long srcAccountId;
    private Long srcAmount;
    private Integer srcCurrencyId;
    private Long srcFeeAmount;
    private Integer srcFeeCurrencyId;
    private Boolean isFeeEnoughFunds;
    private PayRequest.PayRequestStatus status;
    private Long transactionId;

    public Double getDipFXRateRev() {
        return dipFXRateRev;
    }

    public void setDipFXRateRev(Double dipFXRateRev) {
        this.dipFXRateRev = dipFXRateRev;
    }

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

    public Integer getDstCurrencyId() {
        return dstCurrencyId;
    }

    public void setDstCurrencyId(Integer dstCurrencyId) {
        this.dstCurrencyId = dstCurrencyId;
    }

    public String getDstId() {
        return dstId;
    }

    public void setDstId(String dstId) {
        this.dstId = dstId;
    }

    public Long getFxCalcId() {
        return fxCalcId;
    }

    public void setFxCalcId(Long fxCalcId) {
        this.fxCalcId = fxCalcId;
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

    public Boolean getIsFeeEnoughFunds() {
        return isFeeEnoughFunds;
    }

    public void setIsFeeEnoughFunds(Boolean feeEnoughFunds) {
        isFeeEnoughFunds = feeEnoughFunds;
    }

    public PayRequest.PayRequestStatus getStatus() {
        return status;
    }

    public void setStatus(PayRequest.PayRequestStatus status) {
        this.status = status;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
