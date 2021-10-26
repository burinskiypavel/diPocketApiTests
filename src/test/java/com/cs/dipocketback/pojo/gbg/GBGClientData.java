package com.cs.dipocketback.pojo.gbg;

import java.util.Date;

public class GBGClientData {

    private String uniqueId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String yearOfBirth;
    private String address;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String nationality;

    public GBGClientData() {
    }

    public GBGClientData(String uniqueId, 
                         String firstName, 
                         String lastName, 
                         Date birthDate, 
                         String yearOfBirth,
                         String address, 
                         String city, 
                         String state,
                         String postCode, 
                         String country,
                         String nationality) {
        this.uniqueId = uniqueId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
        this.nationality = nationality;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
}

