package com.cs.dipocketback.pojo.dashboard;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class TranAvailCategories {
    
    private Integer id;
    //@JsonProperty("SName")
    private String sName;
    
    public TranAvailCategories() {
    }

    public TranAvailCategories(Integer id, String sName) {
        this.id = id;
        this.sName = sName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }
}
