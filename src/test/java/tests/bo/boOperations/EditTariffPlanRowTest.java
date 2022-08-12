package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class EditTariffPlanRowTest extends TestBase {
    String cookie = null;
    String username = "PAVELBAUTO";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_fee_addTariffRule() {
//        given()
//                .spec(app.requestSpecBO)
//                .cookie(cookie)
//                .body("{\n" +
//                        "  \"tariffPlanId\" : 2,\n" +
//                        "  \"ruleId\" : -100,\n" +
//                        "  \"currencyId\" : 826,\n" +
//                        "  \"feePercent\" : 0,\n" +
//                        "  \"minFeeAmount\" : 0,\n" +
//                        "  \"maxFeeAmount\" : 0,\n" +
//                        "  \"flatFeeAmount\" : 0,\n" +
//                        "  \"feeCurrencyId\" : 826\n" +
//                        "}")
//                .when()
//                .post( "/v1/fee/addTariffRule")
//                .then().log().all()
//                .statusCode(200);
        app.getBoRequestsHelper().boServices_v1_fee_addTariffRule(cookie, 2, -100, 826, 0, 0, 0, 0, 826);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_fee_updateTariffRule() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"tariffPlanId\" : 45768,\n" +
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

    @Test(priority = 4)
    public void test_BOServices_v1_fee_tariffPlan_delete(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("feeTariffPlanId", "45768")
                .when()
                .post( "/v1/fee/tariffPlan/delete")
                .then().log().all()
                .statusCode(200);
    }
}