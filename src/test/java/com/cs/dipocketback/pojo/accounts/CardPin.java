package com.cs.dipocketback.pojo.accounts;

public class CardPin {
    
    private String pin;
    private String oldPin;
    private Long accountId;
    
    public CardPin() {
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setOldPin(String oldPin) {
        this.oldPin = oldPin;
    }

    public String getOldPin() {
        return oldPin;
    }
}
