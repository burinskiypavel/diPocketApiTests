package com.cs.dipocketback.pojo.web.topup;

public class WebAddCardTopUpRequest extends WebTopUpBaseRequest{

    private String accountName;
    private String pan;
    private String cvv;
    private String validThru;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }
}
