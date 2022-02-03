package tests.bo;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.User_roles;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOEditRoleTest extends TestBase {
    String cookie = null;
    String newRoleName = app.generateRandomString(5);

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
        Response res =given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertFalse(app.getBOHelper().isUserRolesNameExist(user_roles, newRoleName));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_role_update(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .queryParam("roleId", "1")
                .queryParam("roleName",newRoleName)
                .when()
                .post( "/BOServices/v1/user/role/update")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_roles_(){
        Response res =given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertTrue(app.getBOHelper().isUserRolesNameExist(user_roles, newRoleName));
    }
}
