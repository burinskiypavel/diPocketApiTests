package com.cs.dipocketback.pojo.references.params;

public class ParamsSendMoney {
    
    private Boolean isFaceToFaceEnabled;
    private Boolean isDipTransferEnabled;
    private Boolean isBankTransferEnabled;
    
    public ParamsSendMoney() {
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

    public void setIsBankTransferEnabled(Boolean isBankTransferEnabled) {
        this.isBankTransferEnabled = isBankTransferEnabled;
    }

    public Boolean getIsBankTransferEnabled() {
        return isBankTransferEnabled;
    }
    
}
