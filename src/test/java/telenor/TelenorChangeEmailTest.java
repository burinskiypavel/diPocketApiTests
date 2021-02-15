package telenor;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.blankOrNullString;

public class TelenorChangeEmailTest extends TestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);
    String cliSessionId = null;
    String newEmail = "telenorchangeemailtest@mailsac.com";
    String secretAnswer = "QA";

    @Test(priority = 1)
    public void test_TestServices_v1_telenor_sendOtpForPhone_smsCode(){
        System.out.println("smsCod:" + smsCode);
        given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .body("{\n" +
                        "  \"phoneNumber\" : \""+app.telenorRegistrationPhone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void test_WebServices_v1_auth_authenticate() {
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .header("site", app.telenorSite)
                .header("content-type", "application/json; charset=utf-8")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/auth/authenticate");

        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
        res.then().assertThat().body("clientFirstName", equalTo("Pavel"));
        res.then().assertThat().body("clientLastName", equalTo("TestQA"));
        res.then().assertThat().body("mainPhone", equalTo(app.telenorRegistrationPhone));
    }

    @Test(priority = 3)
    public void test_WebServices_v1_clientProfile_checkSecAnswAttempts(){
        given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .body("{\n" +
                        "  \"secAnswer\" : \""+secretAnswer+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/clientProfile/checkSecAnswAttempts")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("attemptsCount", equalTo(0))
                .assertThat().body("attemptsLeft", equalTo(3));
    }

    @Test(priority = 4)
    public void test_WebServices_v1_clientProfile_verifyEmail(){
        given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .header("secretanswer", secretAnswer)
                .body("{\n" +
                        "  \"value\" : \""+newEmail+"\"\n" +
                        "}\n")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/clientProfile/verifyEmail")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(blankOrNullString());
    }

    @Test(priority = 5)
    public void test_WebServices_v1_clientProfile_clientInfo(){
        given().log().uri().log().headers().log().body()
                .auth().preemptive().basic(app.fullRegistrationTelenorLoginPhone, smsCode)
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .header("clisessionid", cliSessionId)
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/clientProfile/clientInfo")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("email", equalTo(newEmail))
                .assertThat().body("fullName", equalTo("Pavel TestQA"));
    }

    @Test(priority = 6)
    public void test_confirm_email_link_from_mailsac() throws InterruptedException {
        String link_link = app.getTelenorHelper().getChageEmailConfirmationTelenorLinkFromMailSac();
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
