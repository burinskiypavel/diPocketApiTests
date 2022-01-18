package tests.bo;

import appmanager.HelperBase;
import base.TestBase;
import config.Properties;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest extends TestBase {

    @Test
    public void test_BOServices_v1_user_authentication(){
        given()
                .log().uri().log().headers()
                .auth().preemptive().basic("PAVELB", "D5kHO7a")
                .contentType("application/json")
                .when()
                .post( "https://http.dipocket.dev/BOServices/v1/user/authentication")
                .then().log().all()
                .statusCode(200);
    }
}
