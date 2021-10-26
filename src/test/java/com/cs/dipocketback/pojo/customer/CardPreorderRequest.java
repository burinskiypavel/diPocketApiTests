package com.cs.dipocketback.pojo.customer;

import com.cs.dipocketback.pojo.card.CardType;



public class CardPreorderRequest {

    private String requestId;

    private String program;
    private String currencyCode;

    private CardType cardType;
    private Long accFeeTariffPlanId;
    private Long validityPeriod;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
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

    public CardPreorderRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Long getAccFeeTariffPlanId() {
        return accFeeTariffPlanId;
    }

    public void setAccFeeTariffPlanId(Long accFeeTariffPlanId) {
        this.accFeeTariffPlanId = accFeeTariffPlanId;
    }

    public Long getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Long validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
