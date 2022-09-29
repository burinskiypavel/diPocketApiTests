package tests.bo.boClient;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class RolesBOUserClientPageBlockUnblockBanUnbanClientTests extends TestBase {
    String cookie = null;
    int clientId = 34138;
    String reason = "test";
    String firstName = "Pavel";
    String lastName = "auto QA";
    String phone = "380980316499";
    String email = "testdipocket2@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication(){
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_client_states(){
        app.getBoRequestsHelper().boServices_v1_client_states(cookie);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_sites(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/sites")
                .then().log().all()
                .body("site", hasItems(Site.DIPOCKET.toString(), Site.GETSBY.toString(), Site.PEAK.toString(), Site.PLAYIT.toString(), Site.SODEXO.toString()),
                        "name", hasItems("Salarify", "Sandbox", "Nexo", "Figame"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, clientId, firstName, lastName, phone, email, Site.SODEXO.toString());
    }

    @Test(priority = 5)
    public void test_BOServices_v1_supervisor_34138_reqList(){
        Response res = app.getBoRequestsHelper().boServices_v1_supervisor_reqList(cookie, clientId);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_client_34138(){
        Response res = app.getBoRequestsHelper().boServices_v1_client_(cookie, clientId);
        res.then().body("mainPhone", equalTo(phone),
                "firstName", equalTo(firstName),
                "lastName", equalTo(lastName),
                "email", equalTo(email));
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_all(){
                given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
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
                        "site", hasItem(Site.DIPOCKET.toString()));
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
    public void test_BOServices_v1_clientImage_34138_selfie(){
        Response res = given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/clientImage/"+clientId+"/selfie");
        res.then().log().all().statusCode(200);
    }

    @Test(priority = 11)
    public void test_BOServices_v1_tran_states(){
        app.getBoRequestsHelper().boServices_v1_tran_states(cookie);
    }

    @Test(priority = 12)
    public void test_BOServices_v1_dashboard_tranTypes(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/dashboard/tranTypes")
                .then().log().all()
                .statusCode(200).body("", hasItems("Balance Check at ATM", "Card transaction", "Direct Debit", "Reversed Crowd-Payment", "Top Up"));
    }

    @Test(priority = 13)
    public void test_BOServices_v1_account_other_client_34138(){
        app.getBoRequestsHelper().boServices_v1_account_other_client_(cookie, clientId);
    }

    @Test(priority = 14)
    public void test_BOServices_v1_account_states(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/account/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(20, 10, 5, 0, -50, -100),
                        "sNameEng", hasItems("Active", "Hidden", "To open", "To confirm", "Frozen", "Closed"));
    }

    @Test(priority = 15)
    public void test_BOServices_v1_account_client_34138(){
        Response res = app.getBoRequestsHelper().boServices_v1_account_client_(cookie, clientId);
        res.then().body("accountName", hasItems("Main Account"),
                "clientId", hasItems(clientId));
    }

    @Test(priority = 16)
    public void test_BOServices_v1_clientImage_34138_docs(){
        Response res = given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/clientImage/"+clientId+"/docs");
        res.then().log().all().statusCode(200);
    }

    @Test(priority = 17)
    public void test_BOServices_v1_client_34138_paymentDetails(){
        Response res = app.getBoRequestsHelper().boServices_v1_client_paymentDetails(cookie, clientId);
        res.then().body("accountName", hasItems("Pavel auto QA"),
                "currencyCode", hasItems("PLN"));
    }

    @Test(priority = 18)
    public void test_BOServices_v1_payee_paymentTypes(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/payee/paymentTypes")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(4, 1, 2, 3, 5),
                        "sName", hasItems("GBP in United Kingdom", "PLN in Poland", "EUR in Single Euro Payment Area", "Other payments", "HUF in Hungary"));
    }

    @Test(priority = 19)
    public void test_BOServices_v1_payee_34138(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/payee/"+clientId+"")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 20)
    public void test_BOServices_v1_client_availCurrencies(){
        app.getBoRequestsHelper().boServices_v1_client_availCurrencies(cookie);
    }

    @Test(priority = 21)
    public void test_BOServices_v1_client_34138_tiles(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+clientId+"/tiles")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 22)
    public void test_BOServices_v1_client_34138_address(){
        app.getBoRequestsHelper().boServices_v1_client_address(cookie, clientId);
    }

    @Test(priority = 23)
    public void test_BOServices_v1_ticket_client_34138(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/ticket/client/"+clientId+"")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(29232),
                        "typeId", hasItem(700),
                        "typeName", hasItem("Client restriction"),
                        "stateId", hasItem(100),
                        "stateName", hasItem("Closed"),
                        "username", hasItem("VIKTORIA"),
                        "created", hasItem("2022-09-08"),
                        "closed", hasItem("2022-09-08"),
                        "queueOrder", hasItem("2022-09-08"),
                        "clientId", hasItem(clientId),
                        "clientFullName", hasItem("Pavel auto QA"),
                        "clientSite", hasItem(Site.SODEXO.toString()),
                        "clientStateId", hasItem(1),
                        "clientStateName", hasItem("Active"),
                        "lastMessage", hasItem("Ticket closed. Reason: Client unbanned."));
    }

    @Test(priority = 24)
    public void test_BOServices_v1_client_citizenships(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/citizenships")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(4, 248, 8, 32),
                        "countryId", hasItems(4, 248, 8, 32),
                        "nameEng", hasItems("Australia", "Austria", "Brazil", "China"));
    }

    @Test(priority = 25)
    public void test_BOServices_v1_client_34138_pushMsgs(){
                given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .when()
                .get( "/v1/client/"+clientId+"/pushMsgs")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 26)
    public void test_BOServices_v1_clientImage_34138_docHistory(){
        app.getBoRequestsHelper().boServices_v1_clientImage_docHistory(cookie, clientId);
    }

    @Test(priority = 27, enabled = false)
    public void test_BOServices_v1_clientImage_34138_selfieHistory(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
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
    public void test_BOServices_v1_client_34138_block(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"blockOrBanReason\" : \""+reason+"\"\n" +
                        "}")
                .when()
                .post( "/v1/client/"+clientId+"/block")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 29)
    public void test_BOServices_v1_client_34138_(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Blocked"));
    }

    @Test(priority = 30)
    public void test_BOServices_v1_client_34138_unblock() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"unblockOrUnbanReason\" : \""+reason+"\"\n" +
                        "}")
                .when()
                .post("/v1/client/" + clientId + "/unblock")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 31)
    public void test_BOServices_v1_client_34138__(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Active"));
    }

    @Test(priority = 32)
    public void test_BOServices_v1_client_34138_ban_WithoutBlockingClientDevice(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"blockOrBanReason\" : \""+reason+"\",\n" +
                        "  \"blockClientDevice\" : false\n" +
                        "}")
                .when()
                .post( "/v1/client/"+clientId+"/ban")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 33)
    public void test_BOServices_v1_client_34138___(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Banned"));
    }

    @Test(priority = 34)
    public void test_BOServices_v1_client_34138_unban(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{}")
                .when()
                .post( "/v1/client/"+clientId+"/unban")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 35)
    public void test_BOServices_v1_client_34138____(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Active"));
    }

    @Test(priority = 36)
    public void test_BOServices_v1_client_34138_ban(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"blockOrBanReason\" : \""+reason+"\",\n" +
                        "  \"blockClientDevice\" : true\n" +
                        "}")
                .when()
                .post( "/v1/client/"+clientId+"/ban")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 37)
    public void test_BOServices_v1_client_34138_____(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Banned"));
    }

    @Test(priority = 38)
    public void test_BOServices_v1_client_34138_unban_(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{}")
                .when()
                .post( "/v1/client/"+clientId+"/unban")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 39)
    public void test_BOServices_v1_client_34138______(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("stateName", equalTo("Active"));
    }
}