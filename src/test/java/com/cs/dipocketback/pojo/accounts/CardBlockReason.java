package com.cs.dipocketback.pojo.accounts;

//pojo//import com.fasterxml.jackson.annotation.JsonProperty;

public class CardBlockReason {
    
    private String code;
    private String sName;
    
    public CardBlockReason() {
    }

    public CardBlockReason(String code, String sName) {
        this.code = code;
        this.sName = sName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    ////@JsonProperty("SName")
    public String getSName() {
        return sName;
    }

}
