package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddAndDeleteARowTest extends TestBase {
    String cookie = null;
    String username = "PAVELBAUTO";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_fee_addTariffRule(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"tariffPlanId\" : 2,\n" +
                        "  \"ruleId\" : -100,\n" +
                        "  \"currencyId\" : 826,\n" +
                        "  \"feePercent\" : 0,\n" +
                        "  \"minFeeAmount\" : 0,\n" +
                        "  \"maxFeeAmount\" : 0,\n" +
                        "  \"flatFeeAmount\" : 0,\n" +
                        "  \"feeCurrencyId\" : 826\n" +
                        "}")
                .when()
                .post( "/v1/fee/addTariffRule")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_fee_tariff_2(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariff/2")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(notNullValue()),
                        "tariffPlanId", hasItems(2),
                        "ruleId", hasItems(-100),
                        "ruleName", hasItems("Apple Pay bonus"),
                        "currencyId", hasItems(826),
                        "currencyCode", hasItems("GBP"),
                        "feePercent", hasItems(0),
                        "minFeeAmount", hasItems(0),
                        "maxFeeAmount", hasItems(0),
                        "flatFeeAmount", hasItems(0),
                        "feeCurrencyId", hasItems(826),
                        "feeCurrencyCode", hasItems("GBP"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_fee_deleteTariffRule(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("tariffRuleId", 43243)
                .when()
                .post( "/v1/fee/deleteTariffRule")
                .then().log().all()
                .statusCode(200);
    }
}