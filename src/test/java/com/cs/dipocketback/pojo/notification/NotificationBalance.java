package com.cs.dipocketback.pojo.notification;



public class NotificationBalance {


    private Long requestId;

    private Integer attemptNo;

    private String eventTime;

    private Long sequenceId;

    private Long clientId;
    private Long detailsRef;
    private Long accountId;

    private String accCurrencyCode;

    private Long availableBalanceDelta;

    private Long availableBalance;

    private Long financeBalanceDelta;

    private Long financeBalance;

    public NotificationBalance() {
    }

    public NotificationBalance(Long requestId, Integer attemptNo, String eventTime, Long sequenceId, Long clientId,
                               Long detailsRef, Long accountId, String accCurrencyCode, Long availableBalanceDelta,
                               Long availableBalance, Long financeBalanceDelta, Long financeBalance) {
        this.requestId = requestId;
        this.attemptNo = attemptNo;
        this.eventTime = eventTime;
        this.sequenceId = sequenceId;
        this.clientId = clientId;
        this.detailsRef = detailsRef;
        this.accountId = accountId;
        this.accCurrencyCode = accCurrencyCode;
        this.availableBalanceDelta = availableBalanceDelta;
        this.availableBalance = availableBalance;
        this.financeBalanceDelta = financeBalanceDelta;
        this.financeBalance = financeBalance;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Integer getAttemptNo() {
        return attemptNo;
    }

    public void setAttemptNo(Integer attemptNo) {
        this.attemptNo = attemptNo;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getDetailsRef() {
        return detailsRef;
    }

    public void setDetailsRef(Long detailsRef) {
        this.detailsRef = detailsRef;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccCurrencyCode() {
        return accCurrencyCode;
    }

    public void setAccCurrencyCode(String accCurrencyCode) {
        this.accCurrencyCode = accCurrencyCode;
    }

    public Long getAvailableBalanceDelta() {
        return availableBalanceDelta;
    }

    public void setAvailableBalanceDelta(Long availableBalanceDelta) {
        this.availableBalanceDelta = availableBalanceDelta;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getFinanceBalanceDelta() {
        return financeBalanceDelta;
    }

    public void setFinanceBalanceDelta(Long financeBalanceDelta) {
        this.financeBalanceDelta = financeBalanceDelta;
    }

    public Long getFinanceBalance() {
        return financeBalance;
    }

    public void setFinanceBalance(Long financeBalance) {
        this.financeBalance = financeBalance;
    }

    @Override
    public String toString() {
        return "NotificationBalance{" +
                "requestId=" + requestId +
                ", attemptNo=" + attemptNo +
                ", eventTime='" + eventTime + '\'' +
                ", sequenceId=" + sequenceId +
                ", clientId=" + clientId +
                ", detailsRef=" + detailsRef +
                ", accountId=" + accountId +
                ", accCurrencyCode='" + accCurrencyCode + '\'' +
                ", availableBalanceDelta=" + availableBalanceDelta +
                ", availableBalance=" + availableBalance +
                ", financeBalanceDelta=" + financeBalanceDelta +
                ", financeBalance=" + financeBalance +
                '}';
    }
}
