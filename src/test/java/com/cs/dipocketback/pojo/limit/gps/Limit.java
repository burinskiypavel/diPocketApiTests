package com.cs.dipocketback.pojo.limit.gps;

public class Limit {
    
    private String type;
    private String name;
    private Integer ccyId;
    private String ccySymbol;
    private Long maxAmount;
    private Long limitAmount;
    private Long usageAmount;
    private Long availableAmount;
    
    public Limit() {
    }

    public Limit(String type, 
                 String name, 
                 Integer ccyId, 
                 String ccySymbol, 
                 Long maxAmount, 
                 Long limitAmount, 
                 Long usageAmount, 
                 Long availableAmount) {
        this.type = type;
        this.name = name;
        this.ccyId = ccyId;
        this.ccySymbol = ccySymbol;
        this.maxAmount = maxAmount;
        this.limitAmount = limitAmount;
        this.usageAmount = usageAmount;
        this.availableAmount = availableAmount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setLimitAmount(Long limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Long getLimitAmount() {
        return limitAmount;
    }

    public void setUsageAmount(Long usageAmount) {
        this.usageAmount = usageAmount;
    }

    public Long getUsageAmount() {
        return usageAmount;
    }

    public void setAvailableAmount(Long availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Long getAvailableAmount() {
        return availableAmount;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("type = ");
        sb.append(type);
        sb.append("\n");
        sb.append("name = ");
        sb.append(name);
        sb.append("\n");
        sb.append("ccyId = ");
        sb.append(ccyId);
        sb.append("\n");
        sb.append("ccySymbol = ");
        sb.append(ccySymbol);
        sb.append("\n");
        sb.append("maxAmount = ");
        sb.append(maxAmount);
        sb.append("\n");
        sb.append("limitAmount = ");
        sb.append(limitAmount);
        sb.append("\n");
        sb.append("availableAmount = ");
        sb.append(availableAmount);
        sb.append("\n");
        return sb.toString();
    }
}

