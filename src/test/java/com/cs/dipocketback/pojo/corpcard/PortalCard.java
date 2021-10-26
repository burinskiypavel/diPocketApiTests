package com.cs.dipocketback.pojo.corpcard;

public class PortalCard {
    
    private Long cardId;
    
    private String portalUserName;
    
    private String token;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    
    private Integer langId;
    
    private String dateOfBirth;
    private String address;
    private String city;
    private String postCode;
    
    private Integer countryId;
    private String externalId;
    
    public PortalCard() {
    }

    public PortalCard(String token, String phoneNumber, String firstName, String lastName, String portalUserName, Integer langId) {
        this.token = token;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.portalUserName = portalUserName;
        this.langId = langId;
    }

    public PortalCard(String portalUserName, String token, String phoneNumber, String firstName, String lastName,
                      Integer langId, String dateOfBirth, String address, String city, String postCode, Integer countryId,
                      String externalId) {
        this.portalUserName = portalUserName;
        this.token = token;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.langId = langId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.countryId = countryId;
        this.externalId = externalId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setPortalUserName(String portalUserName) {
        this.portalUserName = portalUserName;
    }

    public String getPortalUserName() {
        return portalUserName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
