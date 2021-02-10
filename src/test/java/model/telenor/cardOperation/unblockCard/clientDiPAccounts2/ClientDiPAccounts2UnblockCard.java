
package model.telenor.cardOperation.unblockCard.clientDiPAccounts2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientDiPAccounts2UnblockCard {

    @SerializedName("accounts")
    @Expose
    private List<Account> accounts = null;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
