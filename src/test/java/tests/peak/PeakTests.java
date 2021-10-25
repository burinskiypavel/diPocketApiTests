package tests.peak;

import base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PeakTests extends TestBase {
    String requestId = "6513ba7c-bbe6-534c-a4fe-"+app.generateRandomString(12)+"";
    String currencyId = "978";
    String publicToken = null;
    String pan = null;
    String pin = null;
    String cvv = null;
    String detailsRef = null;

    @Test(priority = 1)
    public void test_PeakServices_v1_card_cardIssue(){
        baseURI = "http://dipocket3.intranet:8092/";
        Response res =  given().log().uri().log().headers()
                .queryParam("lang", "en")
                .queryParam("ddStatus", "SDD")
                .queryParam("feeTarifPlanId", "10012")
                .queryParam("program", "PEAK_CASHCARD_WHITE_EUR")
                .queryParam("currencyId", currencyId)
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
                .get("PeakServices/v1/card/cardIssue");

                res.then().log().all()
                        .statusCode(200)
                        .body(
                                 containsString("publicToken")
                                ,containsString("pan")
                                ,containsString("expDate")
                                ,containsString("cvv"));

                publicToken = res.getBody().jsonPath().get("publicToken").toString();
                pan = res.getBody().jsonPath().get("pan").toString();
                pin = res.getBody().jsonPath().get("pin").toString();
                cvv = res.getBody().jsonPath().get("cvv").toString();
    }

    @Test(priority = 2)
    public void test_PeakServices_v1_card_activateCard(){
        given().log().uri().log().headers()
                .queryParam("requestId", requestId)
                .queryParam("publicToken", publicToken)
                .when()
                .get("PeakServices/v1/card/activateCard")
                .then()
                .log().all()
                .statusCode(200)
                .body("cardStatus", equalTo("ACTIVE"));
    }

    @Test(priority = 3)
    public void test_PeakServices_v1_card_setPin(){
        given().log().uri().log().headers().log().body()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"requestId\":  \""+requestId+"\",\n" +
                        "    \"publicToken\":  \""+publicToken+"\",\n" +
                        "    \"pin\":  \"0007\"\n" +
                        "}")
                .when()
                .post("PeakServices/v1/card/setPin")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_PeakServices_v1_card_pinReveal(){
        given().log().uri().log().headers()
                .queryParam("publicToken", publicToken)
                .queryParam("cvv", cvv)
                .when()
                .get("PeakServices/v1/card/pinReveal")
                .then()
                .log().all()
                .statusCode(200)
                .body("pin", equalTo("0007"));
    }

    @Test(priority = 5)
    public void test_PeakServices_v1_card_updateCardholder(){
        given().log().uri().log().headers()
                .queryParam("publicToken", publicToken)
                .queryParam("firstName", "firstName")
                .when()
                .get("PeakServices/v1/card/updateCardholder")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void test_PeakServices_v1_card_depositToCard(){
        given().log().uri().log().headers()
                .queryParam("requestId", "4f48912e-412e-30ca-a75d-"+app.generateRandomString(12)+"")
                .queryParam("publicTokenTo", publicToken)
                .queryParam("currencyId", currencyId)
                .queryParam("amount", "15")
                .queryParam("note", "description")
                .when()
                .get("PeakServices/v1/card/depositToCard")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void test_PeakServices_v1_card_cardToCardTransfer(){
        given().log().uri().log().headers()
                .queryParam("requestId", "37e7fa96-9087-41c3-90d0-"+app.generateRandomString(12)+"")
                .queryParam("publicTokenFrom", "352299423")
                .queryParam("currencyId", currencyId)
                .queryParam("amount", "1")
                .queryParam("note", "description")
                .queryParam("publicTokenTo", "352307110")
                .when()
                .get("PeakServices/v1/card/cardToCardTransfer")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 8)
    public void test_PeakServices_v1_card_transactionList(){
        Response res = given().log().uri().log().headers()
                .queryParam("publicToken", publicToken)
                .when()
                .get("PeakServices/v1/card/transactionList");

        res.then().log().all()
                .statusCode(200)
                .body(
                         containsString("account")
                        ,containsString("availableBalance")
                        ,containsString("financeBalance"));

        detailsRef = res.getBody().jsonPath().get("transactions.detailsRef").toString();
    }

    @Test(priority = 9)
    public void test_PeakServices_v1_card_transactionDetails(){
        String resultDetailsRef = detailsRef.substring(1, 16);
        given().log().uri().log().headers()
                .queryParam("detailsRef", resultDetailsRef)
                .when()
                .get("PeakServices/v1/card/transactionDetails")
                .then()
                .log().all()
                .statusCode(200)
                .body(containsString("accCurrencyCode"),
                containsString("accAmount"),
                containsString("stateId"));
    }

    @Test(priority = 10)
    public void test_PeakServices_v1_card_blockCard(){
        given().log().uri().log().headers()
                .queryParam("requestId", requestId)
                .queryParam("publicToken", publicToken)
                .queryParam("reason", "LOST")
                .when()
                .get("PeakServices/v1/card/blockCard")
                .then()
                .log().all()
                .statusCode(200)
                .body("cardStatus", equalTo("LOST"));
    }

    @Test(priority = 11)
    public void test_PeakServices_v1_card_cardInquiry(){
        given().log().uri().log().headers()
                .queryParam("publicToken", publicToken)
                .when()
                .get("PeakServices/v1/card/cardInquiry")
                .then()
                .log().all()
                .statusCode(200)
                .body(containsString("cardStatus")
                        ,containsString("LOST")
                        ,containsString("publicToken")
                        ,containsString("ddStatus")
                        ,containsString("firstName"));
    }

    @Test(priority = 12)
    public void test_PeakServices_v1_card_unblockCard(){
        given().log().uri().log().headers()
                .queryParam("publicToken", publicToken)
                .when()
                .get("PeakServices/v1/card/unblockCard")
                .then()
                .log().all()
                .statusCode(200)
                .body("cardStatus", equalTo("ACTIVE"));
    }
}