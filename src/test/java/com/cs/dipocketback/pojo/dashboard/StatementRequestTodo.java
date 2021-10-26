package com.cs.dipocketback.pojo.dashboard;

import java.sql.Timestamp;

public class StatementRequestTodo {
    
    private Long id;
    private Long clientId;
    private Timestamp reportDate;
    private Integer format;
    
    public StatementRequestTodo() {
    }

    public StatementRequestTodo(Long id,
                                Long clientId,
                                Timestamp reportDate,
                                Integer format) {
        this.id = id;
        this.clientId = clientId;
        this.reportDate = reportDate;
        this.format = format;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setReportDate(Timestamp reportDate) {
        this.reportDate = reportDate;
    }

    public Timestamp getReportDate() {
        return reportDate;
    }

    public void setFormat(Integer format) {
        this.format = format;
    }

    public Integer getFormat() {
        return format;
    }
    
}
