package telenor;

import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.cardOperation.unblockCard.clientDiPAccounts2.ClientDiPAccounts2UnblockCard;
import model.telenor.login.auth_authenticate.AuthAuthenticate;
import model.telenor.login.clientDiPAccounts2.ClientDiPAccounts;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TelenorUnblockCardTest extends TestBase {
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
                //.queryParam("value", "org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterResponse@7211c1e4")
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
        ClientDiPAccounts2UnblockCard clientDiPAccounts2UnblockCard = res.as(ClientDiPAccounts2UnblockCard.class, ObjectMapperType.GSON);

        Assert.assertEquals(res.getStatusCode(), 200);
        app.getTelenorHelper().checkAllFieldsFromTelenorClientDiPAccounts2ResponseUnblockCard(clientDiPAccounts2UnblockCard);
    }

    @Test(priority = 4)
    public void test_WebServices_v1_tile_messages(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/tile/messages");
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
        assertThat(res.getBody().jsonPath().get("unreadMessageCount"),equalTo(1));
    }

    @Test(priority = 5)
    public void test_WebServices_v1_account_plasticCardStatus(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"accountId\" : 9434\n" +
                        "}\n")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/account/plasticCardStatus");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        res.then().body("$", not(hasKey("status")));
    }

    @Test(priority = 6)
    public void test_WebServices_v1_account_canUnblockCard(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"accountId\" : 9434\n" +
                        "}\n")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/account/canUnblockCard");
        res.then().log().all();

        app.getResponseValidationHelper().checkResponseHasItemWithValue(res, "value", true);
        assertThat(res.getStatusCode(), equalTo(200));
    }

    @Test(priority = 7)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"secAnswer\" : \"QA\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/clientProfile/checkSecAnswAttempts");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.getBody().jsonPath().get("attemptsCount"),equalTo(0));
        assertThat(res.getBody().jsonPath().get("attemptsLeft"),equalTo(3));
    }

    @Test(priority = 8)
    public void test_WebServices_v1_account_unblockCard(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", "QA")
                .body("{\n" +
                        "  \"publicToken\" : \"512047269\",\n" +
                        "  \"accountId\" : 9434\n" +
                        "}\n")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/account/unblockCard");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
    }
}
