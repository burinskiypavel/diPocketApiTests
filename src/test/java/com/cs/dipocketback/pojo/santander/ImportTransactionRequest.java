package com.cs.dipocketback.pojo.santander;

public class ImportTransactionRequest {
    
    private Long id;
    private Integer paymentType;
    private String messageId;
    private String createDateTime;
    private Long transactionCount;
    private Long batchId;
    private String paymentMethod;
    private String senderAccount;
    private String senderBank;
    private Long endToEndId;
    private String tranCategory;
    private Long amount;
    private String ccy;
    private String receiverName;
    private String receiverCountry;
    private String receiverAddress;
    private String receiverAccount;
    private String receiverBank;
    private String description;
    private String feeAccount;
    private String executionMode;
    private String paymentTypeCode;
    private String feeSettlement;
    private String swiftTranType;

    public ImportTransactionRequest() {
    }

    public ImportTransactionRequest(Long id, 
                                    Integer paymentType, 
                                    String messageId, 
                                    String createDateTime, 
                                    Long transactionCount, 
                                    Long batchId, 
                                    String paymentMethod, 
                                    String senderAccount, 
                                    String senderBank, 
                                    Long endToEndId, 
                                    String tranCategory, 
                                    Long amount, 
                                    String ccy, 
                                    String receiverName, 
                                    String receiverCountry, 
                                    String receiverAddress, 
                                    String receiverAccount, 
                                    String receiverBank, 
                                    String description, 
                                    String feeAccount, 
                                    String executionMode, 
                                    String paymentTypeCode, 
                                    String feeSettlement, 
                                    String swiftTranType) {
        this.id = id;
        this.paymentType = paymentType;
        this.messageId = messageId;
        this.createDateTime = createDateTime;
        this.transactionCount = transactionCount;
        this.batchId = batchId;
        this.paymentMethod = paymentMethod;
        this.senderAccount = senderAccount;
        this.senderBank = senderBank;
        this.endToEndId = endToEndId;
        this.tranCategory = tranCategory;
        this.amount = amount;
        this.ccy = ccy;
        this.receiverName = receiverName;
        this.receiverCountry = receiverCountry;
        this.receiverAddress = receiverAddress;
        this.receiverAccount = receiverAccount;
        this.receiverBank = receiverBank;
        this.description = description;
        this.feeAccount = feeAccount;
        this.executionMode = executionMode;
        this.paymentTypeCode = paymentTypeCode;
        this.feeSettlement = feeSettlement;
        this.swiftTranType = swiftTranType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Long transactionCount) {
        this.transactionCount = transactionCount;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getSenderBank() {
        return senderBank;
    }

    public void setSenderBank(String senderBank) {
        this.senderBank = senderBank;
    }

    public Long getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(Long endToEndId) {
        this.endToEndId = endToEndId;
    }

    public String getTranCategory() {
        return tranCategory;
    }

    public void setTranCategory(String tranCategory) {
        this.tranCategory = tranCategory;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getReceiverBank() {
        return receiverBank;
    }

    public void setReceiverBank(String receiverBank) {
        this.receiverBank = receiverBank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeeAccount() {
        return feeAccount;
    }

    public void setFeeAccount(String feeAccount) {
        this.feeAccount = feeAccount;
    }

    public String getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(String executionMode) {
        this.executionMode = executionMode;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public String getFeeSettlement() {
        return feeSettlement;
    }

    public void setFeeSettlement(String feeSettlement) {
        this.feeSettlement = feeSettlement;
    }

    public String getSwiftTranType() {
        return swiftTranType;
    }

    public void setSwiftTranType(String swiftTranType) {
        this.swiftTranType = swiftTranType;
    }

}
