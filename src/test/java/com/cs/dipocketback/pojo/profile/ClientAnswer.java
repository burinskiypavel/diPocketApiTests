package com.cs.dipocketback.pojo.profile;

public class ClientAnswer {
    
    private String secQuestion;
    private String secAnswer;
    
    public ClientAnswer() {
    }

    public ClientAnswer(String secQuestion, String secAnswer) {
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

    public void setSecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }

    public String getSecAnswer() {
        return secAnswer;
    }
}
