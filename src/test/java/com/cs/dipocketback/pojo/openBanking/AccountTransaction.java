package com.cs.dipocketback.pojo.openBanking;

public class AccountTransaction {

    private String purposeCode;
    private String creditorName;
    private String debtorName;
    private ConsentIban creditorAccount;
    private AccountBalanceAmount transactionAmount;
    private String transactionId;
    private String bookingDate;
    private String valueDate;

    public AccountTransaction() {
    }

    public AccountTransaction(String purposeCode, String creditorName, String debtorName, ConsentIban creditorAccount,
                              AccountBalanceAmount transactionAmount, String transactionId, String bookingDate, String valueDate) {
        this.purposeCode = purposeCode;
        this.creditorName = creditorName;
        this.debtorName = debtorName;
        this.creditorAccount = creditorAccount;
        this.transactionAmount = transactionAmount;
        this.transactionId = transactionId;
        this.bookingDate = bookingDate;
        this.valueDate = valueDate;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public ConsentIban getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(ConsentIban creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public AccountBalanceAmount getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(AccountBalanceAmount transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }
}
