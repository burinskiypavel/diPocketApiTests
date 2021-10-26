package com.cs.dipocketback.pojo.santander;

import java.util.Date;

public class ImportTransactionResponse {
    
    private String msgId;
//    private Date creationDate;
//    private Date importDate;
    private String creationDate;
    private String importDate;
    private String importStatus;
    private Integer numberOfTransactions;
    
    public ImportTransactionResponse() {
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportStatus(String importStatus) {
        this.importStatus = importStatus;
    }

    public String getImportStatus() {
        return importStatus;
    }

    public void setNumberOfTransactions(Integer numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public Integer getNumberOfTransactions() {
        return numberOfTransactions;
    }
}
