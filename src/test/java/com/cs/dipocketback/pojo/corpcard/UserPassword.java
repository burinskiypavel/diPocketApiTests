package com.cs.dipocketback.pojo.corpcard;

public class UserPassword {
    
    private String userName;
    private String currentPwd;
    private String newPwd1;
    private String newPwd2;
    
    public UserPassword() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setCurrentPwd(String currentPwd) {
        this.currentPwd = currentPwd;
    }

    public String getCurrentPwd() {
        return currentPwd;
    }

    public void setNewPwd1(String newPwd1) {
        this.newPwd1 = newPwd1;
    }

    public String getNewPwd1() {
        return newPwd1;
    }

    public void setNewPwd2(String newPwd2) {
        this.newPwd2 = newPwd2;
    }

    public String getNewPwd2() {
        return newPwd2;
    }
    
}
