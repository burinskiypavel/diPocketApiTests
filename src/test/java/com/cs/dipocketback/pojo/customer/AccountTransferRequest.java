package com.cs.dipocketback.pojo.customer;



public class AccountTransferRequest {


    private String requestId;

    private Long accountFrom;

    private Long amount;

    private String currencyCode;

    private Long accountTo;
    private String note;

    public AccountTransferRequest() {
    }

    public AccountTransferRequest(String requestId, Long accountFrom, Long amount,
                                  String currencyCode, Long accountTo, String note) {
        this.requestId = requestId;
        this.accountFrom = accountFrom;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.accountTo = accountTo;
        this.note = note;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Long accountTo) {
        this.accountTo = accountTo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
