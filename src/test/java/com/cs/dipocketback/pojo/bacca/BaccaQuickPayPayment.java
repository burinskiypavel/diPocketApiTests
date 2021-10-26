package com.cs.dipocketback.pojo.bacca;

public class BaccaQuickPayPayment {
    
    private String agreementNumber;
    private Integer currencyId;
    private Long amount;
    private String paymentType;
    private Integer feeCurrencyId;
    private Long feeAmount;
    private boolean enoughFunds;
    private boolean feeEnoughFunds;
    private String note;
    
    private String ecardUrl;
    private String returnLink;
    
    public BaccaQuickPayPayment() {
    }
    
    public BaccaQuickPayPayment(Integer currencyId, Long amount) {
        // fee
        this.currencyId = currencyId;
        this.amount = amount;
    }
    
    public BaccaQuickPayPayment(Integer feeCurrencyId, Long feeAmount, boolean enoughFunds, boolean feeEnoughFunds) {
        // fee result
        this.feeCurrencyId = feeCurrencyId;
        this.feeAmount = feeAmount;
        this.enoughFunds = enoughFunds;
        this.feeEnoughFunds = feeEnoughFunds;
    }

    public BaccaQuickPayPayment(String agreementNumber, Integer currencyId, Long amount,
                                  String paymentType, Integer feeCurrencyId, Long feeAmount, String note) {
        this.agreementNumber = agreementNumber;
        this.currencyId = currencyId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.feeCurrencyId = feeCurrencyId;
        this.feeAmount = feeAmount;
        this.note = note;
    }


    public BaccaQuickPayPayment(String agreementNumber, Integer currencyId, Long amount,
                                String paymentType, Integer feeCurrencyId, Long feeAmount, boolean enoughFunds,
                                boolean feeEnoughFunds, String note) {
        this.agreementNumber = agreementNumber;
        this.currencyId = currencyId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.feeCurrencyId = feeCurrencyId;
        this.feeAmount = feeAmount;
        this.enoughFunds = enoughFunds;
        this.feeEnoughFunds = feeEnoughFunds;
        this.note = note;
    }

    public void setEnoughFunds(boolean enoughFunds) {
        this.enoughFunds = enoughFunds;
    }

    public boolean isEnoughFunds() {
        return enoughFunds;
    }

    public void setFeeEnoughFunds(boolean feeEnoughFunds) {
        this.feeEnoughFunds = feeEnoughFunds;
    }

    public boolean isFeeEnoughFunds() {
        return feeEnoughFunds;
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

    public void setFeeCurrencyId(Integer feeCurrencyId) {
        this.feeCurrencyId = feeCurrencyId;
    }

    public Integer getFeeCurrencyId() {
        return feeCurrencyId;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setEcardUrl(String ecardUrl) {
        this.agreementNumber = null;
        this.currencyId = null;
        this.amount = null;
        this.paymentType = null;
        this.feeCurrencyId = null;
        this.feeAmount = null;
        this.note = null;
        this.ecardUrl = ecardUrl;
    }

    public String getEcardUrl() {
        return ecardUrl;
    }

    public void setReturnLink(String returnLink) {
        this.returnLink = returnLink;
    }

    public String getReturnLink() {
        return returnLink;
    }
}
