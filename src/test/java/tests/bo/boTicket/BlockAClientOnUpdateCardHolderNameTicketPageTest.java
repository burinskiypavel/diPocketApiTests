package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BlockAClientOnUpdateCardHolderNameTicketPageTest extends TestBase {
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
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
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

    @Test(priority = 3)
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

    @Test(priority = 4)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_ticket_take() {
        String actualTypeNameGlobal = null;
        for(int i = 0; i < 5; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            String actualTypeName = js.getString("typeName");

            if (actualTypeName.equals("SDD check") || actualTypeName.equals("FDD check")) {
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, "05.10.2022 23:35:50");
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            String actualTypeName2 = js2.getString("typeName");
            actualTypeNameGlobal = actualTypeName2;
        }

        assertEquals(actualTypeNameGlobal, "Cardholder name change");
    }

    @Test(priority = 6, enabled = false)
    public void test_BOServices_v1_client_clientId_block(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"blockClientDevice\": true,\n" +
                        "  \"blockOrBanReason\": \"test\",\n" +
                        "  \"closeTicket\": 0,\n" +
                        "  \"ticketId\": "+ticketId+"\n" +
                        "}")
                .when()
                .post("/v1/client/{clientId}/block")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7, enabled = false)
    public void test_BOServices_v1_client_clientId_unblock(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"ticketId\": "+ticketId+",\n" +
                        "  \"unblockOrUnbanReason\": \"test\"\n" +
                        "}")
                .when()
                .post("/v1/client/{clientId}/unblock")
                .then().log().all()
                .statusCode(200);
    }
}