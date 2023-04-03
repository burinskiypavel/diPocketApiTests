package tests.bo.boUser;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class BOUserRolesCBOUnblockUserTest extends TestBase {
    String cookie = null;
    String username = "PAVELB";
    String email = "burinskiypavel@gmail.com";
    String roleId = "CBO";
    String phone = "380685448614";
    String lastName = "Burinskiy";
    String stateName = "Active";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication(){
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
                .statusCode(200);
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
    public void test_BOServices_v1_user_pathParam(){
        app.getBoRequestsHelper().boServices_v1_user_pathParam(cookie, username, email, roleId, phone, lastName, stateName);
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
    public void test_BOServices_v1_user_pathParam_(){
        app.getBoRequestsHelper().boServices_v1_user_pathParam(cookie, username, email, roleId, phone, lastName, "Blocked");
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
    public void test_BOServices_v1_user_pathParam__(){
        app.getBoRequestsHelper().boServices_v1_user_pathParam(cookie, username, email, roleId, phone, lastName, stateName);
    }
}