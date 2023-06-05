package tests.bankIntegration.aspspApi.pis;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.aspsp.Account;
import model.aspsp.ConfirmationOfFundsRequest;
import model.aspsp.CreateConsentRequest;
import model.aspsp.InstructedAmount;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PisTests extends APIUITestBase {
    String partnerId = "654321";
    String actualPaymentId = null;
    String href = null;
    String paymentId = "94647f10-c4d6-4009-84dd-dcbf49a082e3";
    String phone = "380980316499";
    String pass = "reset246740";
    String apiTransactionCode = null;

    int notifyId = 0;
    String site = Site.DIPOCKET.toString();
    String uiTransactionCode = null;
    Gson gson = new Gson();
    CreateConsentRequest createConsentRequest = new CreateConsentRequest();
    Account account = new Account();
    DashBoardNotifyDetails3Request dashBoardNotifyDetails3Request = new DashBoardNotifyDetails3Request();
    ConfirmationOfFundsRequest confirmationOfFundsRequest = new ConfirmationOfFundsRequest();
    InstructedAmount instructedAmount = new InstructedAmount();

    @Test(priority = 1)
    public void test_pisGetPaymentRequest() {
        Response response = given()
                .log().uri().log().headers().log().body()
                .config(app.getSSLCertHelper().aspspSslConfig)
                .pathParam("partnerId", partnerId)
                .pathParam("paymentId", paymentId)
                .header("X-Request-ID", "ded9c406-b701-4963-9b68-5d8d7a2b3041")
                .get("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/payments/sepa-credit-transfers/{paymentId}");

        String stResponse = response.then().log().all()
                .statusCode(200).extract().response().asString();

        response.then()
                .body("transactionStatus", equalTo("ACSC"),
                        "paymentId", notNullValue(),
                        "paymentDetails.instructedAmount.currency", equalTo("PLN"),
                        "paymentDetails.instructedAmount.amount", equalTo("9.00"),
                        "paymentDetails.creditorName", equalTo("some guy"),
                        "paymentDetails.creditorAccount.iban", equalTo("EE657777000047856985"),
                        "paymentDetails.creditorType", equalTo("INDIVIDUAL"),
                        "paymentDetails.remittanceInformationUnstructured", equalTo("domestic transfer test DPB-453 retest v1"));

        actualPaymentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(stResponse, "paymentId");
    }

    @Test(priority = 2)
    public void test_PISGetPaymentRequestStatus(){
        given()
                .log().uri().log().headers().log().body()
                .config(app.getSSLCertHelper().aspspSslConfig)
                .pathParam("partnerId", partnerId)
                .pathParam("paymentId", paymentId)
                .header("X-Request-ID", "ded9c406-b701-4963-9b68-5d8d7a2b3041")
                .get("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/payments/sepa-credit-transfers/{paymentId}/status")
                .then().log().all()
                .statusCode(200)
                .body("transactionStatus", equalTo("ACSC"));
    }

    @Test(priority = 3)
    public void test_PISInitiatePaymentSWIFT(){
        String stResponse = given()
                .log().uri().log().headers().log().body()
                .config(app.getSSLCertHelper().aspspSslConfig)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "ded9c406-b701-4963-9b68-5d8d7a2b3041")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body("{\n" +
                        "    \"instructedAmount\": {\n" +
                        "        \"currency\": \"EUR\", \n" +
                        "        \"amount\": \"1.50\"\n" +
                        "        }, \n" +
                        "    \"creditorName\": \"Merchant123\",\n" +
                        "    \"creditorType\": \"INDIVIDUAL\",\n" +
                        "    \"creditorAddress\": {\n" +
                        "        \"streetName\": \"Sörnäistenlaituri\",\n" +
                        "        \"buildingNumber\": \"3\",\n" +
                        "        \"townName\": \"Helsinki\",\n" +
                        "        \"postCode\": \"00540\",\n" +
                        "        \"country\": \"FI\"\n" +
                        "    },\n" +
                        "    \"creditorAgent\": \"SBANFIHH\",\n" +
                        "    \"creditorAccount\": {\n" +
                        "        \"iban\": \"DE02100100109307118603\"\n" +
                        "        }, \n" +
                        "    \"remittanceInformationUnstructured\": \"SWIFT payment test\"\n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/payments/cross-border-credit-transfers")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(stResponse, "_links.scaRedirect.href");
    }

    @Test(priority = 4)
    public void test_webConfirmaton() {
        appUi.driver.navigate().to(href);
        appUi.getUiboHelper().waitFor(By.id("phone-number"));
        appUi.driver.findElement(By.id("phone-number")).sendKeys(phone);
        appUi.driver.findElement(By.id("password")).sendKeys(pass);
        appUi.driver.findElement(By.xpath("//button[@data-dip-action='login']")).click();
        appUi.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Please go to DiPocket Mobile Application to confirm your authorization attempt')]"));
        uiTransactionCode = appUi.driver.findElement(By.id("transaction-code")).getText();
    }

    @Test(priority = 5)
    public void test_mobileConfirmation() throws SQLException, ClassNotFoundException {
        String cliSessionId = app.getLogin_registrationHelper().loginDipocket_test(phone, pass, prop.getProperty("mobile.login.deviceuuid"));
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

        assertThat(uiTransactionCode, equalTo(apiTransactionCode));
    }
}