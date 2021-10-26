package com.cs.dipocketback.pojo.festival;

import com.cs.dipocketback.pojo.accounts.DiPocketCard;
import com.cs.dipocketback.pojo.card.CardType;

public class FestivalCard {
    
    private Long id;
    private Long accountId;
    private Long clientId;
    @Deprecated
    private DiPocketCard.DiPocketCardType type;
    private CardType cardType;
    private String publicToken;
    private DiPocketCard.DiPocketCardStatus state;
    
    public FestivalCard() {
    }


    public FestivalCard(Long id, Long accountId, Long clientId, Integer typeId, String publictoken,
                        Integer stateId) {
        this.id = id;
        this.accountId = accountId;
        this.clientId = clientId;
        this.publicToken = publictoken;
        setState(DiPocketCard.DiPocketCardStatus.valueOf(stateId));
        setType(DiPocketCard.DiPocketCardType.valueOf(typeId));
        setCardType(CardType.valueOf(typeId));

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setPublicToken(String publictoken) {
        this.publicToken = publictoken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setType(DiPocketCard.DiPocketCardType type) {
        this.type = type;
    }

    public DiPocketCard.DiPocketCardType getType() {
        return type;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setState(DiPocketCard.DiPocketCardStatus state) {
        this.state = state;
    }

    public DiPocketCard.DiPocketCardStatus getState() {
        return state;
    }
    
}
