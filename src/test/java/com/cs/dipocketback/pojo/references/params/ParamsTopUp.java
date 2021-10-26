package com.cs.dipocketback.pojo.references.params;

public class ParamsTopUp {
    
    private Boolean isThirdPartyEnabled;
    private Boolean isQuickPayEnabled;
    private Boolean isBankTransferEnabled;
    private Boolean isQuickPayEnabledForPoles;
    private Boolean isPaymentDetailsEmpty;
    
    public ParamsTopUp() {
    }

    public void setIsThirdPartyEnabled(Boolean isThirdPartyEnabled) {
        this.isThirdPartyEnabled = isThirdPartyEnabled;
    }

    public Boolean getIsThirdPartyEnabled() {
        return isThirdPartyEnabled;
    }

    public void setIsQuickPayEnabled(Boolean isQuickPayEnabled) {
        this.isQuickPayEnabled = isQuickPayEnabled;
    }

    public Boolean getIsQuickPayEnabled() {
        return isQuickPayEnabled;
    }

    public void setIsBankTransferEnabled(Boolean isBankTransferEnabled) {
        this.isBankTransferEnabled = isBankTransferEnabled;
    }

    public Boolean getIsBankTransferEnabled() {
        return isBankTransferEnabled;
    }

    public void setIsQuickPayEnabledForPoles(Boolean isQuickPayEnabledForPoles) {
        this.isQuickPayEnabledForPoles = isQuickPayEnabledForPoles;
    }

    public Boolean getIsQuickPayEnabledForPoles() {
        return isQuickPayEnabledForPoles;
    }

    public Boolean getIsPaymentDetailsEmpty() {
        return isPaymentDetailsEmpty;
    }

    public void setIsPaymentDetailsEmpty(Boolean paymentDetailsEmpty) {
        isPaymentDetailsEmpty = paymentDetailsEmpty;
    }

}
