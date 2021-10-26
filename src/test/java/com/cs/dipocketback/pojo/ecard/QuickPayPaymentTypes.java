package com.cs.dipocketback.pojo.ecard;

public class QuickPayPaymentTypes {

    private String paymentType;
    private String nameOfBank;
    private String description;
    private String logoRef;
    private String iconURL;
    
    public QuickPayPaymentTypes() {
    }

    public QuickPayPaymentTypes(String paymentType, 
                                String nameOfBank, 
                                String description, 
                                String logoRef, 
                                String iconURL) {
        this.paymentType = paymentType;
        this.nameOfBank = nameOfBank;
        this.description = description;
        this.logoRef = logoRef;
        this.iconURL = iconURL;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLogoRef(String logoRef) {
        this.logoRef = logoRef;
    }

    public String getLogoRef() {
        return logoRef;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getIconURL() {
        return iconURL;
    }
    
}
