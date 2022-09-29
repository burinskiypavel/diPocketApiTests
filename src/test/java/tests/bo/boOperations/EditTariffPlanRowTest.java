package tests.bo.boOperations;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class EditTariffPlanRowTest extends TestBase {
    String cookie = null;
    String username = "PAVELBAUTO";
    int createdId;

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_fee_addTariffRule() {
        app.getBoRequestsHelper().boServices_v1_fee_addTariffRule(cookie, 2, -100, 826, 0, 0, 0, 0, 826);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_fee_tariff_2(){
        Response res =  given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariff/2");
        res.then().log().all();
        res.then().statusCode(200);
        int lastId = app.getBOHelper().getLastIdFromResponse(res);
        createdId = lastId;
    }

    @Test(priority = 4)
    public void test_BOServices_v1_fee_updateTariffRule() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"tariffPlanId\" : "+createdId+",\n" +
                        "  \"ruleId\" : 50,\n" +
                        "  \"currencyId\" : 978,\n" +
                        "  \"feePercent\" : 1.0,\n" +
                        "  \"minFeeAmount\" : 200,\n" +
                        "  \"maxFeeAmount\" : 100,\n" +
                        "  \"flatFeeAmount\" : 100,\n" +
                        "  \"feeCurrencyId\" : 978\n" +
                        "}")
                .when()
                .post("/v1/fee/updateTariffRule")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_fee_deleteTariffRule(){
        app.getBoRequestsHelper().boServices_v1_fee_deleteTariffRule(cookie, createdId);
    }
}