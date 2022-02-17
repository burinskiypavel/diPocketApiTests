package model.bo.boClient;

public class Account_client {

    private int id;
    private String accountName;
    private int clientId;
    private int ccyId;
    private String ccyCode;
    private int restAmount;
    private int stateId;
    private String stateName;
    private int typeId;
    private String created;
    private String accStateNameExt;
    private int clientIdOwner;
    private boolean owner;
    private boolean shared;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCcyId() {
        return ccyId;
    }

    public void setCcyId(int ccyId) {
        this.ccyId = ccyId;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public int getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(int restAmount) {
        this.restAmount = restAmount;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAccStateNameExt() {
        return accStateNameExt;
    }

    public void setAccStateNameExt(String accStateNameExt) {
        this.accStateNameExt = accStateNameExt;
    }

    public int getClientIdOwner() {
        return clientIdOwner;
    }

    public void setClientIdOwner(int clientIdOwner) {
        this.clientIdOwner = clientIdOwner;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
