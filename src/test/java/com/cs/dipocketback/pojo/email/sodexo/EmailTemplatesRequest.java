package com.cs.dipocketback.pojo.email.sodexo;

import java.util.List;

public class EmailTemplatesRequest {

    private List<String> templateIdList;

    public EmailTemplatesRequest() {
    }

    public EmailTemplatesRequest(List<String> templateIdList) {
        this.templateIdList = templateIdList;
    }

    public List<String> getTemplateIdList() {
        return templateIdList;
    }

    public void setTemplateIdList(List<String> templateIdList) {
        this.templateIdList = templateIdList;
    }

}
