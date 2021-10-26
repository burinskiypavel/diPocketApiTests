package com.cs.dipocketback.pojo.limit.incontrol;

import java.util.List;

public class TestIncMccContainer {
    
    private List<Integer> listMccId;

    public TestIncMccContainer() {
    }

    public TestIncMccContainer(List<Integer> listMccId) {
        this.listMccId = listMccId;
    }

    public void setListMccId(List<Integer> listMccId) {
        this.listMccId = listMccId;
    }

    public List<Integer> getListMccId() {
        return listMccId;
    }
}
