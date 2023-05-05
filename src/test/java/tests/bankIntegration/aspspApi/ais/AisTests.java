package tests.bankIntegration.aspspApi.ais;

import appmanager.HelperBase;
import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import model.aspsp.Account;
import model.aspsp.ConfirmationOfFundsRequest;
import model.aspsp.CreateConsentRequest;
import model.aspsp.InstructedAmount;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

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
    public String validUntil = "2023-05-17";
    public String site = Site.DIPOCKET.toString();
    Gson gson = new Gson();
    CreateConsentRequest createConsentRequest = new CreateConsentRequest();
    Account account = new Account();
    DashBoardNotifyDetails3Request dashBoardNotifyDetails3Request = new DashBoardNotifyDetails3Request();
    ConfirmationOfFundsRequest confirmationOfFundsRequest = new ConfirmationOfFundsRequest();
    InstructedAmount instructedAmount = new InstructedAmount();


    @Test(priority = 1)
    public void test_AISCreateConsentRequest() {
        //account.setIban(iban);
        //createConsentRequest.setAccount(account);
        //String json = gson.toJson(createConsentRequest);

        String response = given()
                .log().uri().log().headers().log().body()
                .config(app.aspspSslConfig)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body("{\n" +
                        "    \"access\": {\n" +
                        "        \"balances\": [ \n" +
                        "            \n" +
                        "        ],\n" +
                        "        \"transactions\": [\n" +
                        "            \n" +
                        "        ]\n" +
                        "    },\n" +
                        "    \"recurringIndicator\": true,\n" +
                        "    \"validUntil\": \""+validUntil+"\"\n" +
                        "   \n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        consentId = jsonPath.getString("consentId");
        href = jsonPath.getString("_links.scaRedirect.href");
    }

    @Test(priority = 2)
    public void test_webConfirmaton(){
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
        String cliSessionId = app.getLogin_registrationHelper().loginDipocket_test(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
        String response2 = given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(phone, pass)
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
                .auth().preemptive().basic(phone, pass)
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
                .auth().preemptive().basic(phone, pass)
                .contentType("application/json")
                .header("cliSessionId", cliSessionId)
                .pathParam("notifyId", notifyId)
                .header("site", site)
                .post("https://http.dipocket.site/ClientServices/v1/aspsp/{notifyId}/approve")
                .then().log().all()
                .statusCode(200);

        appUi.getUiboHelper().waitFor(By.xpath("//button[contains(text(), 'Consent')]"));
        appUi.driver.findElement(By.xpath("//button[contains(text(), 'Consent')]")).click();

            assertThat(uiTransactionCode, equalTo(apiTransactionCode));
    }

    @Test(priority = 4)
    public void test_AISGetConsentStatus_showConsentStatus() {
        //appUi.getUiboHelper().waitFor(By.xpath("//button[contains(text(), 'Consent')]"));
        //appUi.driver.findElement(By.xpath("//button[contains(text(), 'Consent')]")).click();

        given()
                .log().uri().log().headers().log().body()
                .config(app.aspspSslConfig)
                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/{confirmation-of-funds}/status")
                .then().log().all()
                .statusCode(200)
                .body("consentStatus", equalTo("valid"));
    }

    @Test(priority = 5)
    public void test_AISGetConsentRequest_showConsentInformation(){
        given()
                .log().uri().log().headers().log().body()
                .config(app.aspspSslConfig)
                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/{confirmation-of-funds}")
                .then().log().all()
                .statusCode(200)
                .body("validUntil", equalTo(validUntil),
                        "consentStatus", equalTo("valid"),
                        "recurringIndicator", equalTo(true));
    }
}