package com.cs.dipocketback.pojo.report.jasper;

import com.cs.dipocketback.pojo.report.FileExtension;

public class JasperReport {

    private FileExtension ext;
    private String subDir;
    private String template;
    private String reportDir;

    public FileExtension getExt() {
        return ext;
    }

    public void setExt(FileExtension ext) {
        this.ext = ext;
    }

    public String getSubDir() {
        return subDir;
    }

    public void setSubDir(String subDir) {
        this.subDir = subDir;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getReportDir() {
        return reportDir;
    }

    public void setReportDir(String reportDir) {
        this.reportDir = reportDir;
    }

}
