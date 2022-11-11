package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasEntry;
import static org.testng.Assert.assertEquals;

public class HomePageOpenProfileUpdateCardHolderNameApproveUpdateCardholderTests extends TestBase {
    String cliSessionId = null;
    String phone = "420703666872";
    String pass = app.homePagePass;
    String newCardHolderName = null;
    String oldCardHolderName = null;
    String actualCardHolderName = null;
    String cookie = null;
    String username = app.BOusername;
    int clientId = 40560;
    int ticketId = 0;
    String actualTypeName = null;
    String tomorrow = null;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, ParseException {
        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 3)
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

    @Test(priority = 4)
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

    @Test(priority = 5)
    public void test_ClientServices_v1_clientProfile_imageStatus(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/imageStatus")
                .then().log().all()
                .statusCode(200)
                .body("images.typeId", hasItems(1, 2, 3, 4, 5),
                        "images.stateID", hasItems(10),
                        "images.imageType", hasItems("SELFIE", "PHOTOID", "PROOFOFADDRESS", "SELFIE2", "PHOTOIDBACK"),
                        "images.imageState", hasItems("APPROVED"));
    }

    @Test(priority = 6)
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

        app.getClientProfileRequestsHelper().clientServices_v1_clientProfile_changeCardholderName(cliSessionId, phone, pass, newCardHolderName);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 10)
    public void test_BOServices_v1_ticket_take() {
        for(int i = 0; i < 18; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if(actualTypeName.equals("Cardholder name change")){
                break;
            }

            if(!actualTypeName.equals("Cardholder name change")){
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        assertEquals(actualTypeName, "Cardholder name change");
    }

    @Test(priority = 11)
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

    @Test(priority = 12)
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

    @Test(priority = 13)
    public void test_BOServices_v1_ticket_history_clientId() {
        Response res = given()
                .spec(app.requestSpecBO)
                .pathParam("key", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/ticket/history/{key}");

                res.then().log().all()
                .statusCode(200)
                .body("ticketId", hasItems(32333),
                        "typeName", hasItems("Cardholder name change"));

                //List<String> typeNameValues = res.then().extract().jsonPath().getList("ticketsHistoryList.typeName");
                //Assert.assertTrue(typeNameValues.contains("Cardholder name change"));

                        //"ticketsHistoryList[1].typeName", hasItems("Cardholder name change"),
                        //"ticketsHistoryList", hasItems(hasEntry("typeName", "Cardholder name change")),
                        //"ticketsHistoryList[].username", hasItems("PAVELB_AUTO_BO"),
                        //"ticketsHistoryList.changeDate", hasItems("2021-01-13T12:47:11.044646Z"),
                        //"ticketsHistoryList.created", hasItems("2020-12-04T10:13:47.321483Z"),
                        //"ticketsHistoryList.msg", hasItems("Ticket closed. Reason: Client banned."),
                        //"ticketsHistoryList.clientId", hasItems(clientId));
    }

    @Test(priority = 14)
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

    @Test(priority = 15)
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
    public void test_BOServices_v1_client_clientId_cardholder_approve() {
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
                .post( "/v1/client/{clientId}/cardholder/approve")
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
                .body("cardholderName", equalTo(newCardHolderName));
    }
}