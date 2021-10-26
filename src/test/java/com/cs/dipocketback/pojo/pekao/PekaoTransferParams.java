package com.cs.dipocketback.pojo.pekao;

public class PekaoTransferParams {
    
    private Long id; //sepa, dom, swift
    private Long tranId; //sepa, dom, swift
    private Integer stateId; //sepa, dom, swift
    private String messageId; //sepa, dom, swift
    private Long createDateTime; //sepa, dom, swift
    private Long transactionCount; //sepa, dom, swift
    private String initiatorName; //sepa, dom, swift
    private String payerIdentifier; //sepa, dom, swift
    private String packageName; //sepa, dom, swift
    private String paymentMethod; //sepa, dom, swift
    private Boolean batchBooking; //dom
    private Long execDate; //sepa, dom, swift
    private String payerName; //sepa, dom, swift
    private String payerOrg; //sepa, swift
    private String payerAccount; //sepa, dom, swift
    private String payerBank;// sepa, dom, swift
    private String feeSettelement; //sepa, swift
    private String referenceId; //sepa, dom, swift
    private Long amount; //sepa, dom, swift
    private String ccy; //sepa, dom, swift
    private String paymentTypeCode; //sepa, swift
    private String receiverBank; //sepa, dom, swift
    private String receiverName; //sepa, dom, swift
    private String receiverAddress1; //sepa, dom, swift
    private String receiverAddress2; //sepa, dom, swift
    private String receiverCountry; //sepa, dom
    private String receiverOrg; //sepa
    private String receiverInd; //sepa
    private String receiverAccount; //sepa, dom, swift
    private String orderTitle; //sepa, dom, swift
    private String orderPriority; //swift
    
    public PekaoTransferParams() {
    }

    public PekaoTransferParams(Long id, 
                               Long tranId, 
                               Integer stateId, 
                               String messageId, 
                               Long createDateTime,
                               Long transactionCount, 
                               String initiatorName, 
                               String payerIdentifier, 
                               String packageName,
                               String paymentMethod, 
                               Boolean batchBooking, 
                               Long execDate, 
                               String payerName,
                               String payerOrg, 
                               String payerAccount, 
                               String payerBank, 
                               String feeSettelement,
                               String referenceId,
                               Long amount, 
                               String ccy, 
                               String paymentTypeCode, 
                               String receiverBank,
                               String receiverName, 
                               String receiverAddress1, 
                               String receiverAddress2,
                               String receiverCountry, 
                               String receiverOrg, 
                               String receiverInd, 
                               String receiverAccount,
                               String orderTitle, 
                               String orderPriority) {
        this.id = id;
        this.tranId = tranId;
        this.stateId = stateId;
        this.messageId = messageId;
        this.createDateTime = createDateTime;
        this.transactionCount = transactionCount;
        this.initiatorName = initiatorName;
        this.payerIdentifier = payerIdentifier;
        this.packageName = packageName;
        this.paymentMethod = paymentMethod;
        this.batchBooking = batchBooking;
        this.execDate = execDate;
        this.payerName = payerName;
        this.payerOrg = payerOrg;
        this.payerAccount = payerAccount;
        this.payerBank = payerBank;
        this.feeSettelement = feeSettelement;
        this.referenceId = referenceId;
        this.amount = amount;
        this.ccy = ccy;
        this.paymentTypeCode = paymentTypeCode;
        this.receiverBank = receiverBank;
        this.receiverName = receiverName;
        this.receiverAddress1 = receiverAddress1;
        this.receiverAddress2 = receiverAddress2;
        this.receiverCountry = receiverCountry;
        this.receiverOrg = receiverOrg;
        this.receiverInd = receiverInd;
        this.receiverAccount = receiverAccount;
        this.orderTitle = orderTitle;
        this.orderPriority = orderPriority;
    }

    public Long getId() {
        return id;
    }

    public Long getTranId() {
        return tranId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public String getMessageId() {
        return messageId;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public Long getTransactionCount() {
        return transactionCount;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public String getPayerIdentifier() {
        return payerIdentifier;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Boolean getBatchBooking() {
        return batchBooking;
    }

    public Long getExecDate() {
        return execDate;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getPayerOrg() {
        return payerOrg;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public String getFeeSettelement() {
        return feeSettelement;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public Long getAmount() {
        return amount;
    }

    public String getCcy() {
        return ccy;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public String getReceiverBank() {
        return receiverBank;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverAddress1() {
        return receiverAddress1;
    }

    public String getReceiverAddress2() {
        return receiverAddress2;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public String getReceiverOrg() {
        return receiverOrg;
    }

    public String getReceiverInd() {
        return receiverInd;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public String getOrderPriority() {
        return orderPriority;
    }
    
}
