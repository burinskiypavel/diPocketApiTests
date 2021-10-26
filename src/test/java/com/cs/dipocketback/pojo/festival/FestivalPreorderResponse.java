package com.cs.dipocketback.pojo.festival;

public class FestivalPreorderResponse {
    
    private Boolean preorderEnabled;
    
    public FestivalPreorderResponse() {
    }

    public FestivalPreorderResponse(Boolean preorderEnabled) {
        this.preorderEnabled = preorderEnabled;
    }

    public void setPreorderEnabled(Boolean preorderEnabled) {
        this.preorderEnabled = preorderEnabled;
    }

    public Boolean getPreorderEnabled() {
        return preorderEnabled;
    }
}
