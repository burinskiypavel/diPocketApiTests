package tests.bo.boUser;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.response.Response;
import model.bo.User_roles;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BOUserRolesCBOBlockUserTest extends TestBase {
    String cookie = null;
    String username = "PAVELB";
    String email = "burinskiypavel@gmail.com";
    String roleId = "CBO";
    String phone = "380685448614";
    String lastName = "Burinskiy";
    String stateName = "Active";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication(){
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, app.CBOusername);
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
    public void test_BOServices_v1_client_sites(){
         given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/client/sites")
                 .then().log().all()
                 .statusCode(200)
                .body("site", hasItems("AIQLABS", "AWAS", "BILLON", "DIPOCKET", "PEAK", "SODEXO"),
                        "name", hasItems("AIQLabs", "Agency Welfare Asylum Seekers", "Sodexo", "Billon", "DiPocket", "Peak", "Sodexo"));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_allActive(){
                given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .when()
                .get( "/v1/user/allActive")
                        .then().log().all()
                        .statusCode(200)
                        .body("firstName", hasItem("Pavel"),
                                "lastName", hasItem("Burinskiy"),
                                "roleId", hasItem("CBO"),
                                "stateId", hasItem(10),
                                "stateName", hasItem("Active"),
                                "username", hasItem("PAVELB1"),
                                "phone", hasItem("380685448612"),
                                "email", hasItem("sdafsdjflstalnd@gmail.com"),
                                "site", hasItem(Site.SODEXO.toString()));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_roles(){
        Response res =given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles");
        res.then().log().all().statusCode(200);
        User_roles[] user_roles = res.as(User_roles[].class);

        app.getBOHelper().checkUserRolesId(user_roles, "BO");
        app.getBOHelper().checkUserRolesName(user_roles, "Back officer");
        app.getBOHelper().checkUserRolesId(user_roles, "CBO");
        app.getBOHelper().checkUserRolesName(user_roles, "Chief Back officer");
        app.getBOHelper().checkUserRolesId(user_roles, "FINANCE");
        app.getBOHelper().checkUserRolesName(user_roles, "Finance officer");
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_all(){
                given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .when()
                .get( "/v1/user/all")
                        .then().log().all()
                        .statusCode(200)
                        .body("firstName", hasItem("Anna"),
                                "lastName", hasItem("Karpiliova"),
                                "roleId", hasItem("APIUSER"),
                                "stateId", hasItem(10),
                                "stateName", hasItem("Active"),
                                "username", hasItem("ANNASODEXOTEST"),
                                "phone", hasItem("380935966093"),
                                "email", hasItem("work.annak@gmail.com"),
                                "site", hasItem(Site.SODEXO.toString()));
    }

    @Test(priority = 8)
    public void test_BOServices_v1_user_pathParam(){
        app.getBoRequestsHelper().boServices_v1_user_pathParam(cookie, username, email, roleId, phone, lastName, stateName);
    }

    @Test(priority = 9)
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

    @Test(priority = 10)
    public void test_BOServices_v1_user_pathParam_(){
        app.getBoRequestsHelper().boServices_v1_user_pathParam(cookie, username, email, roleId, phone, lastName, "Blocked");
    }

    @Test(priority = 11)
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

    @Test(priority = 12)
    public void test_BOServices_v1_user_pathParam__(){
        app.getBoRequestsHelper().boServices_v1_user_pathParam(cookie, username, email, roleId, phone, lastName, stateName);
    }
}