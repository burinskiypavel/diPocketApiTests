package com.cs.dipocketback.pojo.references;


public class Language {
    
    private Integer id;
    private String name;
    private String nameEng;
    private String code;

    public Language() {
    }

    public Language(Integer id, String name, String nameEng, String code) {
        this.id = id;
        this.name = name;
        this.nameEng = nameEng;
        this.code = code;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
