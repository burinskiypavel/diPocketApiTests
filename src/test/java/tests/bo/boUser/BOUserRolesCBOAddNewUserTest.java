package tests.bo.boUser;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewUserTest extends TestBase {
    String cookie = null;
    String phone = "380639348839";
    String username = "PAVELB2";
    String email = "burinskiypavel@gmail.com";
    String firstName = "Pavel";

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        if(app.getDbHelper().isBOUserExistInDB(username)){
            app.getDbHelper().deleteBOUserFromDB(username);
        }

        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, "VIKTORIA");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_roles(){
        app.getBoRequestsHelper().boServices_v1_user_roles(cookie);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_all(){
                given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .when()
                .get( "/v1/user/all")
                        .then().log().all()
                        .statusCode(200)
                        .body("username", not(hasItem(username)),
                                "username", hasItem("A.VAIVARS"),
                                "phone", hasItem("37125680800"),
                                "email", hasItem("arnis.vaivars@twino.eu"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_allActive(){
        app.getBoRequestsHelper().boServices_v1_user_allActive(cookie, "A.JARMAN", "447340159323", "anthony.jarman@dipocket.org");
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_corpClients_site_SODEXO(){
        app.getBoRequestsHelper().boServices_v1_user_corpClients_site_SODEXO(cookie, "Sodexo New LE", Site.SODEXO.toString());
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_verifyPhone(){
        app.getBoRequestsHelper().boServices_v1_user_verifyPhone(cookie, phone, true);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_create() throws SQLException, ClassNotFoundException {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body("{\n" +
                        "  \"username\" : \""+username+"\",\n" +
                        "  \"firstName\" : \""+firstName+"\",\n" +
                        "  \"lastName\" : \"Burinskiy\",\n" +
                        "  \"roleId\" : \"CBO\",\n" +
                        "  \"phone\" : \""+phone+"\",\n" +
                        "  \"email\" : \""+email+"\",\n" +
                        "  \"site\" : \"SODEXO\"\n" +
                        "}")
                .when()
                .post( "/v1/user/create")
                .then().log().all()
                .statusCode(200);

        assertTrue(app.getDbHelper().isBOUserExistInDB(username));
    }

    @Test(priority = 8)
    public void test_BOServices_v1_user_all_() throws SQLException, ClassNotFoundException {
        app.getBoRequestsHelper().boServices_v1_user_all(cookie, username, firstName, phone, email);

        if(app.getDbHelper().isBOUserExistInDB(username)){
            app.getDbHelper().deleteBOUserFromDB(username);
        }
    }
}