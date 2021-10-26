package com.cs.dipocketback.pojo.card;

public class CardSecurityInfo {

    private String pan;
    private String expDate;
    private String cvv;

    public CardSecurityInfo() {
    }

    public CardSecurityInfo(String pan, String expDate, String cvv) {
        this.pan = pan;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    
}
