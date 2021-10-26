package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class TokenizedCardContainer {

    private List<TokenizedCard> tokenizedCards;

    public TokenizedCardContainer() {
    }

    public TokenizedCardContainer(List<TokenizedCard> tokenizedCards) {
        this.tokenizedCards = tokenizedCards;
    }

    public List<TokenizedCard> getTokenizedCards() {
        return tokenizedCards;
    }

    public void setTokenizedCards(List<TokenizedCard> tokenizedCards) {
        this.tokenizedCards = tokenizedCards;
    }
}
