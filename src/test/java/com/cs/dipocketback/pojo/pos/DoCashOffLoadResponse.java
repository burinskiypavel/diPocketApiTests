package com.cs.dipocketback.pojo.pos;

import java.util.List;

public class DoCashOffLoadResponse {

    private List<CheckPrintCashLoad> checkList;

    public DoCashOffLoadResponse() {
    }

    public DoCashOffLoadResponse(List<CheckPrintCashLoad> checkList) {
        this.checkList = checkList;
    }

    public List<CheckPrintCashLoad> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<CheckPrintCashLoad> checkList) {
        this.checkList = checkList;
    }
}
