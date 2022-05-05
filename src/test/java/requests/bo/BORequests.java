package requests.bo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

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
}
