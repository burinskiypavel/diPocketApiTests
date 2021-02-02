
package model.telenor.login.accountHistoryList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountHistoryList_ {

    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("ccyId")
    @Expose
    private Integer ccyId;
    @SerializedName("ccySymbol")
    @Expose
    private String ccySymbol;
    @SerializedName("finType")
    @Expose
    private String finType;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemDateISO")
    @Expose
    private String itemDateISO;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("typeId")
    @Expose
    private Integer typeId;
    @SerializedName("typeName")
    @Expose
    private String typeName;
    @SerializedName("accCcyId")
    @Expose
    private Integer accCcyId;
    @SerializedName("accCcySymbol")
    @Expose
    private String accCcySymbol;
    @SerializedName("accAmount")
    @Expose
    private Integer accAmount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getFinType() {
        return finType;
    }

    public void setFinType(String finType) {
        this.finType = finType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemDateISO() {
        return itemDateISO;
    }

    public void setItemDateISO(String itemDateISO) {
        this.itemDateISO = itemDateISO;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getAccCcyId() {
        return accCcyId;
    }

    public void setAccCcyId(Integer accCcyId) {
        this.accCcyId = accCcyId;
    }

    public String getAccCcySymbol() {
        return accCcySymbol;
    }

    public void setAccCcySymbol(String accCcySymbol) {
        this.accCcySymbol = accCcySymbol;
    }

    public Integer getAccAmount() {
        return accAmount;
    }

    public void setAccAmount(Integer accAmount) {
        this.accAmount = accAmount;
    }

}
