package com.cs.dipocketback.pojo.references;

import java.util.List;

public class CountryList {
    
    private List<Country> countryList;
    private List<Currency> availableCurrencies;
    private String countryHash;
    
    public CountryList() {
    }
    
    public CountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public CountryList(List<Country> countryList, List<Currency> availableCurrencies, String countryHash) {
        this.countryList = countryList;
        this.availableCurrencies = availableCurrencies;
        this.countryHash = countryHash;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setAvailableCurrencies(List<Currency> availableCurrencies) {
        this.availableCurrencies = availableCurrencies;
    }

    public List<Currency> getAvailableCurrencies() {
        return availableCurrencies;
    }

    public void setCountryHash(String counnryHash) {
        this.countryHash = counnryHash;
    }

    public String getCountryHash() {
        return countryHash;
    }
    
}
