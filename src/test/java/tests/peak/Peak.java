package tests.peak;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Peak extends TestBase {
    String publicToken = null;
    String pan = null;
    String pin = null;
    String cvv = null;

    @Test(priority = 1)
    public void test_PeakServices_v1_card_cardIssue(){
        given().log().uri().log().headers()
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
                .queryParam("requestId", "6613ba7c-bbe6-434c-a5fe-3790cb51069f")
                .when()
                .get("http://dipocket3.intranet:8092/PeakServices/v1/card/cardIssue")
                .then().log().all()
                .statusCode(200)
                .body(containsString("publicToken"))
                .body(containsString("pan"))
                .body(containsString("pin"))
                .body(containsString("expDate"))
                .body(containsString("cvv"));
    }
}
