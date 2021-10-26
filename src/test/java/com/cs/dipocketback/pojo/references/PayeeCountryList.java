package com.cs.dipocketback.pojo.references;

import java.util.List;

public class PayeeCountryList {

    private List<PayeeCountry> payeeCountryList;

    public PayeeCountryList() {
    }

    public PayeeCountryList(List<PayeeCountry> payeeCountryList) {
      this.payeeCountryList = payeeCountryList;
    }

    public void setPayeeCountryList(List<PayeeCountry> payeeCountryList) {
        this.payeeCountryList = payeeCountryList;
    }

    public List<PayeeCountry> getPayeeCountryList() {
        return payeeCountryList;
    }

}
