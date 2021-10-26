package com.cs.dipocketback.pojo.peak;

public class UnblockCardResponse {
    
    private PeakCardStatus cardStatus;
    
    public UnblockCardResponse() {
    }

    public UnblockCardResponse(PeakCardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public void setCardStatus(PeakCardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public PeakCardStatus getCardStatus() {
        return cardStatus;
    }

}
