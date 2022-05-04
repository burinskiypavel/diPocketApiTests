package requests.bo;

import io.restassured.http.Cookie;

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
}
