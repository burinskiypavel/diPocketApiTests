package com.cs.dipocketback.pojo.accounts;

public class CardsForSecuritySettings {
    
    private Long cardId;
    private Boolean isSupervised;
    
    public CardsForSecuritySettings() {
    }

    public CardsForSecuritySettings(Long cardId, Boolean isSupervised) {
        this.cardId = cardId;
        this.isSupervised = isSupervised;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setIsSupervised(Boolean isSupervised) {
        this.isSupervised = isSupervised;
    }

    public Boolean getIsSupervised() {
        return isSupervised;
    }
    
}
