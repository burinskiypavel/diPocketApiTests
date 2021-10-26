package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class ChartsList {
    
    private List<ReportSpendChannel> reportSpendChannelList;
    private List<ReportSpendType> reportSpendTypeList;
    private List<ReportInsAndOuts> reportInsAndOutsList;
    
    public ChartsList() {
    }

    public ChartsList(List<ReportSpendChannel> reportSpendChannelList, List<ReportSpendType> reportSpendTypeList,
                      List<ReportInsAndOuts> reportInsAndOutsList) {
        this.reportSpendChannelList = reportSpendChannelList;
        this.reportSpendTypeList = reportSpendTypeList;
        this.reportInsAndOutsList = reportInsAndOutsList;
    }

    public void setReportSpendChannelList(List<ReportSpendChannel> reportSpendChannelList) {
        this.reportSpendChannelList = reportSpendChannelList;
    }

    public List<ReportSpendChannel> getReportSpendChannelList() {
        return reportSpendChannelList;
    }

    public void setReportSpendTypeList(List<ReportSpendType> reportSpendTypeList) {
        this.reportSpendTypeList = reportSpendTypeList;
    }

    public List<ReportSpendType> getReportSpendTypeList() {
        return reportSpendTypeList;
    }

    public void setReportInsAndOutsList(List<ReportInsAndOuts> reportInsAndOutsList) {
        this.reportInsAndOutsList = reportInsAndOutsList;
    }

    public List<ReportInsAndOuts> getReportInsAndOutsList() {
        return reportInsAndOutsList;
    }
}
