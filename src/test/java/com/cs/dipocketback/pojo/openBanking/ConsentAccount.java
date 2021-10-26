package com.cs.dipocketback.pojo.openBanking;

public class ConsentAccount {

    private String iban;
    private String currency;
    private String name;
    private ConsentAccountLink _links;

    public ConsentAccount() {
    }

    public ConsentAccount(String iban, String currency, String name, ConsentAccountLink _links) {
        this.iban = iban;
        this.currency = currency;
        this.name = name;
        this._links = _links;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConsentAccountLink get_links() {
        return _links;
    }

    public void set_links(ConsentAccountLink _links) {
        this._links = _links;
    }
}
