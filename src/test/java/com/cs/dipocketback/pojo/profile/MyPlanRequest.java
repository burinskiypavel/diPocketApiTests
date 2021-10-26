package com.cs.dipocketback.pojo.profile;

public class MyPlanRequest {
    
    private String type;
    private String description;
    private Long amount;
    private Long operationCount;
    private Long totalAmount;
    private String ccy;
    
    public MyPlanRequest() {
    }

    public MyPlanRequest(String type, String description, Long amount, Long operationCount, Long totalAmount, String ccy) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.operationCount = operationCount;
        this.totalAmount = totalAmount;
        this.ccy = ccy;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setOperationCount(Long operationCount) {
        this.operationCount = operationCount;
    }

    public Long getOperationCount() {
        return operationCount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }
}
