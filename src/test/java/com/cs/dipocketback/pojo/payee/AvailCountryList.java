package com.cs.dipocketback.pojo.payee;

import java.util.List;

public class AvailCountryList {
    
    private List<AvailCountry> availCountryList;
    
    public AvailCountryList() {
    }

    public AvailCountryList(List<AvailCountry> availCountryList) {
        this.availCountryList = availCountryList;
    }

    public void setAvailCountryList(List<AvailCountry> availCountryList) {
        this.availCountryList = availCountryList;
    }

    public List<AvailCountry> getAvailCountryList() {
        return availCountryList;
    }
    
}
