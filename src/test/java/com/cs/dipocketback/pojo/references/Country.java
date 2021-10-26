package com.cs.dipocketback.pojo.references;

public class Country {
    
    private Integer id;
    private String code;
    private String name;
    private Integer defCurrencyId;
    private Boolean forResidence;
    private Boolean forMail;
    private Boolean canHaveFDD;

    public Country() {
    }

    public Country(Integer id, 
                   String name) {
        this.id = id;
        this.name = name;
    }

    public Country(Integer id, 
                   String code, 
                   String name, 
                   Integer defCurrencyId, 
                   Boolean forResidence, 
                   Boolean forMail,
                   Boolean canHaveFDD) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.defCurrencyId = defCurrencyId;
        this.forResidence = forResidence;
        this.forMail = forMail;
        this.canHaveFDD = canHaveFDD;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDefCurrencyId(Integer defCurrencyId) {
        this.defCurrencyId = defCurrencyId;
    }

    public Integer getDefCurrencyId() {
        return defCurrencyId;
    }

    public void setForResidence(Boolean forResidence) {
        this.forResidence = forResidence;
    }

    public Boolean getForResidence() {
        return forResidence;
    }

    public void setForMail(Boolean forMail) {
        this.forMail = forMail;
    }

    public Boolean getForMail() {
        return forMail;
    }

    public void setCanHaveFDD(Boolean canHaveFDD) {
        this.canHaveFDD = canHaveFDD;
    }

    public Boolean getCanHaveFDD() {
        return canHaveFDD;
    }

}
