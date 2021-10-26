package com.cs.dipocketback.pojo.playit;

public class PlsRegisterClientRequest {

    private String name;
    private String secondName;
    private String email;
    private String birthDate;
    private String mobilePhone;
    private String postCode;
    private Boolean agreeTAC;
    private Boolean agreePP;
    private Boolean agreePM;
    private String cardNumber;
    private String expiryDateMonth;
    private String expiryDateYear;
    private String password;

    public PlsRegisterClientRequest() {
    }

    public PlsRegisterClientRequest(String name, String secondName, String email, String birthDate, String mobilePhone, String postCode, Boolean agreeTAC, Boolean agreePP, Boolean agreePM, String cardNumber, String expiryDateMonth, String expiryDateYear, String password) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.birthDate = birthDate;
        this.mobilePhone = mobilePhone;
        this.postCode = postCode;
        this.agreeTAC = agreeTAC;
        this.agreePP = agreePP;
        this.agreePM = agreePM;
        this.cardNumber = cardNumber;
        this.expiryDateMonth = expiryDateMonth;
        this.expiryDateYear = expiryDateYear;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Boolean getAgreeTAC() {
        return agreeTAC;
    }

    public void setAgreeTAC(Boolean agreeTAC) {
        this.agreeTAC = agreeTAC;
    }

    public Boolean getAgreePP() {
        return agreePP;
    }

    public void setAgreePP(Boolean agreePP) {
        this.agreePP = agreePP;
    }

    public Boolean getAgreePM() {
        return agreePM;
    }

    public void setAgreePM(Boolean agreePM) {
        this.agreePM = agreePM;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDateMonth() {
        return expiryDateMonth;
    }

    public void setExpiryDateMonth(String expiryDateMonth) {
        this.expiryDateMonth = expiryDateMonth;
    }

    public String getExpiryDateYear() {
        return expiryDateYear;
    }

    public void setExpiryDateYear(String expiryDateYear) {
        this.expiryDateYear = expiryDateYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
