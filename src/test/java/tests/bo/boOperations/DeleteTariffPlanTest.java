package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;

public class DeleteTariffPlanTest extends TestBase {
    String cookie = null;
    String username = "VIKTORIA";
    int id = 111222333;
    String name = "Auto_tarif_plan_for_deletion";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(String.valueOf(id), name);
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_fee_tariffPlan_create(){
        app.getBoRequestsHelper().boServices_v1_fee_tariffPlan_create(cookie, id, name);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_fee_tariffPlan_delete(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("feeTariffPlanId",id)
                .when()
                .post( "/v1/fee/tariffPlan/delete")
                .then().log().all()
                .statusCode(200);
    }
}