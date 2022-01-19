package tests.bo;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.Client_sites;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BOLoginTest extends TestBase {
    String cookie = null;
    String username = "PAVELB";
    String URL = "https://support.dipocket.dev";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
        baseURI = URL;
        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic(username, "D5kHO7a")
                .contentType("application/json")
                .when()
                .post( "/BOServices/v1/user/authentication");
        response.then().log().all()
                .statusCode(200)
                .body("username", equalTo(username));
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
                .get( "/BOServices/v1/user/checkAuthentication")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo(true));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_authenticated(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/authenticated")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "email", equalTo("burinskiypavel@gmail.com"),
                        "roleId", equalTo("CBO"),
                        "phone", equalTo("380685448615"),
                        "lastName", equalTo("Burinskiy"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_client_sites(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/client/sites");
            res.then().log().all().statusCode(200);
        Client_sites[] client_sites = res.as(Client_sites[].class);
        assertThat(client_sites[0].getSite(), equalTo("AIQLABS"));
        assertThat(client_sites[0].getName(), equalTo("AIQLabs"));
        assertThat(client_sites[2].getSite(), equalTo("BACCA"));
        assertThat(client_sites[2].getName(), equalTo("Bacca"));
    }
}