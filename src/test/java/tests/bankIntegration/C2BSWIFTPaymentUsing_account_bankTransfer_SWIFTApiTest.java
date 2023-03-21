package tests.bankIntegration;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C2BSWIFTPaymentUsing_account_bankTransfer_SWIFTApiTest extends TestBase {
    String city = "Vilnius";
    String login = "APIOLENA";
    String pass = "pU9N1Lu";

    @Test
    public void test_CustomerServices_v1_account_bankTransfer_SWIFT(){
        String response = given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(login, pass)
                .body("{\n" +
                        "  \"accountId\": 111231,\n" +
                        "  \"amount\": 148,\n" +
                        "  \"bankId\": \"LHVBEE22\",\n" +
                        "  \"beneficiaryAccount\": \"EE407777000012064164\",\n" +
                        "  \"beneficiaryType\": \"COMPANY\",\n" +
                        "  \"city\": \"Vilnius\",\n" +
                        "  \"companyName\": \"OCORPTEST\",\n" +
                        "  \"countryCode\": \"LT\",\n" +
                        "  \"currencyCode\": \"EUR\",\n" +
                        "  \"feeAmount\": 250,\n" +
                        "  \"feeCurrencyCode\": \"EUR\",\n" +
                        "  \"firstName\": \"Pavel\",\n" +
                        "  \"lastName\": \"Burinskiy\",\n" +
                        "  \"reference\": \"oki\",\n" +
                        "  \"requestId\": \"d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"\",\n" +
                        "  \"streetLine1\": \"Upes 2\",\n" +
                        "  \"streetLine2\": \"Upes 2\",\n" +
                        "  \"zip\": \"09100\"\n" +
                        "}")
                .post("https://api.dipocket.site/CustomerServices/v1/account/bankTransfer/SWIFT")
                .then().log().all()
                .statusCode(200).extract().response().asString();

    }
}