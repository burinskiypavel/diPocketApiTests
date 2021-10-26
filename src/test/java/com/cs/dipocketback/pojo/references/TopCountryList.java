package com.cs.dipocketback.pojo.references;

import java.util.List;

public class TopCountryList {
    
    private List<TopCountry> topCountries;
    private String topCountriesHash;
    
    public TopCountryList() {
    }
    
    public TopCountryList(List<TopCountry> topCountries, String topCountriesHash) {
        this.topCountries = topCountries;
        this.topCountriesHash = topCountriesHash;
    }

    public void setTopCountries(List<TopCountry> topCountries) {
        this.topCountries = topCountries;
    }

    public List<TopCountry> getTopCountries() {
        return topCountries;
    }

    public void setTopCountriesHash(String topCountriesHash) {
        this.topCountriesHash = topCountriesHash;
    }

    public String getTopCountriesHash() {
        return topCountriesHash;
    }
    
}
