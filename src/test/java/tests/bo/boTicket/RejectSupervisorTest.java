package tests.bo.boTicket;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.bo.boServices.SupervisorApproveRejectRequest;
import model.clientServices.SupervisionInviteSupervisorRequest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

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
    Gson gson = new Gson();
    SupervisorApproveRejectRequest supervisorRejectRequest = new SupervisorApproveRejectRequest();
    SupervisionInviteSupervisorRequest supervisionInviteSupervisorRequest = new SupervisionInviteSupervisorRequest();

    @Test(priority = 0)
    public void test_registration() throws SQLException, ClassNotFoundException, InterruptedException, ParseException {
        tomorrow = app.getTimeStampHelper().getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", "pasword1", "1230768000000", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
        //cliSessionId = app.getLogin_registrationHelper().loginDipocket(regPhone, regPass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }


    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, InterruptedException {
        //app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", "pasword1", "1230768000000");
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(regPhone, regPass, prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_supervision_inviteSupervisor(){
        supervisionInviteSupervisorRequest.setValue(parentPhone);
        String json = gson.toJson(supervisionInviteSupervisorRequest);

        app.getClientServicesRequestsHelper().clientServices_v1_supervision_inviteSupervisor(prop.getProperty("mobile.base.url"), regPhone, regPass, cliSessionId, json);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_tile_getMessages2() throws SQLException, ClassNotFoundException {
        childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", Site.DIPOCKET.toString());
        Response response = app.getClientServicesRequestsHelper().clientServices_v1_tile_getMessages2(cliSessionId, regPhone, regPass);
        response.then().body("communicationTileList.shortName", hasItem("Approval Pending"));

    }

    @Test(priority = 4)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(parentPhone, parentPass, prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_supervision_childId_acceptRequest() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(parentPhone, parentPass)
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
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 8)
    public void test_BOServices_v1_ticket_take() {
        ticketId = app.getBOHelper().takeSupervisionTicket_dev(cookie, tomorrow);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_supervisor_reject() {
        supervisorRejectRequest.setChildId(childId);
        supervisorRejectRequest.setSupervisorId(supervisorId);
        supervisorRejectRequest.setTicketId(ticketId);
        String json = gson.toJson(supervisorRejectRequest);

        app.getBoRequestsHelper().boServices_v1_supervisor_reject(cookie, json);
    }
}