package com.cs.dipocketback.pojo.customer;

public class UpdateCompanyRequest {
    private String requestId;
    private Long clientId;
    private String langCode;
    private String companyName;
    private String rStreetLine1;
    private String rStreetLine2;
    private String rCity;
    private String rState;
    private String rZip;
    private String rCountryCode;
    private String mStreetLine1;
    private String mStreetLine2;
    private String mCity;
    private String mState;
    private String mZip;
    private String mCountryCode;
    private String ddStatus;
    private String currencyCode;
    private String cardHolderName;

    public UpdateCompanyRequest() {
    }

    public UpdateCompanyRequest(String requestId, Long clientId, String langCode, String companyName,
                                String rStreetLine1, String rStreetLine2, String rCity, String rState, String rZip, String rCountryCode,
                                String mStreetLine1, String mStreetLine2, String mCity, String mState, String mZip, String mCountryCode,
                                String ddStatus, String currencyCode) {
        this.requestId = requestId;
        this.clientId = clientId;
        this.langCode = langCode;
        this.companyName = companyName;
        this.rStreetLine1 = rStreetLine1;
        this.rStreetLine2 = rStreetLine2;
        this.rCity = rCity;
        this.rState = rState;
        this.rZip = rZip;
        this.rCountryCode = rCountryCode;
        this.mStreetLine1 = mStreetLine1;
        this.mStreetLine2 = mStreetLine2;
        this.mCity = mCity;
        this.mState = mState;
        this.mZip = mZip;
        this.mCountryCode = mCountryCode;
        this.ddStatus = ddStatus;
        this.currencyCode = currencyCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getrStreetLine1() {
        return rStreetLine1;
    }

    public void setrStreetLine1(String rStreetLine1) {
        this.rStreetLine1 = rStreetLine1;
    }

    public String getrStreetLine2() {
        return rStreetLine2;
    }

    public void setrStreetLine2(String rStreetLine2) {
        this.rStreetLine2 = rStreetLine2;
    }

    public String getrCity() {
        return rCity;
    }

    public void setrCity(String rCity) {
        this.rCity = rCity;
    }

    public String getrState() {
        return rState;
    }

    public void setrState(String rState) {
        this.rState = rState;
    }

    public String getrZip() {
        return rZip;
    }

    public void setrZip(String rZip) {
        this.rZip = rZip;
    }

    public String getrCountryCode() {
        return rCountryCode;
    }

    public void setrCountryCode(String rCountryCode) {
        this.rCountryCode = rCountryCode;
    }

    public String getmStreetLine1() {
        return mStreetLine1;
    }

    public void setmStreetLine1(String mStreetLine1) {
        this.mStreetLine1 = mStreetLine1;
    }

    public String getmStreetLine2() {
        return mStreetLine2;
    }

    public void setmStreetLine2(String mStreetLine2) {
        this.mStreetLine2 = mStreetLine2;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmZip() {
        return mZip;
    }

    public void setmZip(String mZip) {
        this.mZip = mZip;
    }

    public String getmCountryCode() {
        return mCountryCode;
    }

    public void setmCountryCode(String mCountryCode) {
        this.mCountryCode = mCountryCode;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
