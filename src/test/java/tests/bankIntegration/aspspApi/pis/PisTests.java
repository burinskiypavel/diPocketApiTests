package tests.bankIntegration.aspspApi.pis;

import base.APIUITestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PisTests extends APIUITestBase {
    String partnerId = "654321";
    String paymentId = null;

    @Test(priority = 1)
    public void test_pisGetPaymentRequest() {
        Response response = given()
                .log().uri().log().headers().log().body()
                .config(app.getSSLCertHelper().aspspSslConfig)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "ded9c406-b701-4963-9b68-5d8d7a2b3041")
                .get("https://openbanking.dipocket.site:3443/{partnerId}/bg/v1/payments/sepa-credit-transfers/94647f10-c4d6-4009-84dd-dcbf49a082e3");

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

        paymentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(stResponse, "paymentId");
    }
}