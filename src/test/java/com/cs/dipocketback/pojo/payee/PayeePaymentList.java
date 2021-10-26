package com.cs.dipocketback.pojo.payee;

import java.util.List;

public class PayeePaymentList {
    
    private List<PayeePaymentType> payments;
    private String payeePaymentTypeHash;

    public PayeePaymentList() {
    }
    
    public PayeePaymentList(List<PayeePaymentType> payments, String payeePaymentTypeHash) {
        this.payments = payments;
        this.payeePaymentTypeHash = payeePaymentTypeHash;
    }

    public void setPayments(List<PayeePaymentType> payments) {
        this.payments = payments;
    }

    public List<PayeePaymentType> getPayments() {
        return payments;
    }

    public void setPayeePaymentTypeHash(String hash) {
        this.payeePaymentTypeHash = hash;
    }

    public String getPayeePaymentTypeHash() {
        return payeePaymentTypeHash;
    }
    
}
