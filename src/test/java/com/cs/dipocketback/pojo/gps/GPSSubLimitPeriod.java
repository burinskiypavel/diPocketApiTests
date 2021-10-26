package com.cs.dipocketback.pojo.gps;

public class GPSSubLimitPeriod {
    
    private String period;
    private String unit;
    private Long limit;
    private Integer frequency;
    private Long usage;
    private Integer no;
    
    public GPSSubLimitPeriod() {
    }
    
    public GPSSubLimitPeriod(String period, String unit, Long limit, Integer frequency, Long usage, Integer no) {
        this.period = period;
        this.unit = unit;
        this.limit = limit;
        this.frequency = frequency;
        this.usage = usage;
        this.no = no;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getLimit() {
        return limit;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setUsage(Long usage) {
        this.usage = usage;
    }

    public Long getUsage() {
        return usage;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }
}
