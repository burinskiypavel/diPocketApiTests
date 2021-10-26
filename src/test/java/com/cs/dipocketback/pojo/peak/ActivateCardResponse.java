package com.cs.dipocketback.pojo.peak;

public class ActivateCardResponse {
    
    private PeakCardStatus cardStatus;
    
    public ActivateCardResponse() {
    }

    public ActivateCardResponse(PeakCardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public void setCardStatus(PeakCardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public PeakCardStatus getCardStatus() {
        return cardStatus;
    }

}
