package com.cs.dipocketback.pojo.lang;

public class LangInfo {

    private Integer id;
    private String sname;
    private String snameEng;
    private String code;
    private String codeTwoLetters;

    public LangInfo(Integer id, 
                    String sname, 
                    String snameEng, 
                    String code, 
                    String codeTwoLetters) {
        this.id = id;
        this.sname = sname;
        this.snameEng = snameEng;
        this.code = code;
        this.codeTwoLetters = codeTwoLetters;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSname() {
        return sname;
    }

    public void setSnameEng(String snameEng) {
        this.snameEng = snameEng;
    }

    public String getSnameEng() {
        return snameEng;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCodeTwoLetters(String codeTwoLetters) {
        this.codeTwoLetters = codeTwoLetters;
    }

    public String getCodeTwoLetters() {
        return codeTwoLetters;
    }

}
