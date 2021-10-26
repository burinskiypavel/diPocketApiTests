package com.cs.dipocketback.pojo.ecard;

public class ECardToInit {
    
    private Long orderNumber;
    private Long amount;
    private String paymentType;
    private String orderDescription;
    
    public ECardToInit() {
    }

    public ECardToInit(Long orderNumber, Long amount, String paymentType, String orderDescription) {
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.paymentType = paymentType;
        this.orderDescription = orderDescription;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

}

