package tests.bo.boUser;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class BOUserRolesCBOUnblockUserTest extends TestBase {
    String cookie = null;
    String username = "PAVELB";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication(){
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_checkAuthentication(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/checkAuthentication")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo(true));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_authenticated(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/authenticated")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo("VIKTORIA"),
                        "email", equalTo("vikarezznik60@gmail.com"),
                        "roleId", equalTo("CBO"),
                        "phone", equalTo("380634413376"),
                        "lastName", equalTo("Reznik"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_PAVELB(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/"+username+"")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "email", equalTo("burinskiypavel@gmail.com"),
                        "role.id", equalTo("CBO"),
                        "phone", equalTo("380685448614"),
                        "lastName", equalTo("Burinskiy"),
                        "stateName", equalTo("Active"));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_block(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"username\" : \""+username+"\",\n" +
                        "  \"reason\" : \"test\"\n" +
                        "}")
                .when()
                .post( "/v1/user/block")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_PAVELB_(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/"+username+"")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "email", equalTo("burinskiypavel@gmail.com"),
                        "role.id", equalTo("CBO"),
                        "phone", equalTo("380685448614"),
                        "lastName", equalTo("Burinskiy"),
                        "stateName", equalTo("Blocked"));
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_unblock(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"username\" : \""+username+"\",\n" +
                        "  \"reason\" : \"test\"\n" +
                        "}")
                .when()
                .post( "/v1/user/unblock")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 8)
    public void test_BOServices_v1_user_PAVELB__(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/"+username+"")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "email", equalTo("burinskiypavel@gmail.com"),
                        "role.id", equalTo("CBO"),
                        "phone", equalTo("380685448614"),
                        "lastName", equalTo("Burinskiy"),
                        "stateName", equalTo("Active"));
    }
}