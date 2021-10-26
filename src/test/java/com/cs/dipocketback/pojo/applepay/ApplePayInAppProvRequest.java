package com.cs.dipocketback.pojo.applepay;

import java.util.List;

public class ApplePayInAppProvRequest {

    private String accountNumber;
    private String accountExpiry;
    private String nonce;
    private String nonceSignature;
    private String cardholderName;
    private List<String> certificates;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountExpiry() {
        return accountExpiry;
    }

    public void setAccountExpiry(String accountExpiry) {
        this.accountExpiry = accountExpiry;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getNonceSignature() {
        return nonceSignature;
    }

    public void setNonceSignature(String nonceSignature) {
        this.nonceSignature = nonceSignature;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public String getInAppBody() {
        return "{\n" +
                "    \"nonce\": \""+nonce+"\",\n" +
                "    \"nonceSignature\": \""+nonceSignature+"\",\n" +
                "    \"name\": \""+cardholderName+"\",\n" +
                "    \"expiration\": \""+accountExpiry+"\",\n" +
                "    \"primaryAccountNumber\": \""+accountNumber+"\"\n" +
                "}";
    }
}
