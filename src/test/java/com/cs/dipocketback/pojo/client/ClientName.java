package com.cs.dipocketback.pojo.client;

public class ClientName {
    
    private String firstName;
    private String lastName;
    
    public ClientName() {
    }

    public ClientName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
