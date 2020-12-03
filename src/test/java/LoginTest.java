import Config.Properties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class LoginTest  extends BaseTest{
    String cliSessionId = null;

    @BeforeTest
    public void setUp(){
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_node_1(){
        given()
                .header("deviceuuid", "eGy9q-lDQBGKz-bgdz1U6q")
                .header("site", Properties.site)
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1OjI0Njc0MA==")
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"eGy9q-lDQBGKz-bgdz1U6q\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post( Properties.devUrl+"homePage/authenticateMobileApp?value=com.cs.dipocketback.pojo.push.DeviceInfo@3f3e6bbe")
                .then()
                .statusCode(400)
                .body("errCode", equalTo("DIP-00591"))
                .log().all();
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_node_2() throws SQLException, ClassNotFoundException {
        String loginSMSCode = getLoginSMSFromDB("380685448615");
        Response res =  given()
                .header("deviceuuid", "eGy9q-lDQBGKz-bgdz1U6q")
                .header("site", Properties.site)
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1OjI0Njc0MA==")
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"eGy9q-lDQBGKz-bgdz1U6q\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( Properties.devUrl+"homePage/authenticateMobileApp?value=com.cs.dipocketback.pojo.push.DeviceInfo@3f3e6bbe");
//                .then()
//                .statusCode(200)
//                .log().all();
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        Assert.assertEquals(StatusCode, 200);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2(){
        given()
                .header("deviceuuid", "eGy9q-lDQBGKz-bgdz1U6q")
                .header("site", Properties.site)
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1OjI0Njc0MA==")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"clientProfile/clientInfo2")
                .then()
                .statusCode(200)
                .body("clientFirstName", equalTo("Pavel"))
                .body("clientLastName", equalTo("Burinsky"))
                .log().all();
    }

    @Test(priority = 4)
    public void test_ClientServices_v1_ClientProfile_ClientConfig(){
        given()
                .header("deviceuuid", "eGy9q-lDQBGKz-bgdz1U6q")
                .header("site", Properties.site)
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1OjI0Njc0MA==")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"clientProfile/clientConfig")
                .then()
                .statusCode(200)
                .body("payeeCurrencyHash", notNullValue())
                .body("payeePaymentTypeHash", notNullValue())
                .body("bankTransferReasonHash", notNullValue())
                .body("avlCurrencyForNewAccHash", notNullValue())
                .body("dipTransferCurrencyHash", notNullValue())
                .body("availCategoriesHash", notNullValue())
                .log().all();
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_accounts_ClientDipAccounts2(){
        given()
                .header("deviceuuid", "eGy9q-lDQBGKz-bgdz1U6q")
                .header("site", Properties.site)
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1OjI0Njc0MA==")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"accounts/clientDiPAccounts2?walletId=null")
                .then()
                .statusCode(200)
                .body("accounts.state", equalTo(Arrays.asList("ACTIVE")))
                .body("accounts.ccy", equalTo(Arrays.asList("PLN")))
                .log().all();
    }

    @Test(enabled = false)//already exists
    public void test_ClientServices_v1_references_AppConfig(){
        given()
                .header("deviceuuid", "eGy9q-lDQBGKz-bgdz1U6q")
                .header("site", Properties.site)
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1OjI0Njc0MA==")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"references/appConfig?platform=android&version=2.2.7&langCode=ukr")
                .then()
                .statusCode(200)
                .body("queryValidator", equalTo("b28f29ba8c1d5ddf7545d74b58c9fdfb58027f2cd2d30615f39950d5d138cba7"))
                .body("countryHash", notNullValue())
                .body("langHash", notNullValue())
                .body("topCountriesHash", notNullValue())
                .log().all();
    }

    @Test(priority = 6)
    public void test_ClientServices_v1_tile_getMessage2(){
        given()
                .header("deviceuuid", "eGy9q-lDQBGKz-bgdz1U6q")
                .header("site", Properties.site)
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1OjI0Njc0MA==")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"tile/getMessages2")
                .then()
                .statusCode(200)
                .body("communicationTileList.shortName", equalTo(Arrays.asList("Подтвердить email")))
                .log().all();
    }

}
