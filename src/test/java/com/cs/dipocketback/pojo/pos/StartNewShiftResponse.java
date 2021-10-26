package com.cs.dipocketback.pojo.pos;

import java.util.List;

public class StartNewShiftResponse {

    private List<CheckPrintData> printDataList;

    public StartNewShiftResponse() {
    }

    public StartNewShiftResponse(List<CheckPrintData> printDataList) {
        this.printDataList = printDataList;
    }

    public List<CheckPrintData> getPrintDataList() {
        return printDataList;
    }

    public void setPrintDataList(List<CheckPrintData> printDataList) {
        this.printDataList = printDataList;
    }
}
