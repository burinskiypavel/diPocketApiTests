package com.cs.dipocketback.pojo.sms;


public class SMSInfo {
    
    private Integer codeNo;
    private String message;
    private String code;

    public void setCodeNo(Integer codeNo) {
        this.codeNo = codeNo;
    }

    public Integer getCodeNo() {
        return codeNo;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return message != null ? message.split(" ", 3)[2] : null;
    }

    public SMSInfo() {
    }

    public SMSInfo(Integer codeNo, String message) {
        this.codeNo = codeNo;
        this.message = message;
    }
}
