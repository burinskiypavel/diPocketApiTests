package com.cs.dipocketback.pojo.pos;

public class StartNewShiftRequest {

    private String posSerialNumber;
    private String currencyCode;

    public String getPosSerialNumber() {
        return posSerialNumber;
    }

    public void setPosSerialNumber(String posSerialNumber) {
        this.posSerialNumber = posSerialNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
