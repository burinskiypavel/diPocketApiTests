package com.cs.dipocketback.pojo.pos;

import java.util.List;

public class DoCashLoadResponse {

    private List<CheckPrintCashLoad> checkList;

    public DoCashLoadResponse() {
    }

    public DoCashLoadResponse(List<CheckPrintCashLoad> checkList) {
        this.checkList = checkList;
    }

    public List<CheckPrintCashLoad> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<CheckPrintCashLoad> checkList) {
        this.checkList = checkList;
    }
}
