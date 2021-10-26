package com.cs.dipocketback.pojo.extCharge;

public class ExtChargePayByLinkResponse {

    private String ecardUrl;
    private Long transactionId;

    public ExtChargePayByLinkResponse() {
    }

    public ExtChargePayByLinkResponse(String ecardUrl, Long transactionId) {
        this.ecardUrl = ecardUrl;
        this.transactionId = transactionId;
    }

    public String getEcardUrl() {
        return ecardUrl;
    }

    public void setEcardUrl(String ecardUrl) {
        this.ecardUrl = ecardUrl;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
