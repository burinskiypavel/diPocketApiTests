package com.cs.dipocketback.pojo.rsa;

public class RsaFile {
    
    private Long id;
    private String issuerCode;
    private Long fileDate;
    private Long seqNum;
    private String timeZone;
    private Long recordCount;
    private String fiId;
    private String fileName;
    
    public RsaFile() {
    }

    public RsaFile(Long id, 
                   String issuerCode, 
                   Long fileDate, 
                   Long seqNum, 
                   String timeZone, 
                   Long recordCount, 
                   String fiId,
                   String fileName) {
        this.id = id;
        this.issuerCode = issuerCode;
        this.fileDate = fileDate;
        this.seqNum = seqNum;
        this.timeZone = timeZone;
        this.recordCount = recordCount;
        this.fiId = fiId;
        this.fileName = fileName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    public String getIssuerCode() {
        return issuerCode;
    }

    public void setFileDate(Long fileDate) {
        this.fileDate = fileDate;
    }

    public Long getFileDate() {
        return fileDate;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setFiId(String fiId) {
        this.fiId = fiId;
    }

    public String getFiId() {
        return fiId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return timeZone;
    }
    
}
