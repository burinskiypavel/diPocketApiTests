package com.cs.dipocketback.pojo.dashboard;

import java.util.Arrays;
import java.util.List;

public class CustomerStatementRequestList {
    
    private static final CustomerStatementRequestList stub = new CustomerStatementRequestList(Arrays.asList(new CustomerStatementRequest[]
      {
        new CustomerStatementRequest("1", "2015", null), new CustomerStatementRequest("2", "2015", null),
        new CustomerStatementRequest("3", "2015", null), new CustomerStatementRequest("4", "2015", null),
        new CustomerStatementRequest("5", "2015", null), new CustomerStatementRequest("6", "2015", null),
        new CustomerStatementRequest("7", "2015", null), new CustomerStatementRequest("8", "2015", null),
        new CustomerStatementRequest("9", "2015", null), new CustomerStatementRequest("10", "2015", null),
        new CustomerStatementRequest("11", "2015", null), new CustomerStatementRequest("12", "2015", null)
      }),null);

    private List<CustomerStatementRequest> statementRequestList;

    private Integer reportTypeId;
    private Long clientId;
    private String email;

    public CustomerStatementRequestList(List<CustomerStatementRequest> statementRequestList, Integer reportTypeId) {
        this.statementRequestList = statementRequestList;
        this.reportTypeId = reportTypeId;
    }

    public void setStatementRequestList(List<CustomerStatementRequest> statementRequestList) {
        this.statementRequestList = statementRequestList;
    }

    public List<CustomerStatementRequest> getStatementRequestList() {
        return statementRequestList;
    }

    public void setReportTypeId(Integer reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    public Integer getReportTypeId() {
        return reportTypeId;
    }

    public CustomerStatementRequestList() {
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static CustomerStatementRequestList getStub() {
        return stub;
    }
    
}
