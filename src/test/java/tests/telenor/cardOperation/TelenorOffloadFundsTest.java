package tests.telenor.cardOperation;

import base.TestBase;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.telenor.login.auth_authenticate.AuthAuthenticate;
import model.telenor.login.clientDiPAccounts2.ClientDiPAccounts;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.testng.Assert.assertEquals;

public class TelenorOffloadFundsTest extends TestBase {
    String smsCode = app.generateRandomNumber(6);
    String cliSessionId = null;
    String offloadFundsLoginPhone =  "$5_" + app.offloadFundsPhone;

    @Test(priority = 1)
    public void test_CustomerServicesDev_v1_card_cashLoad() throws SQLException, ClassNotFoundException {
        app.getDbHelper().activateClientFromDBTelenor(app.offloadFundsPhone);
        given().log().uri().log().headers().log().body()
                .contentType("application/json")
                .header("Authorization", "Basic SEVMTE9QQVk6U2RPQzVFTg==")
                //.header("Cookie", "JSESSIONID=35F0E0127DE81C5496D1CBEEF23E05E4")
                .body("{\n" +
                        "    \"requestId\":  \""+app.generateRandomString(8)+"-9b6d-4005-"+app.generateRandomString(12)+"\",\n" +
                        "    \"token\": \"512166950\",\n" +
                        "    \"amount\":  200000,\n" +
                        "    \"currencyCode\":  \"HUF\",\n" +
                        "    \"note\":  \"200000 форинтов\"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/CustomerServicesDev/v1/card/cashLoad")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
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

    @Test(priority = 3)
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
        AuthAuthenticate authAuthenticate = res.as(AuthAuthenticate.class, ObjectMapperType.GSON);

        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void test_WebServices_v1_account_clientDiPAccounts2(){
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .when()
                .get("/WebServices/v1/account/clientDiPAccounts2");
        res.then().log().all();
        ClientDiPAccounts clientDiPAccounts = res.as(ClientDiPAccounts.class, ObjectMapperType.GSON);

        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void test_WebServices_v1_account_tokenByCardId(){
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"value\" : \"14630\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/account/tokenByCardId");
        res.then().log().all();

        assertEquals(res.getStatusCode(), 200);
        assertThat(res.path("value"),equalTo("512166950"));
    }

    @Test(priority = 6)
    public void test_WebServices_v1_payment_calcBankTransfer(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"trnCcy\" : \"HUF\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/payment/calcBankTransfer")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("trnCcy", equalTo("HUF"));
    }

    @Test(priority = 7)
    public void test_WebServices_v1_payment_doBankTransfer(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"trnCcy\" : \"HUF\",\n" +
                        "  \"trnAmount\" : 200000,\n" +
                        "  \"feeCcy\" : \"HUF\",\n" +
                        "  \"feeAmount\" : 0,\n" +
                        "  \"firstName\" : \"Test\",\n" +
                        "  \"lastName\" : \"QA\",\n" +
                        "  \"accountNo\" : \"123111111111111111111111\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/payment/doBankTransfer")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(blankOrNullString());
    }

    @Test(priority = 8)
    public void checkSTATEIDFromDB() throws SQLException, ClassNotFoundException {
        String stateId = app.getDbHelper().getTelenorStateIdFromDB();
        assertThat(stateId, equalTo("0"));
    }
}
