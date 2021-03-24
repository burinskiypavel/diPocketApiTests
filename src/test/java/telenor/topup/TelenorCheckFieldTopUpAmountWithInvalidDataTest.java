package telenor.topup;

import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.login.auth_authenticate.AuthAuthenticate;
import model.telenor.login.clientDiPAccounts2.ClientDiPAccounts;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorCheckFieldTopUpAmountWithInvalidDataTest extends TestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);
    String cliSessionId = null;

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode(){
        System.out.println("smsCod:" + smsCode);
        Response res = given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.telenorLoginPhone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
    }

    @Test(priority = 2)
    public void test_WebServices_v1_auth_authenticate() {
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .header("site", app.telenorSite)
                .header("content-type", "application/json; charset=utf-8")
                .queryParam("value", "org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterResponse@7211c1e4")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();
        AuthAuthenticate authAuthenticate = res.as(AuthAuthenticate.class, ObjectMapperType.GSON);

        Assert.assertEquals(res.getStatusCode(), 200);
        app.getTelenorHelper().checkFieldsInTelenorAuthAuthenticateResponse(authAuthenticate);
    }

    @Test(priority = 3)
    public void test_WebServices_v1_account_clientDiPAccounts2(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/account/clientDiPAccounts2");
        res.then().log().all();
        ClientDiPAccounts clientDiPAccounts = res.as(ClientDiPAccounts.class, ObjectMapperType.GSON);

        Assert.assertEquals(res.getStatusCode(), 200);
        app.getTelenorHelper().checkAllFieldsFromTelenorClientDiPAccounts2Response(clientDiPAccounts);
    }

    @Test(priority = 4)
    public void test_WebServices_v1_account_tokenByCardId(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"value\" : \"14932\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/account/tokenByCardId");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.getBody().jsonPath().get("value"),equalTo("512047269"));
    }

    @Test(priority = 5)
    public void test_WebServices_v1_payment_topup(){
        given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"amount\" : -0.00,\n" +
                        "  \"ccy\" : \"HUF\"\n" +
                        "}\n")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/payment/topup")
                .then().log().all()
                .assertThat().statusCode(400)
                .assertThat().body("errCode", equalTo("-1"))
                .assertThat().body("errDesc", equalTo("Sorry, something went wrong - please try again"));
    }
}

