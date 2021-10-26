package com.cs.dipocketback.pojo.openBanking;

public class ConsentOutResponse {

    private ConsentAccess access;
    private Boolean recurringIndicator;
    private String validUntil;
    private Integer frequencyPerDay;
    private String consentStatus;
    private ConsentOutAccountLink _links;

    public ConsentOutResponse() {
    }

    public ConsentOutResponse(ConsentAccess access, Boolean recurringIndicator, String validUntil,
                              Integer frequencyPerDay, String consentStatus, ConsentOutAccountLink _links) {
        this.access = access;
        this.recurringIndicator = recurringIndicator;
        this.validUntil = validUntil;
        this.frequencyPerDay = frequencyPerDay;
        this.consentStatus = consentStatus;
        this._links = _links;
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

    public ConsentOutAccountLink get_links() {
        return _links;
    }

    public void set_links(ConsentOutAccountLink _links) {
        this._links = _links;
    }
}
