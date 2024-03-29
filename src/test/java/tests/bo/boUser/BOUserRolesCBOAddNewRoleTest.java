package tests.bo.boUser;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.User_roles;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewRoleTest extends TestBase {
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
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .when()
                .get( "/v1/user/checkAuthentication")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_authenticated(){
        given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
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

    @Test(priority = 5)
    public void test_BOServices_v1_user_roles(){
        Response res =given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertTrue(app.getBOHelper().isUserRolesIdExist(user_roles, "a_roleID"));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_role_saveRights(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"roleId\" : \"a_roleID\",\n" +
                        "  \"checkCodes\" : [ \"BO\" ]\n" +
                        "}")
                .when()
                .post( "/v1/user/role/saveRights")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
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
}