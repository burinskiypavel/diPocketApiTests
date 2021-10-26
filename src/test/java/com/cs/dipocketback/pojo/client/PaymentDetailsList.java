package com.cs.dipocketback.pojo.client;

import java.util.List;

public class PaymentDetailsList {
    
    private List<PaymentDetails> paymentDetailsList;
    
    public PaymentDetailsList() {
    }

    public PaymentDetailsList(List<PaymentDetails> paymentDetailsList) {
        this.paymentDetailsList = paymentDetailsList;
    }

    public void setPaymentDetailsList(List<PaymentDetails> paymentDetailsList) {
        this.paymentDetailsList = paymentDetailsList;
    }

    public List<PaymentDetails> getPaymentDetailsList() {
        return paymentDetailsList;
    }
}
