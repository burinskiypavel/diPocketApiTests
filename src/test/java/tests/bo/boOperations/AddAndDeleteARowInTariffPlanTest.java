package tests.bo.boOperations;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddAndDeleteARowInTariffPlanTest extends TestBase {
    String cookie = null;
    String username = "PAVELBAUTO";
    int createdId;

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_fee_addTariffRule(){
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
        res.then().body("id", hasItem(notNullValue()),
                        "tariffPlanId", hasItems(2),
                        "ruleId", hasItems(-100),
                        "ruleName", hasItems("Apple Pay bonus"),
                        "currencyId", hasItems(826),
                        "currencyCode", hasItems("GBP"),
                        "feePercent", hasItems(nullValue()),
                        "minFeeAmount", hasItems(0),
                        "maxFeeAmount", hasItems(0),
                        "flatFeeAmount", hasItems(0),
                        "feeCurrencyId", hasItems(826),
                        "feeCurrencyCode", hasItems("GBP"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_fee_deleteTariffRule(){
        app.getBoRequestsHelper().boServices_v1_fee_deleteTariffRule(cookie, createdId);
    }
}