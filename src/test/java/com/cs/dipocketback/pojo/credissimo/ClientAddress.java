package com.cs.dipocketback.pojo.credissimo;

public class ClientAddress {

    private String streetLine1;
    private String streetLine2;
    private String city;
    private String countryCode; //Country code; Alpha-2 ISO 3166-1 UA
    private String zip; //01-063

    public ClientAddress() {
    }

    public ClientAddress(String streetLine1, String streetLine2, String city, String countryCode, String zip) {
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.city = city;
        this.countryCode = countryCode;
        this.zip = zip;
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

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }
}
