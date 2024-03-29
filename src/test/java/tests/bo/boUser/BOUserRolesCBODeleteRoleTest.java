package tests.bo.boUser;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.User_roles;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBODeleteRoleTest extends TestBase {
    String cookie = null;

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, app.CBOusername);

        if(app.getDbHelper().isRoleExistInDB("a_roleID")){
            given()
                    .spec(app.requestSpecBO)
                    .cookie(cookie)
                    .queryParam("roleId", "a_roleID")
                    .when()
                    .post( "/v1/user/role/delete")
                    .then().log().all()
                    .statusCode(200);
        }
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
                .body("username", equalTo(app.CBOusername),
                        "email", equalTo("vikarezznik60@gmail.com"),
                        "roleId", equalTo("CBO"),
                        "phone", equalTo("380634413376"),
                        "lastName", equalTo("Reznik"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_roles(){
        Response res =given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertFalse(app.getBOHelper().isUserRolesIdExist(user_roles, "a_roleID"));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_role_create(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("roleId", "a_roleID")
                .queryParam("roleName","a_roleName")
                .when()
                .post( "/v1/user/role/create")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_roles_(){
        Response res =given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertTrue(app.getBOHelper().isUserRolesIdExist(user_roles, "a_roleID"));
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_role_rightsTree(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("roleId", "a_roleID")
                .when()
                .get( "/v1/user/role/rightsTree")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.data.description", hasItems("Access to Back Office tool", "Access to First Line support", "Access to Portal"),
                        "data.data.code", hasItems("BO", "EXTBO", "Portal"));
    }

    @Test(priority = 8)
    public void test_BOServices_v1_user_role_delete(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("roleId", "a_roleID")
                .when()
                .post( "/v1/user/role/delete")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 9)
    public void test_BOServices_v1_user_roles__(){
        Response res =given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertFalse(app.getBOHelper().isUserRolesIdExist(user_roles, "a_roleID"));
    }
}