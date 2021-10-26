package com.cs.dipocketback.pojo.payments;


public class ConvertedAmount {

    private Integer ccyId;
    private String ccyCode;
    private Long amount;
    private Integer feeCcyId;
    private String feeCcyCode;
    private Long fee;

    public void setFeeCcyId(Integer feeCcyId) {
        this.feeCcyId = feeCcyId;
    }

    public Integer getFeeCcyId() {
        return feeCcyId;
    }

    public void setFeeCcyCode(String feeCcyCode) {
        this.feeCcyCode = feeCcyCode;
    }

    public String getFeeCcyCode() {
        return feeCcyCode;
    }


    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
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

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }

    public ConvertedAmount() {
    }

    public ConvertedAmount(Integer ccyId, String ccyCode, Long amount, Integer feeCcyId, String feeCcyCode, Long fee) {
        this.ccyId = ccyId;
        this.ccyCode = ccyCode;
        this.amount = amount;
        this.feeCcyId = feeCcyId;
        this.feeCcyCode = feeCcyCode;
        this.fee = fee;
    }

}
