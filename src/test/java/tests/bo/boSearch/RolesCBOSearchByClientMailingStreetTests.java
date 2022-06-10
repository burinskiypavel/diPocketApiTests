package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItem;

public class RolesCBOSearchByClientMailingStreetTests extends TestBase {
    String cookie = null;
    String name = "Vika";
    String username = "VIKTORIA";
    String phone = "380634413376";
    String email = "vikarezznik60@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated() {
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, username, phone, email);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search() {
                given()
                .log().uri().log().headers().log().body()
                .cookie(cookie)
                        .header("bo-auth-token", "123456")
                .contentType("application/json")
                .body("{\n" +
                        "  \"mailingAddress\" : \"vila\"\n" +
                        "}")
                .when()
                .post("/v1/client/search")
                .then().log().all()
                .statusCode(200)
                .body("firstName", hasItem("Vika"),
                        "lastName", hasItem("Petrova"),
                        "mainPhone", hasItem("380634413376"),
                        "email", hasItem("vikarezznik60@gmail.com"),
                        "site", hasItem(Site.DIPOCKET.toString()));
    }
}