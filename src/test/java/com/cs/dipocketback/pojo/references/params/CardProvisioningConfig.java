package com.cs.dipocketback.pojo.references.params;

public class CardProvisioningConfig {

    private Boolean isUserFromApplePayWhitelist;
    private Boolean isApplePayEnabled;

    public CardProvisioningConfig() {
    }

    public CardProvisioningConfig(Boolean isUserFromApplePayWhitelist, Boolean isApplePayEnabled) {
        this.isUserFromApplePayWhitelist = isUserFromApplePayWhitelist;
        this.isApplePayEnabled = isApplePayEnabled;
    }

    public Boolean getIsUserFromApplePayWhitelist() {
        return isUserFromApplePayWhitelist;
    }

    public void setIsUserFromApplePayWhitelist(Boolean isUserFromApplePayWhitelist) {
        this.isUserFromApplePayWhitelist = isUserFromApplePayWhitelist;
    }

    public Boolean getIsApplePayEnabled() {
        return isApplePayEnabled;
    }

    public void setIsApplePayEnabled(Boolean applePayEnabled) {
        isApplePayEnabled = applePayEnabled;
    }

}
