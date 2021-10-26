package com.cs.dipocketback.pojo.applepay;

public class ApplePayTokenizationResponse {

    private String encryptedData;
    private String ephemeralPublicKey;
    private String activationData;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getEphemeralPublicKey() {
        return ephemeralPublicKey;
    }

    public void setEphemeralPublicKey(String ephemeralPublicKey) {
        this.ephemeralPublicKey = ephemeralPublicKey;
    }

    public String getActivationData() {
        return activationData;
    }

    public void setActivationData(String activationData) {
        this.activationData = activationData;
    }
}
