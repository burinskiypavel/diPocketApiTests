package com.cs.dipocketback.pojo.limit.incontrol;

public class AddCardRequest {
    
    private Long accountId;
    private Long cardId;
    
    public AddCardRequest() {
    }

    public AddCardRequest(Long accountId, Long cardId) {
        this.accountId = accountId;
        this.cardId = cardId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }
    
}
