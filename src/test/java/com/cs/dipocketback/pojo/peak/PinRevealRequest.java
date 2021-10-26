package com.cs.dipocketback.pojo.peak;

public class PinRevealRequest {
    
    private String publicToken; //123456789
    private String cvv;         //012
    private String dob;        //1969-08-08
    private String mainPhone;   //38050XXXXXXX
    private String expDate;     //01/21
    
    public PinRevealRequest() {
    }

    public PinRevealRequest(String publicToken, String cvv, String dob, String mainPhone, String expDate) {
        this.publicToken = publicToken;
        this.cvv = cvv;
        this.dob = dob;
        this.mainPhone = mainPhone;
        this.expDate = expDate;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

}
