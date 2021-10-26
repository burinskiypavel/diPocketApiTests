package com.cs.dipocketback.pojo.accounts;

import com.cs.dipocketback.pojo.gps.GPSCardLimit;
import java.util.ArrayList;
import java.util.List;

public class AccountLimitList {
    
    private List<AccountLimit> accountLimitList;
    private List<GPSCardLimit> cardLimitList = new ArrayList<>();
    
    public AccountLimitList() {
    }

    public AccountLimitList(List<AccountLimit> accountLimitList) {
        this.accountLimitList = accountLimitList;
    }

    public void setAccountLimitList(List<AccountLimit> accountLimitList) {
        this.accountLimitList = accountLimitList;
    }

    public List<AccountLimit> getAccountLimitList() {
        return accountLimitList;
    }

    public void setCardLimitList(List<GPSCardLimit> cardLimitList) {
        this.cardLimitList = cardLimitList;
    }

    public List<GPSCardLimit> getCardLimitList() {
        return cardLimitList;
    }
    
}
