package com.cs.dipocketback.pojo.accounts;

import com.cs.dipocketback.pojo.registration.AttachedCard;

import java.util.List;

public class AttachedCardsList {

    List<AttachedCard> attachedCardsList;

    public AttachedCardsList() {

    }

    public AttachedCardsList(List<AttachedCard> attachedCardsList) {
        this.attachedCardsList = attachedCardsList;
    }

    public void setAttachedCardsList(List<AttachedCard> attachedCardsList) {
        this.attachedCardsList = attachedCardsList;
    }

    public List<AttachedCard> getAttachedCardsList() {
        return attachedCardsList;
    }
}
