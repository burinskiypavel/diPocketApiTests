package requests.bo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class BORequests {

    public void boServices_v1_ticket_states(String cookie) {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get("/v1/ticket/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(10, 50, 100, -10),
                        "name", hasItems("Open", "In progress", "Closed", "Rejected"));
    }

    public void boServices_v1_ticket_types(String cookie) {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get("/v1/ticket/types")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(402, 700, 100, 200, 300, 310, 320),
                        "name", hasItems("PhotoID change", "Client restriction", "SDD check", "FDD check", "PIN incorrect (3)", "PIN change", "Secret answer incorrect (2)"));
    }

    public void boServices_v1_tran_states(String cookie) {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get("/v1/tran/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(-100, -60, -50, -10, 0, 10, 30),
                        "name", hasItems("Error", "Reversed", "Reversing", "Cancelled", "Processing", "Hidden", "Pending"));
    }


    public void boServices_v1_account_other_client_33217(String cookie, int clientId){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/account/other/client/"+clientId+"")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(104447),
                            "clientId", hasItem(clientId),
                            "cardName", hasItem("Test"),
                            "created", hasItem("2022-01-12"),
                            "maskedPan", hasItem("555585******9888"),
                            "accountStateName", hasItem("Closed"));
    }

    public void boServices_v1_account_client_33217(String cookie, int clientId) {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/account/client/"+clientId+"")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(102690),
                        "accountName", hasItem("Bbh"),
                        "clientId", hasItem(clientId),
                        "ccyId", hasItem(826),
                        "ccyCode", hasItem("GBP"),
                        "restAmount", hasItem(0),
                        "stateId", hasItem(-100),
                        "stateName", hasItem("Closed"),
                        "typeId", hasItem(1),
                        "created", hasItem("2021-10-12"),
                        "accStateNameExt", hasItem("Closed"),
                        "clientIdOwner", hasItem(33217),
                        "owner", hasItem(true),
                        "shared", hasItem(false));
    }

    public void boServices_v1_client_33217_paymentDetails(String cookie, int clientId) {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+clientId+"/paymentDetails")
                .then().log().all()
                .statusCode(200)
                .body("paymentType", hasItem(3),
                        "currencyId", hasItem(756),
                        "currencyCode", hasItem("CHF"),
                        "accountName", hasItem("Nona Qwerty"),
                        "bankId", hasItem("WBKPPLPP"),
                        "accountNo", hasItem("PL18109000047340800000085129"),
                        "address", hasItem("Address44 - 11111 City - Ukraine"),
                        "bankName", hasItem("Santander Bank Polska SA - al. Jana Pawla II 17 - 00-854 Warsaw Poland"));

        //        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.paymentType == 3}.paymentType", 3));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.currencyId == 985}.currencyId", 985));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.currencyCode == 'PLN'}.currencyCode", "PLN"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.accountName == 'Nona Qwerty'}.accountName", "Nona Qwerty"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.bankId == 'WBKPPLPP'}.bankId", "WBKPPLPP"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.accountNo == 'PL16109000047335800000085124'}.accountNo", "PL16109000047335800000085124"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.address == 'Address44 - 11111 City - Ukraine'}.address", "Address44 - 11111 City - Ukraine"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.bankName == 'Santander Bank Polska SA - al. Jana Pawla II 17 - 00-854 Warsaw Poland'}.bankName", "Santander Bank Polska SA - al. Jana Pawla II 17 - 00-854 Warsaw Poland"));

    }

    public void boServices_v1_client_availCurrencies(String cookie){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/availCurrencies")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(975, 756, 978),
                        "code", hasItems("BGN", "CHF", "EUR"),
                        "symbol", hasItems("Fr", "€"));
    }

    public void boServices_v1_client_33217_address(String cookie, int clientId){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/"+ clientId +"/address")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItem(clientId),
                        "city", hasItem("City"),
                        "streetLine1", hasItem("Address"),
                        "zip", hasItem("11-11"),
                        "typeId", hasItem(0),
                        "countryId", hasItem(40),
                        "code", hasItem("AT"),
                        "countryName", hasItem("Austria"),
                        "restricted", hasItem(false));
    }

    public void boServices_v1_clientImage_33217_docHistory(String cookie, int clientId){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/33217/docHistory")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(17326),
                        "clientId", hasItem(clientId),
                        "typeId", hasItem(2),
                        "imageInBase64", hasItem(notNullValue()),
                        "added", hasItem("2022-01-20"),
                        "stateId", hasItem(10),
                        "stateName", hasItem("Approved"));
    }
}