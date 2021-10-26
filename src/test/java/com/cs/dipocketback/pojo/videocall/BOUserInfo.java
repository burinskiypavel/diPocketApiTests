package com.cs.dipocketback.pojo.videocall;

public class BOUserInfo {
    
    private String userFirstName;
    private String userPhoto;
    
    public BOUserInfo() {
    }

    public BOUserInfo(String name, String image) {
        this.userFirstName = name;
        this.userPhoto = image;
    }

    public void setUserFirstName(String name) {
        this.userFirstName = name;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserPhoto(String image) {
        this.userPhoto = image;
    }

    public String getUserPhoto() {
        return userPhoto;
    }
}
