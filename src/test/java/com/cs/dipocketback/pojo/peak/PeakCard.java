package com.cs.dipocketback.pojo.peak;

import com.cs.dipocketback.pojo.customer.CardPaymentToken;
//import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PeakCard {
    
    private String publicToken;
    private Integer currencyId;
    private String cardStatus;
    private String expDate;
    private Long avlBalance;
    private Long finBalance;
    private String companyName;
    private String program;
    private String firstName;
    private String lastName;
    private String rStreetLine1;
    private String rStreetLine2;
    private String rCity;
    private String rState;
    private String rZip;
    private Integer rCountryId;
    private String mainPhone;
    private String dob;
    private String email;
    private String pan;
    private String cvv;
    private String ddStatus;
    private Long feeTarifPlanId;
    private String cardholderName;
    private List<CardPaymentToken> paymentTokens;


    public PeakCard() {
    }

    public PeakCard(String publicToken, Integer currencyId, String cardStatus, String expDate, Long avlBalance,
                    Long finBalance, String companyName, String program, String firstName, String lastName,
                    String rStreetLine1, String rStreetLine2, String rCity, String rState, String rZip,
                    Integer rCountryId, String mainPhone, String dob, String email, String ddStatus, 
                    Long feeTarifPlanId, String cardholderName) {
        this.publicToken = publicToken;
        this.currencyId = currencyId;
        this.cardStatus = cardStatus;
        this.expDate = expDate;
        this.avlBalance = avlBalance;
        this.finBalance = finBalance;
        this.companyName = companyName;
        this.program = program;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rStreetLine1 = rStreetLine1;
        this.rStreetLine2 = rStreetLine2;
        this.rCity = rCity;
        this.rState = rState;
        this.rZip = rZip;
        this.rCountryId = rCountryId;
        this.mainPhone = mainPhone;
        this.dob = dob;
        this.email = email;
        this.ddStatus = ddStatus;
        this.feeTarifPlanId = feeTarifPlanId;
        this.cardholderName = cardholderName;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setAvlBalance(Long avlBalance) {
        this.avlBalance = avlBalance;
    }

    public Long getAvlBalance() {
        return avlBalance;
    }

    public void setFinBalance(Long finBalance) {
        this.finBalance = finBalance;
    }

    public Long getFinBalance() {
        return finBalance;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRStreetLine1(String rStreetLine1) {
        this.rStreetLine1 = rStreetLine1;
    }

    //@JsonProperty("rStreetLine1")
    public String getRStreetLine1() {
        return rStreetLine1;
    }

    public void setRStreetLine2(String rStreetLine2) {
        this.rStreetLine2 = rStreetLine2;
    }

    //@JsonProperty("rStreetLine2")
    public String getRStreetLine2() {
        return rStreetLine2;
    }

    public void setRCity(String rCity) {
        this.rCity = rCity;
    }

    //@JsonProperty("rCity")
    public String getRCity() {
        return rCity;
    }

    public void setRState(String rState) {
        this.rState = rState;
    }

    //@JsonProperty("rState")
    public String getRState() {
        return rState;
    }

    public void setRZip(String rZip) {
        this.rZip = rZip;
    }

    //@JsonProperty("rZip")
    public String getRZip() {
        return rZip;
    }

    public void setRCountryId(Integer rCountryId) {
        this.rCountryId = rCountryId;
    }

    //@JsonProperty("rCountryId")
    public Integer getRCountryId() {
        return rCountryId;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setFeeTarifPlanId(Long feeTarifPlanId) {
        this.feeTarifPlanId = feeTarifPlanId;
    }

    public Long getFeeTarifPlanId() {
        return feeTarifPlanId;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public List<CardPaymentToken> getPaymentTokens() {
        return paymentTokens;
    }

    public void setPaymentTokens(List<CardPaymentToken> paymentTokens) {
        this.paymentTokens = paymentTokens;
    }
}
