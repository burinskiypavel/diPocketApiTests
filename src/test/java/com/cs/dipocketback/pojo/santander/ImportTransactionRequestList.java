package com.cs.dipocketback.pojo.santander;

import java.util.List;

public class ImportTransactionRequestList {
    
    private List<ImportTransactionRequest> requestList;
    
    public ImportTransactionRequestList() {
    }

    public ImportTransactionRequestList(List<ImportTransactionRequest> requestList) {
        this.requestList = requestList;
    }

    public void setRequestList(List<ImportTransactionRequest> requestList) {
        this.requestList = requestList;
    }

    public List<ImportTransactionRequest> getRequestList() {
        return requestList;
    }
}
