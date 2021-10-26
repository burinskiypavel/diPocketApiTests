package com.cs.dipocketback.pojo.references;

public class PekaoDiPClientAccount {
    
    private static final int PHONENUMBER_LENGTH = 12;

    private String ccyCode;
    private String iban;
    private String virtualAccHead;
    
    public PekaoDiPClientAccount() {
    }

    public PekaoDiPClientAccount(String ccyCode, String virtualAccHead) {
        this.ccyCode = ccyCode;
        this.virtualAccHead = virtualAccHead;
    }

    public void setVirtualAccHead(String virtualAccHead) {
        this.virtualAccHead = virtualAccHead;
    }

    public String getVirtualAccHead() {
        return virtualAccHead;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public String getCcyCode() {
        return ccyCode;
    }

}
