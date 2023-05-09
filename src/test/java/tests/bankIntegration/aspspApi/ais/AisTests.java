package tests.bankIntegration.aspspApi.ais;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.aspsp.*;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AisTests extends APIUITestBase {
    public String consentId = null;
    public String href = null;
    public String uiTransactionCode = null;
    public String apiTransactionCode = null;
    public int notifyId = 0;
    public String phone = "380980316499";
    public String pass = "reset246740";
    public String iban = "PL42109010560000000150296424";
    public String validUntil = "2023-06-17";
    String[] balances = new String[0];
    String[] transactions = new String[0];
    public String site = Site.DIPOCKET.toString();
    Gson gson = new Gson();
    DashBoardNotifyDetails3Request dashBoardNotifyDetails3Request = new DashBoardNotifyDetails3Request();
    Access access = new Access();
    V1ConsentsRequest v1ConsentsRequest = new V1ConsentsRequest();


    @Test(priority = 1)
    public void test_AISCreateConsentRequest() {
        access.setBalances(balances);
        access.setTransactions(transactions);
        v1ConsentsRequest.setAccess(access);
        v1ConsentsRequest.setRecurringIndicator(true);
        v1ConsentsRequest.setValidUntil(validUntil);
        String json = gson.toJson(v1ConsentsRequest);
        String response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents(json);

        //JsonPath jsonPath = new JsonPath(response);
        //consentId = jsonPath.getString("consentId");
        //href = jsonPath.getString("_links.scaRedirect.href");
        consentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "consentId");
        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "_links.scaRedirect.href");
    }

    @Test(priority = 2)
    public void test_webConfirmaton() {
        appUi.driver.navigate().to(href);
        appUi.getUiboHelper().waitFor(By.id("phone-number"));
        appUi.driver.findElement(By.id("phone-number")).sendKeys(phone);
        appUi.driver.findElement(By.id("password")).sendKeys(pass);
        appUi.driver.findElement(By.xpath("//button[@data-dip-action='login']")).click();
        appUi.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Please go to DiPocket Mobile Application to confirm your authorization attempt')]"));
        uiTransactionCode = appUi.driver.findElement(By.id("transaction-code")).getText();
    }

    @Test(priority = 3)
    public void test_mobileConfirmation() throws SQLException, ClassNotFoundException {
        String cliSessionId = app.getLogin_registrationHelper().loginDipocket_test(phone, pass, prop.getProperty("mobile.login.deviceuuid"));
        Response response = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyList2(prop.getProperty("mobile.test.base.url"), phone, pass, cliSessionId);
//        String response2 = given()
//                .log().uri().log().headers().log().body()
//                .auth().preemptive().basic(phone, pass)
//                .header("site", site)
//                .header("cliSessionId", cliSessionId)
//                .get("https://http.dipocket.site/ClientServices/v1/dashBoard/notifyList2")
        String responseString = response.then().body("notificationList[0].notifyTypeName", equalTo("ASPSP Authorization")).extract().response().asString();

        notifyId = app.getResponseValidationHelper().getIntFromResponseJsonPath(responseString, "notificationList[0].notifyId");
        //JsonPath jsonPath2 = new JsonPath(responseString);
        //notifyId = jsonPath2.getInt("notificationList[0].notifyId");

        dashBoardNotifyDetails3Request.setTypeId(55);
        dashBoardNotifyDetails3Request.setNotifyId(notifyId);
        dashBoardNotifyDetails3Request.setDetailsRef("");
        String json = gson.toJson(dashBoardNotifyDetails3Request);

//        String response4 = given()
//                .log().uri().log().headers().log().body()
//                .auth().preemptive().basic(phone, pass)
//                .contentType("application/json")
//                .header("cliSessionId", cliSessionId)
//                .header("site", site)
//                .body(json)
//                .post("https://http.dipocket.site/ClientServices/v1/dashBoard/notifyDetails3")
//                .then().log().all()
//                .statusCode(200)
        Response response2 = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyDetails3(prop.getProperty("mobile.test.base.url"), json, phone, pass, cliSessionId);
        String responseStringNotifyDetails3 = response2.then().body("notifyTypeName", equalTo("ASPSP Authorization"),
                        "hint", equalTo("Please confirm your authentication attempt only if you see the same PIN at authentication webpage")).extract().response().asString();

        //JsonPath jsonPath3 = new JsonPath(response4);
        //apiTransactionCode = jsonPath3.getString("dtails");
        apiTransactionCode = app.getResponseValidationHelper().getStringFromResponseJsonPath(responseStringNotifyDetails3, "dtails");

//        given()
//                .log().uri().log().headers().log().body()
//                .auth().preemptive().basic(phone, pass)
//                .contentType("application/json")
//                .header("cliSessionId", cliSessionId)
//                .pathParam("notifyId", notifyId)
//                .header("site", site)
//                .post("https://http.dipocket.site/ClientServices/v1/aspsp/{notifyId}/approve")
//                .then().log().all()
//                .statusCode(200);
        app.getClientServicesRequestsHelper().clientServices_v1_aspsp_notifyId_approve(prop.getProperty("mobile.test.base.url"), notifyId, phone, pass, cliSessionId);

        appUi.getUiboHelper().waitFor(By.xpath("//button[contains(text(), 'Consent')]"));
        appUi.driver.findElement(By.xpath("//button[contains(text(), 'Consent')]")).click();

        assertThat(uiTransactionCode, equalTo(apiTransactionCode));
    }

    @Test(priority = 4)
    public void test_AISGetConsentStatus_showConsentStatus() {
        //appUi.getUiboHelper().waitFor(By.xpath("//button[contains(text(), 'Consent')]"));
        //appUi.driver.findElement(By.xpath("//button[contains(text(), 'Consent')]")).click();

        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds_status(consentId);
        response.then().body("consentStatus", equalTo("valid"));
//        given()
//                .log().uri().log().headers().log().body()
//                .config(app.getSSLCertHelper().aspspSslConfig)
//                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
//                .header("TPP-Redirect-URI", "http://www.google.com")
//                .pathParam("confirmation-of-funds", consentId)
//                .get("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/{confirmation-of-funds}/status")
//                .then().log().all()
//                .statusCode(200)
//                .body("consentStatus", equalTo("valid"));
    }

    @Test(priority = 5)
    public void test_AISGetConsentRequest_showConsentInformation() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds(consentId);
        response.then().body("validUntil", equalTo(validUntil),
                "consentStatus", equalTo("valid"),
                "recurringIndicator", equalTo(true));

//        given()
//                .log().uri().log().headers().log().body()
//                .config(app.getSSLCertHelper().aspspSslConfig)
//                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
//                .header("TPP-Redirect-URI", "http://www.google.com")
//                .pathParam("confirmation-of-funds", consentId)
//                .get("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/{confirmation-of-funds}")
//                .then().log().all()
//                .statusCode(200)
//                .body("validUntil", equalTo(validUntil),
//                        "consentStatus", equalTo("valid"),
//                        "recurringIndicator", equalTo(true));
    }
}