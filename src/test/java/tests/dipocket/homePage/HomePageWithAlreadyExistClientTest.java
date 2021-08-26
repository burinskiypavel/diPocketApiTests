package tests.dipocket.homePage;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.testng.Assert.assertEquals;

public class HomePageWithAlreadyExistClientTest extends TestBase {
    String cliSessionId = null;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteClientDeviceFromDB(HelperBase.prop.getProperty("mobile.login.deviceuuid"));
        given()
                .spec(app.requestSpecDipocketHomePage)
                .header("authorization", HelperBase.prop.getProperty("mobile.login.authorizationBasic"))
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.login.deviceuuid")+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {
        String loginSMSCode = app.getDbHelper().getLoginSMSFromDB("380980316499", HelperBase.prop.getProperty("mobile.login.deviceuuid"), "DIPOCKET");
        Response res =  given()
                .spec(app.requestSpecDipocketHomePage)
                .header("authorization", HelperBase.prop.getProperty("mobile.login.authorizationBasic"))
                .header("content-type", "application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.login.deviceuuid")+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        assertEquals(StatusCode, 200);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .header("authorization", HelperBase.prop.getProperty("mobile.login.authorizationBasic"))
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200)
                .body("clientFirstName", equalTo("Pavel"))
                .body("clientLastName", equalTo("Burinsky"));
    }

    @Test(priority = 4)
    public void test_ClientServices_v1_ClientProfile_ClientConfig(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .header("authorization", HelperBase.prop.getProperty("mobile.login.authorizationBasic"))
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/clientConfig")
                .then().log().all()
                .statusCode(200)
                .body("payeeCurrencyHash", notNullValue())
                .body("payeePaymentTypeHash", notNullValue())
                .body("bankTransferReasonHash", notNullValue())
                .body("avlCurrencyForNewAccHash", notNullValue())
                .body("dipTransferCurrencyHash", notNullValue())
                .body("availCategoriesHash", notNullValue());
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_accounts_ClientDipAccounts2(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .header("authorization", HelperBase.prop.getProperty("mobile.login.authorizationBasic"))
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("accounts/clientDiPAccounts2?walletId=null")
                .then().log().all()
                .statusCode(200)
                .body("accounts.state", equalTo(Arrays.asList("ACTIVE")))
                .body("accounts.ccy", equalTo(Arrays.asList("PLN")));
    }

    @Test(priority = 6)
    public void test_ClientServices_v1_tile_getMessage2(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .header("authorization", HelperBase.prop.getProperty("mobile.login.authorizationBasic"))
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("tile/getMessages2")
                .then().log().all()
                .statusCode(200)
                .body("unreadMessageCount", equalTo(0));
    }
}