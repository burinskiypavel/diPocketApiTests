package tests.bo.boClient;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.response.Response;
import model.bo.boClient.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RolesBOUserClientPageTabSelfieTests extends TestBase {
    String cookie = null;
    int clientId = 33217;

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication(){
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_client_states(){
        app.getBoRequestsHelper().boServices_v1_client_states(cookie);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_availCurrencies(){
        app.getBoRequestsHelper().boServices_v1_client_availCurrencies(cookie);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_client_33217(){
        app.getBoRequestsHelper().boServices_v1_client_33217(cookie, clientId);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_client_33217_address(){
        app.getBoRequestsHelper().boServices_v1_client_33217_address(cookie, clientId);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_clientImage_33217_selfie(){
        Response res = given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/clientImage/"+clientId+"/selfie");
        res.then().log().all().statusCode(200);
        ClientImage_Selfie[] clientImage_selfies = res.as(ClientImage_Selfie[].class);
        assertThat(clientImage_selfies[0].getId(), equalTo(30920));
        assertThat(clientImage_selfies[0].getClientId(), equalTo(clientId));
        assertThat(clientImage_selfies[0].getTypeId(), equalTo(1));
        assertThat(clientImage_selfies[0].getImageInBase64(), containsString("/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0ZJTEUAAQEAAAIYAAAAAAQwAABtbnRyUkdC"));
    }

    @Test(priority = 7)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, clientId, "Nona", "Qwerty", "380634413376", "vikarez20@gmail.com", Site.DIPOCKET.toString());
    }

    @Test(priority = 8)
    public void test_BOServices_v1_supervisor_33217_reqList(){
        app.getBoRequestsHelper().boServices_v1_supervisor_33217_reqList(cookie, clientId);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_ticket_types(){
        app.getBoRequestsHelper().boServices_v1_ticket_types(cookie);
    }

    @Test(priority = 10)
    public void test_BOServices_v1_ticket_states(){
        app.getBoRequestsHelper().boServices_v1_ticket_states(cookie);
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
                .statusCode(200)
                .body("", hasItems("Balance Check at ATM", "Card transaction", "Direct Debit", "Reversed Crowd-Payment", "Top Up"));
    }

    @Test(priority = 13)
    public void test_BOServices_v1_account_client_33217(){
        app.getBoRequestsHelper().boServices_v1_account_client_33217(cookie, clientId);
    }

    @Test(priority = 14)
    public void test_BOServices_v1_account_other_client_33217(){
        app.getBoRequestsHelper().boServices_v1_account_other_client_33217(cookie, clientId);
    }

    @Test(priority = 15)
    public void test_BOServices_v1_clientImage_33217_docs(){
        Response res = given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/clientImage/"+clientId+"/docs");
        res.then().log().all().statusCode(200);
        ClientImage_Selfie[] clientImage_selfies = res.as(ClientImage_Selfie[].class);
        assertThat(clientImage_selfies[0].getId(), equalTo(31456));
        assertThat(clientImage_selfies[0].getClientId(), equalTo(clientId));
        assertThat(clientImage_selfies[0].getTypeId(), equalTo(2));
        assertThat(clientImage_selfies[0].getImageInBase64(), containsString("/9j/4AAQSkZJRgABAQAASABIAAD/4QBMRXhpZgAATU0AKgAAAAgAAgESAAMAAAABAAEAAIdpAAQAAAABAAAAJgAAAAAAAqACAAQAAAABAAAEOKADAAQAAAABAAAF7gAAAAD"));
    }

    @Test(priority = 16)
    public void test_BOServices_v1_client_33217_paymentDetails(){
        app.getBoRequestsHelper().boServices_v1_client_33217_paymentDetails(cookie, clientId);
    }

    @Test(priority = 17)
    public void test_BOServices_v1_clientImage_33217_docHistory(){
        app.getBoRequestsHelper().boServices_v1_clientImage_33217_docHistory(cookie, clientId);
    }

    @Test(priority = 18, enabled = false) // fail after too much selfie
    public void test_BOServices_v1_clientImage_33217_selfieHistory(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/"+clientId+"/selfieHistory")
                .then().log().all();
    }

    @Test(priority = 19)
    public void test_BOServices_v1_client_33217_pushMsgs(){
                given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .when()
                .get( "/v1/client/"+clientId+"/pushMsgs")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(660119),
                        "clientId", hasItem(33217),
                        "channel", hasItem("P"),
                        "created", hasItem("21.02.2022 10:57:46"),
                        "sent", hasItem("21.02.2022 10:59:49"),
                        "message", hasItem("Ви не прийняли переказ від Eva Fisher протягом 7 днів, кошти були повернуті платнику"));
    }
}