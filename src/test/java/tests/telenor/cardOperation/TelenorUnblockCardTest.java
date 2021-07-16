package tests.telenor.cardOperation;

import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.cardOperation.unblockCard.clientDiPAccounts2.ClientDiPAccounts2UnblockCard;
import model.telenor.login.auth_authenticate.AuthAuthenticate;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class TelenorUnblockCardTest extends TestBase {
    String smsCode = app.generateRandomNumber(6);
    String cliSessionId = null;
    String secretAnswer = "QA";

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
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();
        AuthAuthenticate authAuthenticate = res.as(AuthAuthenticate.class, ObjectMapperType.GSON);

        assertEquals(res.getStatusCode(), 200);
        app.getTelenorHelper().checkFieldsInTelenorAuthAuthenticateResponse(authAuthenticate);
    }

    @Test(priority = 3)
    public void test_WebServices_v1_account_clientDiPAccounts2(){
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .when()
                .get("/WebServices/v1/account/clientDiPAccounts2");
        res.then().log().all();
        ClientDiPAccounts2UnblockCard clientDiPAccounts2UnblockCard = res.as(ClientDiPAccounts2UnblockCard.class, ObjectMapperType.GSON);

        assertEquals(res.getStatusCode(), 200);
        app.getTelenorHelper().checkAllFieldsFromTelenorClientDiPAccounts2ResponseUnblockCard(clientDiPAccounts2UnblockCard);
    }

    @Test(priority = 4)
    public void test_WebServices_v1_tile_messages(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .when()
                .get("/WebServices/v1/tile/messages")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void test_WebServices_v1_account_plasticCardStatus(){
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"accountId\" : 9434\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/account/plasticCardStatus");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        res.then().body("$", not(hasKey("status")));
    }

    @Test(priority = 6)
    public void test_WebServices_v1_account_canUnblockCard(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"accountId\" : 9434\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/account/canUnblockCard")
                .then()
                .log().all()
                .statusCode(200)
                .body("value", equalTo(true));
    }

    @Test(priority = 7)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts(){
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"secAnswer\" : \""+secretAnswer+"\"\n" +
                        "}")
                .when()
                .post("/WebServices/v1/clientProfile/checkSecAnswAttempts");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.path("attemptsCount"),equalTo(0));
        assertThat(res.path("attemptsLeft"),equalTo(3));
    }

    @Test(priority = 8)
    public void test_WebServices_v1_account_unblockCard(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", secretAnswer)
                .body("{\n" +
                        "  \"publicToken\" : \"512047269\",\n" +
                        "  \"accountId\" : 9434\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/account/unblockCard")
                .then()
                .log().all()
                .statusCode(200);
    }
}
