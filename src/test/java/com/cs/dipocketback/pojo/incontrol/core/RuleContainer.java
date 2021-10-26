package com.cs.dipocketback.pojo.incontrol.core;

import java.util.List;

/**
 *
 * @author Artur
 */
public class RuleContainer {

    private String cpnId;
    private String status;
    private boolean blockCard = false;
    private boolean usageOutsideCash = false;
    private boolean blockCash = false;
    private boolean blockPayPass = false;
    private boolean blockEcom = false;
    private boolean blockMoto = false;
    
    private long annualLimit = 2000_00;
    private long cashDailyLimit = 100_00;
    private long cashMonthlyLimit = 700_00;
    private long purcashDailyLimit = 200_00;
    private long purcashMonthlyLimit = 500_00;
    
    private String timeZone = "Europe/London";
    private Integer countryOfResidence;
    private List<Integer> listOutsideCountries;
    private List<Integer> listRestrictedCategories;
    
    private boolean setAgeingVelocityControl = false;
    private long ageingCumulativeLimit = 10_00;
    private int ageingAuthHoldDays = 2;
    private String ageingTimeZone = "Poland/Warsaw";

    public RuleContainer() {
    }

    public RuleContainer(String cpnId, 
            boolean blockCard, 
            boolean usageOutsideCash, 
            boolean blockCash, 
            boolean blockPayPass, 
            boolean blockEcom, 
            boolean blockMoto, 
            long annualLimit, 
            long cashDailyLimit,
            long cachMonthlyLimit, 
            long purcashDailyLimit,
            long purcashMonthlyLimit,
            int countryOfResidence,
            List<Integer> listOutsideCountries,
            boolean setAgeingVelocityControl,
            long ageingCumulativeLimit,
            int ageingAuthHoldDays,
            String ageingTimeZone) {
        this.cpnId = cpnId;
        this.blockCard = blockCard;
        this.usageOutsideCash = usageOutsideCash;
        this.blockCash = blockCash;
        this.blockPayPass = blockPayPass;
        this.blockEcom = blockEcom;
        this.blockMoto = blockMoto;
        this.annualLimit = annualLimit;
        this.cashDailyLimit = cashDailyLimit;
        this.cashMonthlyLimit = cachMonthlyLimit;
        this.purcashDailyLimit = purcashDailyLimit;
        this.countryOfResidence = countryOfResidence;
        this.purcashMonthlyLimit = purcashMonthlyLimit;
        this.listOutsideCountries = listOutsideCountries;
        this.setAgeingVelocityControl = setAgeingVelocityControl;
        this.ageingCumulativeLimit = ageingCumulativeLimit;
        this.ageingAuthHoldDays = ageingAuthHoldDays;
        this.ageingTimeZone = ageingTimeZone;
    }

    public String getCpnId() {
        return cpnId;
    }

    public void setCpnId(String cpnId) {
        this.cpnId = cpnId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean isBlockCard() {
        return blockCard;
    }

    public void setBlockCard(boolean blockCard) {
        this.blockCard = blockCard;
    }

    public boolean isUsageOutsideCash() {
        return usageOutsideCash;
    }

    public void setUsageOutsideCash(boolean usageOutsideCash) {
        this.usageOutsideCash = usageOutsideCash;
    }

    public boolean isBlockCash() {
        return blockCash;
    }

    public void setBlockCash(boolean blockCash) {
        this.blockCash = blockCash;
    }

    public boolean isBlockPayPass() {
        return blockPayPass;
    }

    public void setBlockPayPass(boolean blockPayPass) {
        this.blockPayPass = blockPayPass;
    }

    public boolean isBlockEcom() {
        return blockEcom;
    }

    public void setBlockEcom(boolean blockEcom) {
        this.blockEcom = blockEcom;
    }

    public boolean isBlockMoto() {
        return blockMoto;
    }

    public void setBlockMoto(boolean blockMoto) {
        this.blockMoto = blockMoto;
    }

    public long getAnnualLimit() {
        return annualLimit;
    }

    public void setAnnualLimit(long annualLimit) {
        this.annualLimit = annualLimit;
    }

    public long getCashDailyLimit() {
        return cashDailyLimit;
    }

    public void setCashDailyLimit(long cashDailyLimit) {
        this.cashDailyLimit = cashDailyLimit;
    }

    public long getCashMonthlyLimit() {
        return cashMonthlyLimit;
    }

    public void setCashMonthlyLimit(long cashMonthlyLimit) {
        this.cashMonthlyLimit = cashMonthlyLimit;
    }

    public long getPurcashDailyLimit() {
        return purcashDailyLimit;
    }

    public void setPurcashDailyLimit(long purcashDailyLimit) {
        this.purcashDailyLimit = purcashDailyLimit;
    }

    public long getPurcashMonthlyLimit() {
        return purcashMonthlyLimit;
    }

    public void setPurcashMonthlyLimit(long purcashMonthlyLimit) {
        this.purcashMonthlyLimit = purcashMonthlyLimit;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(Integer countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public List<Integer> getListOutsideCountries() {
        return listOutsideCountries;
    }

    public void setListOutsideCountries(List<Integer> listCountries) {
        this.listOutsideCountries = listCountries;
    }

    public boolean isSetAgeingVelocityControl() {
        return setAgeingVelocityControl;
    }

    public void setSetAgeingVelocityControl(boolean setAgeingVelocityControl) {
        this.setAgeingVelocityControl = setAgeingVelocityControl;
    }

    public long getAgeingCumulativeLimit() {
        return ageingCumulativeLimit;
    }

    public void setAgeingCumulativeLimit(long ageingCumulativeLimit) {
        this.ageingCumulativeLimit = ageingCumulativeLimit;
    }

    public int getAgeingAuthHoldDays() {
        return ageingAuthHoldDays;
    }

    public void setAgeingAuthHoldDays(int ageingAuthHoldDays) {
        this.ageingAuthHoldDays = ageingAuthHoldDays;
    }

    public String getAgeingTimeZone() {
        return ageingTimeZone;
    }

    public void setAgeingTimeZone(String ageingTimeZone) {
        this.ageingTimeZone = ageingTimeZone;
    }
    
}
