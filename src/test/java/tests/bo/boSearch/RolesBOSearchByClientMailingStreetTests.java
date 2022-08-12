package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

public class RolesBOSearchByClientMailingStreetTests extends TestBase {
    String cookie = null;
    String name = "Vika";
    String username = "EVGENYA";
    String phone = "380685448615";
    String email = "pavelburinskiy@gmail.com";
    String mailingAddress = "Eugieniwska 345";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, app.BOusername);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated() {
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, app.BOusername, phone, email);
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
                .body("firstName", hasItem("    MariEugen"),
                        "lastName", hasItem("Pukpuk"),
                        "mainPhone", hasItem("380931970064"),
                        "email", hasItem("linafaso@gmail.com"),
                        "mailingAddress", hasItem(mailingAddress),
                        "site", hasItem(Site.DIPOCKET.toString()));
    }
}