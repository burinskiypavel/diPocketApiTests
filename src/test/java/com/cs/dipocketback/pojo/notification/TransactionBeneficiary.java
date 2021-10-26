package com.cs.dipocketback.pojo.notification;

public class TransactionBeneficiary {

    private String name;
    private String accountNumber;

    public TransactionBeneficiary() {
    }

    public TransactionBeneficiary(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "TransactionBeneficiary{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
