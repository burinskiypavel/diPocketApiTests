package com.cs.dipocketback.pojo.pos;

import java.util.List;

public class ShiftClosedResponse {

    private List<CheckPrintData> printDataList;

    public ShiftClosedResponse() {
    }

    public ShiftClosedResponse(List<CheckPrintData> printDataList) {
        this.printDataList = printDataList;
    }

    public List<CheckPrintData> getPrintDataList() {
        return printDataList;
    }

    public void setPrintDataList(List<CheckPrintData> printDataList) {
        this.printDataList = printDataList;
    }
}
