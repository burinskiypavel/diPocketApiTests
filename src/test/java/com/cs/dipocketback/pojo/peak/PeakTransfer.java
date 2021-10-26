package com.cs.dipocketback.pojo.peak;

public class PeakTransfer {
    
    private String requestId;
    private String publicTokenFrom;
    private String publicTokenTo;
    private Integer currencyId;
    private Long amount;
    private String note;
    
    public PeakTransfer() {
    }

    public PeakTransfer(String requestId, String publicTokenFrom, String publicTokenTo, Integer currencyId, Long amount,
                        String note) {
        this.requestId = requestId;
        this.publicTokenFrom = publicTokenFrom;
        this.publicTokenTo = publicTokenTo;
        this.currencyId = currencyId;
        this.amount = amount;
        this.note = note;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setPublicTokenFrom(String publicTokenFrom) {
        this.publicTokenFrom = publicTokenFrom;
    }

    public String getPublicTokenFrom() {
        return publicTokenFrom;
    }

    public void setPublicTokenTo(String publicTokenTo) {
        this.publicTokenTo = publicTokenTo;
    }

    public String getPublicTokenTo() {
        return publicTokenTo;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}
