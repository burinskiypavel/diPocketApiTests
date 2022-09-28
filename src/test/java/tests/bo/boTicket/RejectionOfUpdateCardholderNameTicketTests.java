package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertEquals;

public class RejectionOfUpdateCardholderNameTicketTests extends TestBase {
    String cliSessionId = null;
    String phone = "380980316499";
    String pass = "reset246740";
    String newCardHolderName = null;
    String oldCardHolderName = null;
    String actualCardHolderName = null;
    String cookie = null;
    String username = "PAVELB_AUTO_BO";
    int clientId = 29818;
    int ticketId = 0;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteClientDeviceFromDB(HelperBase.prop.getProperty("mobile.login.deviceuuid"));
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .contentType("application/json; charset=UTF-8")
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
        String loginSMSCode = app.getDbHelper().getLoginSMSFromDB(phone, HelperBase.prop.getProperty("mobile.login.deviceuuid"), "DIPOCKET");
        Response res =  given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.login.deviceuuid")+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp");
        res.then().log().all().statusCode(200);
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println("cliSessionId " + cliSessionId);
    }

    @Test(priority = 3, enabled = false)
    public void test_ClientServices_v1_tile_getMainScreenMessages(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("tile/getMainScreenMessages")
                .then().log().all()
                .statusCode(200)
                .body("communicationTileList.shortName", hasItems("Заказать пластиковую карту"));
    }

    @Test(priority = 4, enabled = false)
    public void test_ClientServices_v1_accounts_95901_accountHistoryList(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("accounts/95901/accountHistoryList")
                .then().log().all()
                .statusCode(200)
                .body("accountHistoryList.typeName", hasItems("DiP перевод"),
                        "account.accountId", notNullValue(),
                        "account.accountName", notNullValue(),
                        "account.balance", notNullValue());
    }

    @Test(priority = 5, enabled = false)
    public void test_ClientServices_v1_clientProfile_imageStatus(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/imageStatus")
                .then().log().all()
                .statusCode(200)
                .body("images.typeId", hasItems(1, 2, 3, 4, 5, 6),
                        "images.stateID", hasItems(10),
                        "images.imageType", hasItems("SELFIE", "PHOTOID", "PROOFOFADDRESS", "SELFIE2", "PHOTOIDBACK", "SECONDID"),
                        "images.imageState", hasItems("APPROVED", "REJECTED"));
    }

    @Test(priority = 6, enabled = false)
    public void test_ClientServices_v1_clientProfile_clientSmallImageByType(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .queryParam("imageTypeId", 1)
                .when()
                .get("clientProfile/clientSmallImageByType")
                .then().log().all()
                .statusCode(200)
                .body("typeId", equalTo(1),
                        "base64Image", notNullValue(),
                        "imageType", equalTo("SELFIE"),
                        "imageState", equalTo("APPROVED"));
    }

    @Test(priority = 7)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2(){
        String response = given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(response);
        actualCardHolderName = js.getString("cardholderName");
    }

    @Test(priority = 8)
    public void test_ClientServices_v1_clientProfile_changeCardholderName(){
        if(actualCardHolderName.equals("Pavel Burinsk")){
            newCardHolderName = "Pavel Burinsky";
            oldCardHolderName = "Pavel Burinsk";
        }
        else {
            newCardHolderName = "Pavel Burinsk";
            oldCardHolderName = "Pavel Burinsky";

        }

        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"value\" : \""+newCardHolderName+"\"\n" +
                        "}")
                .when()
                .post("clientProfile/changeCardholderName")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 10)
    public void test_BOServices_v1_ticket_take() {
            String response = given()
                    .spec(app.requestSpecBO)
                    .cookie(cookie)
                    .when()
                    .get("/v1/ticket/take")
                    .then().log().all()
                    .statusCode(200).extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
        String actualTypeName = js.getString("typeName");

        assertEquals(actualTypeName, "Cardholder name change");
    }

    @Test(priority = 11, enabled = false)
    public void test_BOServices_v1_clientImage_clientId_selfie() {
        given()
                .spec(app.requestSpecBO)
                .pathParam("key", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/clientImage/{key}/selfie")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItems(clientId),
                        "typeId", hasItems(1, 4),
                        "imageInBase64", notNullValue());
    }

    @Test(priority = 12, enabled = false)
    public void test_BOServices_v1_clientImage_clientId_image() {
        given()
                .spec(app.requestSpecBO)
                .pathParam("key", clientId)
                .cookie(cookie)
                .queryParam("typeId", 2)
                .when()
                .get("/v1/clientImage/{key}/image")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItems(clientId),
                        "typeId", hasItems(2),
                        "imageInBase64", notNullValue());
    }

    @Test(priority = 14, enabled = false)
    public void test_BOServices_v1_client_clientId_address() {
        given()
                .spec(app.requestSpecBO)
                .pathParam("key", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/client/{key}/address")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItems(clientId),
                        "city", hasItems(notNullValue()),
                        "streetLine1", hasItems(notNullValue()),
                        "zip", hasItems(notNullValue()),
                        "countryId", hasItems(notNullValue()),
                        "countryName", hasItems(notNullValue()));
    }

    @Test(priority = 15, enabled = false)
    public void test_BOServices_v1_client_clientId() {
        given()
                .spec(app.requestSpecBO)
                .pathParam("key", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/client/{key}")
                .then().log().all()
                .statusCode(200)
                .body("id", equalTo(clientId),
                        "mainPhone", equalTo("380980316499"),
                        "firstName", equalTo("Pavel"),
                        "lastName", equalTo("Burinsky"),
                        "birthDate", equalTo("1992-09-04"),
                        "email", equalTo("testdipocket3@gmail.com"),
                        "site", equalTo("DIPOCKET"));
    }

    @Test(priority = 16)
    public void test_BOServices_v1_ticket_ticketId_isTicketOwner() {
        String response = given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("key", ticketId)
                .when()
                .get("/v1/ticket/{key}/isTicketOwner")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        assertEquals(response, "true");
    }

    @Test(priority = 17)
    public void test_BOServices_v1_client_clientId_prevCardholderName() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("key", clientId)
                .when()
                .get("/v1/client/{key}/prevCardholderName")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItems(clientId),
                        "cardholderName", hasItems(oldCardHolderName));
    }

    @Test(priority = 18)
    public void test_BOServices_v1_client_clientId_cardholder_reject() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"reason\": \"test\",\n" +
                        "  \"ticketId\": "+ticketId+"\n" +
                        "}")
                .when()
                .post( "/v1/client/{clientId}/cardholder/reject")
                .then().log().all()
                .statusCode(200);

    }

    @Test(priority = 19)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2_(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200)
                .body("cardholderName", equalTo(oldCardHolderName));
    }
}