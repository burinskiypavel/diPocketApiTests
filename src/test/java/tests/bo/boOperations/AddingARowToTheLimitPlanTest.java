package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AddingARowToTheLimitPlanTest extends TestBase {
    String cookie = null;
    int planId = 1;
    int tranGroupId = 100;
    int typeId = 105;
    int baseCurrencyId = 975;
    String limitLevel = "EDD";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_addLimitValues(){
        app.getBoRequestsHelper().boServices_v1_limit_addLimitValues(cookie, planId, tranGroupId, typeId, baseCurrencyId, limitLevel, "10000");
    }

    @Test(priority = 3)
    public void test_BOServices_v1_limit_delete(){
        app.getBoRequestsHelper().boServices_v1_limit_delete(cookie, planId, tranGroupId, typeId, baseCurrencyId, limitLevel);
    }
}