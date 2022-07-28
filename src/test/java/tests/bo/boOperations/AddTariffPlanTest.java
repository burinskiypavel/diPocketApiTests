package tests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

public class AddTariffPlanTest extends UITestBase {
    String cookie = null;
    String username = "VIKTORIA";
    int id = 123456789;
    String name = "QA_autotest_name";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(String.valueOf(id), name);
        baseURI = app.BOURL;
        basePath = "BOServices";
        app.getDbHelper().deleteFeeTariffPlanDB(String.valueOf(id), name);
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_fee_tariffPlan_create(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("feeTariffPlanId", id)
                .queryParam("feeTariffPlanName", name)
                .when()
                .post("/v1/fee/tariffPlan/create")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_fee_tariffPlan_all_(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariffPlan/all")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(id),
                        "name", hasItems(name));
    }
}
