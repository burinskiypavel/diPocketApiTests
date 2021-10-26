package com.cs.dipocketback.pojo.dashboard;

public class CardInfo {
    
    private String publicToken;
    private String pan;
    private Integer langId;
    private Long avlBalance;
    private Integer ccyId;
    private String ccy;
    private String ccySymbol;
    private Integer programId;
    private String programName;
    private String baseUrl;
    
    public CardInfo() {
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

    public void setAvlBalance(Long avlBalance) {
        this.avlBalance = avlBalance;
    }

    public Long getAvlBalance() {
        return avlBalance;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Integer getProgramId() {
        return programId;
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

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }
}
