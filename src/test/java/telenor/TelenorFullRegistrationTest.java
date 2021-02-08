package telenor;

import appmanager.TelenorHelper;
import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.login.auth_authenticate.AuthAuthenticate;
import model.telenor.login.clientDiPAccounts2.ClientDiPAccounts;
import model.telenor.login.clientInfo.ClientInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorFullRegistrationTest extends TestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);
    String cliSessionId = null;
    int plasticCardId = 0;

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode(){
        System.out.println("smsCod:" + smsCode);
        Response res = given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.telenorRegistrationPhone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
    }

    @Test(priority = 2)
    public void test_WebServices_v1_auth_authenticate() {
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .header("site", app.telenorSite)
                .header("content-type", "application/json; charset=utf-8")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();
        AuthAuthenticate authAuthenticate = res.as(AuthAuthenticate.class, ObjectMapperType.GSON);

        Assert.assertEquals(res.getStatusCode(), 200);
        app.getTelenorHelper().checkFieldsInTelenorFullRegAuthAuthenticateResponse(authAuthenticate);
    }

    @Test(priority = 3)
    public void test_WebServices_v1_tile_messages(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/tile/messages");
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
        assertThat(res.getBody().jsonPath().get("communicationTileList[0].message"), hasItem("When you have a minute please complete your registration by making selfies and scanning your documents - you will enjoy the full benefits of application.  Please answer the secret question to proceed (case sensitive)"));
        assertThat(res.getBody().jsonPath().get("communicationTileList[0].shortName"), equalTo("Registration"));
    }

    @Test(priority = 4)
    public void test_WebServices_v1_clientProfile_clientImages(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/clientProfile/clientImages");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.getBody().jsonPath().get(""), equalTo(nullValue()));
    }

    @Test(priority = 5)
    public void test_WebServices_v1_account_clientDiPAccounts2(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/account/clientDiPAccounts2");
        res.then().log().all();
        ClientDiPAccounts clientDiPAccounts = res.as(ClientDiPAccounts.class, ObjectMapperType.GSON);

        Assert.assertEquals(res.getStatusCode(), 200);
        plasticCardId = app.getTelenorHelper().getPlasticCardIdFromTelenorClientDiPAccounts2Response(clientDiPAccounts);
    }

    @Test(priority = 6)
    public void test_WebServices_v1_account_tokenByCardId(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"value\" : \""+plasticCardId+"\"\n" + //14656
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/account/tokenByCardId");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.getBody().jsonPath().get("value"),notNullValue());
    }

    @Test(priority = 7)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
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
    public void test_WebServices_v1_clientProfile_updateSelfie() throws IOException {
        String base64Selfie1 = TelenorHelper.readFileReturnString("files/telenor/fullRegistration/base64Selfie1.txt");
        String base64Selfie2 = TelenorHelper.readFileReturnString("files/telenor/fullRegistration/base64Selfie2.txt");
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", "QA")
                .body("{\n" +
                        "  \"base64Selfie1\" : \""+base64Selfie1+"\",\n" +
                        "  \"base64Selfie2\" : \""+base64Selfie2+"\"\n" +
                        "}\n")

                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/clientProfile/updateSelfie");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
    }

    @Test(priority = 9)
    public void test_WebServices_v1_clientProfile_saveDocuments() throws IOException {
        String photoID = TelenorHelper.readFileReturnString("files/telenor/fullRegistration/base64Selfie1.txt");
        String proofOfAddress = TelenorHelper.readFileReturnString("files/telenor/fullRegistration/base64Selfie2.txt");
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", "QA")
                .body("{\n" +
                        "  \"photoID\" : \""+photoID+"\",\n" +
                        "  \"proofOfAddress\" : \""+proofOfAddress+"\",\n" +
                        "  \"savePhotoIDBack\" : false,\n" +
                        "  \"saveProofOfAddress\" : true\n" +
                        "}\n")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/clientProfile/saveDocuments");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
    }

    @Test(priority = 10)
    public void test_WebServices_v1_clientProfile_clientInfo(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/clientProfile/clientInfo");
        res.then().log().all();
        ClientInfo clientInfo = res.as(ClientInfo.class);

        app.getResponseValidationHelper().checkStatusCodeIs200(res);
        app.getTelenorHelper().checkAllRowsInTelenorFullRegClientInfoResponse(clientInfo);
    }

    @Test(priority = 11)
    public void test_WebServices_v1_tile_messages_(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/tile/messages");
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
        assertThat(res.getBody().jsonPath().get("communicationTileList[0]"),equalTo(null));
        assertThat(res.getBody().jsonPath().get("unreadMessageCount."),equalTo(1));
    }

    @Test(priority = 12)
    public void test_WebServices_v1_clientProfile_clientImages_(){
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .get(app.dipocket3_intranet+"/WebServices/v1/clientProfile/clientImages");
        res.then().log().all();

        assertThat(res.getStatusCode(), equalTo(200));
        assertThat(res.getBody().jsonPath().get("imageType"), hasItems("SELFIE", "PHOTOID", "PROOFOFADDRESS", "SELFIE2"));
        assertThat(res.getBody().jsonPath().get("base64Image"), hasItems(notNullValue()));
        assertThat(res.getBody().jsonPath().get("imageState"), hasItems("NEW"));
    }
}
