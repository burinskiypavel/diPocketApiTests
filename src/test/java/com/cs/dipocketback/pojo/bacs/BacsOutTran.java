package com.cs.dipocketback.pojo.bacs;

public class BacsOutTran {
    
    private Long fileId;
    private String sortCode;
    private String accountNo;
    private String accountName;
    private Long amount;
    private String description;
    
    public BacsOutTran() {
    }

    public BacsOutTran(Long fileId, 
                       String sortCode, 
                       String accountNo, 
                       String accountName, 
                       Long amount,
                       String description) {
        this.fileId = fileId;
        this.sortCode = sortCode;
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.amount = amount;
        this.description = description;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
}
