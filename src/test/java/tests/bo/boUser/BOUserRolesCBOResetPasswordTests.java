package tests.bo.boUser;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BOUserRolesCBOResetPasswordTests extends TestBase {
    String cookie = null;
    String phone = "380685448612";
    String username = "PAVELB1";
    String email = "sdafsdjflstalnd@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated(){
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, "VIKTORIA", "380634413376", "vikarezznik60@gmail.com");
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_all(){
        app.getBoRequestsHelper().boServices_v1_user_all(cookie, "A.VAIVARS", "Arnis", "37125680800", "arnis.vaivars@twino.eu");
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_roles(){
        app.getBoRequestsHelper().boServices_v1_user_roles(cookie);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_PAVELB1(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
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
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .post( "/v1/user/"+username+"/updatePassword")
                .then().log().all()
                .statusCode(200);
    }
}