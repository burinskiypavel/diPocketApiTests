package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;

public class DuplicateLimitPlanTest extends TestBase {
    String cookie = null;
    String oldLimitPlanId = "1";
    String newLimitPlanId = "123";
    String newLimitPlanName = "Pavel_QA_Auto";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        baseURI = app.BOURL;
        basePath = "BOServices";
        app.getDbHelper().deleteLimitPlanFromDB(newLimitPlanId, newLimitPlanName);
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_plan_duplicate(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("oldLimitPlanId", oldLimitPlanId)
                .queryParam("newLimitPlanId", newLimitPlanId)
                .queryParam("newLimitPlanName", newLimitPlanName)
                .when()
                .post( "/v1/limit/plan/duplicate")
                .then().log().all()
                .statusCode(200);
    }
}