package com.cs.dipocketback.pojo.dashboard;


public class DetailsReport {

    private Long tranItemId;
    private String tranType;
    private String finType;
    private String corrName;
    private String ccyCode;
    private Long amount;
    private String feeCcyCode;
    private Long feeAmount;
    private String status;
    private String tranDate;
    private String description;

    public DetailsReport() {
    }

    public DetailsReport(Long tranItemId,
                         String tranType,
                         String finType,
                         String corrName,
                         String ccyCode,
                         Long amount,
                         String feeCcyCode,
                         Long feeAmount,
                         String status,
                         String tranDate) {
      this.tranItemId = tranItemId;
      this.tranType = tranType;
      this.finType = finType;
      this.corrName = corrName;
      this.ccyCode = ccyCode;
      this.amount = amount;
      this.feeCcyCode = feeCcyCode;
      this.feeAmount = feeAmount;
      this.status = status;
      this.tranDate = tranDate;
    }

    public void setTranItemId(Long tranItemId) {
        this.tranItemId = tranItemId;
    }

    public Long getTranItemId() {
        return tranItemId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getTranType() {
        return tranType;
    }

    public void setFinType(String finType) {
        this.finType = finType;
    }

    public String getFinType() {
        return finType;
    }

    public void setCorrName(String corrName) {
        this.corrName = corrName;
    }

    public String getCorrName() {
        return corrName;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setFeeCcyCode(String feeCcyCode) {
        this.feeCcyCode = feeCcyCode;
    }

    public String getFeeCcyCode() {
        return feeCcyCode;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
