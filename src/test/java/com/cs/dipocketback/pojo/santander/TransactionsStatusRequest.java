package com.cs.dipocketback.pojo.santander;

public class TransactionsStatusRequest {
    
    private Long id;
    private String messageId;
    private Long batchId;
    private String createDateTime;
    private String origMessageId;
    
    public TransactionsStatusRequest() {
    }

    public TransactionsStatusRequest(Long id, 
                                     String messageId, 
                                     Long batchId, 
                                     String createDateTime,
                                     String origMessageId) {
        this.id = id;
        this.messageId = messageId;
        this.batchId = batchId;
        this.createDateTime = createDateTime;
        this.origMessageId = origMessageId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setOrigMessageId(String origMessageId) {
        this.origMessageId = origMessageId;
    }

    public String getOrigMessageId() {
        return origMessageId;
    }
    
}
