package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class DiPocketCardList {
    
    private List<DiPocketCard> cards;
    
    public DiPocketCardList() {
    }

    public DiPocketCardList(List<DiPocketCard> cards) {
        this.cards = cards;
    }

    public void setCards(List<DiPocketCard> cards) {
        this.cards = cards;
    }

    public List<DiPocketCard> getCards() {
        return cards;
    }
}
