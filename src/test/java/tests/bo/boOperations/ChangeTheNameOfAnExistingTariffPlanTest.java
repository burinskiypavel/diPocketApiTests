package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

public class ChangeTheNameOfAnExistingTariffPlanTest extends TestBase {
    String cookie = null;
    String username = "PAVELBAUTO";
    int id = 123456789;
    String name = "QA_autotest_name_";
    String randomNumber = app.generateRandomNumber(4);
    String feeTariffPlanName = null;

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        baseURI = app.BOURL;
        basePath = "BOServices";
        System.out.println("randomNumber: " + randomNumber);
        feeTariffPlanName = app.getDbHelper().getFeeTariffPlanFromDB(String.valueOf(id));
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_fee_tariffPlan_all_(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariffPlan/all")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(id),
                        "name", hasItems(feeTariffPlanName));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_fee_tariffPlan_rename(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("feeTariffPlanId",id)
                .queryParam("newFeeTariffPlanName",name + randomNumber)
                .when()
                .post( "/v1/fee/tariffPlan/rename")
                .then().log().all()
                .statusCode(200);
    }
}