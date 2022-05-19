package tests.bo.boUser;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BOUserRolesCBOEditUserTest extends TestBase {
    String cookie = null;
    String phone = "380685448614";
    String username = "PAVELB";
    String email = "burinskiypavel@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_user_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_roles(){
        app.getBoRequestsHelper().boServices_v1_user_roles(cookie);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_all(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/all")
                .then().log().all()
                .statusCode(200)
                .body("username", hasItem("A.VAIVARS"),
                        "phone", hasItem("37125680800"),
                        "email", hasItem("arnis.vaivars@twino.eu"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_PAVELB(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/user/PAVELB")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "phone", equalTo(phone),
                        "email", equalTo(email));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_verifyPhone(){
        app.getBoRequestsHelper().boServices_v1_user_verifyPhone(cookie, phone, true);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_corpClients_site_SODEXO(){
        app.getBoRequestsHelper().boServices_v1_user_corpClients_site_SODEXO(cookie, "Sodexo New LE", Site.SODEXO.toString());
    }
}
