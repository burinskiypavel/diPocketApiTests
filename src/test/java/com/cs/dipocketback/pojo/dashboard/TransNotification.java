package com.cs.dipocketback.pojo.dashboard;

public class TransNotification {
    
    private Long id;
    private String tranType;
    private String finType;
    private String corrName;
    private String ccyCode;
    private Long amount;
    private String feeCcyCode;
    private Long feeAmount;
    private String status;
    private String tranDate;
    private String tranDateISO;
    private String description;
    
    public TransNotification() {
    }

    public TransNotification(String tranType, 
                             String tranDate, 
                             String tranDateISO) {
        this.tranType = tranType;
        this.tranDate = tranDate;
        this.tranDateISO = tranDateISO;
    }
    
    public TransNotification(Long id, 
                             String tranType, 
                             String finType, 
                             String corrName, 
                             String ccyCode, 
                             Long amount,
                             String feeCcyCode, 
                             Long feeAmount, 
                             String status, 
                             String tranDate,
                             String tranDateISO,
                             String description) {
        this.id = id;
        this.tranType = tranType;
        this.finType = finType;
        this.corrName = corrName;
        this.ccyCode = ccyCode;
        this.amount = amount;
        this.feeCcyCode = feeCcyCode;
        this.feeAmount = feeAmount;
        this.status = status;
        this.tranDate = tranDate;
        this.tranDateISO = tranDateISO;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTranDateISO(String tranDateISO) {
        this.tranDateISO = tranDateISO;
    }

    public String getTranDateISO() {
        return tranDateISO;
    }

}
