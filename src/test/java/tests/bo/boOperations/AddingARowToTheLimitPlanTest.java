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
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_addLimitValues(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"planId\" : "+planId+",\n" +
                        "  \"tranGroupId\" : "+tranGroupId+",\n" +
                        "  \"typeId\" : "+typeId+",\n" +
                        "  \"baseCurrencyId\" : "+baseCurrencyId+",\n" +
                        "  \"limitLevel\" : \""+limitLevel+"\",\n" +
                        "  \"limitAmount\" : 10000\n" +
                        "}")
                .when()
                .post("/v1/limit/addLimitValues")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_limit_delete(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"planId\" : "+planId+",\n" +
                        "  \"tranGroupId\" : "+tranGroupId+",\n" +
                        "  \"typeId\" : "+typeId+",\n" +
                        "  \"baseCurrencyId\" : "+baseCurrencyId+",\n" +
                        "  \"limitLevel\" : \""+limitLevel+"\"\n" +
                        "}")
                .when()
                .post("/v1/limit/delete")
                .then().log().all()
                .statusCode(200);
    }
}