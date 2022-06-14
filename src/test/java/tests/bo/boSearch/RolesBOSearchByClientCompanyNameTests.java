package tests.bo.boSearch;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class RolesBOSearchByClientCompanyNameTests extends TestBase {
    String cookie = null;
    String username = "EVGENYA";
    String phone = "380992871946";
    String email = "e.kononenko0312+1@gmail.com";
    String companyName = "Dipocket";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated() {
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, username, phone, email);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search() {
        given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .body("{\n" +
                        "  \"companyName\" : \""+companyName+"\"\n" +
                        "}")
                .when()
                .post("/v1/client/search")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(notNullValue()),
                        "mailingAddress", hasItem(notNullValue()),
                        "stateId", hasItem(notNullValue()),
                        "clientStateSName", hasItem(notNullValue()),
                        "site", hasItem(notNullValue()),
                        "companyName", hasItem(notNullValue()),
                        "companyNameChar", hasItem(notNullValue()),
                        "companyName", hasItem(containsString(companyName)));
    }
}