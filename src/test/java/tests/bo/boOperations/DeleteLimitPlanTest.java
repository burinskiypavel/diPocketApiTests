package tests.bo.boOperations;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

public class DeleteLimitPlanTest extends TestBase {
    String cookie = null;
    int limitPlanId = 111222333;
    String limitPlanName = "PPP_AUTO";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_plans(){
        Response res = app.getBoRequestsHelper().boServices_v1_limit_plans(cookie);

        res.then().body("id", not(hasItems(limitPlanId)),
                        "name", not(hasItems(limitPlanName)));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_limit_plan_create(){
        app.getBoRequestsHelper().boServices_v1_limit_plan_create(cookie, limitPlanId, limitPlanName);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_limit_plans_(){
        Response res = app.getBoRequestsHelper().boServices_v1_limit_plans(cookie);

        res.then().body("id", hasItems(limitPlanId),
                "name", hasItems(limitPlanName));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_limit_plan_delete(){
        app.getBoRequestsHelper().boServices_v1_limit_plan_delete(cookie, limitPlanId);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_plans__(){
        Response res = app.getBoRequestsHelper().boServices_v1_limit_plans(cookie);

        res.then().body("id", not(hasItems(limitPlanId)),
                "name", not(hasItems(limitPlanName)));
    }
}