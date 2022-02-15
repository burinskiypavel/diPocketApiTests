package tests.bo.boClient;

import base.TestBase;
import io.restassured.response.Response;
import model.bo.boClient.Client_states;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RolesBOUserClientspageTabSelfieTests extends TestBase {
    String cookie = null;
    String username = "PAVELB";
    int userId = 33217;

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication(){
        baseURI = app.BOURL;
        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic("Viktoria", "kWmaB0s")
                .contentType("application/json")
                .when()
                .post( "/BOServices/v1/user/authentication");
        response.then().log().all()
                .statusCode(200)
                .body("username", equalTo("VIKTORIA"));
        cookie = response.getHeader("Set-Cookie");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_client_states(){
        Response res = given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/client/states");
        res.then().log().all().statusCode(200);
        Client_states[] client_states = res.as(Client_states[].class);
        assertThat(client_states[0].getId(), equalTo(-200));
        assertThat(client_states[0].getName(), equalTo("Archived"));
        assertThat(client_states[1].getId(), equalTo(-150));
        assertThat(client_states[1].getName(), equalTo("Forgotten"));
        assertThat(client_states[2].getId(), equalTo(-100));
        assertThat(client_states[2].getName(), equalTo("Banned"));
        assertThat(client_states[3].getId(), equalTo(-1));
        assertThat(client_states[3].getName(), equalTo("Blocked"));
        assertThat(client_states[4].getId(), equalTo(0));
        assertThat(client_states[4].getName(), equalTo("Savepoint"));
        assertThat(client_states[5].getId(), equalTo(1));
        assertThat(client_states[5].getName(), equalTo("Active"));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_client_33217(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/BOServices/v1/client/"+userId+"")
                .then().log().all()
                .statusCode(200)
                .body("email", equalTo("vikarez20@gmail.com"),
                        "id", equalTo(33217),
                        "mainPhone", equalTo("380634413376"),
                        "firstName", equalTo("Nona"),
                        "lastName", equalTo("Qwerty"));
    }
}
