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

    @Test(priority = 8)
    public void test_BOServices_v1_fee_tariffPlan_all(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariffPlan/all")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 2, 191, 98787777),
                        "name", hasItems("Poland - standard", "EUR - corporate", "Credissimo - Main account", "Peak - Cashacard Business EUR"));
    }

    @Test(priority = 9)
    public void test_BOServices_v1_limit_operPlans(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/limit/operPlans")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 10, 11),
                        "name", hasItems("Unlimited", "Standard client limits", "Standard client limits (UpAndGo)"));
    }

    @Test(priority = 10)
    public void test_BOServices_v1_account_types(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/account/types")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 5),
                        "sNameEng", hasItems("Regular", "No GPS"));
    }

    @Test(priority = 11)
    public void test_BOServices_v1_client_languages(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/languages")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(2, 3, 1, 5, 6, 7, 8, 4, 9),
                        "name", hasItems("Українська", "Polski", "English", "Русский"),
                        "engName", hasItems("Ukrainian", "Polish", "English", "Russian"),
                        "code3", hasItems("ukr", "pol", "eng", "rus"),
                        "code2", hasItems("uk", "pl", "en", "ru"));
    }

    @Test(priority = 12)
    public void test_BOServices_v1_client_countries(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/countries")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(76, 554, 840),
                        "code", hasItems("BR", "NZ", "US"),
                        "name", hasItems("Brazil", "New Zealand", "United States"),
                        "isRestricted", hasItems(false, false, false));
    }

    @Test(priority = 13)
    public void test_BOServices_v1_client_statuses(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/statuses")
                .then().log().all()
                .statusCode(200)
                .body("", hasItems("FDD", "PFDD", "PSDD", "SDD", "SFDD"));
    }

    @Test(priority = 14)
    public void test_BOServices_v1_tcc_payments(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/tcc/payments")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(2160),
                        "stateId", hasItems(10),
                        "stateName", hasItems("Created"),
                        "currency", hasItems("USD"),
                        "amount", hasItems(100),
                        "status", hasItems("ready_to_send"),
                        "paymentType", hasItems("priority"),
                        "reference", hasItems("Payment[2160]"),
                        "reason", hasItems("No reason"),
                        "paymentDate", hasItems("2019-07-26"),
                        "createDat", hasItems("2019-07-26T13:05:01.844556Z"),
                        "username", hasItems("FINANCE1"));
    }

    @Test(priority = 15)
    public void test_BOServices_v1_tcc_payment_states(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/tcc/payment/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(-10, 0, 10),
                        "name", hasItems("TCC Error", "To Create", "Created"));
    }

    @Test(priority = 16)
    public void test_BOServices_v1_tcc_payment_currencies(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/tcc/payment/currencies")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(348, 756, 826, 840, 978, 985),
                        "code", hasItems("HUF", "CHF", "GBP", "USD", "EUR", "PLN"));
    }

    @Test(priority = 17)
    public void test_BOServices_v1_reconciliation_extFiles_26_07_2022(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/reconciliation/extFiles/26.07.2022")
                .then().log().all()
                .statusCode(200)
                .body("typeId", hasItems(1, 3, 4, 5, 6),
                        "typeName", hasItems("Transaction Data File", "Advisement (HUF)", "Advisement (PLN)", "Advisement (GBP)", "Advisement (EUR)", "Advisement (USD)"),
                        "systemName", hasItems("GPS", "MC"));
    }

    @Test(priority = 18)
    public void test_BOServices_v1_bankTransfer_list(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("typeName", "Today")
                .queryParam("fromDate", "26.07.2015")
                .queryParam("tillDate", "26.07.2022")
                .when()
                .get( "/v1/bankTransfer/list")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 19)
    public void test_BOServices_v1_client_verifyCodesCount(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/verifyCodesCount")
                .then().log().all()
                .statusCode(200)
                .body("phone", hasItems("380929019081", "380919019083"),
                        "generated", hasItems("31.08.2017 15:41:19", "27.04.2017 17:21:23"),
                        "site", hasItems("DIPOCKET", "PZT"));
    }

    @Test(priority = 20)
    public void test_BOServices_v1_fee_tariff_1(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariff/1")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(13),
                        "tariffPlanId", hasItems(1),
                        "ruleId", hasItems(400),
                        "ruleName", hasItems("Fee for Move My Funds"),
                        "flatFeeAmount", hasItems(0),
                        "feeCurrencyId", hasItems(985),
                        "feeCurrencyCode", hasItems("PLN"));
    }

    @Test(priority = 21)
    public void test_BOServices_v1_fee_rule_all(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/rule/all")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(-100, 10010, 10231),
                        "name", hasItems("Apple Pay bonus", "Fee for POS Refund with conversion", "Fee for Refund (Financial Reversal)"),
                        "description", hasItems("Fee for POS transaction Refund with conversion", "Fee for Refund (Financial Reversal)"));
    }

    @Test(priority = 22)
    public void test_BOServices_v1_limit_types(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/limit/types")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 100, 250, 260),
                        "name", hasItems("Annual", "Max per single trx", "Min per transaction", "High account balance limit"));
    }
}