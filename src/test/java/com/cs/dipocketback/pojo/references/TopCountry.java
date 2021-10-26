package com.cs.dipocketback.pojo.references;

public class TopCountry {
    
    private Integer rank;
    private Integer id;
    private String code;
    private String name;
    
    public TopCountry() {
    }

    public TopCountry(Integer rank, 
                      Integer id, 
                      String code, 
                      String name) {
        this.rank = rank;
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
