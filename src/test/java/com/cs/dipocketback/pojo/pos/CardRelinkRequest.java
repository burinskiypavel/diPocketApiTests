package com.cs.dipocketback.pojo.pos;

public class CardRelinkRequest {

    private String posSerialNumber;
    private String pan;
    private String qrCode;
    private Long feeAmount;
    private String feeCurrencyCode;

    public String getPosSerialNumber() {
        return posSerialNumber;
    }

    public void setPosSerialNumber(String posSerialNumber) {
        this.posSerialNumber = posSerialNumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }
}
