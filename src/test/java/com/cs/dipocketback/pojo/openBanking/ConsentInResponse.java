package com.cs.dipocketback.pojo.openBanking;



public class ConsentInResponse {

    private String consentId;
    private String consentStatus;
    private ConsentLink _links;
    private ConsentRedirect status;

    private Long powId;

    public ConsentInResponse() {
    }

    public ConsentInResponse(String consentId, String consentStatus, ConsentLink _links, ConsentRedirect status, Long powId) {
        this.consentId = consentId;
        this.consentStatus = consentStatus;
        this._links = _links;
        this.status = status;
        this.powId = powId;
    }

    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    public String getConsentStatus() {
        return consentStatus;
    }

    public void setConsentStatus(String consentStatus) {
        this.consentStatus = consentStatus;
    }

    public ConsentLink get_links() {
        return _links;
    }

    public void set_links(ConsentLink _links) {
        this._links = _links;
    }

    public ConsentRedirect getStatus() {
        return status;
    }

    public void setStatus(ConsentRedirect status) {
        this.status = status;
    }

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

}
