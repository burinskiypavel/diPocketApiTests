package com.cs.dipocketback.pojo.neosurf;

import java.util.List;

public class NeosurfTranInitList {
    
    private List<NeosurfTranInit> tranList;
    
    public NeosurfTranInitList() {
    }

    public NeosurfTranInitList(List<NeosurfTranInit> tranList) {
        this.tranList = tranList;
    }

    public void setTranList(List<NeosurfTranInit> tranList) {
        this.tranList = tranList;
    }

    public List<NeosurfTranInit> getTranList() {
        return tranList;
    }
}
