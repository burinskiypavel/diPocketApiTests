package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.response.Response;
import javafx.application.Application;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class InviteSupervisorTest extends TestBase {
    String cliSessionId = null;
    String phone = "380685448615";
    String pass = "pasword1";
    String newCardHolderName = null;
    String oldCardHolderName = null;
    String actualCardHolderName = null;
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
    public void test_ClientServices_v1_supervision_inviteSupervisor(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
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
    public void test_ClientServices_v1_tile_getMessages2(){
        Response response = app.getClientServicesRequests().clientServices_v1_tile_getMessages2(cliSessionId, phone, pass);
        response.then().body("communicationTileList.shortName", hasItem("Ожидаем ответ Опекуна"));
    }
}