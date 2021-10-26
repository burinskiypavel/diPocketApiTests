package com.cs.dipocketback.pojo.customer;

import com.cs.dipocketback.pojo.card.CardType;

public class CardCreateRequest {
    
    private String requestId;
    private Long clientId;
    private String program;
    private String currencyCode;
    private CardType cardType;
    private Long accountId;
    private Long accFeeTariffPlanId;
    private Long corpClientId;
    private String cardHolderName;

    public CardCreateRequest() {
    }

    public CardCreateRequest(String requestId, Long clientId, String program, String currencyCode, CardType cardType,
                             Long accountId, Long corpClientId) {
        this.requestId = requestId;
        this.clientId = clientId;
        this.program = program;
        this.currencyCode = currencyCode;
        this.cardType = cardType;
        this.accountId = accountId;
        this.corpClientId = corpClientId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getAccFeeTariffPlanId() {
        return accFeeTariffPlanId;
    }

    public void setAccFeeTariffPlanId(Long accFeeTariffPlanId) {
        this.accFeeTariffPlanId = accFeeTariffPlanId;
    }

    public Long getCorpClientId() {
        return corpClientId;
    }

    public void setCorpClientId(Long corpClientId) {
        this.corpClientId = corpClientId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
