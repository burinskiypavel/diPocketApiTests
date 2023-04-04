package model.clientServices;

public class UserRegistrationSendSMSCodeForPhoneRequest {
    private int smsNumber;

    public int getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(int smsNumber) {
        this.smsNumber = smsNumber;
    }
}