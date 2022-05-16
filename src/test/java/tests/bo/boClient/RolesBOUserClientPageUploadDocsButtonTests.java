package tests.bo.boClient;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class RolesBOUserClientPageUploadDocsButtonTests extends TestBase {
    String cookie = null;
    int clientId = 33217;
    String reason = "test";

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
        baseURI = app.BOURL;
        basePath = "BOServices";
        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic("Viktoria", "kWmaB0s")
                .contentType("application/json")
                .when()
                .post( "/v1/user/authentication");
        response.then().log().all()
                .statusCode(200)
                .body("username", equalTo("VIKTORIA"));
        cookie = response.getHeader("Set-Cookie");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, clientId);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_clientImage_docTypes(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/docTypes")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
                        "sName", hasItems("Selfie", "PhotoID", "Proof of address", "Smiling Selfie", "PhotoID Back", "Second ID", "Proof of relationship", "Avatar (Large)", "Avatar (Medium)", "Avatar (Small)", "Residence Permit/Visa Type D"));
    }
}
