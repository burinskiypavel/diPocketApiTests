package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertEquals;

public class RejectionOfUpdateCardholderNameTicketTests extends TestBase {
    String cliSessionId = null;
    String phone = "420703666872";
    String pass = app.homePagePass;
    String newCardHolderName = null;
    String oldCardHolderName = null;
    String actualCardHolderName = null;
    String cookie = null;
    String username = app.BOusername;
    int clientId;
    int ticketId = 0;
    String actualTypeName = null;
    String tomorrow = null;
    String email = "testdipocket002@gmail.com";

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, ParseException, InterruptedException {
        app.getDbHelper().deleteClientFromDB(HelperBase.prop.getProperty("mobile.registration.phoneNumber"), Site.DIPOCKET.toString(), HelperBase.prop.getProperty("db.url"));
        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.homePagePass, "1230768000000", phone, HelperBase.prop.getProperty("mobile.registration.email"), "dev");
        clientId = Integer.parseInt(app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString()));
        app.getDbHelper().updateClientEmailFromDB(email, String.valueOf(clientId));
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 7)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2() {
        String response = given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", cliSessionId)
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        actualCardHolderName = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "cardholderName");
    }

    @Test(priority = 8)
    public void test_ClientServices_v1_clientProfile_changeCardholderName() {
        if (actualCardHolderName.equals("Pavel Burinsk")) {
            newCardHolderName = "Pavel Burinsky";
            oldCardHolderName = "Pavel Burinsk";
        } else {
            newCardHolderName = "Pavel Burinsk";
            oldCardHolderName = "Pavel Burinsky";
        }

        app.getClientProfileRequestsHelper().clientServices_v1_clientProfile_changeCardholderName(cliSessionId, phone, pass, newCardHolderName);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 10)
    public void test_BOServices_v1_ticket_take() {
        for (int i = 0; i < 12; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if (actualTypeName.equals("Cardholder name change")) {
                break;
            }

            if (!actualTypeName.equals("Cardholder name change")) {
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        assertEquals(actualTypeName, "Cardholder name change");
    }

    @Test(priority = 16)
    public void test_BOServices_v1_ticket_ticketId_isTicketOwner() {
        String response = given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("ticketId", ticketId)
                .when()
                .get("/v1/ticket/{ticketId}/isTicketOwner")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        assertEquals(response, "true");
    }

    @Test(priority = 17)
    public void test_BOServices_v1_client_clientId_prevCardholderName() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .when()
                .get("/v1/client/{clientId}/prevCardholderName")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItems(clientId),
                        "cardholderName", hasItems(oldCardHolderName));
    }

    @Test(priority = 18)
    public void test_BOServices_v1_client_clientId_cardholder_reject() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"reason\": \"test\",\n" +
                        "  \"ticketId\": " + ticketId + "\n" +
                        "}")
                .when()
                .post("/v1/client/{clientId}/cardholder/reject")
                .then().log().all()
                .statusCode(200);

    }

    @Test(priority = 19)
    public void test_ClientServices_v1_ClientProfile_ClientInfo2_() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", cliSessionId)
                .when()
                .get("clientProfile/clientInfo2")
                .then().log().all()
                .statusCode(200)
                .body("cardholderName", equalTo(oldCardHolderName));
    }
}