package com.cs.dipocketback.pojo.client;

//import com.cs.dipocketback.base.data.Site;

import com.cs.dipocketback.base.data.Site;

public class User {
    
    //unique
    private String userName;
    private String firstName;
    private String lastName;
    private Integer stateId;
    private String stateReason;
    private String roleId;
    private Long clientId;
    private String phone;
    private String siteString;
    private Site site;
    private String email;

    public User() {
    }

    public User(String userName, 
                String firstName, 
                String lastName, 
                Integer stateId, 
                String stateReason, 
                String roleId,
                Long clientId, 
                String phone, 
                String siteString, 
                Site site,
                String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateId = stateId;
        this.stateReason = stateReason;
        this.roleId = roleId;
        this.clientId = clientId;
        this.phone = phone;
        this.siteString = siteString;
        this.site = site;
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
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

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateReason(String stateReason) {
        this.stateReason = stateReason;
    }

    public String getStateReason() {
        return stateReason;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setSiteString(String siteString) {
        this.siteString = siteString;
    }

    public String getSiteString() {
        return siteString;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Site getSite() {
        return site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
