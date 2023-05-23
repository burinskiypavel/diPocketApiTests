package tests.bankIntegration.aspspApi.ais;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.aspsp.*;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AisTests extends APIUITestBase {
    public String consentId = null;
    public String href = null;
    public String uiTransactionCode = null;
    public String apiTransactionCode = null;
    public int notifyId = 0;
    public String phone = "380980316499";
    public String pass = "reset246740";
    public String iban = "PL42109010560000000150296424";
    String dateFrom = "2019-11-26";
    String dateTo = "2023-05-12";
    public String validUntil = "2023-06-17";
    String resourceId = null;
    String[] balances = new String[0];
    String[] transactions = new String[0];
    String transactionId = null;
    String currency = "PLN";
    String amount = "590.00";
    String ownerName = "Pavel Burinsky";
    String cashAccountType = "CACC";
    String partnerId = "654321";
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
    public void test_webConfirmaton() {
        uiTransactionCode = appUi.getUiAspspHelper().webConfirmaton(href, phone, pass);
    }

    @Test(priority = 3)
    public void test_mobileConfirmation() throws SQLException, ClassNotFoundException {
        String cliSessionId = app.getLogin_registrationHelper().loginDipocket_test(phone, pass, prop.getProperty("mobile.login.deviceuuid"));
        Response response = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyList2(prop.getProperty("mobile.test.base.url"), phone, pass, cliSessionId);
        String responseString = response.then().body("notificationList[0].notifyTypeName", equalTo("ASPSP Authorization")).extract().response().asString();
        notifyId = app.getResponseValidationHelper().getIntFromResponseJsonPath(responseString, "notificationList[0].notifyId");

        dashBoardNotifyDetails3Request.setTypeId(55);
        dashBoardNotifyDetails3Request.setNotifyId(notifyId);
        dashBoardNotifyDetails3Request.setDetailsRef("");
        String json = gson.toJson(dashBoardNotifyDetails3Request);
        Response response2 = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyDetails3(prop.getProperty("mobile.test.base.url"), json, phone, pass, cliSessionId);
        String responseStringNotifyDetails3 = response2.then().body("notifyTypeName", equalTo("ASPSP Authorization"),
                        "hint", equalTo("Please confirm your authentication attempt only if you see the same PIN at authentication webpage")).extract().response().asString();
        apiTransactionCode = app.getResponseValidationHelper().getStringFromResponseJsonPath(responseStringNotifyDetails3, "dtails");

        app.getClientServicesRequestsHelper().clientServices_v1_aspsp_notifyId_approve(prop.getProperty("mobile.test.base.url"), notifyId, phone, pass, cliSessionId);

        appUi.getUiAspspHelper().selectAccount(iban);
        appUi.getUiAspspHelper().pressConsent();

        assertThat(uiTransactionCode, equalTo(apiTransactionCode));
    }

    @Test(priority = 4)
    public void test_AISGetConsentStatus_showConsentStatus() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds_status(consentId, partnerId);
        response.then().body("consentStatus", equalTo("valid"));
    }

    @Test(priority = 5)
    public void test_AISGetConsentRequest_showConsentInformation() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds(consentId, partnerId);
        response.then().body("validUntil", equalTo(validUntil),
                "consentStatus", equalTo("valid"),
                "recurringIndicator", equalTo(true));
    }

    @Test(priority = 6)
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

    @Test(priority = 7)
    public void test_AISReadAccountInfo(){
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_accounts_accountId(consentId, partnerId, resourceId);
        response.then().body("account.resourceId", equalTo(resourceId),
                        "account.iban", equalTo(iban),
                        "account.currency", equalTo(currency),
                        "account.ownerName", equalTo(ownerName),
                        "account.cashAccountType", equalTo(cashAccountType),
                        "account.status", equalTo(status));
    }

    @Test(priority = 8)
    public void test_AISReadAccountBalances(){
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_accounts_accountId_balances(consentId, partnerId, resourceId);
        response.then().body("account.iban", equalTo(iban),
                        "balances.balanceAmount[0].currency", equalTo(currency),
                        "balances.balanceAmount[0].amount", equalTo(amount),
                        "balances.balanceType", hasItems("interimAvailable", "interimBooked"),
                        "balances.balanceAmount[1].currency", equalTo(currency),
                        "balances.balanceAmount[1].amount", equalTo(amount));
    }

    @Test(priority = 9)
    public void test_AISReadAccountTransactionsList(){
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_accounts_accountId_transactions_dateFrom_dateTo(consentId, partnerId, resourceId, dateFrom, dateTo);
        String sRes = response.then().extract().response().asString();
        transactionId = app.getResponseValidationHelper().getStringFromResponseJsonPath(sRes, "transactions.booked.transactionId[0]");

        response.then().body("account.iban", equalTo(iban),
                "transactions.booked.transactionId", hasItems("29818;11;187652", "29818;11;187651"),
                "transactions.booked.entryReference", hasItems("487171", "487170"),
                "transactions.booked.creditorName", hasItems("-29791"),
                "transactions.booked.debtorName", hasItems("380661470959"),
                "transactions.booked.transactionAmount.currency", hasItems(currency),
                "transactions.booked.transactionAmount.amount", hasItems("-10.00", "600.00"),
                "transactions.booked.valueDate", hasItems("2020-12-04", "2020-12-04"),
                "transactions.booked.proprietaryBankTransactionCode", hasItems("DiP transfer"));
    }

    @Test(priority = 10)
    public void test_AISReadAccountTransactionDetailedInfo(){
        given()
                .log().uri().log().headers().log().body()
                .config(app.getSSLCertHelper().aspspSslConfig)
                .pathParam("accountId", resourceId)
                .pathParam("partnerId", partnerId)
                .pathParam("transactionId", transactionId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/accounts/{accountId}/transactions/{transactionId}")
                .then()
                .log().all()
                .statusCode(200)
                .body("transactionsDetails.transactionId", equalTo(transactionId),
                        "transactionsDetails.creditorName", equalTo("-29791"),
                        "transactionsDetails.transactionAmount.currency", equalTo(currency),
                        "transactionsDetails.transactionAmount.amount", equalTo("-10.00"),
                        "transactionsDetails.valueDate", equalTo("2020-12-04"));
    }
}