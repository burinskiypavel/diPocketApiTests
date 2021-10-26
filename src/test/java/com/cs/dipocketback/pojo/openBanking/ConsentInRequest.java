package com.cs.dipocketback.pojo.openBanking;

public class ConsentInRequest {

    private Boolean recurringIndicator;
    private String validUntil; // 2017-09-05T17:58:37+0100
    private Long frequencyPerDay;
    private ConsentAccess access;
    private String availableAccounts;
    private String availableAccountsWithBalance;

    public ConsentInRequest() {
    }

    public ConsentInRequest(Boolean recurringIndicator, String validUntil, Long frequencyPerDay, ConsentAccess access,
                            String availableAccounts, String availableAccountsWithBalance ) {
        this.recurringIndicator = recurringIndicator;
        this.validUntil = validUntil;
        this.frequencyPerDay = frequencyPerDay;
        this.access = access;
        this.availableAccounts = availableAccounts;
        this.availableAccountsWithBalance = availableAccountsWithBalance;
    }

    public Boolean getRecurringIndicator() {
        return recurringIndicator;
    }

    public void setRecurringIndicator(Boolean recurringIndicator) {
        this.recurringIndicator = recurringIndicator;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Long getFrequencyPerDay() {
        return frequencyPerDay;
    }

    public void setFrequencyPerDay(Long frequencyPerDay) {
        this.frequencyPerDay = frequencyPerDay;
    }

    public ConsentAccess getAccess() {
        return access;
    }

    public void setAccess(ConsentAccess access) {
        this.access = access;
    }

    public String getAvailableAccounts() {
        return availableAccounts;
    }

    public void setAvailableAccounts(String availableAccounts) {
        this.availableAccounts = availableAccounts;
    }

    public String getAvailableAccountsWithBalance() {
        return availableAccountsWithBalance;
    }

    public void setAvailableAccountsWithBalance(String availableAccountsWithBalance) {
        this.availableAccountsWithBalance = availableAccountsWithBalance;
    }
}
