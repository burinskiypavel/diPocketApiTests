package tests.bankIntegration.aspspApi.ais;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import model.aspsp.Access;
import model.aspsp.V1ConsentsRequest;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.testng.annotations.Test;

public class ASPSPAutorizationAISForWebcabinetUsersTests extends APIUITestBase {
    public String consentId = null;
    public String href = null;
    public String uiTransactionCode = null;
    public String apiTransactionCode = null;
    public int notifyId = 0;
    public String phone = "380980316499";
    public String pass = "reset246740";
    public String iban = "PL42109010560000000150296424";
    public String validUntil = "2023-06-17";
    String resourceId = null;
    String[] balances = new String[0];
    String[] transactions = new String[0];
    String transactionId = null;
    String currency = "PLN";
    String amount = "590.00";
    String ownerName = "Pavel Burinsky";
    String cashAccountType = "CACC";
    String status = "enabled";
    public String site = Site.DIPOCKET.toString();
    Gson gson = new Gson();
    DashBoardNotifyDetails3Request dashBoardNotifyDetails3Request = new DashBoardNotifyDetails3Request();
    Access access = new Access();
    V1ConsentsRequest v1ConsentsRequest = new V1ConsentsRequest();


    @Test(priority = 1)
    public void test_AISCreateConsentRequest() {
        //access.setBalances(balances);
        //access.setTransactions(transactions);
        v1ConsentsRequest.setAccess(access);
        v1ConsentsRequest.setRecurringIndicator(true);
        v1ConsentsRequest.setValidUntil(validUntil);
        String json = gson.toJson(v1ConsentsRequest);
        String response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents(json, "122222");

        consentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "consentId");
        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "_links.scaRedirect.href");
    }

    @Test(priority = 2)
    public void test_everypayWebConfirmaton() {
        uiTransactionCode = appUi.getUiAspspHelper().everypayWebConfirmaton(href, phone, pass);
    }
}