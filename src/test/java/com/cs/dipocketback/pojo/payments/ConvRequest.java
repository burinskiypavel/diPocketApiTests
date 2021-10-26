package com.cs.dipocketback.pojo.payments;

public class ConvRequest {
    
    private Long tranId;
    private String accName;
    private Integer accCcyId;
    private String accCcy;
    private String accCcySymbol;
    private Long accAmount;
    private Integer trnCcyId;
    private String trnCcy;
    private String trnCcySymbol;
    private Long trnAmount;
    private Long fxCalcId;
    private String fxCalcReason;
    private Boolean fxRateChanged;
    private Double clientRate;
    private Double clientRateRev;
    private Integer feeCcyId;
    private String feeCcy;
    private String feeCcySymbol;
    private Long feeAmount;
    private Boolean isFeeEnoughFunds;
    private PayRequest.PayRequestStatus status;
    
    //create and accept
    private Long accFeeAmount;
    private Integer accFeeCcyId;
    private String accFeeCcy;
    
    public ConvRequest() {
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccCcyId(Integer accCcyId) {
        this.accCcyId = accCcyId;
    }

    public Integer getAccCcyId() {
        return accCcyId;
    }

    public void setAccCcy(String accCcy) {
        this.accCcy = accCcy;
    }

    public String getAccCcy() {
        return accCcy;
    }

    public void setAccAmount(Long accAmount) {
        this.accAmount = accAmount;
    }

    public Long getAccAmount() {
        return accAmount;
    }

    public void setTrnCcyId(Integer trnCcyId) {
        this.trnCcyId = trnCcyId;
    }

    public Integer getTrnCcyId() {
        return trnCcyId;
    }

    public void setTrnCcy(String trnCcy) {
        this.trnCcy = trnCcy;
    }

    public String getTrnCcy() {
        return trnCcy;
    }

    public void setTrnAmount(Long trnAmount) {
        this.trnAmount = trnAmount;
    }

    public Long getTrnAmount() {
        return trnAmount;
    }

    public void setFxCalcId(Long fxCalcId) {
        this.fxCalcId = fxCalcId;
    }

    public Long getFxCalcId() {
        return fxCalcId;
    }

    public void setClientRate(Double clientRate) {
        this.clientRate = clientRate;
    }

    public Double getClientRate() {
        return clientRate;
    }

    public void setClientRateRev(Double clientRateRev) {
        this.clientRateRev = clientRateRev;
    }

    public Double getClientRateRev() {
        return clientRateRev;
    }

    public void setFeeCcyId(Integer feeCcyId) {
        this.feeCcyId = feeCcyId;
    }

    public Integer getFeeCcyId() {
        return feeCcyId;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setIsFeeEnoughFunds(Boolean isFeeEnoughFunds) {
        this.isFeeEnoughFunds = isFeeEnoughFunds;
    }

    public Boolean getIsFeeEnoughFunds() {
        return isFeeEnoughFunds;
    }

    public void setStatus(PayRequest.PayRequestStatus status) {
        this.status = status;
    }

    public PayRequest.PayRequestStatus getStatus() {
        return status;
    }

    public void setFxRateChanged(Boolean fxRateChanged) {
        this.fxRateChanged = fxRateChanged;
    }

    public Boolean getFxRateChanged() {
        return fxRateChanged;
    }

    public void setFxCalcReason(String fxCalcReason) {
        this.fxCalcReason = fxCalcReason;
    }

    public String getFxCalcReason() {
        return fxCalcReason;
    }

    public void setAccCcySymbol(String accCcySymbol) {
        this.accCcySymbol = accCcySymbol;
    }

    public String getAccCcySymbol() {
        return accCcySymbol;
    }

    public void setTrnCcySymbol(String trnCcySymbol) {
        this.trnCcySymbol = trnCcySymbol;
    }

    public String getTrnCcySymbol() {
        return trnCcySymbol;
    }

    public void setFeeCcy(String feeCcy) {
        this.feeCcy = feeCcy;
    }

    public String getFeeCcy() {
        return feeCcy;
    }

    public void setFeeCcySymbol(String feeCcySymbol) {
        this.feeCcySymbol = feeCcySymbol;
    }

    public String getFeeCcySymbol() {
        return feeCcySymbol;
    }

    public void setAccFeeAmount(Long accFeeAmount) {
        this.accFeeAmount = accFeeAmount;
    }

    public Long getAccFeeAmount() {
        return accFeeAmount;
    }

    public void setAccFeeCcyId(Integer accFeeCcyId) {
        this.accFeeCcyId = accFeeCcyId;
    }

    public Integer getAccFeeCcyId() {
        return accFeeCcyId;
    }

    public void setAccFeeCcy(String accFeeCcy) {
        this.accFeeCcy = accFeeCcy;
    }

    public String getAccFeeCcy() {
        return accFeeCcy;
    }

    public PayRequest toPayRequest() {
        return new PayRequest(getAccCcyId(), getAccAmount(), getTrnCcyId(), getTrnAmount(), PayRequest.FX_FIXED_SIDE_SELL);
    }
}
