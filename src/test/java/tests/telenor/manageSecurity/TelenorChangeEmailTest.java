package tests.telenor.manageSecurity;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.testng.Assert.assertEquals;

public class TelenorChangeEmailTest extends TestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);
    String cliSessionId = null;
    String newEmail = "telenorchangeemailtest2@mailsac.com";
    String secretAnswer = "QA";
    String offloadFundsLoginPhone =  "$5_" + app.offloadFundsPhone;

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode() throws SQLException, ClassNotFoundException {
        app.getDbHelper().updateEmailForTelenorFromDB(newEmail, "TELENOR", "telenorchangeemailtest3@mailsac.com", "380932485981");
        System.out.println("smsCod:" + smsCode);
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.offloadFundsPhone+"\"\n" +
                        "}")
                .when()
                .post("/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void test_WebServices_v1_auth_authenticate() {
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();

        assertEquals(res.getStatusCode(), 200);
        res.then().assertThat().body("clientFirstName", equalTo("Test"));
        res.then().assertThat().body("clientLastName", equalTo("QA"));
        res.then().assertThat().body("mainPhone", equalTo(app.offloadFundsPhone));
    }

    @Test(priority = 3)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"secAnswer\" : \""+secretAnswer+"\"\n" +
                        "}")
                .when()
                .post("/WebServices/v1/clientProfile/checkSecAnswAttempts")
                .then()
                .log().all()
                .statusCode(200)
                .body("attemptsCount", equalTo(0))
                .body("attemptsLeft", equalTo(3));
    }

    @Test(priority = 4)
    public void test_WebServices_v1_clientProfile_verifyEmail(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", secretAnswer)
                .body("{\n" +
                        "  \"value\" : \""+newEmail+"\"\n" +
                        "}\n")
                .when()
                .post("/WebServices/v1/clientProfile/verifyEmail")
                .then()
                .log().all()
                .statusCode(200)
                .body(blankOrNullString());
    }

    @Test(priority = 5)
    public void test_WebServices_v1_clientProfile_clientInfo(){
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTelenor)
                .auth().preemptive().basic(offloadFundsLoginPhone, smsCode)
                .header("clisessionid", cliSessionId)
                .when()
                .get("/WebServices/v1/clientProfile/clientInfo")
                .then()
                .log().all()
                .statusCode(200)
                .body("email", equalTo(newEmail))
                .body("fullName", equalTo("Test QA"));
    }

    @Test(priority = 6)
    public void test_confirm_email_link_from_mailsac() throws InterruptedException {
        //String link_link = app.getTelenorHelper().getChageEmailConfirmationTelenorLinkFromMailSac();
        String link_link = app.getTelenorHelper().getEmailConfirmationTelenorLinkFromMailSac(newEmail);
        System.out.println("link_link: " + link_link);
        given().log().uri().log().headers().log().body()
                .when()
                .get(link_link)
                .then()
                .log().all()
                .statusCode(200)
                .body("html.body.div.div.div.p", equalTo("You have successfully confirmed your email address"))
                .body("html.body.div.div.div.h2", equalTo("Thank you!"));
    }
}
