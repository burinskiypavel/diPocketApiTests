package com.cs.dipocketback.pojo.neosurf;

public class NeosurfTranInit {
    
    private Long tranId;
    private Long amount;
    private String currency;
    private String merchantId;
    private Long merchantTransactionId;
    private String methodList;
    private String prohibitedForMinors;
    private String subMerchantId;
    private String test;
    private Integer version;
    private String urlOk;
    private String urlKo;
    private String urlPending;
    private String urlCallback;
    private String hash;
    
    public NeosurfTranInit() {
    }

    public NeosurfTranInit(Long tranId, 
                           Long amount, 
                           String currency, 
                           String merchantId, 
                           Long merchantTransactionId,
                           String methodList, 
                           String prohibitedForMinors, 
                           String subMerchantId, 
                           String test,
                           Integer version) {
        this.tranId = tranId;
        this.amount = amount;
        this.currency = currency;
        this.merchantId = merchantId;
        this.merchantTransactionId = merchantTransactionId;
        this.methodList = methodList;
        this.prohibitedForMinors = prohibitedForMinors;
        this.subMerchantId = subMerchantId;
        this.test = test;
        this.version = version;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantTransactionId(Long merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public Long getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMethodList(String methodList) {
        this.methodList = methodList;
    }

    public String getMethodList() {
        return methodList;
    }

    public void setProhibitedForMinors(String prohibitedForMinors) {
        this.prohibitedForMinors = prohibitedForMinors;
    }

    public String getProhibitedForMinors() {
        return prohibitedForMinors;
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

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setUrlOk(String urlOk) {
        this.urlOk = urlOk;
    }

    public String getUrlOk() {
        return urlOk;
    }

    public void setUrlKo(String urlKo) {
        this.urlKo = urlKo;
    }

    public String getUrlKo() {
        return urlKo;
    }

    public void setUrlPending(String urlPending) {
        this.urlPending = urlPending;
    }

    public String getUrlPending() {
        return urlPending;
    }

    public void setUrlCallback(String urlCallback) {
        this.urlCallback = urlCallback;
    }

    public String getUrlCallback() {
        return urlCallback;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }
    
}
