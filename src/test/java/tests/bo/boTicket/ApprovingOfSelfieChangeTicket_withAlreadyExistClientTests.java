package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class ApprovingOfSelfieChangeTicket_withAlreadyExistClientTests extends TestBase {
    String cookie = null;
    String username = "PAVELB_AUTO_BO";
    int clientId = 29818;
    int ticketId = 0;

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        //baseURI = app.BOURL;
        //basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_ticket_client_clientIdPathParam() {
        given()
                .spec(app.requestSpecBO)
                .pathParam("clientId", clientId)
                .cookie(cookie)
                .when()
                .get("/v1/ticket/client/{clientId}")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(notNullValue()),
                        "typeId", hasItem(notNullValue()),
                        "typeName", hasItem(notNullValue()),
                        "stateName", hasItem(notNullValue()),
                        "username", hasItem(notNullValue()),
                        "created", hasItem(notNullValue()),
                        "closed", hasItem(notNullValue()),
                        "queueOrder", hasItem(notNullValue()),
                        "clientId", hasItem(notNullValue()),
                        "clientFullName", hasItem(notNullValue()),
                        "clientSite", hasItem(notNullValue()),
                        "clientStateId", hasItem(notNullValue()),
                        "clientStateName", hasItem(notNullValue()),
                        "lastMessage", hasItem(notNullValue()));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_ticket_types() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get("/v1/ticket/types")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(402, 406, 700, 900),
                        "name", hasItems("PhotoID change", "Client restriction", "SDD check", "FDD check", "PIN incorrect (3)", "PIN change", "Secret answer incorrect (2)", "Cardholder name change"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_payee_paymentTypes() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get("/v1/payee/paymentTypes")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(4, 1, 2, 3, 5),
                        "sName", hasItems("GBP in United Kingdom", "PLN in Poland", "EUR in Single Euro Payment Area", "Other payments", "HUF in Hungary"));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_clientImage_clientId_selfie() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .when()
                .get("/v1/clientImage/{clientId}/selfie")
                .then().log().all()
                .statusCode(200)
                .body("imageInBase64", hasItem(containsString("/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0Z")));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_clientImage_uploadSelfie() throws IOException {
        String base64Selfie = HelperBase.readFileReturnString("files/bo/images/base64/base64Selfie.txt");
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"base64Selfie1\": \""+base64Selfie+"\",\n" +
                        "  \"base64Selfie2\": \""+base64Selfie+"\",\n" +
                        "  \"clientId\": "+clientId+"\n" +
                        "}")
                .when()
                .post("/v1/clientImage/uploadSelfie")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_ticket_take() {
        Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
        String response =res.then().extract().response().asString();

        JsonPath js = new JsonPath(response);
        ticketId = js.getInt("id");
        String actualTypeName = js.getString("typeName");

        assertEquals(actualTypeName, "Selfie change");
    }

    @Test(priority = 8)
    public void test_BOServices_v1_client_clientId_approveSelfie() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .header("content-type", "application/json")
                .queryParam("ticketId", ticketId)
                .when()
                .post("/v1/client/{clientId}/approveSelfie")
                .then().log().all()
                .statusCode(200);
    }
}