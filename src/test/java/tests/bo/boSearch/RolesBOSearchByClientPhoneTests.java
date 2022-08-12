package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class RolesBOSearchByClientPhoneTests extends TestBase {
    String cookie = null;
    String username = "EVGENYA";
    String searchPhone = "380983488583";
    String phone = "380685448615";
    String email = "pavelburinskiy@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, app.BOusername);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated(){
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, app.BOusername, phone, email);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, "mainPhone",  searchPhone, "Kevin", "Wow", searchPhone, "himef59747@sinagalore.com", Site.DIPOCKET.toString());
    }
}