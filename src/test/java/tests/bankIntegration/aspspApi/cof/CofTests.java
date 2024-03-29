package tests.bankIntegration.aspspApi.cof;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import model.aspsp.Account;
import model.aspsp.ConfirmationOfFundsRequest;
import model.aspsp.CreateConsentRequest;
import model.aspsp.InstructedAmount;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CofTests extends APIUITestBase {
    String partnerId = "654321";
    String consentId = null;
    String href = null;
    String uiTransactionCode = null;
    String apiTransactionCode = null;
    int notifyId = 0;
    String iban = "PL42109010560000000150296424";
    String site = Site.DIPOCKET.toString();
    Gson gson = new Gson();
    CreateConsentRequest createConsentRequest = new CreateConsentRequest();
    Account account = new Account();
    DashBoardNotifyDetails3Request dashBoardNotifyDetails3Request = new DashBoardNotifyDetails3Request();
    ConfirmationOfFundsRequest confirmationOfFundsRequest = new ConfirmationOfFundsRequest();
    InstructedAmount instructedAmount = new InstructedAmount();


    @Test(priority = 1)
    public void test_cofCreateConsentRequest() {
        account.setIban(iban);
        createConsentRequest.setAccount(account);
        String json = gson.toJson(createConsentRequest);

        String response = given()
                .spec(app.requestSpecASPSPTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi/")
                .contentType("application/json")
                .body(json)
                .post("/{partnerId}/bg/v2/consents/confirmation-of-funds")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        consentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "consentId");
        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "_links.scaRedirect.href");
    }

    @Test(priority = 2)
    public void test_webConfirmaton() {
        uiTransactionCode = appUi.getUiAspspHelper().webConfirmaton(href, prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"));
    }

    @Test(priority = 3)
    public void test_mobileConfirmation() throws SQLException, ClassNotFoundException {
        String cliSessionId = app.getLogin_registrationHelper().loginDipocket_test(prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"), prop.getProperty("mobile.login.deviceuuid"));
        String response2 = given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"))
                .header("site", site)
                .header("cliSessionId", cliSessionId)
                .get("https://http.dipocket.site/ClientServices/v1/dashBoard/notifyList2")
                .then().log().all()
                .statusCode(200)
                .body("notificationList[0].notifyTypeName", equalTo("ASPSP Authorization")).extract().response().asString();

        JsonPath jsonPath2 = new JsonPath(response2);
        notifyId = jsonPath2.getInt("notificationList[0].notifyId");

        dashBoardNotifyDetails3Request.setTypeId(55);
        dashBoardNotifyDetails3Request.setNotifyId(notifyId);
        dashBoardNotifyDetails3Request.setDetailsRef("");
        String json = gson.toJson(dashBoardNotifyDetails3Request);

        String response4 = given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"))
                .contentType("application/json")
                .header("cliSessionId", cliSessionId)
                .header("site", site)
                .body(json)
                .post("https://http.dipocket.site/ClientServices/v1/dashBoard/notifyDetails3")
                .then().log().all()
                .statusCode(200)
                .body("notifyTypeName", equalTo("ASPSP Authorization"),
                        "hint", equalTo("Please confirm your authentication attempt only if you see the same PIN at authentication webpage")).extract().response().asString();

        JsonPath jsonPath3 = new JsonPath(response4);
        apiTransactionCode = jsonPath3.getString("dtails");

        given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"))
                .contentType("application/json")
                .header("cliSessionId", cliSessionId)
                .pathParam("notifyId", notifyId)
                .header("site", site)
                .post("https://http.dipocket.site/ClientServices/v1/aspsp/{notifyId}/approve")
                .then().log().all()
                .statusCode(200);

        appUi.getUiAspspHelper().pressConsent();

        assertThat(uiTransactionCode, equalTo(apiTransactionCode));
    }

    @Test(priority = 4)
    public void test_getConsentStatus_showConsentStatus() {
        given()
                .spec(app.requestSpecASPSPTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("/{partnerId}/bg/v2/consents/confirmation-of-funds/{confirmation-of-funds}/status")
                .then().log().all()
                .statusCode(200)
                .body("consentStatus", equalTo("valid"));
    }

    @Test(priority = 5)
    public void test_getConsentRequest_showConsentInformation() {
        given()
                .spec(app.requestSpecASPSPTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "b3500b4a-ca36-4917-9d94-f60a1731c4ca")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("/{partnerId}/bg/v2/consents/confirmation-of-funds/{confirmation-of-funds}")
                .then().log().all()
                .statusCode(200)
                .body("account.iban", equalTo(iban),
                        "consentStatus", equalTo("valid"));
    }

    @Test(priority = 6)
    public void test_confirmationOfFundsRequest_availableFunds() {
        account.setIban(iban);
        instructedAmount.setAmount("10.11");
        instructedAmount.setCurrency("PLN");
        confirmationOfFundsRequest.setAccount(account);
        confirmationOfFundsRequest.setInstructedAmount(instructedAmount);
        String json = gson.toJson(confirmationOfFundsRequest);

        given()
                .spec(app.requestSpecASPSPTest)
                .pathParam("partnerId", partnerId)
                .contentType("application/json")
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .body(json)
                .post("/{partnerId}/bg/v1/funds-confirmations")
                .then().log().all()
                .statusCode(200)
                .body("fundsAvailable", equalTo(true));
    }
}