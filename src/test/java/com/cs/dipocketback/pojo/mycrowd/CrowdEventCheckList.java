package com.cs.dipocketback.pojo.mycrowd;

import java.util.List;

public class CrowdEventCheckList {
    
    private List<CrowdEventCheck> checkList;
    
    public CrowdEventCheckList() {
    }

    public CrowdEventCheckList(List<CrowdEventCheck> checkList) {
        this.checkList = checkList;
    }

    public void setCheckList(List<CrowdEventCheck> checkList) {
        this.checkList = checkList;
    }

    public List<CrowdEventCheck> getCheckList() {
        return checkList;
    }
}
