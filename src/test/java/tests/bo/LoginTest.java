package tests.bo;

import appmanager.HelperBase;
import base.TestBase;
import config.Properties;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest extends TestBase {

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
        given()
                .log().uri().log().headers()
                .auth().preemptive().basic("PAVELB", "D5kHO7a")
                .contentType("application/json")
                .when()
                .post( "https://support.dipocket.dev/BOServices/v1/user/authentication")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo("PAVELB"));
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_checkAuthentication(){
        given()
                .log().uri().log().headers()
                //.auth().preemptive().basic("PAVELB", "D5kHO7a")
                .cookie("JSESSIONID=5AEF1371E86541E0B545BC09CC579A46")
                .contentType("application/json")
                .when()
                .get( "https://support.dipocket.dev/BOServices/v1/user/checkAuthentication")
                .then().log().all()
                .statusCode(200);
                //.body("username", equalTo("PAVELB"));
    }
}
