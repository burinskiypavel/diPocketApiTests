package com.cs.dipocketback.pojo.playit;

public class PlsAuthRequest {
    private String email;
    private String password;

    public PlsAuthRequest() {
    }

    public PlsAuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "PlsAuthRequest{" + 
               "email='" + email + '\'' + 
               ", password='" + password + '\'' + 
               '}';
    }
}
