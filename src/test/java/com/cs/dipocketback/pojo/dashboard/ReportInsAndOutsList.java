package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class ReportInsAndOutsList {
    private List<ReportInsAndOuts> reportInsAndOutsList;

    public void setReportInsAndOutsList(List<ReportInsAndOuts> reportInsAndOutsList) {
        this.reportInsAndOutsList = reportInsAndOutsList;
    }

    public List<ReportInsAndOuts> getReportInsAndOutsList() {
        return reportInsAndOutsList;
    }

    public ReportInsAndOutsList() {
    }

    public ReportInsAndOutsList(List<ReportInsAndOuts> reportInsAndOutsList) {
        this();
        this.reportInsAndOutsList = reportInsAndOutsList;
    }
}
