package com.cs.dipocketback.pojo.dashboard;

import java.util.Date;

public class ReportInsAndOuts {
    
    private Long rowNum;
    private Long monthDate;
    private Long creditAmount;
    private Long debitAmount;
    private String ccySymbol;
    private String dateISO;

    public ReportInsAndOuts() {
    }
    
    public ReportInsAndOuts(Long rowNum, 
                            Long monthDate, 
                            String dateISO, 
                            Long creditAmount, 
                            Long debitAmount) {
        this.rowNum = rowNum;
        this.monthDate = monthDate;
        this.creditAmount = creditAmount;
        this.debitAmount = debitAmount;
        this.dateISO = dateISO;
    }

    public ReportInsAndOuts(Long rowNum, 
                            Date monthDate, 
                            String dateISO, 
                            Long creditAmount, 
                            Long debitAmount) {
        this(rowNum, monthDate.getTime(), dateISO, creditAmount, debitAmount);
    }

    public ReportInsAndOuts(Long rowNum, 
                            Long monthDate, 
                            String dateISO, 
                            Long creditAmount,
                            Long debitAmount, 
                            String ccySymbol) {
        this(rowNum, monthDate, dateISO, creditAmount, debitAmount);
        this.ccySymbol = ccySymbol;
    }
    
    public ReportInsAndOuts(Long rowNum, 
                            Date monthDate, 
                            String dateISO, 
                            Long creditAmount, 
                            Long debitAmount, 
                            String ccySymbol) {
        this(rowNum, monthDate.getTime(), dateISO, creditAmount, debitAmount, ccySymbol);
    }

    public void setRowNum(Long rowNum) {
        this.rowNum = rowNum;
    }

    public Long getRowNum() {
        return rowNum;
    }

    public void setMonthDate(Long monthDate) {
        this.monthDate = monthDate;
    }

    public Long getMonthDate() {
        return monthDate;
    }

    public void setCreditAmount(Long creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Long getCreditAmount() {
        return creditAmount;
    }

    public void setDebitAmount(Long debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Long getDebitAmount() {
        return debitAmount;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setDateISO(String date) {
        this.dateISO = date;
    }

    public String getDateISO() {
        return dateISO;
    }

}
