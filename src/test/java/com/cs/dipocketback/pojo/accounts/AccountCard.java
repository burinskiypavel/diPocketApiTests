package com.cs.dipocketback.pojo.accounts;

public class AccountCard {

    private Long id;
    private String tokenRefId;
    private String maskedPan;

    private DiPocketCard.DiPocketCardStatus cardStatus;

    private Boolean canOpen;
    private Boolean canReorder;
    private Boolean canUnblock;
    private Boolean canLink;
    private String whiteList;
    private String whiteListUrl;

    public AccountCard() {
    }

    public AccountCard(Long id,
                       String tokenRefId,
                       String maskedPan,
                       DiPocketCard.DiPocketCardStatus cardStatus,
                       Boolean canOpen,
                       Boolean canReorder,
                       Boolean canUnblock,
                       Boolean canLink,
                       String whiteList,
                       String whiteListUrl) {
        this.id = id;
        this.tokenRefId = tokenRefId;
        this.maskedPan = maskedPan;
        this.cardStatus = cardStatus;
        this.canOpen = canOpen;
        this.canReorder = canReorder;
        this.canUnblock = canUnblock;
        this.canLink = canLink;
        this.whiteList = whiteList;
        this.whiteListUrl = whiteListUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public DiPocketCard.DiPocketCardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(DiPocketCard.DiPocketCardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Boolean getCanOpen() {
        return canOpen;
    }

    public void setCanOpen(Boolean canOpen) {
        this.canOpen = canOpen;
    }

    public Boolean getCanReorder() {
        return canReorder;
    }

    public void setCanReorder(Boolean canReorder) {
        this.canReorder = canReorder;
    }

    public Boolean getCanUnblock() {
        return canUnblock;
    }

    public void setCanUnblock(Boolean canUnblock) {
        this.canUnblock = canUnblock;
    }

    public Boolean getCanLink() {
        return canLink;
    }

    public void setCanLink(Boolean canLink) {
        this.canLink = canLink;
    }

    public String getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList;
    }

    public String getWhiteListUrl() {
        return whiteListUrl;
    }

    public void setWhiteListUrl(String whiteListUrl) {
        this.whiteListUrl = whiteListUrl;
    }
}
