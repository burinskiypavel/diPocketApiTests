package com.cs.dipocketback.pojo.accounts;

public class Account4Link {

//    TYPE TAvailAccountRec IS RECORD(
//      ID               Account.ID%TYPE,
//      SName            Account.SName%TYPE,
//      CurrencyID       Currency.ID%TYPE,
//      CurrencySymbol   Currency.Symbol%TYPE,
//      CurrencyCode     Currency.Code%TYPE,
//      IsShared         NUMBER(1),
//      OwnerName        ClientPal.PalName%TYPE,
//      IsEnoughFunds    NUMBER(1),
//      IsDefault        NUMBER(1)
//      );

    private Long accountId;
    private String accountSName;
    private Integer currencyId;
    private String currencySymbol;
    private String currencyCode;
    private Boolean isShared;
    private String ownerName;
    private Boolean isEnoughFunds;
    private Boolean isDefault;

    public Account4Link() {
    }

    public Account4Link(Long accountId,
                        String accountSName,
                        Integer currencyId,
                        String currencySymbol,
                        String currencyCode,
                        Boolean isShared,
                        String ownerName,
                        Boolean isEnoughFunds,
                        Boolean isDefault) {
        this.accountId = accountId;
        this.accountSName = accountSName;
        this.currencyId = currencyId;
        this.currencySymbol = currencySymbol;
        this.currencyCode = currencyCode;
        this.isShared = isShared;
        this.ownerName = ownerName;
        this.isEnoughFunds = isEnoughFunds;
        this.isDefault = isDefault;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountSName(String accountSName) {
        this.accountSName = accountSName;
    }

    public String getAccountSName() {
        return accountSName;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setIsShared(Boolean isShared) {
        this.isShared = isShared;
    }

    public Boolean getIsShared() {
        return isShared;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setIsEnoughFunds(Boolean isEnoughFunds) {
        this.isEnoughFunds = isEnoughFunds;
    }

    public Boolean getIsEnoughFunds() {
        return isEnoughFunds;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

}
