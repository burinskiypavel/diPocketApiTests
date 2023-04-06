package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class RolesCBOSearchByClientMailingStreetTests extends TestBase {
    String cookie = null;
    String phone = "380980316499";
    String email = "pavelburinskiy@gmail.com";
    String mailingAddress = "Qwer st 1";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated() {
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, app.CBOusername2, phone, email);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search() {
                given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"mailingAddress\" : \""+mailingAddress+"\"\n" +
                        "}")
                .when()
                .post("/v1/client/search")
                .then().log().all()
                .statusCode(200)
                .body("firstName", hasItem("Q"),
                        "lastName", hasItem("A"),
                        "mainPhone", hasItem("380992568879"),
                        "email", hasItem("qwert@dd.com"),
                        "mailingAddress", hasItem(mailingAddress),
                        "site", hasItem(Site.DIPOCKET.toString()));
    }
}