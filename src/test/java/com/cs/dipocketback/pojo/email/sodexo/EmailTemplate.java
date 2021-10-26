package com.cs.dipocketback.pojo.email.sodexo;

public class EmailTemplate {

    private String typeId;
    private String description;
    private String sName;
    private String htmlBody;

    public EmailTemplate() {
    }

    public EmailTemplate(String description, String htmlBody) {
        this.description = description;
        this.htmlBody = htmlBody;
    }

    public EmailTemplate(String typeId, String description, String htmlBody) {
        this.typeId = typeId;
        this.description = description;
        this.htmlBody = htmlBody;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
