package com.cs.dipocketback.pojo.payvector;

public class PvCrtToDo {
    
    private String token;
    private Long amount;
    private Integer currencyCode;
    private String orderId;
    private String orderDescription;
    private String transactionType;
    private Integer newTransaction;
    private String crossReference;
    private Integer echoCardType;
    private Integer echoAvsCheckResult;
    private Integer echoCv2CheckResult;
    private Integer duplicateDelay;
    private String avsOverridePolicy;
    private String cv2OverridePolicy;
    private Integer threedSecureOverridePolicy;

    public PvCrtToDo() {
    }

    public PvCrtToDo(String token, 
                     Long amount, 
                     Integer currencyCode, 
                     String orderId, 
                     String orderDescription,
                     String transactionType, 
                     Integer newTransaction, 
                     String crossReference, 
                     Integer echoCardType,
                     Integer echoAvsCheckResult, 
                     Integer echoCv2CheckResult, 
                     Integer duplicateDelay,
                     String avsOverridePolicy, 
                     String cv2OverridePolicy, 
                     Integer threedSecureOverridePolicy) {
        this.token = token;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.transactionType = transactionType;
        this.newTransaction = newTransaction;
        this.crossReference = crossReference;
        this.echoCardType = echoCardType;
        this.echoAvsCheckResult = echoAvsCheckResult;
        this.echoCv2CheckResult = echoCv2CheckResult;
        this.duplicateDelay = duplicateDelay;
        this.avsOverridePolicy = avsOverridePolicy;
        this.cv2OverridePolicy = cv2OverridePolicy;
        this.threedSecureOverridePolicy = threedSecureOverridePolicy;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setNewTransaction(Integer newTransaction) {
        this.newTransaction = newTransaction;
    }

    public Integer getNewTransaction() {
        return newTransaction;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setEchoCardType(Integer echoCardType) {
        this.echoCardType = echoCardType;
    }

    public Integer getEchoCardType() {
        return echoCardType;
    }

    public void setEchoAvsCheckResult(Integer echoAvsCheckResult) {
        this.echoAvsCheckResult = echoAvsCheckResult;
    }

    public Integer getEchoAvsCheckResult() {
        return echoAvsCheckResult;
    }

    public void setEchoCv2CheckResult(Integer echoCv2CheckResult) {
        this.echoCv2CheckResult = echoCv2CheckResult;
    }

    public Integer getEchoCv2CheckResult() {
        return echoCv2CheckResult;
    }

    public void setDuplicateDelay(Integer duplicateDelay) {
        this.duplicateDelay = duplicateDelay;
    }

    public Integer getDuplicateDelay() {
        return duplicateDelay;
    }

    public void setAvsOverridePolicy(String avsOverridePolicy) {
        this.avsOverridePolicy = avsOverridePolicy;
    }

    public String getAvsOverridePolicy() {
        return avsOverridePolicy;
    }

    public void setCv2OverridePolicy(String cv2OverridePolicy) {
        this.cv2OverridePolicy = cv2OverridePolicy;
    }

    public String getCv2OverridePolicy() {
        return cv2OverridePolicy;
    }

    public void setThreedSecureOverridePolicy(Integer threedSecureOverridePolicy) {
        this.threedSecureOverridePolicy = threedSecureOverridePolicy;
    }

    public Integer getThreedSecureOverridePolicy() {
        return threedSecureOverridePolicy;
    }
    
}
