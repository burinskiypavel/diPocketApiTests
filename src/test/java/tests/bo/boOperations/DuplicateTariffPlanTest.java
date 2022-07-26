package tests.bo.boOperations;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class DuplicateTariffPlanTest extends TestBase {
    String cookie = null;
    String username = "VIKTORIA";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_limit_values(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("limitPlanId", "1")
                .queryParam("limitPlanLevel", "EDG")
                .queryParam("baseCurrencyId", "975")
                .when()
                .get( "/v1/limit/values/")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_bankTransfer_manualFundsTransfer_list(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("typeName", "Today")
                .queryParam("fromDate", "undefined")
                .queryParam("tillDate", "undefined")
                .when()
                .get( "/v1/bankTransfer/manualFundsTransfer/list")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_card_program(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/card/program")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 12, 39, 52, 400, 211),
                        "intName", hasItems("Dipocket - Thames", "MBA", "PlayIT card", "CafeTrend - HUF", "UPROMANIA card RON"),
                        "name", hasItems("DiPocket", "MBA", "BGN", "UPROMANIA card RON"));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_limit_plans(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/limit/plans")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 3, 7, 8, 70, 11122233),
                        "name", hasItems("Standard", "Peak", "Sodexo", "Getsby", "UpandGo", "Duplicate limit plan"));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_corpClients_contractCountries(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/corpClients/contractCountries")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(440, 826),
                        "name", hasItems("Lithuania", "United Kingdom"));
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_corpClients_types(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/corpClients/types")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems("A", "C", "L"),
                        "sName", hasItems("Card storage", "Corporate", "Legal entity"));
    }
}