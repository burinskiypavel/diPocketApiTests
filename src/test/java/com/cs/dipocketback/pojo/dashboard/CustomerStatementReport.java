package com.cs.dipocketback.pojo.dashboard;


public class CustomerStatementReport {
    private CustomerStatementRequest request;
    private String statementFileName;

    public void setRequest(CustomerStatementRequest request) {
        this.request = request;
    }

    public CustomerStatementRequest getRequest() {
        return request;
    }

    public void setStatementFileName(String statementFileName) {
        this.statementFileName = statementFileName;
    }

    public String getStatementFileName() {
        return statementFileName;
    }

    public CustomerStatementReport() {
    }

    public CustomerStatementReport(CustomerStatementRequest request, String statementFileName) {
        this.request = request;
        this.statementFileName = statementFileName;
    }
}
