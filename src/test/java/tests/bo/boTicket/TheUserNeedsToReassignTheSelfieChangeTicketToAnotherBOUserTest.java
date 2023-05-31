package tests.bo.boTicket;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static appmanager.HelperBase.prop;
import static org.testng.Assert.assertEquals;

public class TheUserNeedsToReassignTheSelfieChangeTicketToAnotherBOUserTest extends TestBase {
    String cliSessionId = null;
    String phone = app.homePageLoginPhone;
    String pass = app.homePagePass;
    String newCardHolderName = null;
    String cookie = null;
    String username = app.BOusername;
    int clientId = app.homePageClientId;
    int ticketId = 0;
    String actualTypeName = null;
    String tomorrow = null;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, ParseException {
        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, prop.getProperty("mobile.login.deviceuuid"));
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
        for(int i = 0; i < 12; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if(actualTypeName.equals("Selfie change")){
                break;
            }

            if(!actualTypeName.equals("Selfie change")){
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
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
        app.getBoRequestsHelper().boServices_v1_ticket_ticketId_reassign(cookie, ticketId, "AUTO", "test");
    }
}