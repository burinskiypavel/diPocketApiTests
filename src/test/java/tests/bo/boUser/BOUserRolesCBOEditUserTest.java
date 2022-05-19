package tests.bo.boUser;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class BOUserRolesCBOEditUserTest extends TestBase {
    String cookie = null;
    String phone = "380685448615";
    String username = "PAVELB2";
    String email = "burinskiypavel@gmail.com";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() {
        baseURI = app.BOURL;
        basePath = "BOServices";
        cookie = app.getBoRequestsHelper().boServices_v1_user_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }
}
