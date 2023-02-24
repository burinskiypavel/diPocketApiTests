package tests.bankIntegration;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LHVOpenVIBANForLegalEntityUnderDipocketUABInEURCurrencyForSITSANDBOXTest extends TestBase {
    String sandboxLogin = "SANDBOX";
    String sandboxPass = "W6qQnx7";

    @Test(priority = 1)
    public void test_CustomerServicesDev_v1_company_register(){
        given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(sandboxLogin, sandboxPass)
                .body("{ \n" +
                        "\n" +
                        "  \"requestId\" : \"47"+app.getBOHelper().generateRandomString(8)+"-dc36-462d-87f7-"+app.getBOHelper().generateRandomString(12)+"\", \n" +
                        "  \"langCode\" : \"en\", \n" +
                        "  \"companyName\" : \"Hand, Hilll and Russel\", \n" +
                        "  \"rStreetLine1\" : \"155 Stehr Squares\", \n" +
                        "  \"rStreetLine2\" : \"4925 Cremin Branch\", \n" +
                        "  \"rCity\" : \"Edmundport\", \n" +
                        "  \"rState\" : \"\", \n" +
                        "  \"rZip\" : \"660820\", \n" +
                        "  \"rCountryCode\" : \"LT\", \n" +
                        "  \"mStreetLine1\" : \"393 Willis Ridges\", \n" +
                        "  \"mStreetLine2\" : \"1299 Marianne Junctions\", \n" +
                        "  \"mCity\" : \"Kharkiv\", \n" +
                        "  \"mState\" : \"\", \n" +
                        "  \"mZip\" : \"81101\", \n" +
                        "  \"mCountryCode\" : \"LT\", \n" +
                        "  \"ddStatus\" : \"FDD\", \n" +
                        "  \"currencyCode\" : \"EUR\", \n" +
                        "  \"type\" : \"LEGAL_ENTITY\" \n" +
                        "\n" +
                        "} ")
                .post("https://api.dipocket.site/CustomerServices/v1/company/register")
                .then().log().all()
                .statusCode(200);
    }
}