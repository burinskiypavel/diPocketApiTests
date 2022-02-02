package tests.bo;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.User_roles;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BOUserRolesCBODeleteRoleTest extends TestBase {
    String cookie = null;
    //String username = "PAVELB";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
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
                .body("username", equalTo("VIKTORIA"),
                        "email", equalTo("vikarezznik60@gmail.com"),
                        "roleId", equalTo("CBO"),
                        "phone", equalTo("380634413376"),
                        "lastName", equalTo("Reznik"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_roles(){
        Response res =given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        app.getBOHelper().checkUserRolesId(user_roles, "BO");
        app.getBOHelper().checkUserRolesName(user_roles, "Back officer");
        app.getBOHelper().checkUserRolesId(user_roles, "CBO");
        app.getBOHelper().checkUserRolesName(user_roles, "Chief Back officer");
        app.getBOHelper().checkUserRolesId(user_roles, "FINANCE");
        app.getBOHelper().checkUserRolesName(user_roles, "Finance officer");
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_role_create(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .queryParam("roleId", "a_roleID")
                .queryParam("roleName","a_roleName")
                .when()
                .post( "/BOServices/v1/user/role/create")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_roles_(){
        Response res =given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        app.getBOHelper().checkUserRolesId(user_roles, "BO");
        app.getBOHelper().checkUserRolesName(user_roles, "Back officer");
        app.getBOHelper().checkUserRolesId(user_roles, "CBO");
        app.getBOHelper().checkUserRolesName(user_roles, "Chief Back officer");
        app.getBOHelper().checkUserRolesId(user_roles, "FINANCE");
        app.getBOHelper().checkUserRolesName(user_roles, "Finance officer");
    }

}
