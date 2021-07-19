package tests.telenor.topup;

import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.login.auth_authenticate.AuthAuthenticate;
import model.telenor.login.clientDiPAccounts2.ClientDiPAccounts;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TelenorCheckFieldTopUpAmountWithInvalidDataTest extends TestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);
    String cliSessionId = null;

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
                .accept("application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
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
        ClientDiPAccounts clientDiPAccounts = res.as(ClientDiPAccounts.class, ObjectMapperType.GSON);

        assertEquals(res.getStatusCode(), 200);
        app.getTelenorHelper().checkAllFieldsFromTelenorClientDiPAccounts2Response(clientDiPAccounts);
    }

    @Test(priority = 4)
    public void test_WebServices_v1_account_tokenByCardId(){
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"value\" : \"14932\"\n" +
                        "}")
                .when()
                .post("/WebServices/v1/account/tokenByCardId");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.path("value"),equalTo("512047269"));
    }

    @Test(priority = 5)
    public void test_WebServices_v1_payment_topup(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"amount\" : -0.00,\n" +
                        "  \"ccy\" : \"HUF\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/payment/topup")
                .then()
                .log().all()
                .statusCode(400)
                .body("errCode", equalTo("-1"))
                .body("errDesc", equalTo("Sorry, something went wrong - please try again"));
    }
}

