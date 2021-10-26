package com.cs.dipocketback.pojo.pekao;

import java.util.Date;

public class PekaoDocumentDetails {

    private String rptNm;
    private Date creDt;
    private String rptType;
    private String rptKind;
    protected String rptSize;
    protected String rptId;

    public PekaoDocumentDetails() {
    }

    public PekaoDocumentDetails(String rptNm, Date creDt, String rptType, String rptKind, String rptSize, String rptId) {
        this.rptNm = rptNm;
        this.creDt = creDt;
        this.rptType = rptType;
        this.rptKind = rptKind;
        this.rptSize = rptSize;
        this.rptId = rptId;
    }

    public String getRptNm() {
        return rptNm;
    }

    public void setRptNm(String rptNm) {
        this.rptNm = rptNm;
    }

    public Date getCreDt() {
        return creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    public String getRptType() {
        return rptType;
    }

    public void setRptType(String rptType) {
        this.rptType = rptType;
    }

    public String getRptKind() {
        return rptKind;
    }

    public void setRptKind(String rptKind) {
        this.rptKind = rptKind;
    }

    public String getRptSize() {
        return rptSize;
    }

    public void setRptSize(String rptSize) {
        this.rptSize = rptSize;
    }

    public String getRptId() {
        return rptId;
    }

    public void setRptId(String rptId) {
        this.rptId = rptId;
    }

}
