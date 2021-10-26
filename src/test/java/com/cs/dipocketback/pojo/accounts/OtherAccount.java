package com.cs.dipocketback.pojo.accounts;


public class OtherAccount {
    
    private Long id;
    private String accountName;
    private String maskedPan;
    private String ccy;
    private Integer ccyID;
    private String subtype;

    public OtherAccount() {
    }

    public OtherAccount(Long id, 
                        String accountName, 
                        String maskedPan, 
                        String ccy, 
                        Integer ccyID) {
        this.id = id;
        this.accountName = accountName;
        this.maskedPan = maskedPan;
        this.ccy = ccy;
        this.ccyID = ccyID;
    }

    public OtherAccount(Long id, 
                        String accountName, 
                        String maskedPan, 
                        String ccy, 
                        Integer ccyID, 
                        String subtype) {
        this.id = id;
        this.accountName = accountName;
        this.maskedPan = maskedPan;
        this.ccy = ccy;
        this.ccyID = ccyID;
        this.subtype = subtype;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcyID(Integer ccyID) {
        this.ccyID = ccyID;
    }

    public Integer getCcyID() {
        return ccyID;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getSubtype() {
        return subtype;
    }

}
