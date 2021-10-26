package com.cs.dipocketback.pojo.customer.signature;

public interface CardCashResponseSignature {

    Long getFeeAmount();
    String getFeeCurrencyCode();
    Long getTransactionId();
}
