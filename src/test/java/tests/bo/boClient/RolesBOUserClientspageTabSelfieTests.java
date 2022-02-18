package tests.bo.boClient;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.boClient.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RolesBOUserClientspageTabSelfieTests extends TestBase {
    String cookie = null;
    int clientId = 33217;

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
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/states");
        res.then().log().all().statusCode(200);
        Client_states[] client_states = res.as(Client_states[].class);
        assertThat(client_states[0].getId(), equalTo(-200));
        assertThat(client_states[0].getName(), equalTo("Archived"));
        assertThat(client_states[1].getId(), equalTo(-150));
        assertThat(client_states[1].getName(), equalTo("Forgotten"));
        assertThat(client_states[2].getId(), equalTo(-100));
        assertThat(client_states[2].getName(), equalTo("Banned"));
        assertThat(client_states[3].getId(), equalTo(-1));
        assertThat(client_states[3].getName(), equalTo("Blocked"));
        assertThat(client_states[4].getId(), equalTo(0));
        assertThat(client_states[4].getName(), equalTo("Savepoint"));
        assertThat(client_states[5].getId(), equalTo(1));
        assertThat(client_states[5].getName(), equalTo("Active"));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_availCurrencies(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/availCurrencies");
        res.then().log().all().statusCode(200);
        Client_availCurrencies[] client_availCurrencies = res.as(Client_availCurrencies[].class);
        assertThat(client_availCurrencies[0].getId(), equalTo(975));
        assertThat(client_availCurrencies[0].getCode(), equalTo("BGN"));
        assertThat(client_availCurrencies[1].getId(), equalTo(756));
        assertThat(client_availCurrencies[1].getCode(), equalTo("CHF"));
        assertThat(client_availCurrencies[1].getSymbol(), equalTo("Fr"));
        assertThat(client_availCurrencies[2].getId(), equalTo(978));
        assertThat(client_availCurrencies[2].getCode(), equalTo("EUR"));
        assertThat(client_availCurrencies[2].getSymbol(), equalTo("€"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_client_33217(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("email", equalTo("vikarez20@gmail.com"),
                        "id", equalTo(33217),
                        "mainPhone", equalTo("380634413376"),
                        "firstName", equalTo("Nona"),
                        "lastName", equalTo("Qwerty"));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_client_33217_address(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+ clientId +"/address");
        res.then().log().all().statusCode(200);
        Client_address[] client_addresses = res.as(Client_address[].class);
        assertThat(client_addresses[0].getClientId(), equalTo(clientId));
        assertThat(client_addresses[0].getCity(), equalTo("City"));
        assertThat(client_addresses[0].getStreetLine1(), equalTo("Address"));
        assertThat(client_addresses[0].getZip(), equalTo("11-11"));
        assertThat(client_addresses[0].getTypeId(), equalTo(0));
        assertThat(client_addresses[0].getCountryId(), equalTo(40));
        assertThat(client_addresses[0].getCode(), equalTo("AT"));
        assertThat(client_addresses[0].getCountryName(), equalTo("Austria"));
        assertThat(client_addresses[0].isRestricted(), equalTo(false));
    }

    @Test(priority = 6)
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

    @Test(priority = 7)
    public void test_BOServices_v1_client_search(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\" : 33217\n" +
                        "}")
                .when()
                .post( "/v1/client/search");
        res.then().log().all().statusCode(200);
        Client_search[] client_search = res.as(Client_search[].class);
        assertThat(client_search[0].getId(), equalTo(clientId));
        assertThat(client_search[0].getFirstName(), equalTo("Nona"));
        assertThat(client_search[0].getLastName(), equalTo("Qwerty"));
        assertThat(client_search[0].getMainPhone(), equalTo("380634413376"));
        assertThat(client_search[0].getEmail(), equalTo("vikarez20@gmail.com"));
        assertThat(client_search[0].getSite(), equalTo("DIPOCKET"));
    }

    @Test(priority = 8)
    public void test_BOServices_v1_supervisor_33217_reqList(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/supervisor/33217/reqList");
        res.then().log().all().statusCode(200);
        Supervisor_reqList[] supervisor_reqLists = res.as(Supervisor_reqList[].class);
        assertThat(supervisor_reqLists[0].getReqId(), equalTo(2676));
        assertThat(supervisor_reqLists[0].getClientId(), equalTo(33217));
        assertThat(supervisor_reqLists[0].getRole(), equalTo("Child"));
        assertThat(supervisor_reqLists[0].getrClientPhone(), equalTo("380638918373"));
        assertThat(supervisor_reqLists[0].getrFullName(), equalTo("Vika Qwerty"));
        assertThat(supervisor_reqLists[0].getStateId(), equalTo(- 100));
        assertThat(supervisor_reqLists[0].getStateName(), equalTo("Finished"));
        Assert.assertFalse(supervisor_reqLists[0].getCreatedAt().isEmpty());
        Assert.assertFalse(supervisor_reqLists[0].getApprovedAt().isEmpty());
    }

    @Test(priority = 9)
    public void test_BOServices_v1_ticket_types(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/ticket/types");
        res.then().log().all().statusCode(200);
        Ticket_types[] ticket_types = res.as(Ticket_types[].class);
        assertThat(ticket_types[0].getId(), equalTo(402));
        assertThat(ticket_types[0].getName(), equalTo("PhotoID change"));
        assertThat(ticket_types[1].getId(), equalTo(700));
        assertThat(ticket_types[1].getName(), equalTo("Client restriction"));
        assertThat(ticket_types[2].getId(), equalTo(100));
        assertThat(ticket_types[2].getName(), equalTo("SDD check"));
        assertThat(ticket_types[3].getId(), equalTo(200));
        assertThat(ticket_types[3].getName(), equalTo("FDD check"));
        assertThat(ticket_types[4].getId(), equalTo(300));
        assertThat(ticket_types[4].getName(), equalTo("PIN incorrect (3)"));
        assertThat(ticket_types[5].getId(), equalTo(310));
        assertThat(ticket_types[5].getName(), equalTo("PIN change"));
        assertThat(ticket_types[6].getId(), equalTo(320));
        assertThat(ticket_types[6].getName(), equalTo("Secret answer incorrect (2)"));
    }

    @Test(priority = 10)
    public void test_BOServices_v1_ticket_states(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/ticket/states");
        res.then().log().all().statusCode(200);
        Ticket_states[] ticket_states = res.as(Ticket_states[].class);
        assertThat(ticket_states[0].getId(), equalTo(10));
        assertThat(ticket_states[0].getName(), equalTo("Open"));
        assertThat(ticket_states[1].getId(), equalTo(50));
        assertThat(ticket_states[1].getName(), equalTo("In progress"));
        assertThat(ticket_states[2].getId(), equalTo(100));
        assertThat(ticket_states[2].getName(), equalTo("Closed"));
        assertThat(ticket_states[3].getId(), equalTo(-10));
        assertThat(ticket_states[3].getName(), equalTo("Rejected"));
    }

    @Test(priority = 11)
    public void test_BOServices_v1_tran_states(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/tran/states");
        res.then().log().all().statusCode(200);
        Tran_states[] tran_states = res.as(Tran_states[].class);
        assertThat(tran_states[0].getId(), equalTo(-100));
        assertThat(tran_states[0].getName(), equalTo("Error"));
        assertThat(tran_states[1].getId(), equalTo(-60));
        assertThat(tran_states[1].getName(), equalTo("Reversed"));
        assertThat(tran_states[2].getId(), equalTo(-50));
        assertThat(tran_states[2].getName(), equalTo("Reversing"));
        assertThat(tran_states[3].getId(), equalTo(-10));
        assertThat(tran_states[3].getName(), equalTo("Cancelled"));
        assertThat(tran_states[4].getId(), equalTo(0));
        assertThat(tran_states[4].getName(), equalTo("Processing"));
        assertThat(tran_states[5].getId(), equalTo(10));
        assertThat(tran_states[5].getName(), equalTo("Hidden"));
        assertThat(tran_states[6].getId(), equalTo(30));
        assertThat(tran_states[6].getName(), equalTo("Pending"));
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
    public void test_BOServices_v1_account_client_33217(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/account/client/"+clientId+"");
        res.then().log().all().statusCode(200);
        Account_client[] account_clients = res.as(Account_client[].class);
        assertThat(account_clients[0].getId(), equalTo(102690));
        assertThat(account_clients[0].getAccountName(), equalTo("Bbh"));
        assertThat(account_clients[0].getClientId(), equalTo(33217));
        assertThat(account_clients[0].getCcyId(), equalTo(826));
        assertThat(account_clients[0].getCcyCode(), equalTo("GBP"));
        assertThat(account_clients[0].getRestAmount(), equalTo(0));
        assertThat(account_clients[0].getStateId(), equalTo(-100));
        assertThat(account_clients[0].getStateName(), equalTo("Closed"));
        assertThat(account_clients[0].getTypeId(), equalTo(1));
        assertThat(account_clients[0].getCreated(), equalTo("2021-10-12"));
        assertThat(account_clients[0].getAccStateNameExt(), equalTo("Closed"));
        assertThat(account_clients[0].getClientIdOwner(), equalTo(33217));
        assertThat(account_clients[0].isOwner(), equalTo(true));
        assertThat(account_clients[0].isShared(), equalTo(false));
    }

    @Test(priority = 14)
    public void test_BOServices_v1_account_other_client_33217(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/account/other/client/33217");
        res.then().log().all().statusCode(200);
        Account_other_client[] account_other_clients = res.as(Account_other_client[].class);
        assertThat(account_other_clients[0].getId(), equalTo(104447));
        assertThat(account_other_clients[0].getClientId(), equalTo(33217));
        assertThat(account_other_clients[0].getCardName(), equalTo("Test"));
        assertThat(account_other_clients[0].getCreated(), equalTo("2022-01-12"));
        assertThat(account_other_clients[0].getMaskedPan(), equalTo("555585******9888"));
        assertThat(account_other_clients[0].getAccountStateName(), equalTo("Closed"));
    }

    @Test(priority = 15)
    public void test_BOServices_v1_clientImage_33217_docs(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/33217/docs");
        res.then().log().all().statusCode(200);
        ClientImage_Selfie[] clientImage_selfies = res.as(ClientImage_Selfie[].class);
        assertThat(clientImage_selfies[0].getId(), equalTo(31456));
        assertThat(clientImage_selfies[0].getClientId(), equalTo(clientId));
        assertThat(clientImage_selfies[0].getTypeId(), equalTo(2));
        assertThat(clientImage_selfies[0].getImageInBase64(), containsString("/9j/4AAQSkZJRgABAQAASABIAAD/4QBMRXhpZgAATU0AKgAAAAgAAgESAAMAAAABAAEAAIdpAAQAAAABAAAAJgAAAAAAAqACAAQAAAABAAAEOKADAAQAAAABAAAF7gAAAAD"));
    }
}