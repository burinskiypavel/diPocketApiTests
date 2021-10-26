package com.cs.dipocketback.pojo.payup;

public class CardCreateResult {
    
    private Long cardId;
    private Long powId;
    private Boolean duplicate;
    
    public CardCreateResult() {
    }

    public CardCreateResult(Long cardId, Long powId, Boolean duplicate) {
        this.cardId = cardId;
        this.powId = powId;
        this.duplicate = duplicate;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setDuplicate(Boolean duplicate) {
        this.duplicate = duplicate;
    }

    public Boolean getDuplicate() {
        return duplicate;
    }
}
