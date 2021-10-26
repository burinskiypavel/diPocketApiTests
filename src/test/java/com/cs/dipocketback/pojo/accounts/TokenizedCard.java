package com.cs.dipocketback.pojo.accounts;

import com.cs.dipocketback.pojo.card.CardType;

public class TokenizedCard {
    private Long  cardId;
    private Integer cardTypeID;
    private CardType cardType;
    private String maskedpan;
    private Long accountId;
    private String accountName;
    private String tokenURef;

    public TokenizedCard() {
    }

    public TokenizedCard(Long cardId, Integer cardTypeID, CardType cardType,String maskedpan, Long accountId, String accountName, String tokenURef) {
        this.cardId = cardId;
        this.cardTypeID = cardTypeID;
        this.cardType = cardType;
        this.maskedpan = maskedpan;
        this.accountId = accountId;
        this.accountName = accountName;
        this.tokenURef = tokenURef;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Integer getCardTypeID() {
        return cardTypeID;
    }

    public void setCardTypeID(Integer cardTypeID) {
        this.cardTypeID = cardTypeID;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getMaskedpan() {
        return maskedpan;
    }

    public void setMaskedpan(String maskedpan) {
        this.maskedpan = maskedpan;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTokenURef() {
        return tokenURef;
    }

    public void setTokenURef(String tokenURef) {
        this.tokenURef = tokenURef;
    }
}
