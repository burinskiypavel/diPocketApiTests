package requests.bo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class BORequests {

    public void boServices_v1_ticket_states(String cookie){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/ticket/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(10, 50, 100, -10),
                        "name", hasItems("Open", "In progress", "Closed", "Rejected"));
    }

    public void boServices_v1_ticket_types(String cookie){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/ticket/types")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(402, 700, 100, 200, 300, 310, 320),
                        "name", hasItems("PhotoID change", "Client restriction", "SDD check", "FDD check", "PIN incorrect (3)", "PIN change", "Secret answer incorrect (2)"));
    }
}
