package com.cs.dipocketback.pojo.email;

import java.util.List;

public class TemplateIdListResponse {

    private List<String> templateIdList;

    public TemplateIdListResponse() {
    }

    public TemplateIdListResponse(List<String> templateIdList) {
        this.templateIdList = templateIdList;
    }

    public List<String> getTemplateIdList() {
        return templateIdList;
    }

    public void setTemplateIdList(List<String> templateIdList) {
        this.templateIdList = templateIdList;
    }

}
