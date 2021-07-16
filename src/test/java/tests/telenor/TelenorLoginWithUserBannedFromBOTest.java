package tests.telenor;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TelenorLoginWithUserBannedFromBOTest extends TestBase {
    String smsCode = app.generateRandomNumber(6);
    String cliSessionId = null;

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode(){
        System.out.println("smsCod:" + smsCode);
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.bannedPhone+"\"\n" +
                        "}")
                .when()
                .post("/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void test_WebServices_v1_auth_authenticate() {
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginBannedPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();

        assertEquals(res.getStatusCode(), 200);
        app.getResponseValidationHelper().checkResponseHasItemWithValue(res, "stateId", -100);
    }

    @Test(priority = 3)
    public void test_WebServices_v1_account_clientDiPAccounts2(){
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginBannedPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .when()
                .get("/WebServices/v1/account/clientDiPAccounts2");
        res.then().log().all();

        assertEquals(res.getStatusCode(), 400);
        app.getResponseValidationHelper().checkResponseHasItemWithValue(res, "errCode", "DIP-00425");
    }
}