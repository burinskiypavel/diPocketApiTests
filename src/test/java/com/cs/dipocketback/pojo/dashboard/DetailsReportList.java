package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class DetailsReportList {

    private List<DetailsReport> detailsReportList;

    public void setDetailsReportList(List<DetailsReport> detailsReportList) {
        this.detailsReportList = detailsReportList;
    }

    public List<DetailsReport> getDetailsReportList() {
        return detailsReportList;
    }

    public DetailsReportList() {
    }

    public DetailsReportList(List<DetailsReport> detailsReportList) {
        this.detailsReportList = detailsReportList;
    }

}
