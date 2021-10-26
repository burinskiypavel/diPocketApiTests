package com.cs.dipocketback.pojo.openBanking;

import java.util.Map;

public class ConsentInfoResponse {

    private ConsentInfoOut data;
    private Map<String, String> webText;

    public ConsentInfoResponse() {
    }

    public ConsentInfoResponse(ConsentInfoOut data, Map<String, String> webText) {
        this.data = data;
        this.webText = webText;
    }

    public ConsentInfoOut getData() {
        return data;
    }

    public void setData(ConsentInfoOut data) {
        this.data = data;
    }

    public Map<String, String> getWebText() {
        return webText;
    }

    public void setWebText(Map<String, String> webText) {
        this.webText = webText;
    }
}
