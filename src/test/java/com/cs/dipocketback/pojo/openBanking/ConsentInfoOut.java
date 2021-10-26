package com.cs.dipocketback.pojo.openBanking;

public class ConsentInfoOut {
    private ConsentAccess access;
    private Boolean recurringIndicator;
    private String validUntil;
    private Integer frequencyPerDay;
    private String consentStatus;
    private String tppRedirectUri;
    private String tppNokRedirectUri;

    public ConsentInfoOut() {
    }

    public ConsentInfoOut(ConsentAccess access, Boolean recurringIndicator, String validUntil, Integer frequencyPerDay,
                          String consentStatus, String tppRedirectUri, String tppNokRedirectUri) {
        this.access = access;
        this.recurringIndicator = recurringIndicator;
        this.validUntil = validUntil;
        this.frequencyPerDay = frequencyPerDay;
        this.consentStatus = consentStatus;
        this.tppRedirectUri = tppRedirectUri;
        this.tppNokRedirectUri = tppNokRedirectUri;
    }

    public ConsentAccess getAccess() {
        return access;
    }

    public void setAccess(ConsentAccess access) {
        this.access = access;
    }

    public Boolean getRecurringIndicator() {
        return recurringIndicator;
    }

    public void setRecurringIndicator(Boolean recurringIndicator) {
        this.recurringIndicator = recurringIndicator;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getFrequencyPerDay() {
        return frequencyPerDay;
    }

    public void setFrequencyPerDay(Integer frequencyPerDay) {
        this.frequencyPerDay = frequencyPerDay;
    }

    public String getConsentStatus() {
        return consentStatus;
    }

    public void setConsentStatus(String consentStatus) {
        this.consentStatus = consentStatus;
    }

    public String getTppRedirectUri() {
        return tppRedirectUri;
    }

    public void setTppRedirectUri(String tppRedirectUri) {
        this.tppRedirectUri = tppRedirectUri;
    }

    public String getTppNokRedirectUri() {
        return tppNokRedirectUri;
    }

    public void setTppNokRedirectUri(String tppNokRedirectUri) {
        this.tppNokRedirectUri = tppNokRedirectUri;
    }
}
