package tests.bankIntegration.aspspApi.cof;

import appmanager.HelperBase;
import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CofTests extends APIUITestBase {
    public String consentId = null;
    public String href = null;
    public int notifyId = 0;
    public String phone = "380980316499";
    public String pass = "reset246740";
    public String iban = "PL42109010560000000150296424";
    public String site = Site.DIPOCKET.toString();

    RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
            SSLConfig.sslConfig()
                    .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                    .keyStore("files/certs/client_created.p12", "123456").keystoreType("PKCS12")
                    .allowAllHostnames()
    );

    @Test(priority = 1)
    public void test_COFCreateConsentRequest() {
        String response = given()
                .log().uri().log().headers().log().body()
                .config(sslConfig)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi/")
                .contentType("application/json")
                .body("{\n" +
                        "    \"account\": {\n" +
                        "        \"iban\": \""+iban+"\"\n" +
                        "    }\n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v2/consents/confirmation-of-funds")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        consentId = jsonPath.getString("consentId");
        href = jsonPath.getString("_links.scaRedirect.href");

        appUi.driver.navigate().to(href);
        appUi.getUiboHelper().waitFor(By.id("phone-number"));
        appUi.driver.findElement(By.id("phone-number")).sendKeys(phone);
        appUi.driver.findElement(By.id("password")).sendKeys(pass);
        appUi.driver.findElement(By.xpath("//button[@data-dip-action='login']")).click();
        appUi.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Please go to DiPocket Mobile Application to confirm your authorization attempt')]"));
    }

        @Test(priority = 2)
        public void test_mobileConfirmation() throws SQLException, ClassNotFoundException {
        String cliSessionId = appUi.getLogin_registrationHelper().loginDipocket_test(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
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

        given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(phone, pass)
                .contentType("application/json")
                .header("cliSessionId", cliSessionId)
                .header("site", site)
                .body("{\n" +
                        "  \"typeId\" : 55,\n" +
                        "  \"notifyId\" : "+notifyId+",\n" +
                        "  \"detailsRef\" : \"\"\n" +
                        "}")
                .post("https://http.dipocket.site/ClientServices/v1/dashBoard/notifyDetails3")
                .then().log().all()
                .statusCode(200)
                .body("notifyTypeName", equalTo("ASPSP Authorization"),
                        "hint", equalTo("Please confirm your authentication attempt only if you see the same PIN at authentication webpage"));

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
    }

    @Test(priority = 3)
    public void test_GetConsentStatus() throws InterruptedException {
        appUi.getUiboHelper().waitFor(By.xpath("//button[contains(text(), 'Consent')]"));
        appUi.driver.findElement(By.xpath("//button[contains(text(), 'Consent')]")).click();

        Thread.sleep(4000);
        given()
                .log().uri().log().headers().log().body()
                .config(sslConfig)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("https://openbanking.dipocket.site:3443/654321/bg/v2/consents/confirmation-of-funds/{confirmation-of-funds}/status")
                .then().log().all()
                .statusCode(200)
                .body("consentStatus", equalTo("valid"));
    }
    @Test(priority = 4)
    public void test_GetConsentRequest(){
        given()
                .log().uri().log().headers().log().body()
                .config(sslConfig)
                .header("X-Request-ID", "b3500b4a-ca36-4917-9d94-f60a1731c4ca")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("https://openbanking.dipocket.site:3443/654321/bg/v2/consents/confirmation-of-funds/{confirmation-of-funds}")
                .then().log().all()
                .statusCode(200)
                .body("account.iban", equalTo(iban),
                        "consentStatus", equalTo("valid"));
    }

    @Test(priority = 5)
    public void test_ConfirmationOfFundsRequest(){
        given()
                .log().uri().log().headers().log().body()
                .config(sslConfig)
                .contentType("application/json")
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .body("{\n" +
                        "    \"account\": { \n" +
                        "        \"iban\": \""+iban+"\"\n" +
                        "        },\n" +
                        "    \"instructedAmount\": {\n" +
                        "        \"amount\":\"10.11\", \n" +
                        "        \"currency\":\"EUR\"\n" +
                        "        }\n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v1/funds-confirmations")
                .then().log().all()
                .statusCode(200);
    }
}