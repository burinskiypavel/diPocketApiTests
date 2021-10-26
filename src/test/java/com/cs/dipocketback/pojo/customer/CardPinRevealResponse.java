package com.cs.dipocketback.pojo.customer;

public class CardPinRevealResponse {
    
    private String pin;
    
    public CardPinRevealResponse() {
    }

    public CardPinRevealResponse(String pin) {
        this.pin = pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

}
