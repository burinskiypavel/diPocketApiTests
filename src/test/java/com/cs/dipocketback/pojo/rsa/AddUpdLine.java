package com.cs.dipocketback.pojo.rsa;

public class AddUpdLine {
    
    private Long fileId;
    private Long lineNo;
    private String action;
    private String publicToken;
    
    public AddUpdLine() {
    }

    public AddUpdLine(Long fileId, 
                      Long lineNo, 
                      String action, 
                      String publicToken) {
        this.fileId = fileId;
        this.lineNo = lineNo;
        this.action = action;
        this.publicToken = publicToken;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }
    
}
