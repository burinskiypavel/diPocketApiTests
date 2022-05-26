package tests.bo.boSearch;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class RolesCBOSearchByClientCompanyNameTests extends TestBase {
    String cookie = null;
    String username = "VIKTORIA";
    String phone = "380634413376";
    String email = "vikarezznik60@gmail.com";
    String companyName = "Dipocket";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_user_authentication(app.CBOuserLogin, app.CBOuserPass, username);
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
                .contentType("application/json")
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