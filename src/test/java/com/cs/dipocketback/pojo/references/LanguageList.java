package com.cs.dipocketback.pojo.references;

import java.util.List;

public class LanguageList {
    
    private List<Language> languageList;
    private String langHash;

    public LanguageList() {
    }
    
    public LanguageList(List<Language> languageList, String langHash) {
        this.languageList = languageList;
        this.langHash = langHash;
    }
    
    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLangHash(String langHash) {
        this.langHash = langHash;
    }

    public String getLangHash() {
        return langHash;
    }
    
}
