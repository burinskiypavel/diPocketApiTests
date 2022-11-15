package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.testng.Assert.assertEquals;

public class RejectSupervisorTest extends TestBase {
    String cliSessionId = null;
    String regPhone = "380685448615";
    String regPass = "pasword1";
    String cookie = null;
    String username = app.BOusername;
    int ticketId = 0;
    String actualTypeName = null;
    String childId =  null;
    int supervisorId = app.homePageClientId;
    String tomorrow = null;
    String parentPhone = app.homePageLoginPhone;
    String parentPass = app.homePagePass;

    @Test(priority = 0)
    public void test_registration() throws SQLException, ClassNotFoundException, InterruptedException, ParseException {
        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", "pasword1", "1230768000000", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
        //cliSessionId = app.getLogin_registrationHelper().loginDipocket(regPhone, regPass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }


    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, InterruptedException {
        //app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", "pasword1", "1230768000000");
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(regPhone, regPass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_supervision_inviteSupervisor(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(regPhone, regPass)
                .contentType("application/json")
                .header("clisessionid", ""+cliSessionId+"")
                .body("{\n" +
                        "  \"value\" : \""+parentPhone+"\"\n" +
                        "}")
                .when()
                .post("supervision/inviteSupervisor")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_tile_getMessages2() throws SQLException, ClassNotFoundException {
        childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", Site.DIPOCKET.toString());
        Response response = app.getClientServicesRequests().clientServices_v1_tile_getMessages2(cliSessionId, regPhone, regPass);
        response.then().body("communicationTileList.shortName", hasItem("Ожидаем ответ Опекуна"));

    }

    @Test(priority = 4)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(parentPhone, parentPass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_supervision_childId_acceptRequest() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(parentPhone, parentPass)
                .pathParam("childId", childId)
                .contentType("application/json")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .post("supervision/{childId}/acceptRequest")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 8)
    public void test_BOServices_v1_ticket_take() {
        for(int i = 0; i < 12; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if(actualTypeName.equals("Supervision")){
                break;
            }

            if(!actualTypeName.equals("Supervision")){
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        assertEquals(actualTypeName, "Supervision");
    }

    @Test(priority = 9)
    public void test_ClientServices_v1_supervisor_reject() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"childId\" : "+childId+",\n" +
                        "  \"supervisorId\" : "+supervisorId+",\n" +
                        "  \"ticketId\" : "+ticketId+"\n" +
                        "}")
                .when()
                .post("/v1/supervisor/reject")
                .then().log().all()
                .statusCode(200);
    }
}