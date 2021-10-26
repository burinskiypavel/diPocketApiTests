package com.cs.dipocketback.pojo.bacs;

import java.util.List;

public class BacsOutTranList {
    
    private List<BacsOutTran> tranList;
    
    public BacsOutTranList() {
    }

    public BacsOutTranList(List<BacsOutTran> tranList) {
        this.tranList = tranList;
    }

    public void setTranList(List<BacsOutTran> tranList) {
        this.tranList = tranList;
    }

    public List<BacsOutTran> getTranList() {
        return tranList;
    }
}
