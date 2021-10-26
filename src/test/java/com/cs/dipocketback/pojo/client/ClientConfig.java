package com.cs.dipocketback.pojo.client;

import com.cs.dipocketback.pojo.references.params.AppParams;

public class ClientConfig {
    
    private AppParams appParams;
    
    private String payeeCurrencyHash;
    private String payeePaymentTypeHash;
    private String bankTransferReasonHash;
    private String avlCurrencyForNewAccHash;
    private String dipTransferCurrencyHash;
    private String availCategoriesHash;
    
    public ClientConfig() {
    }

    public void setAppParams(AppParams appParams) {
        this.appParams = appParams;
    }

    public AppParams getAppParams() {
        return appParams;
    }

    public void setPayeePaymentTypeHash(String payeePaymentTypesHash) {
        this.payeePaymentTypeHash = payeePaymentTypesHash;
    }

    public String getPayeePaymentTypeHash() {
        return payeePaymentTypeHash;
    }

    public void setPayeeCurrencyHash(String payeeCurrencyHash) {
        this.payeeCurrencyHash = payeeCurrencyHash;
    }

    public String getPayeeCurrencyHash() {
        return payeeCurrencyHash;
    }

    public void setBankTransferReasonHash(String bankTransferReasonHash) {
        this.bankTransferReasonHash = bankTransferReasonHash;
    }

    public String getBankTransferReasonHash() {
        return bankTransferReasonHash;
    }

    public void setAvlCurrencyForNewAccHash(String avlCurrencyForNewAccHash) {
        this.avlCurrencyForNewAccHash = avlCurrencyForNewAccHash;
    }

    public String getAvlCurrencyForNewAccHash() {
        return avlCurrencyForNewAccHash;
    }

    public void setDipTransferCurrencyHash(String dipTransferCurrencyHash) {
        this.dipTransferCurrencyHash = dipTransferCurrencyHash;
    }

    public String getDipTransferCurrencyHash() {
        return dipTransferCurrencyHash;
    }

    public void setAvailCategoriesHash(String availCategoriesHash) {
        this.availCategoriesHash = availCategoriesHash;
    }

    public String getAvailCategoriesHash() {
        return availCategoriesHash;
    }

}
