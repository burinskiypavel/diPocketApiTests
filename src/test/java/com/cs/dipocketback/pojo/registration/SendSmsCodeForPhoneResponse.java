package com.cs.dipocketback.pojo.registration;

public class SendSmsCodeForPhoneResponse {
    
    private Integer smsNumber;
    
    public SendSmsCodeForPhoneResponse() {
    }

    public SendSmsCodeForPhoneResponse(Integer smsNumber) {
        this.smsNumber = smsNumber;
    }

    public void setSmsNumber(Integer smsNumber) {
        this.smsNumber = smsNumber;
    }

    public Integer getSmsNumber() {
        return smsNumber;
    }

}
