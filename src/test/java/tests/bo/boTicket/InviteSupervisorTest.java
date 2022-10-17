package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class InviteSupervisorTest extends TestBase {
    String cliSessionId = null;
    String phone = "380685448616";
    String pass = "pasword1";
    String regPhone = "380685448615";
    String regPass = "pasword1";
    String newCardHolderName = null;
    String oldCardHolderName = null;
    String actualCardHolderName = null;
    String cookie = null;
    String username = "PAVELB_AUTO_BO";
    int clientId = 29818;
    int ticketId = 0;
    String actualTypeName = null;
    String parentClientId = "39484";
    String childId =  null;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, InterruptedException {
        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", "pasword1");
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
                        "  \"value\" : \"380685448616\"\n" +
                        "}")
                .when()
                .post("supervision/inviteSupervisor")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_tile_getMessages2() throws SQLException, ClassNotFoundException {
        Response response = app.getClientServicesRequests().clientServices_v1_tile_getMessages2(cliSessionId, regPhone, regPass);
        response.then().body("communicationTileList.shortName", hasItem("Ожидаем ответ Опекуна"));
        childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", "DIPOCKET");

    }

    @Test(priority = 4)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException, InterruptedException {
        app.getDbHelper().deleteClientFromDB(regPhone, "DIPOCKET");
        app.getDbHelper().updateClientPhoneFromDB("380685448615", parentClientId);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(regPhone, regPass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_supervision_childId_acceptRequest() throws SQLException, ClassNotFoundException {
        //String childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", "DIPOCKET");
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(regPhone, regPass)
                .pathParam("childId", childId)
                .contentType("application/json")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .post("supervision/{childId}/acceptRequest")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void updatePhoneNumber() throws SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientPhoneFromDB("380685448616", parentClientId);
    }
}