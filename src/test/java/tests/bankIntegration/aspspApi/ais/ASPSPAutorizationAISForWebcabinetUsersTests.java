package tests.bankIntegration.aspspApi.ais;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.aspsp.Access;
import model.aspsp.V1ConsentsRequest;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ASPSPAutorizationAISForWebcabinetUsersTests extends APIUITestBase {
    String consentId = null;
    String href = null;
    String uiTransactionCode = null;
    String apiTransactionCode = null;
    int notifyId = 0;
    String dateFrom = "2019-11-26";
    String dateTo = "2023-05-12";
    String phone = "37064902199";
    String partnerId = "122222";
    String pass = "123456A";
    String clientId = "62008";

    String iban = "EE517777000012207332";
    String validUntil = "2023-06-17";
    String resourceId = null;
    String[] balances = new String[0];
    String[] transactions = new String[0];
    String transactionId = null;
    String currency = "EUR";
    String amount = "911.00";
    String amount2 = "926.00";
    String ownerName = "Vasya White";
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
        String response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents(json, partnerId);

        consentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "consentId");
        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "_links.scaRedirect.href");
    }

    @Test(priority = 2)
    public void test_everypayWebConfirmaton() throws SQLException, ClassNotFoundException {
        appUi.getUiAspspHelper().everypayWebConfirmaton(href, phone, pass, clientId);
        appUi.getUiAspspHelper().selectAccount(iban);
        appUi.getUiAspspHelper().pressConsent();
    }

    @Test(priority = 3)
    public void test_AISGetConsentStatus_showConsentStatus() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds_status(consentId, partnerId);
        response.then().body("consentStatus", equalTo("valid"));
    }

    @Test(priority = 4)
    public void test_AISGetConsentRequest_showConsentInformation() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds(consentId, partnerId);
        response.then().body("validUntil", equalTo(validUntil),
                "consentStatus", equalTo("valid"),
                "recurringIndicator", equalTo(true));
    }

    @Test(priority = 5)
    public void test_AISReadAccountsList() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_accounts(consentId, partnerId);
        String resString = response.then()
                .body("accounts[0].iban", equalTo(iban),
                        "accounts[0].currency", equalTo(currency),
                        "accounts[0].ownerName", equalTo(ownerName),
                        "accounts[0].cashAccountType", equalTo(cashAccountType),
                        "accounts[0].status", equalTo(status)).extract().response().asString();

        resourceId = app.getResponseValidationHelper().getStringFromResponseJsonPath(resString, "accounts[0].resourceId");
    }

    @Test(priority = 6)
    public void test_AISReadAccountInfo(){
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_accounts_accountId(consentId, partnerId, resourceId);
        response.then().body("account.resourceId", equalTo(resourceId),
                        "account.iban", equalTo(iban),
                        "account.currency", equalTo(currency),
                        "account.ownerName", equalTo(ownerName),
                        "account.cashAccountType", equalTo(cashAccountType),
                        "account.status", equalTo(status));
    }

    @Test(priority = 7)
    public void test_AISReadAccountBalances(){
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_accounts_accountId_balances(consentId, partnerId, resourceId);
        response.then().body("account.iban", equalTo(iban),
                        "balances.balanceAmount[0].currency", equalTo(currency),
                        "balances.balanceAmount[0].amount", equalTo(amount),
                        "balances.balanceType", hasItems("interimAvailable", "interimBooked"),
                        "balances.balanceAmount[1].currency", equalTo(currency),
                        "balances.balanceAmount[1].amount", equalTo(amount2));
    }

    @Test(priority = 8)
    public void test_AISReadAccountTransactionsList(){
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_accounts_accountId_transactions_dateFrom_dateTo(consentId, partnerId, resourceId, dateFrom, dateTo);
        String sRes = response.then().extract().response().asString();
        transactionId = app.getResponseValidationHelper().getStringFromResponseJsonPath(sRes, "transactions.booked.transactionId[0]");

        response.then().body("account.iban", equalTo(iban),
                "transactions.booked.transactionId", hasItems("62008;11;376771", "62008;11;376772"),
                "transactions.booked.entryReference", hasItems("675652", "675653"),
                "transactions.booked.creditorName", hasItems("Shop with Chip POS"),
                "transactions.booked.debtorName", hasItems("Everypay Payments Services S.M.S.A"),
                "transactions.booked.transactionAmount.currency", hasItems(currency),
                "transactions.booked.transactionAmount.amount", hasItems("1200.00", "-33.00"),
                "transactions.booked.valueDate", hasItems("2023-05-09", "2023-05-11"),
                "transactions.booked.proprietaryBankTransactionCode", hasItems("In-store Purchase"));
    }
}