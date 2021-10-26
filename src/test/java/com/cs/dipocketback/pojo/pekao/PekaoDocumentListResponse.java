package com.cs.dipocketback.pojo.pekao;

import java.util.List;

public class PekaoDocumentListResponse {

    private String messageIdentification;
    private List<PekaoDocumentDetails> lstNtry;

    public PekaoDocumentListResponse() {
    }

    public PekaoDocumentListResponse(String messageIdentification, List<PekaoDocumentDetails> lstNtry) {
        this.messageIdentification = messageIdentification;
        this.lstNtry = lstNtry;
    }

    public String getMessageIdentification() {
        return messageIdentification;
    }

    public void setMessageIdentification(String messageIdentification) {
        this.messageIdentification = messageIdentification;
    }

    public List<PekaoDocumentDetails> getLstNtry() {
        return lstNtry;
    }

    public void setLstNtry(List<PekaoDocumentDetails> lstNtry) {
        this.lstNtry = lstNtry;
    }

}
