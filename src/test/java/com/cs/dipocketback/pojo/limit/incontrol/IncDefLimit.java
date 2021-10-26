package com.cs.dipocketback.pojo.limit.incontrol;

public class IncDefLimit {    
    
    private Integer id;
    
    private String sName;   //Online shopping
    private String envList; //ECOM, MOTO
    
    private Long limitValue;
    
    private Integer ccyId;
    private String ccyCode;
    private String ccySymbol;
    
    private LimitTypeInDb type;
    
    public IncDefLimit() {
    }

    public IncDefLimit(Integer id, 
                       String sName, 
                       String envList, 
                       Long limitValue, 
                       Integer ccyId, 
                       String ccyCode, 
                       String ccySymbol,
                       LimitTypeInDb type) {
        this.id = id;
        this.sName = sName;
        this.envList = envList;
        this.limitValue = limitValue;
        this.ccyId = ccyId;
        this.ccyCode = ccyCode;
        this.ccySymbol = ccySymbol;
        this.type = type;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }

    public void setEnvList(String envList) {
        this.envList = envList;
    }

    public String getEnvList() {
        return envList;
    }

    public void setLimitValue(Long limitValue) {
        this.limitValue = limitValue;
    }

    public Long getLimitValue() {
        return limitValue;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setType(LimitTypeInDb type) {
        this.type = type;
    }

    public LimitTypeInDb getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" sName: ");
        sb.append(sName);
        sb.append(" envList: ");
        sb.append(envList);
        sb.append(" limitValue: ");
        sb.append(limitValue);
        sb.append(" ccyId: ");
        sb.append(ccyId);
        sb.append(" ccyCode: ");
        sb.append(ccyCode);
        sb.append(" ccySymbol: ");
        sb.append(ccySymbol);
        sb.append(" type: ");
        sb.append(type);
        return sb.toString();
    }

}
