package com.cs.dipocketback.pojo.registration;

public class AttachedCard {
    
    private Long id;
    private String name;
    private String pan;
    private Integer ccyId;
    private Boolean selected;
    private Integer countryId;
    
    public AttachedCard() {
    }

    public AttachedCard(Long id) {
        this.id = id;
    }

    public AttachedCard(Long id, 
                        String name, 
                        String pan, 
                        Integer ccyId, 
                        boolean selected, 
                        Integer countryId) {
        this.id = id;
        this.name = name;
        this.pan = pan;
        this.ccyId = ccyId;
        this.selected = selected;
        this.countryId = countryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean isSelected() {
        return selected;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

}
