package com.cs.dipocketback.pojo.pos;

public class DoCashLoadRequest {

    private String posSerialNumber;
    private String publicToken;
    private Long amount;
    private String feeCurrencyCode;
    private Long feeAmount;
    private String note;

    public String getPosSerialNumber() {
        return posSerialNumber;
    }

    public void setPosSerialNumber(String posSerialNumber) {
        this.posSerialNumber = posSerialNumber;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
