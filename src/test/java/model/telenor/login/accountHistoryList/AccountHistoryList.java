
package model.telenor.login.accountHistoryList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountHistoryList {

    @SerializedName("accountHistoryList")
    @Expose
    private List<AccountHistoryList_> accountHistoryList = null;

    public List<AccountHistoryList_> getAccountHistoryList() {
        return accountHistoryList;
    }

    public void setAccountHistoryList(List<AccountHistoryList_> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

}
