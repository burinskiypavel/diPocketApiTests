package tests.telenor.manageSecurity;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TelenorWrongSecretAnswerTest extends TestBase {
    String smsCode = "111111"; // app.generateRandomNumber(6);
    String cliSessionId = null;

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode(){
        System.out.println("smsCod:" + smsCode);
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.telenorRegistrationPhone+"\"\n" +
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
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();

        assertEquals(res.getStatusCode(), 200);
        res.then().assertThat().body("clientFirstName", equalTo("Pavel"));
        res.then().assertThat().body("clientLastName", equalTo("TestQA"));
        res.then().assertThat().body("mainPhone", equalTo("380980316499"));
    }

    @Test(priority = 3)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"secAnswer\" : \"QA\"\n" +
                        "}")
                .when()
                .post("/WebServices/v1/clientProfile/checkSecAnswAttempts")
                .then()
                .log().all()
                .statusCode(200)
                .body("attemptsCount", equalTo(0))
                .body("attemptsLeft", equalTo(3));
    }

    @Test(priority = 4)
    public void test_WebServices_v1_auth_unblockClient(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", "test")
                .body("")
                .when()
                .post("/WebServices/v1/auth/unblockClient")
                .then()
                .log().all()
                .statusCode(400)
                .body("errCode", equalTo("-1"))
                .body("errDesc", equalTo("Wrong Secret Answer"));
    }
}
