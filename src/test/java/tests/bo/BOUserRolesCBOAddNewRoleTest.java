package tests.bo;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.User_roles;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewRoleTest extends TestBase {

    String cookie = null;

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() throws SQLException, ClassNotFoundException {
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

        if(app.getDbHelper().isRoleExistInDB("a_roleID")){
            given()
                    .log().uri().log().headers()
                    .cookie(cookie)
                    .contentType("application/json")
                    .queryParam("roleId", "a_roleID")
                    .when()
                    .post( "/BOServices/v1/user/role/delete")
                    .then().log().all()
                    .statusCode(200);
        }
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

    @Test(priority = 5)
    public void test_BOServices_v1_user_roles(){
        Response res =given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertTrue(app.getBOHelper().isUserRolesIdExist(user_roles, "a_roleID"));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_role_saveRights(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"roleId\" : \"a_roleID\",\n" +
                        "  \"checkCodes\" : [ \"BO\" ]\n" +
                        "}")
                .when()
                .post( "/BOServices/v1/user/role/saveRights")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_role_delete(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .queryParam("roleId", "a_roleID")
                .when()
                .post( "/BOServices/v1/user/role/delete")
                .then().log().all()
                .statusCode(200);
    }
}
