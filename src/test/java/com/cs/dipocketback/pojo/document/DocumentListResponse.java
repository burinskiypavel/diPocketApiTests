package com.cs.dipocketback.pojo.document;

import java.util.List;

public class DocumentListResponse {
    
    private List<Document> documentList;
    
    public DocumentListResponse() {
    }

    public DocumentListResponse(List<Document> documentList) {
        this.documentList = documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

}
