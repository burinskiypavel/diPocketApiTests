package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;

public class DuplicateLimitPlanTest extends TestBase {
    String cookie = null;
    int planId = 2;
    int tranGroupId = 100;
    int typeId = 105;
    int baseCurrencyId = 975;
    String limitLevel = "EDD";

    String duplicateId = "123";
    String duplicateName = "Pavel_QA_Auto";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        baseURI = app.BOURL;
        basePath = "BOServices";
        app.getDbHelper().deleteLimitPlanFromDB(duplicateId, duplicateName);
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_plan_duplicate(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("oldLimitPlanId", "1")
                .queryParam("newLimitPlanId", "123")
                .queryParam("limitPlanName", "Pavel_QA_Auto")
                .when()
                .post( "/v1/limit/plan/duplicate")
                .then().log().all()
                .statusCode(200);
    }
}