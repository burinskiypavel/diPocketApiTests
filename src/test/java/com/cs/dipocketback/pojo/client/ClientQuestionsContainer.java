package com.cs.dipocketback.pojo.client;

import java.util.List;

public class ClientQuestionsContainer {
    
    private List<CheckboxContainer> clientQuestions;
    
    public ClientQuestionsContainer() {
    }

    public ClientQuestionsContainer(List<CheckboxContainer> clientQuestions) {
        this.clientQuestions = clientQuestions;
    }

    public void setClientQuestions(List<CheckboxContainer> clientQuestions) {
        this.clientQuestions = clientQuestions;
    }

    public List<CheckboxContainer> getClientQuestions() {
        return clientQuestions;
    }
    
}
