package com.cs.dipocketback.pojo.mycrowd;

public class CrowdEventCheck {
    
    private Long id;
    private Integer termResult;
    private Integer amountResult;
    
    public CrowdEventCheck() {
    }

    public CrowdEventCheck(Long id, 
                           Integer termResult, 
                           Integer amountResult) {
        this.id = id;
        this.termResult = termResult;
        this.amountResult = amountResult;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTermResult(Integer termResult) {
        this.termResult = termResult;
    }

    public Integer getTermResult() {
        return termResult;
    }

    public void setAmountResult(Integer amountResult) {
        this.amountResult = amountResult;
    }

    public Integer getAmountResult() {
        return amountResult;
    }
    
}
