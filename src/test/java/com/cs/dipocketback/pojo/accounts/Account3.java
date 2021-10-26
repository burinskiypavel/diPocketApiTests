package com.cs.dipocketback.pojo.accounts;

public class Account3 {

    private Long id;
    private String accountName;
    private String ccy;
    private Integer ccyId;
    private Long balance;
    private Long availableBalance;
    private Long blocked;

    private Boolean main;
    private Boolean isDefault;
    private Boolean own;
    private Boolean shared;
    private Boolean myShared;

    private Boolean supervised;
    private SharedModeType sharedModeType;

    private String ownerName;
    private Long ownerId;
    private AccountState state;
    private String closed;
    private Boolean canTopUp;
    private Boolean canOffload;

    private AccountCard plasticCard;
    private AccountCard virtualCard;

    public Account3() {
    }

    public Account3(Long id,
                    String accountName,
                    String ccy,
                    Integer ccyId,
                    Long balance,
                    Long availableBalance,
                    Long blocked,
                    Boolean main,
                    Boolean isDefault,
                    Boolean own,
                    Boolean shared,
                    Boolean myShared,
                    Boolean supervised,
                    SharedModeType sharedMode,
                    String ownerName,
                    AccountState state,
                    String closed,
                    Long ownerId,
                    AccountCard plasticCard,
                    AccountCard virtualCard) {

        this.id = id;
        this.accountName = accountName;
        this.ccy = ccy;
        this.ccyId = ccyId;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.blocked = blocked;
        this.main = main;
        this.isDefault = isDefault;
        this.own = own;
        this.shared = shared;
        this.myShared = myShared;
        this.supervised = supervised;
        this.sharedModeType = sharedMode;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.state = state;
        this.closed = closed;
        this.plasticCard = plasticCard;
        this.virtualCard = virtualCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getBlocked() {
        return blocked;
    }

    public void setBlocked(Long blocked) {
        this.blocked = blocked;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getOwn() {
        return own;
    }

    public void setOwn(Boolean own) {
        this.own = own;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public Boolean getMyShared() {
        return myShared;
    }

    public void setMyShared(Boolean myShared) {
        this.myShared = myShared;
    }

    public Boolean getSupervised() {
        return supervised;
    }

    public void setSupervised(Boolean supervised) {
        this.supervised = supervised;
    }

    public SharedModeType getSharedModeType() {
        return sharedModeType;
    }

    public void setSharedModeType(SharedModeType sharedModeType) {
        this.sharedModeType = sharedModeType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
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

    public AccountCard getPlasticCard() {
        return plasticCard;
    }

    public void setPlasticCard(AccountCard plasticCard) {
        this.plasticCard = plasticCard;
    }

    public AccountCard getVirtualCard() {
        return virtualCard;
    }

    public void setVirtualCard(AccountCard virtualCard) {
        this.virtualCard = virtualCard;
    }

}
