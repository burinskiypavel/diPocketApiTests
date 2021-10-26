package com.cs.dipocketback.pojo.accounts;

public class PlasticCard {
    
    private Long id;
    private Long accountId;
    private Integer typeId;
    private String typeSname;
    private String firstName;
    private String lastName;
    private String expDate;
    private String maskedPan;
    private DiPocketCard.DiPocketCardStatus status;
    private Boolean canActivate;
    private Boolean noName;
    private Boolean pinIsSet;
    private String dipToken;
    
    public PlasticCard() {
    }
    
    public PlasticCard(Long accountId, 
                       String typeSname, 
                       String firstName, 
                       String lastName,
                       String expDate, 
                       String maskedPan,  
                       Integer stateId, 
                       Boolean canActivate, 
                       Boolean noName,
                       Boolean pinIsSet, 
                       String dipToken) {
        this.accountId = accountId;
        this.typeSname = typeSname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expDate = expDate;
        this.maskedPan = maskedPan;
        setStatus(DiPocketCard.DiPocketCardStatus.valueOf(stateId));
        this.canActivate = canActivate;
        this.noName = noName;
        this.pinIsSet = pinIsSet;
        this.dipToken = dipToken;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeSname(String typeSname) {
        this.typeSname = typeSname;
    }

    public String getTypeSname() {
        return typeSname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setStatus(DiPocketCard.DiPocketCardStatus status) {
        this.status = status;
    }

    public DiPocketCard.DiPocketCardStatus getStatus() {
        return status;
    }

    public void setCanActivate(Boolean canActivate) {
        this.canActivate = canActivate;
    }

    public Boolean getCanActivate() {
        return canActivate;
    }

    public void setNoName(Boolean noName) {
        this.noName = noName;
    }

    public Boolean getNoName() {
        return noName;
    }

    public void setPinIsSet(Boolean pinIsSet) {
        this.pinIsSet = pinIsSet;
    }

    public Boolean getPinIsSet() {
        return pinIsSet;
    }

    public void setDipToken(String dipToken) {
        this.dipToken = dipToken;
    }

    public String getDipToken() {
        return dipToken;
    }
    
    public void clearOnGetStatus() {
        setAccountId(null);
        setTypeId(null);
        setTypeSname(null);
        setFirstName(null);
        setLastName(null);
        setExpDate(null);
        setMaskedPan(null);
    }
    
}
