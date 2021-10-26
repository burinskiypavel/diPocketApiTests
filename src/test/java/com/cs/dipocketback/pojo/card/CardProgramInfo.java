package com.cs.dipocketback.pojo.card;

public class CardProgramInfo {
    
    private String publicToken;
    private Integer langId;
    
    private String clientSite;
    private Integer programId;
    private String programIntName;
    private String programName;
    private String baseUrl;
    
    public CardProgramInfo() {
    }

    public CardProgramInfo(String publicToken, Integer langId) {
        this.publicToken = publicToken;
        this.langId = langId;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setClientSite(String clientSite) {
        this.clientSite = clientSite;
    }

    public String getClientSite() {
        return clientSite;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramIntName(String programIntName) {
        this.programIntName = programIntName;
    }

    public String getProgramIntName() {
        return programIntName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
