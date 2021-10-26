package com.cs.dipocketback.pojo.pekao;

import java.util.Date;

public class PekaoHeadLine {
    
//    public static final int IDENTIFIER = 0;
    public static final int ACCOUNT_NUMBER = 1;
    public static final int ACCOUNT_NUMBER_MASK = 2;
    public static final int STATEMENT_DATE = 3;
    public static final int CURRENCY = 4;

    public PekaoHeadLine() {
    }

    public PekaoHeadLine(String identifier, String accountNumber, String accountNumberMask, 
            Date statementDate, String currency) {
        this.Identifier = identifier;
        this.accountNumber = accountNumber;
        this.accountNumberMask = accountNumberMask;
        this.statementDate = statementDate;
        this.currency = currency;        
    }

    private String Identifier;
    private String accountNumber;
    private String accountNumberMask;
    private Date statementDate;
    private String currency;

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumberMask() {
        return accountNumberMask;
    }

    public void setAccountNumberMask(String accountNumberMask) {
        this.accountNumberMask = accountNumberMask;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PekaoHeadLine{" +
                "Identifier=" + Identifier +
                ", accountNumber=" + accountNumber +
                ", accountNumberMask=" + accountNumberMask +
                ", statementDate=" + statementDate +
                ", currency='" + currency + '\'' +
                '}';
    }
}
