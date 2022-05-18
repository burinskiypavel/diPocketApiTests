package tests.bo.boUser;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class BOUserRolesCBOAddNewUserTest extends TestBase {
    String cookie = null;

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic("Viktoria", "kWmaB0s")
                .contentType("application/json")
                .when()
                .post( "/BOServices/v1/user/authentication");
        response.then().log().all()
                .statusCode(200)
                .body("username", equalTo("VIKTORIA"));
        cookie = response.getHeader("Set-Cookie");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_roles(){
                given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/roles")
                        .then().log().all()
                        .statusCode(200)
                        .body("id", hasItems("BO", "CBO"),
                                "name", hasItems("Back officer", "Chief Back officer"));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_all(){
                given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/all")
                        .then().log().all()
                        .statusCode(200)
                        .body("username", hasItem("A.SZEWCZYK"),
                                "phone", hasItem("48663647283"),
                                "email", hasItem("Agnieszka.Szewczyk@sodexo.com"));
    }
}
