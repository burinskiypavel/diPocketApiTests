package com.cs.dipocketback.pojo.references.params;

public class ParamsRegistration {
    
    private boolean isUsingCard;
    private boolean isUsingCardRequired;
    
    public ParamsRegistration() {
    }

    public ParamsRegistration(boolean isUsingCard, boolean isUsingCardRequired) {
        this.isUsingCard = isUsingCard;
        this.isUsingCardRequired = isUsingCardRequired;
    }

    public void setIsUsingCard(boolean isUsingCard) {
        this.isUsingCard = isUsingCard;
    }

    public boolean isIsUsingCard() {
        return isUsingCard;
    }

    public void setIsUsingCardRequired(boolean isUsingCardRequired) {
        this.isUsingCardRequired = isUsingCardRequired;
    }

    public boolean isIsUsingCardRequired() {
        return isUsingCardRequired;
    }
    
}
