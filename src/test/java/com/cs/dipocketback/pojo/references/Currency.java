package com.cs.dipocketback.pojo.references;

public class Currency {

    private Integer id; 
    private String code;
    private String symbol;
    private String name;
    private Boolean canOpenVirtual;
    private Boolean canOpenPlastic;
    private Boolean availableForRegistration;

    public Currency() {
    }

    public Currency(Integer id, 
                    String code, 
                    String symbol, 
                    String name) {
        this.id = id;
        this.code = code;
        this.symbol = symbol;
        this.name = name;
    }

    public Currency(Integer id, 
                    String code, 
                    String symbol, 
                    String name, 
                    Boolean canOpenVirtual,
                    Boolean canOpenPlastic) {
        this.id = id;
        this.code = code;
        this.symbol = symbol;
        this.name = name;
        this.canOpenVirtual = canOpenVirtual;
        this.canOpenPlastic = canOpenPlastic;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCanOpenVirtual(Boolean canOpenVirtual) {
        this.canOpenVirtual = canOpenVirtual;
    }

    public Boolean getCanOpenVirtual() {
        return canOpenVirtual;
    }

    public void setCanOpenPlastic(Boolean canOpenPlastic) {
        this.canOpenPlastic = canOpenPlastic;
    }

    public Boolean getCanOpenPlastic() {
        return canOpenPlastic;
    }

    public void setAvailableForRegistration(Boolean availableForRegistration) {
        this.availableForRegistration = availableForRegistration;
    }

    public Boolean getAvailableForRegistration() {
        return availableForRegistration;
    }

}
