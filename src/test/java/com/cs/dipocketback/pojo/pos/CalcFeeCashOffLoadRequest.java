package com.cs.dipocketback.pojo.pos;

public class CalcFeeCashOffLoadRequest {

    private String posSerialNumber;
    private String publicToken;
    private Long amount;

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
}
