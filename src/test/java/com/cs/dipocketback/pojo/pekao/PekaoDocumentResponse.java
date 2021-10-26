package com.cs.dipocketback.pojo.pekao;

public class PekaoDocumentResponse {

    protected String rptNm;
    protected byte[] rptFile;

    public PekaoDocumentResponse() {
    }

    public PekaoDocumentResponse(String rptNm, byte[] rptFile) {
        this.rptNm = rptNm;
        this.rptFile = rptFile;
    }

    public String getRptNm() {
        return rptNm;
    }

    public void setRptNm(String rptNm) {
        this.rptNm = rptNm;
    }

    public byte[] getRptFile() {
        return rptFile;
    }

    public void setRptFile(byte[] rptFile) {
        this.rptFile = rptFile;
    }

}
