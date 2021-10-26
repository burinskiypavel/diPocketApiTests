package com.cs.dipocketback.pojo.festival;



public class FestivalClientInfo {


    private Long clientId;

    private Long festivalAccountId;

    private Long dipClientId;
    private Boolean migrated;
    private Boolean canConvert;
    private Boolean canReLink;
    private Boolean festClientHasStrongPassword;
    private Boolean dipClientHasStrongPassword;
    
    public FestivalClientInfo() {
    }

    public FestivalClientInfo(Long clientId, Long festivalAccountId, Boolean migrated, Boolean canConvert,
                              Boolean canReLink) {
        this.clientId = clientId;
        this.festivalAccountId = festivalAccountId;
        this.migrated = migrated;
        this.canConvert = canConvert;
        this.canReLink = canReLink;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setFestivalAccountId(Long festivalAccountId) {
        this.festivalAccountId = festivalAccountId;
    }

    public Long getFestivalAccountId() {
        return festivalAccountId;
    }

    public void setMigrated(Boolean migrated) {
        this.migrated = migrated;
    }

    public Boolean getMigrated() {
        return migrated;
    }

    public void setCanConvert(Boolean canConvert) {
        this.canConvert = canConvert;
    }

    public Boolean getCanConvert() {
        return canConvert;
    }

    public void setCanReLink(Boolean canReLink) {
        this.canReLink = canReLink;
    }

    public Boolean getCanReLink() {
        return canReLink;
    }

    public Boolean getFestClientHasStrongPassword() {
        return festClientHasStrongPassword;
    }

    public void setFestClientHasStrongPassword(Boolean festClientHasStrongPassword) {
        this.festClientHasStrongPassword = festClientHasStrongPassword;
    }

    public Boolean getDipClientHasStrongPassword() {
        return dipClientHasStrongPassword;
    }

    public void setDipClientHasStrongPassword(Boolean dipClientHasStrongPassword) {
        this.dipClientHasStrongPassword = dipClientHasStrongPassword;
    }

    public Long getDipClientId() {
        return dipClientId;
    }

    public void setDipClientId(Long dipClientId) {
        this.dipClientId = dipClientId;
    }
}
