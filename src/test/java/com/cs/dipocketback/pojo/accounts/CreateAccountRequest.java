package com.cs.dipocketback.pojo.accounts;


public class CreateAccountRequest {
    
    private Long id;
    private Integer currencyId;
    private String accountName;
    private Boolean openVirtualCard;
    private Boolean openPlasticCard;
    private Boolean noNamePlasticCard;
    private String cardHolderName;
    private Long attachedCardId;
    
    public CreateAccountRequest(Long id, 
                                Integer currencyId, 
                                String accountName, 
                                Boolean openVirtualCard,
                                Boolean openPlasticCard, 
                                String cardHolderName) {
        this.id = id;
        this.currencyId = currencyId;
        this.accountName = accountName;
        this.openVirtualCard = openVirtualCard;
        this.openPlasticCard = openPlasticCard;
        this.cardHolderName = cardHolderName;
    }

    public CreateAccountRequest(Long id, 
                                Integer currencyId, 
                                String accountName, 
                                Boolean openVirtualCard,
                                Boolean openPlasticCard, 
                                Boolean noNamePlasticCard, 
                                String cardHolderName,
                                Long attachedCardId) {
        this.id = id;
        this.currencyId = currencyId;
        this.accountName = accountName;
        this.openVirtualCard = openVirtualCard;
        this.openPlasticCard = openPlasticCard;
        this.noNamePlasticCard = noNamePlasticCard;
        this.cardHolderName = cardHolderName;
        this.attachedCardId = attachedCardId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setOpenVirtualCard(Boolean openVirtualCard) {
        this.openVirtualCard = openVirtualCard;
    }

    public Boolean getOpenVirtualCard() {
        return openVirtualCard;
    }

    public void setOpenPlasticCard(Boolean openPlasticCard) {
        this.openPlasticCard = openPlasticCard;
    }

    public Boolean getOpenPlasticCard() {
        return openPlasticCard;
    }

    public CreateAccountRequest() {
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setNoNamePlasticCard(Boolean noNamePlasticCard) {
        this.noNamePlasticCard = noNamePlasticCard;
    }

    public Boolean getNoNamePlasticCard() {
        return noNamePlasticCard;
    }

    public void setAttachedCardId(Long attachedCardId) {
        this.attachedCardId = attachedCardId;
    }

    public Long getAttachedCardId() {
        return attachedCardId;
    }

}
