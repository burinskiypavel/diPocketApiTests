package com.cs.dipocketback.pojo.references;

public class MailAddrCountry {
    
    private Integer id;
    private String code;
    private String code3;
    private String name;
    
    public MailAddrCountry() {
    }

    public MailAddrCountry(Integer id, 
                           String code, 
                           String code3, 
                           String name) {
        this.id = id;
        this.code = code;
        this.code3 = code3;
        this.name = name;
    }

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

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getCode3() {
        return code3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
