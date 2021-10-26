package com.cs.dipocketback.pojo.extCharge;

public class ExtChargePayByLinkRequest {

    private Long amount;
    private String ccy;
    private String paymentType;
    private String returnLink;
    private String orderDescription;
    private Integer langId;

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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getReturnLink() {
        return returnLink;
    }

    public void setReturnLink(String returnLink) {
        this.returnLink = returnLink;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }
}
