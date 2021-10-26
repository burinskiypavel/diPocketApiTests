package com.cs.dipocketback.pojo.card;

public class CardPinRequest {

    private Long cardId;
    private String pin;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
