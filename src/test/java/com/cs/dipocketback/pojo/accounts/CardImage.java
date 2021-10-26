package com.cs.dipocketback.pojo.accounts;

public class CardImage {
    
    private String frontView;
    private String backView;
    
    public CardImage() {
    }

    public CardImage(String frontView, String backView) {
        this.frontView = frontView;
        this.backView = backView;
    }

    public void setFrontView(String frontView) {
        this.frontView = frontView;
    }

    public String getFrontView() {
        return frontView;
    }

    public void setBackView(String backView) {
        this.backView = backView;
    }

    public String getBackView() {
        return backView;
    }
}
