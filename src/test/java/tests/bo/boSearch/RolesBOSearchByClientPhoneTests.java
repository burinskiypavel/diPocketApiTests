package tests.bo.boSearch;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class RolesBOSearchByClientPhoneTests extends TestBase {
    String cookie = null;
    String username = "EVGENYA";
    String phone = "380634413376";
    String searchPhone = "380983488583";
    String email = "vikarezznik60@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_user_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_authenticated(){
        app.getBoRequestsHelper().boServices_v1_user_authenticated(cookie, username, phone, email);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, "mainPhone",  searchPhone, "Kevin", "Wow", searchPhone, "himef59747@sinagalore.com", Site.DIPOCKET.toString());
    }
}