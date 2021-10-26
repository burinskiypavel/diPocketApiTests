package com.cs.dipocketback.pojo.peak;

public class BlockCardResponse {
    
    private PeakCardStatus cardStatus;
    
    public BlockCardResponse() {
    }

    public BlockCardResponse(PeakCardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public void setCardStatus(PeakCardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public PeakCardStatus getCardStatus() {
        return cardStatus;
    }

}
