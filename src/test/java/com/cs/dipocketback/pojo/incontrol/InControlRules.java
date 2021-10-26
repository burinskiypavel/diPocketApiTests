package com.cs.dipocketback.pojo.incontrol;

import java.util.List;

public class InControlRules {

    private Long cpnId;
    private boolean blockCard = false;
    
    private boolean blockAtm = false;
    private boolean blockEcom = false;
    private boolean blockMoto = false;
    private boolean blockPayPass = false;
    private boolean blockPos = false;
    private boolean blockPwcb = false;
    
    private Limit cashDailyLimit;
    private Limit purchaseDailyLimit;
    
    private List<String> listIdPermittedCountries;
    private List<String> listTransactionTypesInPermittedCountries;
    private List<String> listIdRestrictedCategories;
    
    public InControlRules() {
    }

    public void setCpnId(Long cpnId) {
        this.cpnId = cpnId;
    }

    public Long getCpnId() {
        return cpnId;
    }

    public void setBlockCard(boolean blockCard) {
        this.blockCard = blockCard;
    }

    public boolean isBlockCard() {
        return blockCard;
    }

    public void setBlockAtm(boolean blockAtm) {
        this.blockAtm = blockAtm;
    }

    public boolean isBlockAtm() {
        return blockAtm;
    }

    public void setBlockEcom(boolean blockEcom) {
        this.blockEcom = blockEcom;
    }

    public boolean isBlockEcom() {
        return blockEcom;
    }

    public void setBlockMoto(boolean blockMoto) {
        this.blockMoto = blockMoto;
    }

    public boolean isBlockMoto() {
        return blockMoto;
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

    public void setBlockPwcb(boolean blockPwcb) {
        this.blockPwcb = blockPwcb;
    }

    public boolean isBlockPwcb() {
        return blockPwcb;
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

    public void setListIdPermittedCountries(List<String> listIdPermittedCountries) {
        this.listIdPermittedCountries = listIdPermittedCountries;
    }

    public List<String> getListIdPermittedCountries() {
        return listIdPermittedCountries;
    }

    public void setListTransactionTypesInPermittedCountries(List<String> listTransactionTypesInPermittedCountries) {
        this.listTransactionTypesInPermittedCountries = listTransactionTypesInPermittedCountries;
    }

    public List<String> getListTransactionTypesInPermittedCountries() {
        return listTransactionTypesInPermittedCountries;
    }

    public void setListIdRestrictedCategories(List<String> listIdRestrictedCategories) {
        this.listIdRestrictedCategories = listIdRestrictedCategories;
    }

    public List<String> getListIdRestrictedCategories() {
        return listIdRestrictedCategories;
    }
}
