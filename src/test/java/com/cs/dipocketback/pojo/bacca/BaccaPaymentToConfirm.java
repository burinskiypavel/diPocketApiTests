package com.cs.dipocketback.pojo.bacca;

import java.sql.Timestamp;

public class BaccaPaymentToConfirm {

    private Long id;
    private Long tranId;
    private String agreementNumber;
    private Integer currencyId;
    private String currencyCode;
    private Long amount;
    private Timestamp paymentDate;
    
    public BaccaPaymentToConfirm() {
    }

    public BaccaPaymentToConfirm(Long id,
                                 Long tranId,
                                 String agreementNumber,
                                 Integer currencyId,
                                 String currencyCode,
                                 Long amount,
                                 Timestamp paymentDate) {
        this.id = id;
        this.tranId = tranId;
        this.agreementNumber = agreementNumber;
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }
    
}
