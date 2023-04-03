package tests.dipocket.homePage;

import appmanager.HelperBase;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.clientServices.HomePageAuthenticateMobileAppRequest;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class HomePageWithAlreadyExistClientTest extends TestBase {
    String cliSessionId = null;
    String phone = "380980316499";
    String pass = "reset246740";
    int accountId = 109405;
    Gson gson = new Gson();
    HomePageAuthenticateMobileAppRequest homePageAuthenticateMobileAppRequest = new HomePageAuthenticateMobileAppRequest();

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteClientDeviceFromDB(HelperBase.prop.getProperty("mobile.login.deviceuuid"), HelperBase.prop.getProperty("db.url"));

        homePageAuthenticateMobileAppRequest.setDevToken("eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8");
        homePageAuthenticateMobileAppRequest.setDevType("android");
        homePageAuthenticateMobileAppRequest.setDeviceUUID(HelperBase.prop.getProperty("mobile.login.deviceuuid"));
        homePageAuthenticateMobileAppRequest.setAppVersion("2.2.7");
        String json = gson.toJson(homePageAuthenticateMobileAppRequest);

        Response response = app.getClientServicesRequestsHelper().clientServices_v1_homePage_AutintificateMobileApp(phone, pass, json, 400);
        response.then().body("errCode", equalTo("DIP-00591"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {
        String loginSMSCode = app.getDbHelper().getLoginSMSFromDB(phone, HelperBase.prop.getProperty("mobile.login.deviceuuid"), Site.DIPOCKET.toString(), HelperBase.prop.getProperty("db.url"));

        homePageAuthenticateMobileAppRequest.setOtp(loginSMSCode);
        String json = gson.toJson(homePageAuthenticateMobileAppRequest);

        Response response = app.getClientServicesRequestsHelper().clientServices_v1_homePage_AutintificateMobileApp(phone, pass, json, 200);
        cliSessionId = response.getHeader("cliSessionId");
        System.out.println("cliSessionId " + cliSessionId);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200)
                .body("clientFirstName", equalTo("Pavel"),
                        "clientLastName", equalTo("Burinsky"),
                        "mainPhone",equalTo("380980316499"),
                        "email", equalTo("testdipocket3@gmail.com"));
    }

    @Test(priority = 4)
    public void test_ClientServices_v1_ClientProfile_ClientConfig(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/clientConfig")
                .then().log().all()
                .statusCode(200)
                .body("payeeCurrencyHash", notNullValue(),
                        "payeePaymentTypeHash", notNullValue(),
                        "bankTransferReasonHash", notNullValue(),
                        "avlCurrencyForNewAccHash", notNullValue(),
                        "dipTransferCurrencyHash", notNullValue(),
                        "availCategoriesHash", notNullValue());
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_accounts_ClientDipAccounts2(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .queryParam("walletId","null" )
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("accounts/clientDiPAccounts2")
                .then().log().all()
                .statusCode(200)
                .body("accounts.state", hasItem("ACTIVE"),
                "accounts.ccy", hasItem("PLN"));
    }

    @Test(priority = 6)
    public void test_ClientServices_v1_accounts_getAccountInfo(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .queryParam("accountId", accountId)
                .queryParam("walletId","null" )
                .when()
                .get("accounts/getAccountInfo")
                .then().log().all()
                .statusCode(200)
                .body("id", equalTo(accountId),
                        "state", equalTo("ACTIVE"),
                        "ccy", equalTo("PLN"));
    }

    @Test(priority = 7)
    public void test_ClientServices_v1_tile_getMessage2(){
        Response response = app.getClientServicesRequestsHelper().clientServices_v1_tile_getMessages2(cliSessionId, phone, pass);
        response.then().body("unreadMessageCount", equalTo(0));
    }
}