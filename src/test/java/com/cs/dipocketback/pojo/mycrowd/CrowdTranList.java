package com.cs.dipocketback.pojo.mycrowd;

import java.util.List;

public class CrowdTranList {
    
    private List<CrowdTran> tranList;
    
    public CrowdTranList() {
    }

    public CrowdTranList(List<CrowdTran> tranList) {
        this.tranList = tranList;
    }

    public void setTranList(List<CrowdTran> tranList) {
        this.tranList = tranList;
    }

    public List<CrowdTran> getTranList() {
        return tranList;
    }
}
