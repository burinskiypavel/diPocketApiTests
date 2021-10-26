package com.cs.dipocketback.pojo.pos;

import java.util.List;

public class CheckShiftResponse {

    private String login;
    private Boolean isShiftOpened;
    private List<CashierAvlCurrency> avlCurrencies;

    public CheckShiftResponse() {
    }

    public CheckShiftResponse(String login, Boolean isShiftOpened, List<CashierAvlCurrency> avlCurrencies) {
        this.login = login;
        this.isShiftOpened = isShiftOpened;
        this.avlCurrencies = avlCurrencies;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getShiftOpened() {
        return isShiftOpened;
    }

    public void setShiftOpened(Boolean shiftOpened) {
        isShiftOpened = shiftOpened;
    }

    public List<CashierAvlCurrency> getAvlCurrencies() {
        return avlCurrencies;
    }

    public void setAvlCurrencies(List<CashierAvlCurrency> avlCurrencies) {
        this.avlCurrencies = avlCurrencies;
    }
}
