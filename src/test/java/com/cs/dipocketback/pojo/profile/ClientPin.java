package com.cs.dipocketback.pojo.profile;

public class ClientPin {
    
    private String oldPin;
    private String pin1;
    private String pin2;
    
    public ClientPin() {
    }

    public ClientPin(String oldPin, String pin1, String pin2) {
        this.oldPin = oldPin;
        this.pin1 = pin1;
        this.pin2 = pin2;
    }

    public void setPin1(String pin1) {
        this.pin1 = pin1;
    }

    public String getPin1() {
        return pin1;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }

    public String getPin2() {
        return pin2;
    }

    public void setOldPin(String oldPin) {
        this.oldPin = oldPin;
    }

    public String getOldPin() {
        return oldPin;
    }
}
