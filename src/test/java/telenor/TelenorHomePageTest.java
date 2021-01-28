package telenor;

import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.auth_authenticate.AuthAuthenticate;
import model.telenor.clientDiPAccounts2.Accountt;
import model.telenor.clientDiPAccounts2.ClientDiPAccounts;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorHomePageTest extends TestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);
    String cliSessionId = null;
    String basic = null;
    String basicAuthorization = null;
    String loginPhone = "$5_380685448615";

    @Test(priority = 1)
    public void test_WebServices_v1_security_sendOtpForPhone(){
        Response res = given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .queryParam("value", "com.cs.dipocketback.pojo.telenor.TelenorRequest@3704980d")
                .body("{\n" +
                        "  \"phoneNumber\" : \"380685448615\"\n" +
                        "}")
                .when()
                .post("https://dipocket3.intranet:8900/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"");
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
                .auth().preemptive().basic(loginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                //.header("authorization", basicAuthorization)
                .header("site", app.telenorSite)
                .header("content-type", "application/json; charset=utf-8")
                .queryParam("value", "org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterResponse@7211c1e4")
                .when()
                .post("https://dipocket3.intranet:8900/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();
        int StatusCode = res.getStatusCode();
        Assert.assertEquals(StatusCode, 200);

        AuthAuthenticate authAuthenticate = res.as(AuthAuthenticate.class, ObjectMapperType.GSON);
        assertThat(authAuthenticate.getId(), equalTo(30943));
        assertThat(authAuthenticate.getClientFirstName(), equalTo("Pavel"));
        assertThat(authAuthenticate.getClientLastName(), equalTo("Test"));
    }

    @Test(priority = 3)
    public void test_WebServices_v1_account_clientDiPAccounts2(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get("https://dipocket3.intranet:8900/WebServices/v1/account/clientDiPAccounts2");
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(), 200);

        ClientDiPAccounts clientDiPAccounts = res.as(ClientDiPAccounts.class, ObjectMapperType.GSON);
        SoftAssert softAssert = new SoftAssert();
        List<Accountt> accounts = clientDiPAccounts.getAccounts();
        for(Accountt accountt : accounts) {
            assertThat(accountt.getAccountId(), equalTo(9434));
            assertThat(accountt.getAccountName(), equalTo("Band 512047269"));
            softAssert.assertEquals(accountt.getCcy(), "HUF");
            assertThat(accountt.getCcyId(), equalTo(348));
            assertThat(accountt.getBalance(), equalTo(200000));
            assertThat(accountt.getAvailableBalance(), equalTo(200000));
            assertThat(accountt.getBlocked(), equalTo(0));
            assertThat(accountt.getPlasticCardId(), equalTo(14932));
            assertThat(accountt.getPlasticMaskedPan(), equalTo("545598******6620"));
            softAssert.assertTrue(accountt.getMain().equals(true), "Main is not true");
            assertThat(accountt.getIsDefault(), equalTo(true));
            assertThat(accountt.getOwn(), equalTo(true));
            assertThat(accountt.getShared(), equalTo(false));
            assertThat(accountt.getCanOpenVirtualCard(), equalTo(true));
            assertThat(accountt.getCanOpenPlasticCard(), equalTo(false));
            assertThat(accountt.getIsMyShared(), equalTo(false));
            assertThat(accountt.getIsSupervised(), equalTo(false));
            assertThat(accountt.getOwnerId(), equalTo(30943));
            assertThat(accountt.getState(), equalTo("ACTIVE"));
            assertThat(accountt.getCanReorderVirtual(), equalTo(false));
            assertThat(accountt.getCanReorderPlastic(), equalTo(false));
            assertThat(accountt.getPlasticCardStatus(), equalTo("ACTIVE"));
            assertThat(accountt.getCanUnblockPlasticCard(), equalTo(false));
            assertThat(accountt.getCanLinkPlastic(), equalTo(false));
            assertThat(accountt.getCanUnblockVirtualCard(), equalTo(false));
        }
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_WebServices_v1_tile_messages(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get("https://dipocket3.intranet:8900/WebServices/v1/tile/messages");
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(), 200);
        assertThat(res.getBody().jsonPath().get("unreadMessageCount"),equalTo(1));
    }

    @Test(priority = 5)
    public void test_WebServices_v1_account_tokenByCardId(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(loginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"value\" : \"14932\"\n" +
                        "}")
                .when()
                .post("https://dipocket3.intranet:8900/WebServices/v1/account/tokenByCardId");
        res.then().log().all();
        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.getBody().jsonPath().get("value"),equalTo("512047269"));
    }
}