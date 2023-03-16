package tests.bankIntegration;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BankTransferSwiftTest extends TestBase {
    String city = "Vilnius";
    String login = "ASPSP.DIPOCKET";
    String pass = "W6qQnx7";

    @Test
    public void test_CustomerServices_v1_bankTransfer_SWIFT(){
        String response = given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(login, pass)
                .body("{\n" +
                        "  \"accountId\": 117202,\n" +
                        "  \"amount\": 10,\n" +
                        "  \"bankId\": \"SWIFT\",\n" +
                        "  \"beneficiaryAccount\": \"EE657777000012110759\",\n" +
                        "  \"beneficiaryType\": \"INDIVIDUAL\",\n" +
                        "  \"city\": \""+city+"\",\n" +
                        "  \"companyName\": \"TestCompanyBankTransferSwift\",\n" +
                        "  \"countryCode\": \"440\",\n" +
                        "  \"currencyCode\": \"EUR \",\n" +
                        "  \"feeAmount\": 250,\n" +
                        "  \"feeCurrencyCode\": \"EUR\",\n" +
                        "  \"firstName\": \"Pavel\",\n" +
                        "  \"lastName\": \"Burinskiy\",\n" +
                        "  \"reference\": \"cross border transfer test version1\",\n" +
                        "  \"requestId\": \"d1f202fe-df2e-46da-94ba-"+app.generateRandomString(12)+"\",\n" +
                        "  \"streetLine1\": \"streetLine1\",\n" +
                        "  \"streetLine2\": \"streetLine2\",\n" +
                        "  \"zip\": \"123456\"\n" +
                        "}")
                .post("https://api.dipocket.site/CustomerServices/v1/bankTransfer/SWIFT")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        //JsonPath jsonPath = new JsonPath(response);
        //clientIdSandbox = jsonPath.getInt("clientId");
    }
}
