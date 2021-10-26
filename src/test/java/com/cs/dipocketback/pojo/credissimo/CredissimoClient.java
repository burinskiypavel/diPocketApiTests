package com.cs.dipocketback.pojo.credissimo;

public class CredissimoClient {
    
    private String credissimoClientId;
    private String firstName;
    private String lastName;
    private String dob; //1985-12-24
    private String identifyCode;
    private String phone;
    private String email;
    private ClientAddress address;
    private String langCode;
    private String currencyCode;
    
    public CredissimoClient() {
    }

    public CredissimoClient(String credissimoClientId, String firstName, String lastName, String dob, String identifyCode,
                      String phone, String email, ClientAddress address, String langCode, String currencyCode) {
        this.credissimoClientId = credissimoClientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.identifyCode = identifyCode;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.langCode = langCode;
        this.currencyCode = currencyCode;
    }

    public void setCredissimoClientId(String credissimoClientId) {
        this.credissimoClientId = credissimoClientId;
    }

    public String getCredissimoClientId() {
        return credissimoClientId;
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

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(ClientAddress address) {
        this.address = address;
    }

    public ClientAddress getAddress() {
        return address;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

}
