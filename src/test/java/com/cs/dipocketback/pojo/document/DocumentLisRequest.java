package com.cs.dipocketback.pojo.document;

import java.util.List;

public class DocumentLisRequest {
    
    private List<Document> documentList;
    
    public DocumentLisRequest() {
    }

    public DocumentLisRequest(List<Document> documentList) {
        this.documentList = documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

}
