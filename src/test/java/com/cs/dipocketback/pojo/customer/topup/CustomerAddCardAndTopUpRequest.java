package com.cs.dipocketback.pojo.customer.topup;

public class CustomerAddCardAndTopUpRequest extends CustomerBaseTopUpRequest{

    private String cvv;
    private String pan;
    private String expDate;

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
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
}
