package com.cs.dipocketback.pojo.playit;

public class PlsUpdateClientRequest {
    private String name;
    private String secondName;
    private String birthDate;
    private String mobilePhone;
    private String postCode;
    private Boolean agreePM;
    private String expiryDateMonth;
    private String expiryDateYear;
    private String password;

    public PlsUpdateClientRequest() {
    }

    public PlsUpdateClientRequest(String name, String secondName, String birthDate, String mobilePhone, String postCode, Boolean agreePM, String expiryDateMonth, String expiryDateYear, String password) {
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.mobilePhone = mobilePhone;
        this.postCode = postCode;
        this.agreePM = agreePM;
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

    public Boolean getAgreePM() {
        return agreePM;
    }

    public void setAgreePM(Boolean agreePM) {
        this.agreePM = agreePM;
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
