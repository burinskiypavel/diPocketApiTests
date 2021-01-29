package telenor;

import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.auth_authenticate.AuthAuthenticate;
import model.telenor.clientDiPAccounts2.ClientDiPAccounts;
import model.telenor.clientImages.Image;
import model.telenor.clientInfo.ClientInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorHomePageTest extends TestBase {
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
//        basic = "$5_380685448615:" + smsCode;
//
//        // Encode data on your side using BASE64
//        byte[] bytesEncoded = Base64.encodeBase64(basic.getBytes());
//        System.out.println("encoded value is " + new String(bytesEncoded));
//
//        basicAuthorization = "Basic " + new String(bytesEncoded);
//        System.out.println(basicAuthorization);

        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                //.header("authorization", basicAuthorization)
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

    @Test(priority = 6)
    public void test_WebServices_v1_clientProfile_clientImages(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/clientProfile/clientImages");
        res.then().log().all();
        Image[] images = res.as(Image[].class);

        assertThat(res.getStatusCode(), equalTo(200));
        app.getTelenorHelper().checkAllFieldsOfTelenorClientImagesResponse(images);
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
    public void test_WebServices_v1_clientProfile_clientInfo(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/clientProfile/clientInfo");
        res.then().log().all();
        ClientInfo clientInfo = res.as(ClientInfo.class);

        assertThat(res.getStatusCode(), equalTo(200));
        app.getTelenorHelper().checkAllRowsOfTelenorClientInfoResponse(clientInfo);
    }
}