package com.cs.dipocketback.pojo.references.params;

public class ParamsRequestMoney {
    
    private Boolean isFaceToFaceEnabled;
    private Boolean isDipTransferEnabled;
    
    public ParamsRequestMoney() {
    }

    public void setIsFaceToFaceEnabled(Boolean isFaceToFaceEnabled) {
        this.isFaceToFaceEnabled = isFaceToFaceEnabled;
    }

    public Boolean getIsFaceToFaceEnabled() {
        return isFaceToFaceEnabled;
    }

    public void setIsDipTransferEnabled(Boolean isDipTransferEnabled) {
        this.isDipTransferEnabled = isDipTransferEnabled;
    }

    public Boolean getIsDipTransferEnabled() {
        return isDipTransferEnabled;
    }
    
}
