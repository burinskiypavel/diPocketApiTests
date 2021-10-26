package com.cs.dipocketback.pojo.santander;

import java.util.Date;

public class EinHistoryTran {
    
    private String txId;
    private String debitAcc;
    private String creditAcc;
    private String debitName;
    private String creditName;
    private Date bookingDate;
    private Date execDate;
    private Double amount;
    private String note;
    private String operationCode;
    
    public EinHistoryTran() {
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getTxId() {
        return txId;
    }

    public void setDebitAcc(String debitAcc) {
        this.debitAcc = debitAcc;
    }

    public String getDebitAcc() {
        return debitAcc;
    }

    public void setCreditAcc(String creditAcc) {
        this.creditAcc = creditAcc;
    }

    public String getCreditAcc() {
        return creditAcc;
    }

    public void setDebitName(String debitName) {
        this.debitName = debitName;
    }

    public String getDebitName() {
        return debitName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    public Date getExecDate() {
        return execDate;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationCode() {
        return operationCode;
    }
}
