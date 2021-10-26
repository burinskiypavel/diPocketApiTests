package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class ReportSpendChannelList {

    private List<ReportSpendChannel> reportSpendChannelList;

    public void setReportSpendChannelList(List<ReportSpendChannel> reportSpendChannelList) {
        this.reportSpendChannelList = reportSpendChannelList;
    }

    public List<ReportSpendChannel> getReportSpendChannelList() {
        return reportSpendChannelList;
    }

    public ReportSpendChannelList() {
    }

    public ReportSpendChannelList(List<ReportSpendChannel> reportSpendChannelList) {
        this.reportSpendChannelList = reportSpendChannelList;
    }

}
