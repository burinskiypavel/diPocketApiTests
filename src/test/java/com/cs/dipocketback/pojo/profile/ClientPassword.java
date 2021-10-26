package com.cs.dipocketback.pojo.profile;

public class ClientPassword {
    
    private String oldPassword;
    private String password;
    private String confirmedPassword;
    private String otp;
    
    public ClientPassword() {
    }

    public ClientPassword(String oldPassword, String password, String confirmedPassword) {
        this.oldPassword = oldPassword;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

}
