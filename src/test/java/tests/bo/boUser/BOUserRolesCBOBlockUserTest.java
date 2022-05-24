package tests.bo.boUser;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.response.Response;
import model.bo.Client_sites;
import model.bo.User_All_AllActive;
import model.bo.User_roles;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BOUserRolesCBOBlockUserTest extends TestBase {
    String cookie = null;
    String username = "PAVELB";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_user_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_checkAuthentication(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/checkAuthentication")
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
    public void test_BOServices_v1_client_sites(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/client/sites");
            res.then().log().all().statusCode(200);
        Client_sites[] client_sites = res.as(Client_sites[].class);
        assertThat(client_sites[0].getSite(), equalTo("AIQLABS"));
        assertThat(client_sites[0].getName(), equalTo("AIQLabs"));
        assertThat(client_sites[2].getSite(), equalTo("BACCA"));
        assertThat(client_sites[2].getName(), equalTo("Bacca"));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_allActive(){
                given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/allActive")
                        .then().log().all()
                        .statusCode(200)
                        .body("firstName", hasItem("Anthony"),
                                "lastName", hasItem("Jarman"),
                                "roleId", hasItem("PORTAL"),
                                "stateId", hasItem(10),
                                "stateName", hasItem("Active"),
                                "username", hasItem("A.JARMAN"),
                                "phone", hasItem("447340159323"),
                                "email", hasItem("anthony.jarman@dipocket.org"),
                                "site", hasItem(Site.DIPOCKET.toString()));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_roles(){
        Response res =given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
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
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/all")
                        .then().log().all()
                        .statusCode(200)
                        .body("firstName", hasItem("Agnieszka"),
                                "lastName", hasItem("Szewczyk"),
                                "roleId", hasItem("PORTAL"),
                                "stateId", hasItem(10),
                                "stateName", hasItem("Active"),
                                "username", hasItem("A.SZEWCZYK"),
                                "phone", hasItem("48663647283"),
                                "corpClientId", hasItem(28518),
                                "email", hasItem("Agnieszka.Szewczyk@sodexo.com"),
                                "site", hasItem(Site.DIPOCKET.toString()));
    }

    @Test(priority = 8)
    public void test_BOServices_v1_user_PAVELB(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
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

    @Test(priority = 9)
    public void test_BOServices_v1_user_block(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
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
    public void test_BOServices_v1_user_PAVELB_(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
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

    @Test(priority = 11)
    public void test_BOServices_v1_user_unblock(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
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
    public void test_BOServices_v1_user_PAVELB__(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
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