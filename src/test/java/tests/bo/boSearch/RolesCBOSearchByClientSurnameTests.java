package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class RolesCBOSearchByClientSurnameTests extends TestBase {
    String cookie = null;
    String lastName = "reznik";
    String phone = "380980316499";
    String phone2 = "380634413376";
    String email = "pavelburinskiy@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated(){
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, app.CBOusername2, phone, email);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, "lastName",  lastName, "Vika", "Reznik", phone2, "vikarezznik60@gmail.com", Site.PLAYIT.toString());
    }
}