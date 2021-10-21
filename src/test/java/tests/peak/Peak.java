package tests.peak;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Peak extends TestBase {
    String requestId = "6613ba7c-bbe6-434c-a5fe-3781cb51069f";
    String publicToken = null;
    String pan = null;
    String pin = null;
    String cvv = null;

    @Test(priority = 1)
    public void test_PeakServices_v1_card_cardIssue(){
        Response res =  given().log().uri().log().headers()
                .queryParam("lang", "en")
                .queryParam("ddStatus", "SDD")
                .queryParam("feeTarifPlanId", "10012")
                .queryParam("program", "PEAK_CASHCARD_WHITE_EUR")
                .queryParam("currencyId", "978")
                .queryParam("firstName", "PEAK")
                .queryParam("lastName", "TEST")
                .queryParam("rStreetLine1", "rStreetLine1")
                .queryParam("rStreetLine2", "rStreetLine2")
                .queryParam("rCity", "rCity")
                .queryParam("rState", "rState")
                .queryParam("rZip", "rZip")
                .queryParam("rCountryId", "840")
                .queryParam("mStreetLine1", "mStreetLine1")
                .queryParam("mStreetLine2", "mStreetLine2")
                .queryParam("mCity", "mCity")
                .queryParam("mState", "mState")
                .queryParam("mZip", "mZip")
                .queryParam("mCountryId", "840")
                .queryParam("cardHolderName", "cardHolderName")
                .queryParam("email", "dipocket3010+peak"+app.generateRandomNumber(4)+"@gmail.com")
                .queryParam("mainPhone", "38093"+app.generateRandomNumber(6)+"")
                .queryParam("dob", "1992-01-01")
                .queryParam("companyName", "companyName")
                .queryParam("idType", "ATIN")
                .queryParam("idNumber", "268715469")
                .queryParam("cardType", "PLASTIC")
                .queryParam("requestId", requestId)
                .when()
                .get("http://dipocket3.intranet:8092/PeakServices/v1/card/cardIssue");

                res.then().log().all()
                        .statusCode(200)
                        .body(containsString("publicToken"))
                        .body(containsString("pan"))
                        .body(containsString("expDate"))
                        .body(containsString("cvv"));

                publicToken = res.getBody().jsonPath().get("publicToken").toString();
                pan = res.getBody().jsonPath().get("pan").toString();
                pin = res.getBody().jsonPath().get("pin").toString();
                cvv = res.getBody().jsonPath().get("cvv").toString();
    }

    @Test(priority = 2)
    public void test_PeakServices_v1_card_activateCard(){
        given().log().uri().log().headers().log().body()
                .queryParam("requestId", requestId)
                .queryParam("publicToken", publicToken)
                .when()
                .get("http://dipocket3.intranet:8092/PeakServices/v1/card/activateCard")
                .then()
                .log().all()
                .statusCode(200)
                .body("cardStatus", equalTo("ACTIVE"));
    }
}
