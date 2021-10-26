package com.cs.dipocketback.pojo.androidpay;

public class GoogleTokenizationResponse {

    private String opaquePaymentCard;
    private String panLastDigits;

    public String getOpaquePaymentCard() {
        return opaquePaymentCard;
    }

    public void setOpaquePaymentCard(String opaquePaymentCard) {
        this.opaquePaymentCard = opaquePaymentCard;
    }

    public String getPanLastDigits() {
        return panLastDigits;
    }

    public void setPanLastDigits(String panLastDigits) {
        this.panLastDigits = panLastDigits;
    }
}
