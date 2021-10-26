package com.cs.dipocketback.pojo.extCharge;

public class ExtChargeByCardRequest {

    private String pan;
    private String cvv;
    private String validThru;
    private Long amount;
    private String ccy;
    private String returnLink;
    private Integer langId;

    public ExtChargeByCardRequest() {
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getReturnLink() {
        return returnLink;
    }

    public void setReturnLink(String returnLink) {
        this.returnLink = returnLink;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }
}
