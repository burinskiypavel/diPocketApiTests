package com.cs.dipocketback.pojo.topUp;

public class AddCardWithTopUpRequest {
    
    private Long dstAccountId;
    private Long dstAmount;
    private String dstCurrencyCode;
    
    private String accounName;
    private String pan;
    private String cvv;
    private String validThru;

    private String feeCurrencyCode;
    private Long feeAmount;
    
    private String note;
    
    public AddCardWithTopUpRequest() {
    }

    public AddCardWithTopUpRequest(Long dstAccountId, Long dstAmount, String accounName, String pan, String cvv,
                                   String validThru, String dstCurrencyCode, String feeCurrencyCode, Long feeAmount,
                                   String note) {
        this.dstAccountId = dstAccountId;
        this.dstAmount = dstAmount;
        this.accounName = accounName;
        this.pan = pan;
        this.cvv = cvv;
        this.validThru = validThru;
        this.dstCurrencyCode = dstCurrencyCode;
        this.feeCurrencyCode = feeCurrencyCode;
        this.feeAmount = feeAmount;
        this.note = note;
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public Long getDstAccountId() {
        return dstAccountId;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setAccounName(String accounName) {
        this.accounName = accounName;
    }

    public String getAccounName() {
        return accounName;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setDstCurrencyCode(String dstCurrencyCode) {
        this.dstCurrencyCode = dstCurrencyCode;
    }

    public String getDstCurrencyCode() {
        return dstCurrencyCode;
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

}
