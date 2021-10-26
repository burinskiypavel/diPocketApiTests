package com.cs.dipocketback.pojo.customer;

public class CardInfoByPanRequest {

    private String pan;

    public CardInfoByPanRequest() {
    }

    public CardInfoByPanRequest(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

}
