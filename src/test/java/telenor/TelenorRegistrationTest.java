package telenor;

import appmanager.GoogleSheetsHelper;
import base.TestBase;
import org.testng.annotations.Test;

import java.io.*;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TelenorRegistrationTest extends TestBase {
    String smsCode = null;
    //String token = "512252941";
    String token = null;

    @Test(priority = 1)
    public void test_WebServices_v1_registration_checkPhoneAndToken() throws SQLException, ClassNotFoundException, IOException, GeneralSecurityException {
        //token = app.getTelenorHelper().getTokenFromFile("files/telenor/tokensForTelenorRegistration.txt");
        token = GoogleSheetsHelper.start();
        System.out.println("token: " + token);
        app.getDbHelper().deleteClientFromDBTelenor(app.telenorRegistrationPhone);
        given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .queryParam("value", "com.cs.dipocketback.pojo.telenor.TelenorRequest@6d1f8ef7")
                .body("{\n" +
                        "  \"publicToken\" : \""+token+"\",\n" +
                        "  \"phoneNumber\" : \""+app.telenorRegistrationPhone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/registration/checkPhoneAndToken")
                .then()
                .log().all()
                .statusCode(200)
                .body("validPhone", equalTo(true))
                .body("validToken", equalTo(true));
    }

    @Test(priority = 2)
    public void test_WebServices_v1_registration_sendSMSCodeForPhone(){
        given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .queryParam("value", "com.cs.dipocketback.pojo.registration.VerifyPhoneRequest@51ceb0d3")
                .body("{\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"phoneNumber\" : \""+app.telenorRegistrationPhone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/registration/sendSMSCodeForPhone")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_WebServices_v1_registration_checkCodeForPhone() throws SQLException, ClassNotFoundException {
        smsCode = app.getDbHelper().getSMSCodeFromDBTelenor(app.telenorRegistrationPhone);
        given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .queryParam("value", "com.cs.dipocketback.pojo.registration.VerifyPhoneRequest@4b430f10")
                .body("{\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"phoneNumber\" : \""+app.telenorRegistrationPhone+"\",\n" +
                        "  \"code\" : \""+smsCode+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/registration/checkCodeForPhone")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_WebServices_v1_registration_registerTelenorClient() {
        given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .queryParam("value", "com.cs.dipocketback.pojo.registration.RegSavepointData@541a8ad0")
                .body("{\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"firstName\" : \"Pavel\",\n" +
                        "  \"lastName\" : \"TestQA\",\n" +
                        "  \"mainPhone\" : \""+app.telenorRegistrationPhone+"\",\n" +
                        "  \"email\" : \"pavelqaemail@mailsac.com\",\n" +
                        "  \"birthDateAsDate\" : \"1990-01-01\",\n" +
                        "  \"secQuestion\" : \"QA\",\n" +
                        "  \"secAnswer\" : \"QA\",\n" +
                        "  \"pin\" : \""+smsCode+"\",\n" +
                        "  \"address\" : {\n" +
                        "    \"streetLine1\" : \"address\",\n" +
                        "    \"streetLine2\" : \"address2\",\n" +
                        "    \"city\" : \"city\",\n" +
                        "    \"zip\" : \"123456\",\n" +
                        "    \"countryId\" : 616\n" +
                        "  },\n" +
                        "  \"token\" : \""+token+"\",\n" +
                        "  \"publicToken\" : \""+token+"\",\n" +
                        "  \"agreeTariffs\" : true,\n" +
                        "  \"agreeTerms\" : true,\n" +
                        "  \"agreeProcessInfo\" : true,\n" +
                        "  \"attachedCardsList\" : [ ],\n" +
                        "  \"address1\" : {\n" +
                        "    \"streetLine1\" : \"address\",\n" +
                        "    \"streetLine2\" : \"address2\",\n" +
                        "    \"city\" : \"city\",\n" +
                        "    \"zip\" : \"123456\",\n" +
                        "    \"countryId\" : 616\n" +
                        "  },\n" +
                        "  \"attachedCardIds\" : [ ]\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/registration/registerTelenorClient")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void test_confirm_email_link_from_mailsac() throws InterruptedException {
        //String link_link = app.getTelenorHelper().getEmailConfirmationRegistrationTelenorLinkFromMailSac();
        String link_link = app.getTelenorHelper().getEmailConfirmationTelenorLinkFromMailSac("pavelqaemail@mailsac.com");
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