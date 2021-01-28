
package model.telenor.clientDiPAccounts2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import model.telenor.clientDiPAccounts2.Accountt;

public class ClientDiPAccounts {

    @SerializedName("accounts")
    @Expose
    private List<Accountt> accounts = null;

    public List<Accountt> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accountt> accountts) {
        this.accounts = accountts;
    }

}
