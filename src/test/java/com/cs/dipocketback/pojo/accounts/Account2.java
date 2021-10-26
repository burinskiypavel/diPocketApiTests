package com.cs.dipocketback.pojo.accounts;

import javax.xml.bind.annotation.XmlTransient;

public class Account2 {
    
    private Long accountId;
    private String accountName;
    private String ccy;
    private Integer ccyId;
    private Long balance;
    private Long availableBalance;
    private Long blocked;
    private Long virtualCardId;
    private Long plasticCardId;
    private String plasticMaskedPan;
    private Boolean main;
    private Boolean isDefault;
    private Boolean own;
    private Boolean shared;
    private Boolean canOpenVirtualCard;
    private Boolean canOpenPlasticCard;
    private Boolean isMyShared;
    private Boolean isSupervised;
    private SharedModeType sharedModeType;
    private String ownerName;
    private Long ownerId;
    private AccountState state;
    private String closed;
    private Boolean canReorderVirtual;
    private Boolean canReorderPlastic;
    private String plasticCardTokenRefId;
    private String virtualCardTokenRefId;
    private DiPocketCard.DiPocketCardStatus plasticCardStatus;
    private DiPocketCard.DiPocketCardStatus virtualCardStatus;
    private Long unblockPlasticCardId;
    private Boolean canUnblockPlasticCard;
    private String unblockPlasticMaskedPan;
    private String virtualMaskedPan;
    private Boolean canLinkPlastic;
    private Long unblockVirtualCardId;
    private Boolean canTopUp;
    private Boolean canOffload;
    private Boolean canUnblockVirtualCard;
    private String plasticWhiteList;
    private String plasticWhiteListUrl;
    private String virtualWhiteList;
    private String virtualWhiteListUrl;
//    own
//    shared
//    isMyShared
//    isSupervised
//    sharedModeType(REGULAR, SUPERVISED)

    public Account2() {
    }

    public Account2(Long accountId,
                    String accountName,
                    String ccy,
                    Integer ccyId,
                    Long balance,
                    Long availableBalance,
                    Long blocked,
                    Long virtualCardId,
                    Long plasticCardId,
                    String plasticMaskedPan,
                    Boolean main,
                    Boolean isDefault,
                    Boolean own,
                    Boolean shared,
                    Boolean canOpenVirtualCard,
                    Boolean canOpenPlasticCard,
                    Boolean isMyShared,
                    Boolean isSupervised,
                    Integer sharedMode,
                    String ownerName,
                    Integer stateId,
                    String closed,
                    Boolean canReorderVirtual,
                    Boolean canReorderPlastic,
                    String plasticCardTokenRefId,
                    String virtualCardTokenRefId,
                    Long ownerId,
                    DiPocketCard.DiPocketCardStatus plasticCardStatus,
                    DiPocketCard.DiPocketCardStatus virtualCardStatus,
                    Long unblockPlasticCardId,
                    Boolean canUnblockPlasticCard,
                    String unblockPlasticMaskedPan,
                    String virtualMaskedPan,
                    Boolean canLinkPlastic,
                    Long unblockVirtualCardId,
                    Boolean canTopUp,
                    Boolean canOffload,
                    Boolean canUnblockVirtualCard,
                    String plasticWhiteList,
                    String plasticWhiteListUrl,
                    String virtualWhiteList,
                    String virtualWhiteListUrl) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.ccy = ccy;
        this.ccyId = ccyId;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.blocked = blocked;
        this.virtualCardId = virtualCardId;
        this.plasticCardId = plasticCardId;
        this.plasticMaskedPan = plasticMaskedPan;
        this.main = main;
        this.isDefault = isDefault;
        this.own = own;
        this.shared = shared;
        this.canOpenVirtualCard = canOpenVirtualCard;
        this.canOpenPlasticCard = canOpenPlasticCard;
        this.isMyShared = isMyShared;
        this.isSupervised = isSupervised;
        this.sharedModeType = SharedModeType.valueOf(sharedMode);
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.state = AccountState.valueOf(stateId);
        this.closed = closed;
        this.canReorderVirtual = canReorderVirtual;
        this.canReorderPlastic = canReorderPlastic;
        this.plasticCardTokenRefId = plasticCardTokenRefId;
        this.virtualCardTokenRefId = virtualCardTokenRefId;
        this.plasticCardStatus = plasticCardStatus;
        this.virtualCardStatus = virtualCardStatus;
        this.canUnblockPlasticCard = canUnblockPlasticCard;
        this.unblockPlasticMaskedPan = unblockPlasticMaskedPan;
        this.virtualMaskedPan = virtualMaskedPan;
        this.unblockPlasticCardId = unblockPlasticCardId;
        this.canLinkPlastic = canLinkPlastic;
        this.unblockVirtualCardId = unblockVirtualCardId;
        this.canTopUp = canTopUp;
        this.canOffload = canOffload;
        this.canUnblockVirtualCard = canUnblockVirtualCard;
        this.plasticWhiteList = plasticWhiteList;
        this.plasticWhiteListUrl = plasticWhiteListUrl;
        this.virtualWhiteList = virtualWhiteList;
        this.virtualWhiteListUrl = virtualWhiteListUrl;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
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

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
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

    public void setBlocked(Long blocked) {
        this.blocked = blocked;
    }

    public Long getBlocked() {
        return blocked;
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

    public void setPlasticMaskedPan(String plasticMaskedPan) {
        this.plasticMaskedPan = plasticMaskedPan;
    }

    public String getPlasticMaskedPan() {
        return plasticMaskedPan;
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

    public void setSharedModeType(SharedModeType sharedModeType) {
        this.sharedModeType = sharedModeType;
    }

    public SharedModeType getSharedModeType() {
        return sharedModeType;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public AccountState getState() {
        return state;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getClosed() {
        return closed;
    }

    public void setCanReorderVirtual(Boolean canReorderVirtual) {
        this.canReorderVirtual = canReorderVirtual;
    }

    public Boolean getCanReorderVirtual() {
        return canReorderVirtual;
    }

    public void setCanReorderPlastic(Boolean canReorderPlastic) {
        this.canReorderPlastic = canReorderPlastic;
    }

    public Boolean getCanReorderPlastic() {
        return canReorderPlastic;
    }

    public void setPlasticCardTokenRefId(String plasticCardTokenRefId) {
        this.plasticCardTokenRefId = plasticCardTokenRefId;
    }

    public String getPlasticCardTokenRefId() {
        return plasticCardTokenRefId;
    }

    public void setVirtualCardTokenRefId(String virtualCardTokenRefId) {
        this.virtualCardTokenRefId = virtualCardTokenRefId;
    }

    public String getVirtualCardTokenRefId() {
        return virtualCardTokenRefId;
    }

    public void setPlasticCardStatus(DiPocketCard.DiPocketCardStatus plasticCardStatus) {
        this.plasticCardStatus = plasticCardStatus;
    }

    public DiPocketCard.DiPocketCardStatus getPlasticCardStatus() {
        return plasticCardStatus;
    }

    public DiPocketCard.DiPocketCardStatus getVirtualCardStatus() {
        return virtualCardStatus;
    }

    public void setVirtualCardStatus(DiPocketCard.DiPocketCardStatus virtualCardStatus) {
        this.virtualCardStatus = virtualCardStatus;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setCanUnblockPlasticCard(Boolean canUnblockPlasticCard) {
        this.canUnblockPlasticCard = canUnblockPlasticCard;
    }

    public Boolean getCanUnblockPlasticCard() {
        return canUnblockPlasticCard;
    }

    public void setUnblockPlasticMaskedPan(String unblockPlasticCardPan) {
        this.unblockPlasticMaskedPan = unblockPlasticCardPan;
    }

    public String getUnblockPlasticMaskedPan() {
        return unblockPlasticMaskedPan;
    }

    public String getVirtualMaskedPan() {
        return virtualMaskedPan;
    }

    public void setVirtualMaskedPan(String virtualMaskedPan) {
        this.virtualMaskedPan = virtualMaskedPan;
    }

    public void setUnblockPlasticCardId(Long unblockPlasticCardId) {
        this.unblockPlasticCardId = unblockPlasticCardId;
    }

    @XmlTransient
    public Long getUnblockPlasticCardId() {
        return unblockPlasticCardId;
    }

    public void setCanLinkPlastic(Boolean canLinkPlastic) {
        this.canLinkPlastic = canLinkPlastic;
    }

    public Boolean getCanLinkPlastic() {
        return canLinkPlastic;
    }

    public Long getUnblockVirtualCardId() {
        return unblockVirtualCardId;
    }

    public void setUnblockVirtualCardId(Long unblockVirtualCardId) {
        this.unblockVirtualCardId = unblockVirtualCardId;
    }

    public Boolean getCanTopUp() {
        return canTopUp;
    }

    public void setCanTopUp(Boolean canTopUp) {
        this.canTopUp = canTopUp;
    }

    public Boolean getCanOffload() {
        return canOffload;
    }

    public void setCanOffload(Boolean canOffload) {
        this.canOffload = canOffload;
    }

    public Boolean getCanUnblockVirtualCard() {
        return canUnblockVirtualCard;
    }

    public void setCanUnblockVirtualCard(Boolean canUnblockVirtualCard) {
        this.canUnblockVirtualCard = canUnblockVirtualCard;
    }

    public String getPlasticWhiteList() {
        return plasticWhiteList;
    }

    public void setPlasticWhiteList(String plasticWhiteList) {
        this.plasticWhiteList = plasticWhiteList;
    }

    public String getPlasticWhiteListUrl() {
        return plasticWhiteListUrl;
    }

    public void setPlasticWhiteListUrl(String plasticWhiteListUrl) {
        this.plasticWhiteListUrl = plasticWhiteListUrl;
    }

    public String getVirtualWhiteList() {
        return virtualWhiteList;
    }

    public void setVirtualWhiteList(String virtualWhiteList) {
        this.virtualWhiteList = virtualWhiteList;
    }

    public String getVirtualWhiteListUrl() {
        return virtualWhiteListUrl;
    }

    public void setVirtualWhiteListUrl(String virtualWhiteListUrl) {
        this.virtualWhiteListUrl = virtualWhiteListUrl;
    }
}
