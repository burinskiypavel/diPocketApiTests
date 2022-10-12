package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;

public class TheUserNeedsToReassignTheSelfieChangeTicketToAnotherBOUserTest extends TestBase {
    String cliSessionId = null;
    String phone = "380980316499";
    String pass = "reset246740";
    String newCardHolderName = null;
    String cookie = null;
    String username = "PAVELB_AUTO_BO";
    int clientId = 29818;
    int ticketId = 0;
    String actualTypeName = null;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException {
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_clientProfile_updateSelfie(){
        app.getClientProfileRequestsHelper().clientServices_v1_clientProfile_updateSelfie(cliSessionId, phone, pass, newCardHolderName);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_ticket_take() {
        for(int i = 0; i < 5; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if(actualTypeName.equals("Selfie change")){
                break;
            }

            if (actualTypeName.equals("SDD check") || actualTypeName.equals("FDD check") || actualTypeName.equals("Cardholder name change") || actualTypeName.equals("PhotoID change") || actualTypeName.equals("Proof of address change") || actualTypeName.equals("PhotoID Back change") || actualTypeName.equals("Second ID change")) {
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, "30.12.2022 23:35:50");
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        assertEquals(actualTypeName, "Selfie change");
    }

    @Test(priority = 5)
    public void test_BOServices_v1_ticket_ticketId_reassign() {
        app.getBoRequestsHelper().boServices_v1_ticket_ticketId_reassign(cookie, ticketId);
    }
}