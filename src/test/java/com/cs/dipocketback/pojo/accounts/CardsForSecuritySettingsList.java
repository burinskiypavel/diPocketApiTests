package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class CardsForSecuritySettingsList {
    
    private List<CardsForSecuritySettings> cards;
    
    public CardsForSecuritySettingsList() {
    }

    public CardsForSecuritySettingsList(List<CardsForSecuritySettings> cards) {
        this.cards = cards;
    }

    public void setCards(List<CardsForSecuritySettings> cards) {
        this.cards = cards;
    }

    public List<CardsForSecuritySettings> getCards() {
        return cards;
    }
}
