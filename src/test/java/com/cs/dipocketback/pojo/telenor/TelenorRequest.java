package com.cs.dipocketback.pojo.telenor;

public class TelenorRequest {
    
    private String publicToken;
    private String dipToken;
    private String phoneNumber;
    private Long accountId;
    
    private Long amount;
    private Integer ccyId;
    private String ccy;
    
    private Long availableBalance;
    private String secQuestion;
    
    public TelenorRequest() {
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setDipToken(String dipToken) {
        this.dipToken = dipToken;
    }

    public String getDipToken() {
        return dipToken;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    public String getSecQuestion() {
        return secQuestion;
    }
}
