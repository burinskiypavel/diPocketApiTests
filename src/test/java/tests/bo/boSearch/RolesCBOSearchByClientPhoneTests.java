package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class RolesCBOSearchByClientPhoneTests extends TestBase {
    String cookie = null;
    String phone = "380980316499";
    String searchPhone = "380983488583";
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
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, "mainPhone",  searchPhone, "Kevin", "Wow", searchPhone, "himef59747@sinagalore.com", Site.DIPOCKET.toString());
    }
}