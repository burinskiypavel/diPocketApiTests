package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class RolesBOSearchByClientClientIDTests extends TestBase {
    String cookie = null;
    int clientId = 33217;
    String username = "EVGENYA";
    String phone = "380685448615";
    String email = "pavelburinskiy@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, app.BOusername);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated(){
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, app.BOusername, phone, email);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, clientId, "Nona", "Qwerty", "380634413376", "vikarez20@gmail.com", Site.DIPOCKET.toString());
    }
}