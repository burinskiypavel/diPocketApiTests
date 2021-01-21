package telenor.registration;

import appmanager.HelperBase;
import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class RegistrationTest extends TestBase {

    @Test(priority = 1)
    public void test_WebServices_v1_auth_authenticate(){
        given()
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .header("content-type", "application/json; charset=utf-8")
                .header("site", "TELENOR")
                .header("authorization", "Basic MzgwNjg1NDQ4NjE1")
                .when()
                .post(app.TDSBaseUrl +"/WebServices/v1/auth/authenticate?value=org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterResponse@2dedf6a0")
                .then()
                .log().all()
                .statusCode(200)
//                .body("languageList.name", hasItems("English", "Polski", "Русский", "Українська"))
                .body("clientFirstName", equalTo("Pavel"));
    }


    @Test(priority = 2)
    public void test_WebServices_v1_account_tokenByCardId(){
        given()
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .header("content-type", "application/json; charset=utf-8")
                .header("site", "TELENOR")
                //.header("authorization", "Basic MzgwNjg1NDQ4NjE1")
                .body("{\n" +
                        "  \"value\" : \"14932\"\n" +
                        "}")
                .when()
                .post(app.TDSBaseUrl +"/WebServices/v1/account/tokenByCardId?value=com.cs.dipocketback.pojo.base.StringContainer@3a70118")
                .then()
                .log().all()
                .statusCode(200)
//                .body("languageList.name", hasItems("English", "Polski", "Русский", "Українська"))
                .body("clientFirstName", equalTo("Pavel"));
    }
}
