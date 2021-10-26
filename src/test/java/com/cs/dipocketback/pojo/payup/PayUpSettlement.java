package com.cs.dipocketback.pojo.payup;

public class PayUpSettlement {
    
    private Long amount;
    private String cashierId;
    private String operationDateTime;
    private String publicToken;
    private String requestId;
    private String terminalId;
    
    public PayUpSettlement() {
    }

    public PayUpSettlement(Long amount, String cashierId, String operationDateTime, String publicToken,
                           String requestId, String terminalId) {
        this.amount = amount;
        this.cashierId = cashierId;
        this.operationDateTime = operationDateTime;
        this.publicToken = publicToken;
        this.requestId = requestId;
        this.terminalId = terminalId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setOperationDateTime(String operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    public String getOperationDateTime() {
        return operationDateTime;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }
}
