package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import com.google.gson.Gson;
import model.bo.boServices.ClientImageUploadSelfieRequest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApprovingOfSelfieChangeTicket_withAlreadyExistClient_fromBOTests extends TestBase {
    String cookie = null;
    int clientId = app.homePageClientId;
    int ticketId = 0;
    String tomorrow = null;
    Gson gson = new Gson();
    ClientImageUploadSelfieRequest clientImageUploadSelfieRequest = new ClientImageUploadSelfieRequest();

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws ParseException {
        tomorrow = app.getTimeStampHelper().getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, app.BOusername);
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
                .body("imageInBase64", hasItem(containsString("/9j/4AAQSkZJRgABAQAAAQABAAD")));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_clientImage_uploadSelfie() throws IOException {
        String base64Selfie = HelperBase.readFileReturnString("files/bo/images/base64/base64Selfie.txt");
        clientImageUploadSelfieRequest.setBase64Selfie1(base64Selfie);
        clientImageUploadSelfieRequest.setBase64Selfie2(base64Selfie);
        clientImageUploadSelfieRequest.setClientId(clientId);
        String json = gson.toJson(clientImageUploadSelfieRequest);

        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .header("content-type", "application/json")
                .body(json)
                .when()
                .post("/v1/clientImage/uploadSelfie")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_ticket_take() {
        ticketId = app.getBOHelper().takeSelfieChangeTicket_dev(cookie, tomorrow);
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