package tests.bo.boOperations;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddAndDeleteARowTest extends TestBase {
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
        Response res =  given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariff/2");
                res.then().log().all();
                res.then().statusCode(200);
                res.then().body("id", hasItem(notNullValue()),
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

        JsonPath jsonPathEvaluator = res.jsonPath();
        List<Integer> id = jsonPathEvaluator.get("id");
        int size = id.size() - 1;
        int lastId = id.get(size);
        createdId = lastId;
    }

    @Test(priority = 4)
    public void test_BOServices_v1_fee_deleteTariffRule(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("tariffId", createdId)
                .when()
                .post( "/v1/fee/deleteTariffRule")
                .then().log().all()
                .statusCode(200);
    }
}