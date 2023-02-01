package tests.bankIntegration;

import appmanager.HelperBase;
import appmanager.Login_RegistrationHelper;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GenerationTest extends TestBase {
    String cookie = null;
    String username = "PAVELB_BO";
    int ticketId = 0;
    String actualTypeName = null;
    String  boUserLogin = "PavelB_BO";
    String boUserPass = "vVahVkR";
    String sms = null;
    String tomorrow = null;
    String clientId = null;

    String actualClientId = null;

    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();


    @Test(priority = 1)
    public void testGeneration() throws SQLException, InterruptedException, ClassNotFoundException {
        login_registrationHelper.dipocketRegistration(440, 978, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "test");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        clientId = app.getDbHelper().getClientIdFromTestDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(boUserLogin, boUserPass, username);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_ticket_take() throws SQLException, ClassNotFoundException {
        String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        sms = message.substring(13);

        int count = 0;
        for(int i = 0; i < 27; i++) {
            count++;
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take_test(cookie, sms);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");
            actualClientId = js.getString("clientId");

            if(actualTypeName.equals("SDD check") && actualClientId.equals(clientId)){
                break;
            }

            if(!actualTypeName.equals("SDD check")){
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        System.out.println("count: " + count);

        assertEquals(actualTypeName, "SDD check");
    }

    @Test(priority = 4)
    public void test_BOServices_v1_client_clientID_update() {
        given()
                .spec(app.requestSpecBOTest)
                .pathParam("clientId", clientId)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .when()
                .body("{\n" +
                        "  \"id\" : "+clientId+",\n" +
                        "  \"mainPhone\" : \"380685448615\",\n" +
                        "  \"firstName\" : \"Pavel\",\n" +
                        "  \"lastName\" : \"Burinsky\",\n" +
                        "  \"birthDate\" : \"03.09.1992\",\n" +
                        "  \"email\" : \"testdipocket@gmail.com\",\n" +
                        "  \"emailIsVerified\" : true,\n" +
                        "  \"stateId\" : 1,\n" +
                        "  \"stateName\" : \"Active\",\n" +
                        "  \"currencyId\" : 978,\n" +
                        "  \"currencyCode\" : \"EUR\",\n" +
                        "  \"langId\" : 4,\n" +
                        "  \"langCode\" : \"rus\",\n" +
                        "  \"langName\" : \"Russian\",\n" +
                        "  \"gender\" : \"M\",\n" +
                        "  \"ddStatus\" : \"PSDD\",\n" +
                        "  \"cardHolderName\" : \"Pavel Burinsky\",\n" +
                        "  \"clientType\" : \"I\",\n" +
                        "  \"site\" : \"DIPOCKET\",\n" +
                        "  \"registeredAddrAsMail\" : true,\n" +
                        "  \"residenceCountryId\" : 440,\n" +
                        "  \"feeTariffPlanId\" : 7,\n" +
                        "  \"feeTariffPlanName\" : \"EUR - standart\",\n" +
                        "  \"age\" : 30,\n" +
                        "  \"migrated\" : false,\n" +
                        "  \"skippedReg\" : false\n" +
                        "}")
                .post("/v1/client/{clientId}/update")
                .then().log().all()
                .statusCode(200);

    }

    @Test(priority = 5)
    public void test_BOServices_v1_client_clientId_approveSDD(){
        given()
                .spec(app.requestSpecBOTest)
                .pathParam("clientId", clientId)
                .header("bo-auth-token", sms)
                .queryParam("ticketId", ticketId)
                .cookie(cookie)
                .post("/v1/client/{clientId}/approveSDD")
                .then().log().all()
                .statusCode(200);
    }
}