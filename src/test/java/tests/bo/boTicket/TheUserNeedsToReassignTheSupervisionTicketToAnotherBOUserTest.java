package tests.bo.boTicket;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class TheUserNeedsToReassignTheSupervisionTicketToAnotherBOUserTest extends TestBase {
    String cliSessionId = null;
    String cookie = null;
    //String username = app.BOusername;
    int ticketId = 0;
    String childId =  null;
    String tomorrow = null;
    //String parentPhone = app.homePageLoginPhone;
    //String parentPass = app.homePagePass;

    @Test(priority = 0)
    public void test_registration() throws SQLException, ClassNotFoundException, InterruptedException, ParseException {
        tomorrow = app.getTimeStampHelper().getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", prop.getProperty("mobile.registration.pass"), "1230768000000", app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.email"), "dev");
    }


    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, InterruptedException {
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.pass"), prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_supervision_inviteSupervisor(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.pass"))
                .contentType("application/json")
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"value\" : \""+app.homePageLoginPhone+"\"\n" +
                        "}")
                .when()
                .post("supervision/inviteSupervisor")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_tile_getMessages2() throws SQLException, ClassNotFoundException {
        childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", Site.DIPOCKET.toString());
        Response response = app.getClientServicesRequestsHelper().clientServices_v1_tile_getMessages2(cliSessionId, app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.pass"));
        response.then().body("communicationTileList.shortName", hasItem("Approval Pending"));
    }

    @Test(priority = 4)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(app.homePageLoginPhone, app.homePagePass, prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_supervision_childId_acceptRequest() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(app.homePageLoginPhone, app.homePagePass)
                .pathParam("childId", childId)
                .contentType("application/json")
                .header("clisessionid", cliSessionId)
                .when()
                .post("supervision/{childId}/acceptRequest")
                .then().log().all()
                .statusCode(200);
    }


    @Test(priority = 7)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, app.BOusername);
    }

    @Test(priority = 8)
    public void test_BOServices_v1_ticket_take() {
        ticketId = app.getBOHelper().takeSupervisionTicket_dev(cookie, tomorrow);
    }

    @Test(priority = 9)
    public void test_ClientServices_v1_supervisor_childSupervisor() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"childId\" : "+childId+",\n" +
                        "  \"ticketId\" : "+ticketId+"\n" +
                        "}")
                .when()
                .post("/v1/supervisor/childSupervisor")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 10)
    public void test_BOServices_v1_ticket_ticketId_reassign() {
        app.getBoRequestsHelper().boServices_v1_ticket_ticketId_reassign(cookie, ticketId, "AUTO", "test");
    }
}