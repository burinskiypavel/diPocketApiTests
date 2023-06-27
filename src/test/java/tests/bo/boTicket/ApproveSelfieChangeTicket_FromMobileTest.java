package tests.bo.boTicket;

import base.TestBase;
import com.google.gson.Gson;
import model.clientServices.ClientProfileUpdateSelfieRequest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;

public class ApproveSelfieChangeTicket_FromMobileTest extends TestBase {
    String cliSessionId = null;
    String cookie = null;
    int clientId = app.homePageClientId;
    int ticketId = 0;
    String actualTypeName = null;
    String tomorrow = null;
    Gson gson = new Gson();
    ClientProfileUpdateSelfieRequest clientProfileUpdateSelfieRequest = new ClientProfileUpdateSelfieRequest();

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, ParseException {
        tomorrow = app.getTimeStampHelper().getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(app.homePageLoginPhone, app.homePagePass, prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_clientProfile_updateSelfie() {
        clientProfileUpdateSelfieRequest.setBase64Selfie1("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\\nSSEKiX8B/9k=");
        clientProfileUpdateSelfieRequest.setBase64Selfie2("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\\nSSEKiX8B/9k=");
        String json = gson.toJson(clientProfileUpdateSelfieRequest);

        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(app.homePageLoginPhone, app.homePagePass)
                .contentType("application/json")
                .header("clisessionid", cliSessionId)
                .body(json)
                .when()
                .put("clientProfile/updateSelfie")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, app.BOusername);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_ticket_take() {
        ticketId = app.getBOHelper().takeSelfieChangeTicket_dev(cookie, tomorrow);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_client_clientId_approveSelfie() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .contentType("application/json")
                .queryParam("ticketId", ticketId)
                .when()
                .post("/v1/client/{clientId}/approveSelfie")
                .then().log().all()
                .statusCode(200);
    }
}