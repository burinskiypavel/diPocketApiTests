package tests.bo.boSearch;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class RolesCBOSearchByClientCompanyNameTests extends TestBase {
    String cookie = null;
    String phone = "380980316499";
    String email = "pavelburinskiy@gmail.com";
    String companyName = "Dipocket";

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
                        "companyName", hasItem(containsString(companyName)));
    }
}