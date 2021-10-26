package com.cs.dipocketback.pojo.gps;

import java.util.List;

public class CardChangeAcceptorList {
    
    private List<CardChangeAcceptor> cardChangeAcceptorList;
    
    public CardChangeAcceptorList() {
    }

    public CardChangeAcceptorList(List<CardChangeAcceptor> cardChangeAcceptorList) {
        this.cardChangeAcceptorList = cardChangeAcceptorList;
    }

    public void setCardChangeAcceptorList(List<CardChangeAcceptor> cardChangeAcceptorList) {
        this.cardChangeAcceptorList = cardChangeAcceptorList;
    }

    public List<CardChangeAcceptor> getCardChangeAcceptorList() {
        return cardChangeAcceptorList;
    }
}
