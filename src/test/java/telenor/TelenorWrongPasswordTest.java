package telenor;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TelenorWrongPasswordTest extends TestBase {
    String smsCode = app.generateRandomNumber(6);
    String wrongSmsCode = "111111";

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode(){
        System.out.println("smsCod:" + smsCode);
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.telenorLoginPhone+"\"\n" +
                        "}")
                .when()
                .post("/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void test_WebServices_v1_auth_authenticate() {
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, wrongSmsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("/WebServices/v1/auth/authenticate")
                .then()
                .log().all()
                .statusCode(401);
    }
}
