package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

public class EditRowInLimitPlanTest extends TestBase {
    String cookie = null;
    int planId = 1;
    int tranGroupId = 100;
    int typeId = 105;
    int baseCurrencyId = 975;
    String limitLevel = "EDD";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_operPlans(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get("/v1/limit/operPlans")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 10, 11),
                        "name", hasItems("Unlimited", "Standard client limits", "Standard client limits (UpAndGo)"));
    }
}