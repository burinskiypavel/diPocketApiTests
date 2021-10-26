package com.cs.dipocketback.pojo.applepay;

import java.util.List;

public class ApplePayTokenizationRequest {

    private Long cardId;
    private Boolean isVirtual;
    private String nonce;
    private String nonceSignature;
    private List<String> certificates;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Boolean getVirtual() {
        return isVirtual;
    }

    public void setVirtual(Boolean virtual) {
        isVirtual = virtual;
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

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }
}
