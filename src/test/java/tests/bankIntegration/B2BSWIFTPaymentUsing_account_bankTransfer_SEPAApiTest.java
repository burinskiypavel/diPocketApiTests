package tests.bankIntegration;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class B2BSWIFTPaymentUsing_account_bankTransfer_SEPAApiTest extends TestBase {
    String city = "Vilnius";
    String login = "APIOLENA";
    String pass = "pU9N1Lu";
    int feeAmount = 0;
    String currencyCode = "EUR";
    int accountId = 115975;

    @Test(priority = 1)
    public void test_CustomerServices_v1_account_calculateBankTransfer_SEPA(){
        String response = given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(login, pass)
                .body("{\n" +
                        "  \"accountId\": "+accountId+",\n" +
                        "  \"requestId\": \"d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"\",\n" +
                        "  \"currencyCode\": \""+currencyCode+"\",\n" +
                        "  \"amount\": \"10\"\n" +
                        "}")
                .post("https://api.dipocket.site/CustomerServices/v1/account/calculateBankTransfer/SEPA")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        feeAmount = jsonPath.getInt("feeAmount");
    }

    @Test(priority = 2)
    public void test_CustomerServices_v1_account_bankTransfer_SEPA(){
        String response = given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(login, pass)
                .body("{\n" +
                        "  \"accountId\": "+accountId+",\n" +
                        "  \"amount\": 148,\n" +
                        "  \"bankId\": \"LHVBEE22\",\n" +
                        "  \"beneficiaryAccount\": \"117997\",\n" +
                        "  \"beneficiaryType\": \"COMPANY\",\n" +
                        "  \"city\": \""+city+"\",\n" +
                        "  \"companyName\": \"Mantest\",\n" +
                        "  \"countryCode\": \"LT\",\n" +
                        "  \"currencyCode\": \""+currencyCode+"\",\n" +
                        "  \"feeAmount\": "+feeAmount+",\n" +
                        "  \"feeCurrencyCode\": \""+currencyCode+"\",\n" +
                        "  \"firstName\": \"\",\n" +
                        "  \"lastName\": \"\",\n" +
                        "  \"reference\": \"test\",\n" +
                        "  \"requestId\": \"d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"\",\n" +
                        "  \"streetLine1\": \"Upes 2\",\n" +
                        "  \"streetLine2\": \"Upes 2\",\n" +
                        "  \"zip\": \"09100\"\n" +
                        "}")
                .post("https://api.dipocket.site/CustomerServices/v1/account/bankTransfer/SEPA")
                .then().log().all()
                .statusCode(200).extract().response().asString();
    }

    @Test(priority = 3)
    public void test_verifyStatusPTSFromPTS_OUT_TRAN() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualPTSStatus = app.getDbHelper().getStatusPTSFromTestDB();
        assertEquals(actualPTSStatus, "INPRCS");
    }
}