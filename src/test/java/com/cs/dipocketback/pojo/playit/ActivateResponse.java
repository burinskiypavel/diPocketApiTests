package com.cs.dipocketback.pojo.playit;

import com.cs.dipocketback.pojo.accounts.DiPocketCard;

public class ActivateResponse {
    
    private DiPocketCard.DiPocketCardStatus state;
    
    public ActivateResponse() {
    }

    public void setState(DiPocketCard.DiPocketCardStatus state) {
        this.state = state;
    }

    public DiPocketCard.DiPocketCardStatus getState() {
        return state;
    }
}
