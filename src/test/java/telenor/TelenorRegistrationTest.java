package telenor;

import appmanager.HelperBase;
import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class TelenorRegistrationTest extends TestBase {
    String smsCode = null;
    String token = "512219400";

    @Test(priority = 1)
    public void test_WebServices_v1_registration_checkPhoneAndToken(){
        given()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", "TELENOR")
                .queryParam("value", "com.cs.dipocketback.pojo.telenor.TelenorRequest@6d1f8ef7")
                .body("{\n" +
                        "  \"publicToken\" : \""+token+"\",\n" +
                        "  \"phoneNumber\" : \"380980316499\"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/WebServices/v1/registration/checkPhoneAndToken")
                .then()
                .log().all()
                .statusCode(200)
                .body("validPhone", equalTo(true))
                .body("validToken", equalTo(true));
    }

    @Test(priority = 2)
    public void test_WebServices_v1_registration_sendSMSCodeForPhone(){
        given()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", "TELENOR")
                .body("{\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"phoneNumber\" : \"380980316499\"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/WebServices/v1/registration/sendSMSCodeForPhone?value=com.cs.dipocketback.pojo.registration.VerifyPhoneRequest@51ceb0d3")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_WebServices_v1_registration_checkCodeForPhone() throws SQLException, ClassNotFoundException {
        smsCode = app.getDbHelper().getSMSCodeFromDBTelenor("380980316499");
        given()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", "TELENOR")
                .body("{\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"phoneNumber\" : \"380980316499\",\n" +
                        "  \"code\" : \""+smsCode+"\"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/WebServices/v1/registration/checkCodeForPhone?value=com.cs.dipocketback.pojo.registration.VerifyPhoneRequest@4b430f10")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_WebServices_v1_registration_registerTelenorClient() {
        given()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", "TELENOR")
                .body("{\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"firstName\" : \"Pavel\",\n" +
                        "  \"lastName\" : \"TestQA\",\n" +
                        "  \"mainPhone\" : \"380980316499\",\n" +
                        "  \"email\" : \"burinskiypavel@gmail.com\",\n" +
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
                        "  \"token\" : \"512219400\",\n" +
                        "  \"publicToken\" : \"512219400\",\n" +
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
                .post("https://lvov.csltd.com.ua/WebServices/v1/registration/registerTelenorClient?value=com.cs.dipocketback.pojo.registration.RegSavepointData@541a8ad0")
                .then()
                .log().all()
                .statusCode(200);
    }




























    @Test(priority = 22, enabled = false)
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


    @Test(priority = 23, enabled = false)
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
