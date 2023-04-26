package tests.bankIntegration.aspspApi.cof;

import base.APIUITestBase;
import base.TestBase;
import base.UITestBase;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CofTests extends APIUITestBase {
    public String consentId = null;
    public String href = null;

    @Test(priority = 1)
    public void test_COFCreateConsentRequest() {
        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/client_created.p12", "123456").keystoreType("PKCS12")
                        .allowAllHostnames()
        );

        String response = given()
                .log().uri().log().headers().log().body()
                .config(sslConfig)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi/")
                .contentType("application/json")
                .body("{\n" +
                        "    \"account\": {\n" +
                        "        \"iban\": \"EE657777000012110759\"\n" +
                        "    }\n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v2/consents/confirmation-of-funds")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        consentId = jsonPath.getString("consentId");
        href = jsonPath.getString("_links.scaRedirect.href");

        appUi.driver.navigate().to(href);
    }
}