package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;

public class RenameLimitPlanTest extends TestBase {
    String cookie = null;
    String limitPlanId = "1";
    String randomNumber = app.generateRandomNumber(4);


    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_plan_rename() throws SQLException, ClassNotFoundException {
        System.out.println("randomNumber: " + randomNumber);
        String limitPlanName = app.getDbHelper().getLimitPlanFromDB(limitPlanId);
        System.out.println("limitPlanName: " + limitPlanName);

        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("limitPlanId", limitPlanId)
                .queryParam("limitPlanName", "Pavel_rename_AUTO_"+randomNumber)
                .when()
                .post( "/v1/limit/plan/rename")
                .then().log().all()
                .statusCode(200);
    }
}