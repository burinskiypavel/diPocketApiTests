package com.cs.dipocketback.pojo.customer.signature;

public interface CardCashRequestSignature {

    Long getAmount();
    String getCurrencyCode();
    String getNote();
    String getRequestId();
    String getToken();
    String getSignature();

}
