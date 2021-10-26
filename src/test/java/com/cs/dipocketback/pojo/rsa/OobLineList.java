package com.cs.dipocketback.pojo.rsa;

import java.util.List;

public class OobLineList {
    
    private List<OobLine> lineList;
    
    public OobLineList() {
    }

    public OobLineList(List<OobLine> oobList) {
        this.lineList = oobList;
    }

    public void setLineList(List<OobLine> oobList) {
        this.lineList = oobList;
    }

    public List<OobLine> getLineList() {
        return lineList;
    }
}
