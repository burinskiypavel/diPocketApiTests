package com.cs.dipocketback.pojo.telenor;

//import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TelenorSmsRequest {

    private final String clientId;
    private final String password;
    private List<String> destinationAddresses;
    private String message;
    private Date date = new Date();

    public TelenorSmsRequest(String clientId, String password) {
        this.clientId = clientId;
        this.password = password;
    }

    public TelenorSmsRequest(String clientId, String password, String phone, String message) {
        this.clientId = clientId;
        this.password = password;
        this.destinationAddresses = Arrays.asList(phone);
        this.message = message;
    }

    public TelenorSmsRequest(String clientId, String password, List<String> destinationAddresses, String message) {
        this.clientId = clientId;
        this.password = password;
        this.destinationAddresses = destinationAddresses;
        this.message = message;
    }

    //@JsonProperty("clientID")
    public String getClientId() {
        return clientId;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(String phone) {
        this.destinationAddresses = Arrays.asList(phone);
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TelenorSmsRequest{\n" +
                "clientId='" + clientId + '\'' +
                ",\npassword='" + password + '\'' +
                ",\ndestinationAddresses=" + destinationAddresses +
                ",\nmessage='" + message + '\'' +
                ",\ndate=" + date +
                "\n}";
    }

}
