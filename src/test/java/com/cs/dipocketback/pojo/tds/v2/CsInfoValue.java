package com.cs.dipocketback.pojo.tds.v2;

public class CsInfoValue {
    private Long cResId;
    private String csInfoKey;
    private String csInfoValue;

    public CsInfoValue() {
    }

    public Long getcResId() {
        return cResId;
    }

    public void setcResId(Long cResId) {
        this.cResId = cResId;
    }

    public String getCsInfoKey() {
        return csInfoKey;
    }

    public void setCsInfoKey(String csInfoKey) {
        this.csInfoKey = csInfoKey;
    }

    public String getCsInfoValue() {
        return csInfoValue;
    }

    public void setCsInfoValue(String csInfoValue) {
        this.csInfoValue = csInfoValue;
    }
}
