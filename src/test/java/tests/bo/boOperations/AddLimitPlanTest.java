package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class AddLimitPlanTest extends TestBase {
    String cookie = null;
    int limitPlanId = 111222333;
    String limitPlanName = "PPP_AUTO";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_plan_create(){
        app.getBoRequestsHelper().boServices_v1_limit_plan_create(cookie, limitPlanId, limitPlanName);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_limit_plan_delete(){
        app.getBoRequestsHelper().boServices_v1_limit_plan_delete(cookie, limitPlanId);
    }
}