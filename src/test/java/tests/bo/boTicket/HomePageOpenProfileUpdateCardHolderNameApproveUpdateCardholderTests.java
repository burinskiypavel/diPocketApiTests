package tests.bo.boTicket;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.bo.boServices.CardholderApproveRejectRequest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertEquals;

public class HomePageOpenProfileUpdateCardHolderNameApproveUpdateCardholderTests extends TestBase {
    String cliSessionId = null;
    String phone = "420703666872";
    String newCardHolderName = null;
    String oldCardHolderName = null;
    String actualCardHolderName = null;
    String cookie = null;
    int clientId;
    int ticketId = 0;
    String tomorrow = null;
    String email = "testdipocket002@gmail.com";
    String accountId = "95901";
    int currencyId = 978;
    int countryId = 826;
    Gson gson = new Gson();
    CardholderApproveRejectRequest cardholderApproveRequest = new CardholderApproveRejectRequest();

    @Test(priority = 1)
    public void test_registration() throws SQLException, ClassNotFoundException, ParseException, InterruptedException {
        app.getDbHelper().deleteClientFromDB(prop.getProperty("mobile.registration.phoneNumber"), Site.DIPOCKET.toString(), prop.getProperty("db.url"));
        System.out.println("delete done");
        tomorrow = app.getTimeStampHelper().getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.homePagePass, "1230768000000", phone, prop.getProperty("mobile.registration.email"), "dev");
//        clientId = Integer.parseInt(app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), "DIPOCKET"));
//        app.getDbHelper().updateClientEmailFromDB(email, String.valueOf(clientId));
//        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, app.homePagePass, prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, ParseException, InterruptedException {
//        app.getDbHelper().deleteClientFromDB(HelperBase.prop.getProperty("mobile.registration.phoneNumber"), "DIPOCKET");
//        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
//        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.homePagePass, "1230768000000", phone, HelperBase.prop.getProperty("mobile.registration.email"));
        clientId = Integer.parseInt(app.getDbHelper().getClientIdFromDB(prop.getProperty("mobile.registration.email"), "DIPOCKET"));
        System.out.println("clientId: " + clientId);
        app.getDbHelper().updateClientEmailFromDB(email, String.valueOf(clientId));
        System.out.println("update done");
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, app.homePagePass, prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_tile_getMainScreenMessages() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, app.homePagePass)
                .header("clisessionid", cliSessionId)
                .when()
                .get("tile/getMainScreenMessages")
                .then().log().all()
                .statusCode(200)
                .body("communicationTileList.shortName", hasItems("Top up"));
    }

    @Test(priority = 4)
    public void test_ClientServices_v1_accounts_accountId_accountHistoryList() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, app.homePagePass)
                .pathParam("accountId", accountId)
                .header("clisessionid", cliSessionId)
                .when()
                .get("accounts/{accountId}/accountHistoryList")
                .then().log().all()
                .statusCode(200);
//                .body("accountHistoryList.typeName", hasItems("DiP перевод"),
//                        "account.accountId", notNullValue(),
//                        "account.accountName", notNullValue(),
//                        "account.balance", notNullValue());
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_clientProfile_imageStatus() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, app.homePagePass)
                .header("clisessionid", cliSessionId)
                .when()
                .get("clientProfile/imageStatus")
                .then().log().all()
                .statusCode(200)
                .body("images.typeId", hasItems(1, 4),
                        "images.stateID", hasItems(0),
                        "images.imageType", hasItems("SELFIE", "SELFIE2"),
                        "images.imageState", hasItems("NEW"));
    }

    @Test(priority = 6)
    public void test_ClientServices_v1_clientProfile_clientSmallImageByType() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, app.homePagePass)
                .header("clisessionid", cliSessionId)
                .queryParam("imageTypeId", 1)
                .when()
                .get("clientProfile/clientSmallImageByType")
                .then().log().all()
                .statusCode(200)
                .body("typeId", equalTo(1),
                        "base64Image", notNullValue(),
                        "imageType", equalTo("SELFIE"),
                        "imageState", equalTo("NEW"));
    }

    @Test(priority = 7)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2() {
        String response = given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, app.homePagePass)
                .header("clisessionid", cliSessionId)
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        actualCardHolderName = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "cardholderName");
    }

    @Test(priority = 8)
    public void test_ClientServices_v1_clientProfile_changeCardholderName() {
        if (actualCardHolderName.equals("Pavel Burinsk")) {
            newCardHolderName = "Pavel Burinsky";
            oldCardHolderName = "Pavel Burinsk";
        } else {
            newCardHolderName = "Pavel Burinsk";
            oldCardHolderName = "Pavel Burinsky";
        }

        app.getClientProfileRequestsHelper().clientServices_v1_clientProfile_changeCardholderName(cliSessionId, phone, app.homePagePass, newCardHolderName);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, app.BOusername);
    }

    @Test(priority = 10)
    public void test_BOServices_v1_ticket_take() {
        ticketId = app.getBOHelper().takeCardholderNameChangeTicket_dev(cookie, tomorrow);
    }

    @Test(priority = 11)
    public void test_BOServices_v1_clientImage_clientId_selfie() {
        given()
                .spec(app.requestSpecBO)
                .pathParam("clientId", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/clientImage/{clientId}/selfie")
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
                .pathParam("clientId", clientId)
                .cookie(cookie)
                .queryParam("typeId", 2)
                .when()
                .get("/v1/clientImage/{clientId}/image")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 13)
    public void test_BOServices_v1_ticket_history_clientId() {
        Response res = given()
                .spec(app.requestSpecBO)
                .pathParam("clientId", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/ticket/history/{clientId}");

        res.then().log().all()
                .statusCode(200)
                .body("ticketId", hasItems(ticketId),
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
                .pathParam("clientId", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/client/{clientId}/address")
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
                .pathParam("clientId", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/client/{clientId}")
                .then().log().all()
                .statusCode(200)
                .body("id", equalTo(clientId),
                        "mainPhone", equalTo(phone),
                        "firstName", equalTo("Pavel"),
                        "lastName", equalTo("Burinsky"),
                        "birthDate", equalTo("2009-01-01"),
                        "email", equalTo(email),
                        "site", equalTo(Site.DIPOCKET.toString()));
    }

    @Test(priority = 16)
    public void test_BOServices_v1_ticket_ticketId_isTicketOwner() {
        String response = given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("ticketId", ticketId)
                .when()
                .get("/v1/ticket/{ticketId}/isTicketOwner")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        assertEquals(response, "true");
    }

    @Test(priority = 17)
    public void test_BOServices_v1_client_clientId_prevCardholderName() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .when()
                .get("/v1/client/{clientId}/prevCardholderName")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItems(clientId),
                        "cardholderName", hasItems(oldCardHolderName));
    }

    @Test(priority = 18)
    public void test_BOServices_v1_client_clientId_cardholder_approve() {
        cardholderApproveRequest.setReason("test");
        cardholderApproveRequest.setTicketId(ticketId);
        String json = gson.toJson(cardholderApproveRequest);

        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .contentType("application/json")
                .body(json)
                .when()
                .post("/v1/client/{clientId}/cardholder/approve")
                .then().log().all()
                .statusCode(200);

    }

    @Test(priority = 19)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2_() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, app.homePagePass)
                .header("clisessionid", cliSessionId)
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200)
                .body("cardholderName", equalTo(newCardHolderName));
    }
}