package com.cs.dipocketback.pojo.festival;

public class FestivalPhoneResponse {

    private Boolean isValid;
    private Boolean isRegistered;
    private Boolean isMigrated;
    
    public FestivalPhoneResponse() {
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public Boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsMigrated(Boolean isMigrated) {
        this.isMigrated = isMigrated;
    }

    public Boolean getIsMigrated() {
        return isMigrated;
    }

}
