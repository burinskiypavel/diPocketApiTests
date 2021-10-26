package com.cs.dipocketback.pojo.references;


public class PayeeCountry {

    private Integer id;
    private String code;
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PayeeCountry() {
    }

    public PayeeCountry(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

}