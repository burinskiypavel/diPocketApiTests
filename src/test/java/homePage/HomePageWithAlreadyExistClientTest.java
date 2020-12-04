package homePage;

import base.BaseTest;
import config.Properties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class HomePageWithAlreadyExistClientTest extends BaseTest {
    String cliSessionId = null;
    static java.util.Properties prop = new java.util.Properties();

    @BeforeClass
    public void start() throws SQLException, ClassNotFoundException {
        deleteClientDeviceFromDB("380980316499-AutoTest-Login");
        prop = loadDataFromConfigFile();
    }

    @BeforeTest
    public void setUp(){
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test(priority = 18)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp(){
        given()
                .header("deviceuuid", Properties.deviceuuid3)
                .header("site", Properties.site)
                .header("authorization", Properties.authorizationBasic2)
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+Properties.deviceuuid3+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post( Properties.devUrl+"homePage/authenticateMobileApp?value=com.cs.dipocketback.pojo.push.DeviceInfo@3f3e6bbe")
                .then()
                .statusCode(400)
                .body("errCode", equalTo("DIP-00591"))
                .log().all();
    }

    @Test(priority = 19)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {

        String loginSMSCode = getLoginSMSFromDB("380980316499", Properties.deviceuuid3);
        Response res =  given()
                .header("deviceuuid", Properties.deviceuuid3)
                .header("site", Properties.site)
                .header("authorization", Properties.authorizationBasic2)
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+Properties.deviceuuid3+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( Properties.devUrl+"homePage/authenticateMobileApp?value=com.cs.dipocketback.pojo.push.DeviceInfo@3f3e6bbe");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        Assert.assertEquals(StatusCode, 200);
    }

    @Test(priority = 20)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2(){
        given()
                .header("deviceuuid", Properties.deviceuuid3)
                .header("site", Properties.site)
                .header("authorization", Properties.authorizationBasic2)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"clientProfile/clientInfo2")
                .then()
                .statusCode(200)
                .body("clientFirstName", equalTo("Pavel"))
                .body("clientLastName", equalTo("Burinsky"))
                .log().all();
    }

    @Test(priority = 21)
    public void test_ClientServices_v1_ClientProfile_ClientConfig(){
        given()
                .header("deviceuuid", Properties.deviceuuid3)
                .header("site", Properties.site)
                .header("authorization", Properties.authorizationBasic2)
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

    @Test(priority = 22)
    public void test_ClientServices_v1_accounts_ClientDipAccounts2(){
        given()
                .header("deviceuuid", Properties.deviceuuid3)
                .header("site", Properties.site)
                .header("authorization", Properties.authorizationBasic2)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"accounts/clientDiPAccounts2?walletId=null")
                .then()
                .statusCode(200)
                .body("accounts.state", equalTo(Arrays.asList("ACTIVE")))
                .body("accounts.ccy", equalTo(Arrays.asList("PLN")))
                .log().all();
    }

    @Test(priority = 23)
    public void test_ClientServices_v1_tile_getMessage2(){
        given()
                .header("deviceuuid", Properties.deviceuuid3)
                .header("site", Properties.site)
                .header("authorization", Properties.authorizationBasic2)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(Properties.devUrl+"tile/getMessages2")
                .then()
                .statusCode(200)
                .body("unreadMessageCount", equalTo(0))
                .log().all();
    }

}
