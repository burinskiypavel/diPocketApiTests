package com.cs.dipocketback.pojo.pos;

public class CheckPrintCashLoad {

    private String dateTime;
    private String amountCurrencyCode;
    private Long amount;
    private String feeCurrencyCode;
    private Long feeAmount;
    private String accCurrencyCode;
    private Long balance;
    private String publicToken;
    private Long cashierId;
    private Long tranId;
    private String data;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAmountCurrencyCode() {
        return amountCurrencyCode;
    }

    public void setAmountCurrencyCode(String amountCurrencyCode) {
        this.amountCurrencyCode = amountCurrencyCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getAccCurrencyCode() {
        return accCurrencyCode;
    }

    public void setAccCurrencyCode(String accCurrencyCode) {
        this.accCurrencyCode = accCurrencyCode;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
