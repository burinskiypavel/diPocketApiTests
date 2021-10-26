package com.cs.dipocketback.pojo.androidpay;

public class CardDataBase64 {
    
    private String cardDataBase64;
    private String pan4Digits;
    
    public CardDataBase64() {
    }

    public CardDataBase64(String cardDataBase64, String pan4Digits) {
        this.cardDataBase64 = cardDataBase64;
        this.pan4Digits = pan4Digits;
    }

    public void setCardDataBase64(String cardDataBase64) {
        this.cardDataBase64 = cardDataBase64;
    }

    public String getCardDataBase64() {
        return cardDataBase64;
    }

    public void setPan4Digits(String pan4Digits) {
        this.pan4Digits = pan4Digits;
    }

    public String getPan4Digits() {
        return pan4Digits;
    }
}
