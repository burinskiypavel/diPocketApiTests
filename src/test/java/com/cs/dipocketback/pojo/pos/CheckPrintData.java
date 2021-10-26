package com.cs.dipocketback.pojo.pos;

public class CheckPrintData {

    private String eventType;
    private Long shiftId;
    private String posSn;
    private Long cashierId;
    private String cashierFirstName;
    private String cashierLastName;
    private String dateTime;
    private Long avlBalance;
    private String currencyCode;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public String getPosSn() {
        return posSn;
    }

    public void setPosSn(String posSn) {
        this.posSn = posSn;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierFirstName() {
        return cashierFirstName;
    }

    public void setCashierFirstName(String cashierFirstName) {
        this.cashierFirstName = cashierFirstName;
    }

    public String getCashierLastName() {
        return cashierLastName;
    }

    public void setCashierLastName(String cashierLastName) {
        this.cashierLastName = cashierLastName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Long getAvlBalance() {
        return avlBalance;
    }

    public void setAvlBalance(Long avlBalance) {
        this.avlBalance = avlBalance;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
