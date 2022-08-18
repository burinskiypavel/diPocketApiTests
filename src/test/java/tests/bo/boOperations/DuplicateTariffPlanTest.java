package tests.bo.boOperations;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DuplicateTariffPlanTest extends TestBase {
    String cookie = null;
    String username = "VIKTORIA";
    int id = 14361371;
    String name = "QA_autotest_name";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        baseURI = app.BOURL;
        basePath = "BOServices";
        app.getDbHelper().deleteFeeTariffPlanDB(String.valueOf(id), name);
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
        Response res = app.getBoRequestsHelper().boServices_v1_limit_plans(cookie);
        res.then().body("id", hasItems(1, 3, 7, 8, 70),
                "name", hasItems("Peak", "Sodexo", "Getsby", "UpandGo"));
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
                .body("phone", hasItems(notNullValue()),
                        "generated", hasItems(notNullValue()),
                        "site", hasItems("DIPOCKET"));
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
                .body("id", hasItems(57),
                        "tariffPlanId", hasItems(1),
                        "ruleId", hasItems(500),
                        "ruleName", hasItems("Fee for ATM used worldwide with conversion"),
                        "flatFeeAmount", hasItems(75),
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

    @Test(priority = 23)
    public void test_BOServices_v1_limit_levels(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/limit/levels")
                .then().log().all()
                .statusCode(200)
                .body("", hasItems("EDD", "FDD", "PSDD", "SDD", "SFDD"));
    }

    @Test(priority = 24)
    public void test_BOServices_v1_limit_tranGroups(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/limit/tranGroups")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 10, 110, 210),
                        "name", hasItems("DiP Transfers (Out)", "Topup (In)", "Cash load (In)"),
                        "tranSign", hasItems(-1 ,1));
    }

    @Test(priority = 25)
    public void test_BOServices_v1_tcc_balances(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/tcc/balances")
                .then().log().all()
                .statusCode(200)
                .body("currencyId", hasItems(840),
                        "code", hasItems("USD"),
                        "paymentDate", hasItems(notNullValue()),
                        "maxPayment", hasItems(403308),
                        "today", hasItems(notNullValue()),
                        "today1", hasItems(notNullValue()),
                        "today2", hasItems(notNullValue()),
                        "today3", hasItems(notNullValue()),
                        "today4", hasItems(notNullValue()),
                        "today5", hasItems(notNullValue()),
                        "today6", hasItems(notNullValue()),
                        "amount_T0", hasItems(notNullValue()),
                        "amount_T1", hasItems(notNullValue()),
                        "amount_T2", hasItems(notNullValue()),
                        "amount_T3", hasItems(notNullValue()),
                        "amount_T4", hasItems(notNullValue()),
                        "amount_T5", hasItems(notNullValue()),
                        "amount_T6", hasItems(notNullValue()));
    }

    @Test(priority = 26)
    public void test_BOServices_v1_fee_tariffPlan_duplicate(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("oldFeeTariffPlanId", 1436137)
                .queryParam("newFeeTariffPlanId", id)
                .queryParam("feeTariffPlanName", name)
                .when()
                .post("/v1/fee/tariffPlan/duplicate")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 27)
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

    @Test(priority = 28)
    public void test_BOServices_v1_fee_tariff_1436137(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/fee/tariff/14361371")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(notNullValue()),
                        "tariffPlanId", hasItems(id),
                        "ruleId", hasItems(190),
                        "ruleName", hasItems("Fee for Face to Face"),
                        "flatFeeAmount", hasItems(50),
                        "feeCurrencyId", hasItems(840),
                        "feeCurrencyCode", hasItems("USD"));
    }
}