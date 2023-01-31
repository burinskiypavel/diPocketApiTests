package tests.bankIntegration;

import appmanager.HelperBase;
import appmanager.Login_RegistrationHelper;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;

public class GenerationTest extends TestBase {
    String cookie = null;
    String username = app.BOusername;
    int ticketId = 0;
    String actualTypeName = null;

    String tomorrow = null;
    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();


    @Test(priority = 1)
    public void testGeneration() throws SQLException, InterruptedException, ClassNotFoundException {
        //login_registrationHelper.dipocketRegistration(440, 978, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "test");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_ticket_take() {
        int count = 0;
        for(int i = 0; i < 27; i++) {
            count++;
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if(actualTypeName.equals("Cardholder name change")){
                break;
            }

            if(!actualTypeName.equals("Cardholder name change")){
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        System.out.println("count: " + count);

        assertEquals(actualTypeName, "Cardholder name change");
    }
}