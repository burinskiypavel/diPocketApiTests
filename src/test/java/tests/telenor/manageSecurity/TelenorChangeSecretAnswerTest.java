package tests.telenor.manageSecurity;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.testng.Assert.assertEquals;

public class TelenorChangeSecretAnswerTest extends TestBase {
    String smsCode = app.generateRandomNumber(6);
    String cliSessionId = null;
    String  secAnswer = "QA";
    String  secAnswer2 = "qa";
    String offloadFundsLoginPhone =  "$5_" + app.offloadFundsPhone;

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode(){
        System.out.println("smsCod:" + smsCode);
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.offloadFundsPhone+"\"\n" +
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
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();

        assertEquals(res.getStatusCode(), 200);
        res.then().body("clientFirstName", equalTo("Test"),
                "clientLastName", equalTo("QA"),
                        "mainPhone", equalTo(app.offloadFundsPhone));
    }

    @Test(priority = 3)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"secAnswer\" : \""+secAnswer+"\"\n" +
                        "}")
                .when()
                .post("/WebServices/v1/clientProfile/checkSecAnswAttempts")
                .then()
                .log().all()
                .statusCode(200)
                .body("attemptsCount", equalTo(0),
                        "attemptsLeft", equalTo(3));
    }

    @Test(priority = 4)
    public void test_WebServices_v1_clientProfile_updateAnswer(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", secAnswer)
                .body("{\n" +
                        "  \"secQuestion\" : \"QA\",\n" +
                        "  \"secAnswer\" : \""+secAnswer2+"\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/clientProfile/updateAnswer")
                .then()
                .log().all()
                .statusCode(200)
                .body(blankOrNullString());
    }

    @Test(priority = 5)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts_(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"secAnswer\" : \""+secAnswer2+"\"\n" +
                        "}")
                .when()
                .post("/WebServices/v1/clientProfile/checkSecAnswAttempts")
                .then()
                .log().all()
                .statusCode(200)
                .body("attemptsCount", equalTo(0),
                        "attemptsLeft", equalTo(3));
    }

    @Test(priority = 6)
    public void test_WebServices_v1_clientProfile_updateAnswer_(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", secAnswer2)
                .body("{\n" +
                        "  \"secQuestion\" : \"QA\",\n" +
                        "  \"secAnswer\" : \""+secAnswer+"\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/clientProfile/updateAnswer")
                .then()
                .log().all()
                .statusCode(200)
                .body(blankOrNullString());
    }
}