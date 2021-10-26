package com.cs.dipocketback.pojo.client;

public class SendVerificationCodeResponse {
    
    private Integer smsNumber;
    
    public SendVerificationCodeResponse() {
    }

    public SendVerificationCodeResponse(Integer smsNumber) {
        this.smsNumber = smsNumber;
    }

    public void setSmsNumber(Integer smsNumber) {
        this.smsNumber = smsNumber;
    }

    public Integer getSmsNumber() {
        return smsNumber;
    }
    
}
