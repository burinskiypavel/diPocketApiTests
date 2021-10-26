package com.cs.dipocketback.pojo.festival;

public class AnonymousCardInfoResponse {

    private Long availableBalance;
    private Boolean linked;
    private String ccy;
    private String pin;

    public AnonymousCardInfoResponse() {
    }

    public AnonymousCardInfoResponse(Long availableBalance, Boolean linked, String ccy, String pin) {
        this.availableBalance = availableBalance;
        this.linked = linked;
        this.ccy = ccy;
        this.pin = pin;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Boolean isLinked() {
        return linked;
    }

    public void setLinked(Boolean linked) {
        this.linked = linked;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}
