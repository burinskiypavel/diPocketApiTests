package com.cs.dipocketback.pojo.card;

public class CardFee {
    
    private Integer orderingFeeCurrencyId;
    private String orderingFeeCurrencySymbol;
    private Long orderingFeeAmount;
    private Boolean orderingFeeEnoughFunds;
    private Integer monthlyFeeCurrencyId;
    private String monthlyFeeCurrencySymbol;
    private Long monthlyFeeAmount;
    
    public CardFee() {
    }
    
    public CardFee(Integer orderingFeeCurrencyId, Long orderingFeeAmount,
                   Boolean orderingFeeEnoughFunds, Integer monthlyFeeCurrencyId,
                   Long monthlyFeeAmount) {
        this.orderingFeeCurrencyId = orderingFeeCurrencyId;
        this.orderingFeeAmount = orderingFeeAmount;
        this.orderingFeeEnoughFunds = orderingFeeEnoughFunds;
        this.monthlyFeeCurrencyId = monthlyFeeCurrencyId;
        this.monthlyFeeAmount = monthlyFeeAmount;
    }

    public CardFee(Integer orderingFeeCurrencyId, String orderingFeeCurrencySymbol, Long orderingFeeAmount,
                   Boolean orderingFeeEnoughFunds, Integer monthlyFeeCurrencyId, String monthlyFeeCurrencySymbol,
                   Long monthlyFeeAmount) {
        this.orderingFeeCurrencyId = orderingFeeCurrencyId;
        this.orderingFeeCurrencySymbol = orderingFeeCurrencySymbol;
        this.orderingFeeAmount = orderingFeeAmount;
        this.orderingFeeEnoughFunds = orderingFeeEnoughFunds;
        this.monthlyFeeCurrencyId = monthlyFeeCurrencyId;
        this.monthlyFeeCurrencySymbol = monthlyFeeCurrencySymbol;
        this.monthlyFeeAmount = monthlyFeeAmount;
    }

    public void setOrderingFeeCurrencyId(Integer orderingFeeCurrencyId) {
        this.orderingFeeCurrencyId = orderingFeeCurrencyId;
    }

    public Integer getOrderingFeeCurrencyId() {
        return orderingFeeCurrencyId;
    }

    public void setOrderingFeeCurrencySymbol(String orderingFeeCurrencySymbol) {
        this.orderingFeeCurrencySymbol = orderingFeeCurrencySymbol;
    }

    public String getOrderingFeeCurrencySymbol() {
        return orderingFeeCurrencySymbol;
    }

    public void setOrderingFeeAmount(Long orderingFeeAmount) {
        this.orderingFeeAmount = orderingFeeAmount;
    }

    public Long getOrderingFeeAmount() {
        return orderingFeeAmount;
    }

    public void setOrderingFeeEnoughFunds(Boolean orderingFeeEnoughFunds) {
        this.orderingFeeEnoughFunds = orderingFeeEnoughFunds;
    }

    public Boolean getOrderingFeeEnoughFunds() {
        return orderingFeeEnoughFunds;
    }

    public void setMonthlyFeeCurrencyId(Integer monthlyFeeCurrencyId) {
        this.monthlyFeeCurrencyId = monthlyFeeCurrencyId;
    }

    public Integer getMonthlyFeeCurrencyId() {
        return monthlyFeeCurrencyId;
    }

    public void setMonthlyFeeCurrencySymbol(String monthlyFeeCurrencySymbol) {
        this.monthlyFeeCurrencySymbol = monthlyFeeCurrencySymbol;
    }

    public String getMonthlyFeeCurrencySymbol() {
        return monthlyFeeCurrencySymbol;
    }

    public void setMonthlyFeeAmount(Long monthlyFeeAmount) {
        this.monthlyFeeAmount = monthlyFeeAmount;
    }

    public Long getMonthlyFeeAmount() {
        return monthlyFeeAmount;
    }

}
