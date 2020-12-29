package homePage;

import config.Properties;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class HomePageTest extends BaseTest {
    String cliSessionId = null;

    @Test(priority = 18)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp(){
        given()
                .header("deviceuuid", Properties.deviceuuid2)
                .header("site", prop.getProperty("mobile.site"))
                .header("authorization", Properties.authorizationBasic)
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+Properties.deviceuuid2+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post( prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp?value=com.cs.dipocketback.pojo.push.DeviceInfo@3f3e6bbe")
                .then()
                .statusCode(400)
                .body("errCode", equalTo("DIP-00591"))
                .log().all();
    }

    @Test(priority = 19)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {
        String loginSMSCode = getLoginSMSFromDB("380685448615", Properties.deviceuuid2);
        Response res =  given()
                .header("deviceuuid", Properties.deviceuuid2)
                .header("site", prop.getProperty("mobile.site"))
                .header("authorization", Properties.authorizationBasic)
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+Properties.deviceuuid2+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp?value=com.cs.dipocketback.pojo.push.DeviceInfo@3f3e6bbe");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        Assert.assertEquals(StatusCode, 200);
    }

    @Test(priority = 20)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2(){
        given()
                .header("deviceuuid", Properties.deviceuuid2)
                .header("site", prop.getProperty("mobile.site"))
                .header("authorization", Properties.authorizationBasic)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(prop.getProperty("mobile.base.url")+"clientProfile/clientInfo2")
                .then()
                .statusCode(200)
                .body("clientFirstName", equalTo("Pavel"))
                .body("clientLastName", equalTo("Burinsky"))
                .log().all();
    }

    @Test(priority = 21)
    public void test_ClientServices_v1_ClientProfile_ClientConfig(){
        given()
                .header("deviceuuid", Properties.deviceuuid2)
                .header("site", prop.getProperty("mobile.site"))
                .header("authorization", Properties.authorizationBasic)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(prop.getProperty("mobile.base.url")+"clientProfile/clientConfig")
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
                .header("deviceuuid", Properties.deviceuuid2)
                .header("site", prop.getProperty("mobile.site"))
                .header("authorization", Properties.authorizationBasic)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(prop.getProperty("mobile.base.url")+"accounts/clientDiPAccounts2?walletId=null")
                .then()
                .statusCode(200)
                .body("accounts.state", equalTo(Arrays.asList("ACTIVE")))
                .body("accounts.ccy", equalTo(Arrays.asList("PLN")))
                .log().all();
    }

    @Test(priority = 23)
    public void test_ClientServices_v1_tile_getMessage2(){
        given()
                .header("deviceuuid", Properties.deviceuuid2)
                .header("site", prop.getProperty("mobile.site"))
                .header("authorization", Properties.authorizationBasic)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get(prop.getProperty("mobile.base.url")+"tile/getMessages2")
                .then()
                .statusCode(200)
                .body("communicationTileList.shortName", equalTo(Arrays.asList("Подтвердить email")))
                .log().all();
    }

}
