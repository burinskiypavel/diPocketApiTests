package com.cs.dipocketback.pojo.client;

import java.util.List;

public class ClientAnswerListContainer {

    private List<CheckboxContainer> checkboxList;

    public ClientAnswerListContainer() {
    }

    public ClientAnswerListContainer(List<CheckboxContainer> checkboxList) {
        this.checkboxList = checkboxList;
    }

    public List<CheckboxContainer> getCheckboxList() {
        return checkboxList;
    }

    public void setCheckboxList(List<CheckboxContainer> checkboxList) {
        this.checkboxList = checkboxList;
    }

}
