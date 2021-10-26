package com.cs.dipocketback.pojo.neosurf;

public class NeosurfOnCallbackRequest {
    
    private Long amount;
    private String created;
    private String currency;
    private String hash;
    private Integer merchantId;
    private String merchantTransactionId;
    private String methodExpiry;
    private String methodId;
    private String methodLabel;
    private String methodName;
    private String status;
    private String subMerchantId;
    private String test;
    private String transaction3d;
    private Integer transactionId;
    
    public NeosurfOnCallbackRequest() {
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMethodExpiry(String methodExpiry) {
        this.methodExpiry = methodExpiry;
    }

    public String getMethodExpiry() {
        return methodExpiry;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodLabel(String methodLabel) {
        this.methodLabel = methodLabel;
    }

    public String getMethodLabel() {
        return methodLabel;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTransaction3d(String transaction3d) {
        this.transaction3d = transaction3d;
    }

    public String getTransaction3d() {
        return transaction3d;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }
}
