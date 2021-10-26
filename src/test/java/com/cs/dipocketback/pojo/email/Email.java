package com.cs.dipocketback.pojo.email;

import com.cs.dipocketback.base.data.Site;

public class Email {

    private Long id;
    private String typeId;
    private EmailType type;
    private Long clientId;
    private Site site;
    private String emailAddr;
    private String lang; // en

    public Email() {
    }

    public Email(EmailType type, Site site, String emailAddr, String lang) {
        this.type = type;
        this.site = site;
        this.emailAddr = emailAddr;
        this.lang = lang;
    }

    public Email(Long id,
                 String typeId,
                 EmailType type,
                 Long clientId,
                 Site site,
                 String emailAddr,
                 String lang) {
        this.id = id;
        this.typeId = typeId;
        this.type = type;
        this.clientId = clientId;
        this.site = site;
        this.emailAddr = emailAddr;
        this.lang = lang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
        this.type = type;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
