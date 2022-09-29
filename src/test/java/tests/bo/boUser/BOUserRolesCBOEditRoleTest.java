package tests.bo.boUser;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.User_roles;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOEditRoleTest extends TestBase {
    String cookie = null;
    String newRoleName = app.generateRandomString(5);

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_roles(){
        Response res =given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertFalse(app.getBOHelper().isUserRolesNameExist(user_roles, newRoleName));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_role_update(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .queryParam("roleId", "1")
                .queryParam("roleName",newRoleName)
                .when()
                .post( "/v1/user/role/update")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_roles_(){
        Response res =given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        assertTrue(app.getBOHelper().isUserRolesNameExist(user_roles, newRoleName));
    }
}