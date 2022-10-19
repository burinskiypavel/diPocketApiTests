package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.testng.Assert.assertEquals;

public class RejectSupervisorTest extends TestBase {
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
    int ticketId = 0;
    String actualTypeName = null;
    String parentClientId = "39484";
    String childId =  null;
    String supervisorId = "39571";

    @Test(priority = 0)
    public void test_registration() throws SQLException, ClassNotFoundException, InterruptedException {
        app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", "pasword1", "1230768000000");
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
                        "  \"value\" : \"380980316499\"\n" +
                        "}")
                .when()
                .post("supervision/inviteSupervisor")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_ClientServices_v1_tile_getMessages2() throws SQLException, ClassNotFoundException {
        childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", "DIPOCKET");
        Response response = app.getClientServicesRequests().clientServices_v1_tile_getMessages2(cliSessionId, regPhone, regPass);
        response.then().body("communicationTileList.shortName", hasItem("Ожидаем ответ Опекуна"));

    }

    @Test(priority = 4)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException, InterruptedException {
        //app.getDbHelper().deleteClientFromDB(regPhone, "DIPOCKET");
        //app.getDbHelper().updateClientPhoneFromDB("380685448617", childId);
        //app.getDbHelper().updateClientPhoneFromDB("380685448615", parentClientId);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket("380980316499", "reset246740", HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 5)
    public void test_ClientServices_v1_supervision_childId_acceptRequest() throws SQLException, ClassNotFoundException {
        //String childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", "DIPOCKET");
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic("380980316499", "reset246740")
                .pathParam("childId", childId)
                .contentType("application/json")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .post("supervision/{childId}/acceptRequest")
                .then().log().all()
                .statusCode(200);
    }

    //@Test(priority = 6)
    //public void updatePhoneNumber() throws SQLException, ClassNotFoundException {
        //app.getDbHelper().updateClientPhoneFromDB("380685448616", parentClientId);
        //app.getDbHelper().updateClientPhoneFromDB("380685448615", childId);

    //}

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
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, "29.12.2023 23:35:50");
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
    public void test_ClientServices_v1_supervisor_reject() throws SQLException, ClassNotFoundException {
        //String childId = app.getDbHelper().getClientIdFromDB("testdipocket@gmail.com", "DIPOCKET");
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