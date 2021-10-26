package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class CardBlockReasonList {
    
    private List<CardBlockReason> cardBlockReasons;

    public void setCardBlockReasons(List<CardBlockReason> cardBlockReasons) {
        this.cardBlockReasons = cardBlockReasons;
    }

    public List<CardBlockReason> getCardBlockReasons() {
        return cardBlockReasons;
    }

    public CardBlockReasonList() {
    }

    public CardBlockReasonList(List<CardBlockReason> cardBlockReasons) {
        this.cardBlockReasons = cardBlockReasons;
    }
    
}
