package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class ReportSpendTypeList {
    
    private List<ReportSpendType> reportSpendTypeList;
    
    public ReportSpendTypeList() {
    }

    public ReportSpendTypeList(List<ReportSpendType> reportSpendTypeList) {
        this.reportSpendTypeList = reportSpendTypeList;
    }

    public void setReportSpendTypeList(List<ReportSpendType> reportSpendTypeList) {
        this.reportSpendTypeList = reportSpendTypeList;
    }

    public List<ReportSpendType> getReportSpendTypeList() {
        return reportSpendTypeList;
    }
    
}
