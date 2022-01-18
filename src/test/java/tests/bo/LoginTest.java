package tests.bo;

import appmanager.HelperBase;
import base.TestBase;
import config.Properties;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest extends TestBase {
    String cookie = null;

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic("PAVELB", "D5kHO7a")
                .contentType("application/json")
                .when()
                .post( "https://support.dipocket.dev/BOServices/v1/user/authentication");
        response.then().log().all()
                .statusCode(200)
                .body("username", equalTo("PAVELB"));
        cookie = response.getHeader("Set-Cookie");
        System.out.println("cookie: " + cookie);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_checkAuthentication(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "https://support.dipocket.dev/BOServices/v1/user/checkAuthentication")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo(true));
    }
}