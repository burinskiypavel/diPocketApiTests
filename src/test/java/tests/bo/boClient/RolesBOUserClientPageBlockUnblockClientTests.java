package tests.bo.boClient;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.boClient.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

public class RolesBOUserClientPageBlockUnblockClientTests extends TestBase {
    String cookie = null;
    int clientId = 33217;
    String reason = "test";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
        baseURI = app.BOURL;
        basePath = "BOServices";
        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic("Viktoria", "kWmaB0s")
                .contentType("application/json")
                .when()
                .post( "/v1/user/authentication");
        response.then().log().all()
                .statusCode(200)
                .body("username", equalTo("VIKTORIA"));
        cookie = response.getHeader("Set-Cookie");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_client_states(){
        app.getBoRequestsHelper().boServices_v1_client_states(cookie);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_sites(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/sites")
                .then().log().all()
                .body("site", hasItems("DIPOCKET", "GETSBY", "PEAK", "PLAYIT", "SODEXO"),
                        "name", hasItems("Salarify", "Sandbox", "Nexo", "Figame"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, clientId);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_supervisor_33217_reqList(){
        app.getBoRequestsHelper().boServices_v1_supervisor_33217_reqList(cookie, clientId);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_client_33217(){
        app.getBoRequestsHelper().boServices_v1_client_33217(cookie, clientId);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_all(){
                given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/all")
                .then().log().all()
                .statusCode(200)
                .body("firstName", hasItem("Agnieszka"),
                        "lastName", hasItem("Szewczyk"),
                        "roleId", hasItem("PORTAL"),
                        "stateId", hasItem(10),
                        "stateName", hasItem("Active"),
                        "username", hasItem("A.SZEWCZYK"),
                        "phone", hasItem("48663647283"),
                        "email", hasItem("Agnieszka.Szewczyk@sodexo.com"),
                        "site", hasItem("DIPOCKET"));
    }

    @Test(priority = 8)
    public void test_BOServices_v1_ticket_states(){
        app.getBoRequestsHelper().boServices_v1_ticket_states(cookie);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_ticket_types(){
        app.getBoRequestsHelper().boServices_v1_ticket_types(cookie);
    }

    @Test(priority = 10)
    public void test_BOServices_v1_clientImage_33217_selfie(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/"+clientId+"/selfie");
        res.then().log().all().statusCode(200);
        ClientImage_Selfie[] clientImage_selfies = res.as(ClientImage_Selfie[].class);
        assertThat(clientImage_selfies[0].getId(), equalTo(30920));
        assertThat(clientImage_selfies[0].getClientId(), equalTo(clientId));
        assertThat(clientImage_selfies[0].getTypeId(), equalTo(1));
        assertThat(clientImage_selfies[0].getImageInBase64(), containsString("/9j/4AAQSkZJRgABAQAASABIAAD/4QBMRXhpZgAATU0AKgAAAAgAAgESAAMAAAABAAEAAIdpAAQAAAABAAAAJgAAAAA"));
    }

    @Test(priority = 11)
    public void test_BOServices_v1_tran_states(){
        app.getBoRequestsHelper().boServices_v1_tran_states(cookie);
    }

    @Test(priority = 12)
    public void test_BOServices_v1_dashboard_tranTypes(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/dashboard/tranTypes")
                .then().log().all()
                .statusCode(200).body("", hasItems("Balance Check at ATM", "Card transaction", "Direct Debit", "Reversed Crowd-Payment", "Top Up"));
    }

    @Test(priority = 13)
    public void test_BOServices_v1_account_other_client_33217(){
        app.getBoRequestsHelper().boServices_v1_account_other_client_33217(cookie, clientId);
    }

    @Test(priority = 14)
    public void test_BOServices_v1_account_states(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/account/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(20, 10, 5, 0, -50, -100),
                        "sNameEng", hasItems("Active", "Hidden", "To open", "To confirm", "Frozen", "Closed"));
    }

    @Test(priority = 15)
    public void test_BOServices_v1_account_client_33217(){
        app.getBoRequestsHelper().boServices_v1_account_client_33217(cookie, clientId);
    }

    @Test(priority = 16)
    public void test_BOServices_v1_clientImage_33217_docs(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/"+clientId+"/docs");
        res.then().log().all().statusCode(200);
        ClientImage_Selfie[] clientImage_selfies = res.as(ClientImage_Selfie[].class);
        assertThat(clientImage_selfies[0].getId(), equalTo(31456));
        assertThat(clientImage_selfies[0].getClientId(), equalTo(clientId));
        assertThat(clientImage_selfies[0].getTypeId(), equalTo(2));
        assertThat(clientImage_selfies[0].getImageInBase64(), containsString("/9j/4AAQSkZJRgABAQAASABIAAD/4QBMRXhpZgAATU0AKgAAAAgAAgESAAMAAAABAAEAAIdpAAQAAAABAAAAJgAAAAAAAqACAAQAAAABAAAEOKADAAQAAAABAAAF7gAAAAD"));
    }

    @Test(priority = 17)
    public void test_BOServices_v1_client_33217_paymentDetails(){
        app.getBoRequestsHelper().boServices_v1_client_33217_paymentDetails(cookie, clientId);
    }

    @Test(priority = 18)
    public void test_BOServices_v1_payee_paymentTypes(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/payee/paymentTypes")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(4, 1, 2, 3, 5),
                        "sName", hasItems("GBP in United Kingdom", "PLN in Poland", "EUR in Single Euro Payment Area", "Other payments", "HUF in Hungary"));
    }

    @Test(priority = 19)
    public void test_BOServices_v1_payee_33217(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/payee/"+clientId+"")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(3952),
                        "clientId", hasItems(clientId),
                        "nickName", hasItem("Den"),
                        "paymentTypeId", hasItem(1),
                        "paymentTypeName", hasItem("PLN in Poland"),
                        "currencyId", hasItem(985));
    }

    @Test(priority = 20)
    public void test_BOServices_v1_client_availCurrencies(){
        app.getBoRequestsHelper().boServices_v1_client_availCurrencies(cookie);
    }

    @Test(priority = 21)
    public void test_BOServices_v1_client_33217_tiles(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+clientId+"/tiles")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 22)
    public void test_BOServices_v1_client_33217_address(){
        app.getBoRequestsHelper().boServices_v1_client_33217_address(cookie, clientId);
    }

    @Test(priority = 23)
    public void test_BOServices_v1_ticket_client_33217(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/ticket/client/"+clientId+"")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(26276),
                        "typeId", hasItem(700),
                        "typeName", hasItem("Client restriction"),
                        "stateId", hasItem(100),
                        "stateName", hasItem("Closed"),
                        "username", hasItem("EVGENYA"),
                        "created", hasItem("2022-05-05"),
                        "closed", hasItem("2022-05-05"),
                        "queueOrder", hasItem("2022-05-05"),
                        "clientId", hasItem(clientId),
                        "clientFullName", hasItem("Nona Qwerty"),
                        "clientSite", hasItem("DIPOCKET"),
                        "clientStateId", hasItem(1),
                        "clientStateName", hasItem("Active"),
                        "lastMessage", hasItem("Ticket closed. Reason: Client unblocked."));
    }

    @Test(priority = 24)
    public void test_BOServices_v1_client_citizenships(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/citizenships")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(4, 248, 8, 32),
                        "countryId", hasItems(4, 248, 8, 32),
                        "nameEng", hasItems("Australia", "Austria", "Brazil", "China"));
    }

    @Test(priority = 25)
    public void test_BOServices_v1_client_33217_pushMsgs(){
                given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+clientId+"/pushMsgs")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(660119),
                        "clientId", hasItem(clientId),
                        "channel", hasItem("P"),
                        "created", hasItem("21.02.2022 10:57:46"),
                        "sent", hasItem("21.02.2022 10:59:49"),
                        "message", hasItem("Ви не прийняли переказ від Eva Fisher протягом 7 днів, кошти були повернуті платнику"));
    }

    @Test(priority = 26)
    public void test_BOServices_v1_clientImage_33217_docHistory(){
        app.getBoRequestsHelper().boServices_v1_clientImage_33217_docHistory(cookie, clientId);
    }

    @Test(priority = 27, enabled = false)
    public void test_BOServices_v1_clientImage_33217_selfieHistory(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/"+clientId+"/selfieHistory")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(17159),
                        "clientId", hasItem(clientId),
                        "typeId", hasItem(4),
                        "imageInBase64", hasItem(notNullValue()),
                        "added", hasItem("2021-12-29T13:10:12.551693Z"),
                        "stateId", hasItem(10),
                        "stateName", hasItem("Approved"));
    }

    @Test(priority = 28)
    public void test_BOServices_v1_client_33217_block(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"blockOrBanReason\" : \""+reason+"\"\n" +
                        "}")
                .when()
                .post( "/v1/client/"+clientId+"/block")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 29)
    public void test_BOServices_v1_client_33217_(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Blocked"));
    }

    @Test(priority = 30)
    public void test_BOServices_v1_client_33217_unblock() {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"unblockOrUnbanReason\" : \""+reason+"\"\n" +
                        "}")
                .when()
                .post("/v1/client/" + clientId + "/unblock")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 31)
    public void test_BOServices_v1_client_33217__(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Active"));
    }
}