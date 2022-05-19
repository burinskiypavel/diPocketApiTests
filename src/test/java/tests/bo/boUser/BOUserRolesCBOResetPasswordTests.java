package tests.bo.boUser;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class BOUserRolesCBOResetPasswordTests extends TestBase {
    String cookie = null;
    String phone = "380685448612";
    String username = "PAVELB1";
    String email = "sdafsdjflstalnd@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_user_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/authenticated")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo("VIKTORIA"),
                        "phone", equalTo("380634413376"),
                        "email", equalTo("vikarezznik60@gmail.com"));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_all(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/all")
                .then().log().all()
                .statusCode(200)
                .body("username", hasItem("A.VAIVARS"),
                        "phone", hasItem("37125680800"),
                        "email", hasItem("arnis.vaivars@twino.eu"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_roles(){
        app.getBoRequestsHelper().boServices_v1_user_roles(cookie);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_PAVELB1(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/"+username+"")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "phone", equalTo(phone),
                        "email", equalTo(email));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_PAVELB1_updatePassword(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .when()
                .post( "/v1/user/"+username+"/updatePassword")
                .then().log().all()
                .statusCode(200);
    }
}