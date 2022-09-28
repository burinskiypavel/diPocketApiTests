package tests.bo.boTicket;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

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
        baseURI = app.BOURL;
        basePath = "BOServices";
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
    public void test_BOServices_v1_clientImage_uploadSelfie() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"base64Selfie1\": \"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\",\n" +
                        "  \"base64Selfie2\": \"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\",\n" +
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