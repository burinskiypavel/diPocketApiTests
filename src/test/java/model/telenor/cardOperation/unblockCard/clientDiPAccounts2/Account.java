
package model.telenor.cardOperation.unblockCard.clientDiPAccounts2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("accountName")
    @Expose
    private String accountName;
    @SerializedName("ccy")
    @Expose
    private String ccy;
    @SerializedName("ccyId")
    @Expose
    private Integer ccyId;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("availableBalance")
    @Expose
    private Integer availableBalance;
    @SerializedName("blocked")
    @Expose
    private Integer blocked;
    @SerializedName("main")
    @Expose
    private Boolean main;
    @SerializedName("isDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("own")
    @Expose
    private Boolean own;
    @SerializedName("shared")
    @Expose
    private Boolean shared;
    @SerializedName("canOpenVirtualCard")
    @Expose
    private Boolean canOpenVirtualCard;
    @SerializedName("canOpenPlasticCard")
    @Expose
    private Boolean canOpenPlasticCard;
    @SerializedName("isMyShared")
    @Expose
    private Boolean isMyShared;
    @SerializedName("isSupervised")
    @Expose
    private Boolean isSupervised;
    @SerializedName("ownerId")
    @Expose
    private Integer ownerId;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("canReorderVirtual")
    @Expose
    private Boolean canReorderVirtual;
    @SerializedName("canReorderPlastic")
    @Expose
    private Boolean canReorderPlastic;
    @SerializedName("unblockPlasticCardId")
    @Expose
    private Integer unblockPlasticCardId;
    @SerializedName("canUnblockPlasticCard")
    @Expose
    private Boolean canUnblockPlasticCard;
    @SerializedName("unblockPlasticMaskedPan")
    @Expose
    private String unblockPlasticMaskedPan;
    @SerializedName("canLinkPlastic")
    @Expose
    private Boolean canLinkPlastic;
    @SerializedName("canUnblockVirtualCard")
    @Expose
    private Boolean canUnblockVirtualCard;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Integer getBlocked() {
        return blocked;
    }

    public void setBlocked(Integer blocked) {
        this.blocked = blocked;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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

    public Boolean getCanOpenVirtualCard() {
        return canOpenVirtualCard;
    }

    public void setCanOpenVirtualCard(Boolean canOpenVirtualCard) {
        this.canOpenVirtualCard = canOpenVirtualCard;
    }

    public Boolean getCanOpenPlasticCard() {
        return canOpenPlasticCard;
    }

    public void setCanOpenPlasticCard(Boolean canOpenPlasticCard) {
        this.canOpenPlasticCard = canOpenPlasticCard;
    }

    public Boolean getIsMyShared() {
        return isMyShared;
    }

    public void setIsMyShared(Boolean isMyShared) {
        this.isMyShared = isMyShared;
    }

    public Boolean getIsSupervised() {
        return isSupervised;
    }

    public void setIsSupervised(Boolean isSupervised) {
        this.isSupervised = isSupervised;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getCanReorderVirtual() {
        return canReorderVirtual;
    }

    public void setCanReorderVirtual(Boolean canReorderVirtual) {
        this.canReorderVirtual = canReorderVirtual;
    }

    public Boolean getCanReorderPlastic() {
        return canReorderPlastic;
    }

    public void setCanReorderPlastic(Boolean canReorderPlastic) {
        this.canReorderPlastic = canReorderPlastic;
    }

    public Integer getUnblockPlasticCardId() {
        return unblockPlasticCardId;
    }

    public void setUnblockPlasticCardId(Integer unblockPlasticCardId) {
        this.unblockPlasticCardId = unblockPlasticCardId;
    }

    public Boolean getCanUnblockPlasticCard() {
        return canUnblockPlasticCard;
    }

    public void setCanUnblockPlasticCard(Boolean canUnblockPlasticCard) {
        this.canUnblockPlasticCard = canUnblockPlasticCard;
    }

    public String getUnblockPlasticMaskedPan() {
        return unblockPlasticMaskedPan;
    }

    public void setUnblockPlasticMaskedPan(String unblockPlasticMaskedPan) {
        this.unblockPlasticMaskedPan = unblockPlasticMaskedPan;
    }

    public Boolean getCanLinkPlastic() {
        return canLinkPlastic;
    }

    public void setCanLinkPlastic(Boolean canLinkPlastic) {
        this.canLinkPlastic = canLinkPlastic;
    }

    public Boolean getCanUnblockVirtualCard() {
        return canUnblockVirtualCard;
    }

    public void setCanUnblockVirtualCard(Boolean canUnblockVirtualCard) {
        this.canUnblockVirtualCard = canUnblockVirtualCard;
    }

}
