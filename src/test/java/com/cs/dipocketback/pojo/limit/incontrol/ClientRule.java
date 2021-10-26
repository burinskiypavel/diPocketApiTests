package com.cs.dipocketback.pojo.limit.incontrol;

import com.cs.dipocketback.pojo.incontrol.Limit;
import com.cs.dipocketback.pojo.references.Country;

import java.util.List;

public class ClientRule {
    
    private Long accountId;
    private Long cardId;
    private Long cpnId;
    private boolean blockCard = false;
    
    private boolean blockCash = false;
   
    private boolean blockOnline = false;
    private boolean blockPayPass = false;
    private boolean blockPos = false;
    
    private Limit cashDailyLimit;
    private Limit purchaseDailyLimit;
    
    private boolean listPermittedCountriesEditable;
    private List<Country> listPermittedCountries;
    private List<IncDiPocketMccCategory> listRestrictedCategories;

    public ClientRule() {
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setCpnId(Long cpnId) {
        this.cpnId = cpnId;
    }

    public Long getCpnId() {
        return cpnId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setBlockCard(boolean blockCard) {
        this.blockCard = blockCard;
    }

    public boolean isBlockCard() {
        return blockCard;
    }

    public void setBlockCash(boolean blockCash) {
        this.blockCash = blockCash;
    }

    public boolean isBlockCash() {
        return blockCash;
    }

    public void setBlockOnline(boolean blockOnline) {
        this.blockOnline = blockOnline;
    }

    public boolean isBlockOnline() {
        return blockOnline;
    }

    public void setBlockPayPass(boolean blockPayPass) {
        this.blockPayPass = blockPayPass;
    }

    public boolean isBlockPayPass() {
        return blockPayPass;
    }

    public void setBlockPos(boolean blockPos) {
        this.blockPos = blockPos;
    }

    public boolean isBlockPos() {
        return blockPos;
    }

    public void setCashDailyLimit(Limit cashDailyLimit) {
        this.cashDailyLimit = cashDailyLimit;
    }

    public Limit getCashDailyLimit() {
        return cashDailyLimit;
    }

    public void setPurchaseDailyLimit(Limit purchaseDailyLimit) {
        this.purchaseDailyLimit = purchaseDailyLimit;
    }

    public Limit getPurchaseDailyLimit() {
        return purchaseDailyLimit;
    }

    public void setListPermittedCountriesEditable(boolean listPermittedCountriesEditable) {
        this.listPermittedCountriesEditable = listPermittedCountriesEditable;
    }

    public boolean isListPermittedCountriesEditable() {
        return listPermittedCountriesEditable;
    }

    public void setListPermittedCountries(List<Country> listPermittedCountries) {
        this.listPermittedCountries = listPermittedCountries;
    }

    public List<Country> getListPermittedCountries() {
        return listPermittedCountries;
    }

    public void setListRestrictedCategories(List<IncDiPocketMccCategory> listRestrictedCategories) {
        this.listRestrictedCategories = listRestrictedCategories;
    }

    public List<IncDiPocketMccCategory> getListRestrictedCategories() {
        return listRestrictedCategories;
    }

}
