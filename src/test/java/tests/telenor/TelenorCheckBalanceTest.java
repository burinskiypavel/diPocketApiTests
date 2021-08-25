package tests.telenor;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TelenorCheckBalanceTest extends TestBase {
    String token = "512047269";

    @Test(priority = 1)
    public void test_WebServices_v1_anonymous_bandBalance(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .body("{\n" +
                        "  \"publicToken\" : \""+token+"\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/anonymous/bandBalance")
                .then()
                .log().all()
                .statusCode(200)
                .body("publicToken", equalTo("512047269"))
                .body("ccy", equalTo("HUF"))
                .body("availableBalance", equalTo(4000));//53000//102000
    }
}
