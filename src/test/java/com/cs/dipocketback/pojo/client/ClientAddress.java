package com.cs.dipocketback.pojo.client;

public class ClientAddress {
    
    public final static Integer MAIL = 0;
    public final static Integer REGISTERED_ADDRESS = 3;
    
    private Integer typeId;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String zip;
    private String state;
    private Integer countryId;
    private Boolean registeredAddrAsMail;
    
    public ClientAddress() {
    }

    public ClientAddress(Integer typeId, 
                         String streetLine1, 
                         String streetLine2, 
                         String city, 
                         String zip,
                         Integer countryId, 
                         String state) {
        this.typeId = typeId;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.city = city;
        this.zip = zip;
        this.countryId = countryId;
        this.state = state;
    }

    public ClientAddress(Integer typeId, 
                         String streetLine1, 
                         String streetLine2, 
                         String city, 
                         String zip,
                         Integer countryId, 
                         Boolean registeredAddrAsMail, 
                         String state) {
        this.typeId = typeId;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.city = city;
        this.zip = zip;
        this.countryId = countryId;
        this.registeredAddrAsMail = registeredAddrAsMail;
        this.state = state;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setRegisteredAddrAsMail(Boolean registeredAddrAsMail) {
        this.registeredAddrAsMail = registeredAddrAsMail;
    }

    public Boolean getRegisteredAddrAsMail() {
        return registeredAddrAsMail;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "typeId: " + getTypeId() + ", Street1: " + getStreetLine1() + ", Street2: " + getStreetLine2() +
               ", Country: " + getCountryId() + ", Zip: " + getZip()+ ", State: "+getState();
    }
    
}
