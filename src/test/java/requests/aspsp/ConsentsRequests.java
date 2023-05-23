package requests.aspsp;

import appmanager.HelperBase;
import appmanager.SSLCertHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ConsentsRequests {
    SSLCertHelper sslCertHelper = new SSLCertHelper();

    public RequestSpecification requestSpecConsents = given()
            .log().uri().log().headers().log().body()
            //.basePath("")
            .baseUri("https://openbanking.dipocket.site")
            .port(3443);

    public RequestSpecification requestSpecConsentsTest = given()
            .log().uri().log().headers().log().body()
            //.basePath("")
            .contentType("application/json");

    public String partnerId_bg_v1_consents(String json, String partnerId) {
        String response = given()
                .log().uri().log().headers().log().body()
                .config(sslCertHelper.aspspSslConfig)
                //.baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
//                .body("{\n" +
//                        "    \"access\": {\n" +
//                        "        \"balances\": [\n" +
//                        "            \n" +
//                        "        ],\n" +
//                        "        \"transactions\": [\n" +
//                        "            \n" +
//                        "        ]\n" +
//                        "    },\n" +
//                        "    \"recurringIndicator\": true,\n" +
//                        "    \"validUntil\": \"2023-05-17\"\n" +
//                        "}")
                .post("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/consents/")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public Response partnerId_bg_v1_consents_confirmationOfFunds_status(String consentId, String partnerId) {
        Response response = given()
                .log().uri().log().headers().log().body()
                .config(sslCertHelper.aspspSslConfig)
                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("https://openbanking.dipocket.site:3443/" + partnerId + "/bg/v1/consents/{confirmation-of-funds}/status");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_consents_confirmationOfFunds(String consentId, String partnerId) {
        Response response = given()
                .log().uri().log().headers().log().body()
                .config(sslCertHelper.aspspSslConfig)
                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("confirmation-of-funds", consentId)
                .get("https://openbanking.dipocket.site:3443/" + partnerId + "/bg/v1/consents/{confirmation-of-funds}");
        response.then().log().all()
                .statusCode(200);
                return response;
    }

    public Response partnerId_bg_v1_accounts(String consentId, String partnerId) {
        Response response = given()
                .log().uri().log().headers().log().body()
                .config(sslCertHelper.aspspSslConfig)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/accounts");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_accounts_accountId(String consentId, String partnerId, String resourceId) {
        Response response = given()
                .log().uri().log().headers().log().body()
                .config(sslCertHelper.aspspSslConfig)
                .pathParam("partnerId", partnerId)
                .pathParam("accountId", resourceId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/accounts/{accountId}");
        response.then().log().all()
                .statusCode(200);
        return response;
    }
}