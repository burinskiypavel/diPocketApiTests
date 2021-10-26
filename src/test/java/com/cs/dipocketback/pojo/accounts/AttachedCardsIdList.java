package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class AttachedCardsIdList {
    
    private List<Long> cardsIdList;
    
    public AttachedCardsIdList() {
    }

    public AttachedCardsIdList(List<Long> cardsIdList) {
        this.cardsIdList = cardsIdList;
    }

    public void setCardsIdList(List<Long> cardsIdList) {
        this.cardsIdList = cardsIdList;
    }

    public List<Long> getCardsIdList() {
        return cardsIdList;
    }
}
