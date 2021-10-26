package com.cs.dipocketback.pojo.pekao;

public class PekaoTransferStatus {
    
    public static final int PT_LOCAL = 1;
    public static final int PT_SEPA = 2;
    public static final int PT_SWIFT = 3;
    
    //main
    private Long tranId;
    private Long internalTranId;
    private String messageId;
    private Long createDateTime;
    private String origMessageId;
    
    //return values
    private String rMessageId;
    private Long rCreatedDateTime;
    private String origPaymentId;
    private String status;
    private String statusText;
    private Long execDate;

    public PekaoTransferStatus() {
    }

    public PekaoTransferStatus(Long tranId, 
                               Long internalTranId, 
                               String messageId, 
                               Long createDateTime, 
                               String origMessageId) {
        this.tranId = tranId;
        this.internalTranId = internalTranId;
        this.messageId = messageId;
        this.createDateTime = createDateTime;
        this.origMessageId = origMessageId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setOrigMessageId(String origMessageId) {
        this.origMessageId = origMessageId;
    }

    public String getOrigMessageId() {
        return origMessageId;
    }

    public void setRMessageId(String rMessageId) {
        this.rMessageId = rMessageId;
    }

    public String getRMessageId() {
        return rMessageId;
    }

    public void setRCreatedDateTime(Long rCreatedDateTime) {
        this.rCreatedDateTime = rCreatedDateTime;
    }

    public Long getRCreatedDateTime() {
        return rCreatedDateTime;
    }

    public void setOrigPaymentId(String origPaymentId) {
        this.origPaymentId = origPaymentId;
    }

    public String getOrigPaymentId() {
        return origPaymentId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setExecDate(Long execDate) {
        this.execDate = execDate;
    }

    public Long getExecDate() {
        return execDate;
    }

    public void setInternalTranId(Long internalTranId) {
        this.internalTranId = internalTranId;
    }

    public Long getInternalTranId() {
        return internalTranId;
    }
    
}
