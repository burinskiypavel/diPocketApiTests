package com.cs.dipocketback.pojo.email.sodexo;

import java.util.List;

public class EmailTemplatesResponse {

    private List<EmailTemplate> sodexoTemplates;

    public EmailTemplatesResponse() {
    }

    public EmailTemplatesResponse(List<EmailTemplate> sodexoTemplates) {
        this.sodexoTemplates = sodexoTemplates;
    }

    public List<EmailTemplate> getSodexoTemplates() {
        return sodexoTemplates;
    }

    public void setSodexoTemplates(List<EmailTemplate> sodexoTemplates) {
        this.sodexoTemplates = sodexoTemplates;
    }

}
