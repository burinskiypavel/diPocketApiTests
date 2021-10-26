package com.cs.dipocketback.pojo.references;

public class GetRegisterInfoByCardRequest {

    private Integer langId;
    private String lang;
    private String token;

    public GetRegisterInfoByCardRequest() {
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
