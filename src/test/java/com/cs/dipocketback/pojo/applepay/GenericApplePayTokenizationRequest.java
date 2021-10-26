package com.cs.dipocketback.pojo.applepay;

import java.util.List;

public class GenericApplePayTokenizationRequest {

    private String nonce;
    private String nonceSignature;
    private List<String> certificates;
    private String token;

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

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String publicToken) {
        this.token = publicToken;
    }
}
