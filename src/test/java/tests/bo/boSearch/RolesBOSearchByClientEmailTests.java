package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class RolesBOSearchByClientEmailTests extends TestBase {
    String cookie = null;
    String username = "EVGENYA";
    String phone = "447459005206";
    String email = "vikarez20@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_client_states(){
        app.getBoRequestsHelper().boServices_v1_client_states(cookie);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, "email",  email, "Luiza", "Qwerty", phone, email, Site.DIPOCKET.toString());
    }
}