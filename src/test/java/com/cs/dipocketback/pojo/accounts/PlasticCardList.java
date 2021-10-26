package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class PlasticCardList {
    
    private List<PlasticCard> cards;
    
    public PlasticCardList() {
    }

    public void setCards(List<PlasticCard> cards) {
        this.cards = cards;
    }

    public List<PlasticCard> getCards() {
        return cards;
    }

    public PlasticCardList(List<PlasticCard> cards) {
        this.cards = cards;
    }
}
