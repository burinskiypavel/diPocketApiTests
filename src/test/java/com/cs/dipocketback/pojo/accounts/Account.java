package com.cs.dipocketback.pojo.accounts;


public class Account {

    private Long id;
    private String accountName;
    private String ccy;
    private Integer ccyID;
    private Long balance;
    private Long availableBalance;
    private Long blocked;
    private Long pendingIn;
    private Long pendingOut;
    private Long virtualCardId;
    private Long plasticCardId;
    private String maskedPan;
    private Boolean main;
    private Boolean isDefault;
    private Boolean own;
    private Boolean shared;
    private String plasticCardStatus;
    private Boolean canOpenVirtualCard;
    private Boolean canOpenPlasticCard;
    private Boolean isMyShared;
    private Boolean isSupervised;
    private Integer sharedMode;
    private String ownerName;
    private Long ownerId;
    private String programNickName;

    public Account() {
    }

    public Account(Long id, String accountName, String ccy, Integer ccyID, Long balance, Long availableBalance,
                   Long blocked, Long pendingIn, Long pendingOut, Long virtualCardId, Long plasticCardId,
                   String maskedPan, Boolean main, Boolean isDefault, Boolean own, Boolean shared, String ownerName,
                   String plasticCardStatus, Boolean canOpenVirtualCard, Boolean canOpenPlasticCard, Boolean isMyShared,
                   Boolean isSupervised, Integer sharedMode, Long ownerId, String programNickName) {
        this.id = id;
        this.accountName = accountName;
        this.ccy = ccy;
        this.ccyID = ccyID;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.blocked = blocked;
        this.pendingIn = pendingIn;
        this.pendingOut = pendingOut;
        this.virtualCardId = virtualCardId;
        this.plasticCardId = plasticCardId;
        this.maskedPan = maskedPan;
        this.main = main;
        this.isDefault = isDefault;
        this.own = own;
        this.shared = shared;
        this.ownerName = ownerName;
        this.plasticCardStatus = plasticCardStatus;
        this.canOpenVirtualCard = canOpenVirtualCard;
        this.canOpenPlasticCard = canOpenPlasticCard;
        this.isMyShared = isMyShared;
        this.isSupervised = isSupervised;
        this.sharedMode = sharedMode;
        this.ownerId = ownerId;
        this.programNickName = programNickName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcyID(Integer ccyID) {
        this.ccyID = ccyID;
    }

    public Integer getCcyID() {
        return ccyID;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setPendingIn(Long pendingIn) {
        this.pendingIn = pendingIn;
    }

    public Long getPendingIn() {
        return pendingIn;
    }

    public void setPendingOut(Long pendingOut) {
        this.pendingOut = pendingOut;
    }

    public Long getPendingOut() {
        return pendingOut;
    }

    public void setVirtualCardId(Long virtualCardId) {
        this.virtualCardId = virtualCardId;
    }

    public Long getVirtualCardId() {
        return virtualCardId;
    }

    public void setPlasticCardId(Long plasticCardId) {
        this.plasticCardId = plasticCardId;
    }

    public Long getPlasticCardId() {
        return plasticCardId;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public Boolean getMain() {
        return main;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setOwn(Boolean own) {
        this.own = own;
    }

    public Boolean getOwn() {
        return own;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setPlasticCardStatus(String plasticCardStatus) {
        this.plasticCardStatus = plasticCardStatus;
    }

    public String getPlasticCardStatus() {
        return plasticCardStatus;
    }

    public void setCanOpenVirtualCard(Boolean canOpenVirtualCard) {
        this.canOpenVirtualCard = canOpenVirtualCard;
    }

    public Boolean getCanOpenVirtualCard() {
        return canOpenVirtualCard;
    }

    public void setCanOpenPlasticCard(Boolean canOpenPlasticCard) {
        this.canOpenPlasticCard = canOpenPlasticCard;
    }

    public Boolean getCanOpenPlasticCard() {
        return canOpenPlasticCard;
    }

    public void setBlocked(Long blocked) {
        this.blocked = blocked;
    }

    public Long getBlocked() {
        return blocked;
    }

    public void setIsMyShared(Boolean isMyShared) {
        this.isMyShared = isMyShared;
    }

    public Boolean getIsMyShared() {
        return isMyShared;
    }

    public void setIsSupervised(Boolean isSupervised) {
        this.isSupervised = isSupervised;
    }

    public Boolean getIsSupervised() {
        return isSupervised;
    }

    public void setSharedMode(Integer sharedMode) {
        this.sharedMode = sharedMode;
    }

    public Integer getSharedMode() {
        return sharedMode;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getProgramNickName() {
        return programNickName;
    }

    public void setProgramNickName(String programNickName) {
        this.programNickName = programNickName;
    }

}
