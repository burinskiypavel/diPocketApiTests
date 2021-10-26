package com.cs.dipocketback.pojo.references;

import java.util.List;

public class MailAddrCountryList {
    
    private List<MailAddrCountry> countryList;
    
    public MailAddrCountryList() {
    }

    public MailAddrCountryList(List<MailAddrCountry> countryList) {
        this.countryList = countryList;
    }

    public void setCountryList(List<MailAddrCountry> countryList) {
        this.countryList = countryList;
    }

    public List<MailAddrCountry> getCountryList() {
        return countryList;
    }

}
