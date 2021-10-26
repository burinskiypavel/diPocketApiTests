package com.cs.dipocketback.pojo.client;

public class SecretAnswer {
    
    private Integer attemptsCount;
    private Integer attemptsLeft;
    
    public SecretAnswer() {
    }

    public SecretAnswer(Integer attemptsCount, Integer attemptsLeft) {
        this.attemptsCount = attemptsCount;
        this.attemptsLeft = attemptsLeft;
    }

    public void setAttemptsCount(Integer count) {
        this.attemptsCount = count;
    }

    public Integer getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsLeft(Integer leftCount) {
        this.attemptsLeft = leftCount;
    }

    public Integer getAttemptsLeft() {
        return attemptsLeft;
    }
}
