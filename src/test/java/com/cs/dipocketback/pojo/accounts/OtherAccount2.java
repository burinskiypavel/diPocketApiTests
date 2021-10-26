package com.cs.dipocketback.pojo.accounts;

public class OtherAccount2 {
    
    private Long accountId;
    private String accountName;
    private String maskedPan;
    private String currencyCode;
    private Integer currencyId;
    private String subtype;

    public OtherAccount2() {
    }

    public OtherAccount2(Long accountId, 
                         String accountName, 
                         String maskedPan, 
                         String currencyCode, 
                         Integer currencyId,
                         String subtype) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.maskedPan = maskedPan;
        this.currencyCode = currencyCode;
        this.currencyId = currencyId;
        this.subtype = subtype;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getSubtype() {
        return subtype;
    }

}
