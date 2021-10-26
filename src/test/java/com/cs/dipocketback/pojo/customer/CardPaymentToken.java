package com.cs.dipocketback.pojo.customer;

public class CardPaymentToken {

    private String tokenRef;
    private String walletType;
    private String wallet;

    public CardPaymentToken() {
    }

    public CardPaymentToken(String tokenRef, String walletType, String wallet) {
        this.tokenRef = tokenRef;
        this.walletType = walletType;
        this.wallet = wallet;
    }

    public String getTokenRef() {
        return tokenRef;
    }

    public void setTokenRef(String tokenRef) {
        this.tokenRef = tokenRef;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }
}
