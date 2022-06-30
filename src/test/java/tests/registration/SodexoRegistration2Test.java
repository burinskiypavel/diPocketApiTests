package tests.registration;

import appmanager.EmailIMAPHelper;
import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SodexoRegistration2Test extends TestBase {
    String smsCode = null;
    String countryId = "804";
    String phone = "380980316499";
    String email = "testdipocket2@gmail.com";
    String site = app.mobile_site_sodexo;
    int langId = 1;
    String token = "76729364";
    String firstName = "Pavel";
    String lastName = "auto QA";

    @Test(priority = 1)
    public void test_WebServices_v1_references_getRegisterInfoByCard() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteClientFromDB(phone, site);
        given()
                .spec(app.requestSpecSodexoRegistration)
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"langId\" : "+langId+",\n" +
                        "  \"token\" : \""+token+"\"\n" +
                        "}\n")
                .when()
                .post( "references/getRegisterInfoByCard")
                .then()
                .log().all()
                .statusCode(200)
                .body("firstName", equalTo(firstName),
                        "lastName", equalTo(lastName),
                        "email", equalTo(email));
    }

        @Test(priority = 2)
        public void test_WebServices_v1_references_checkCardByToken(){
            given()
                    .spec(app.requestSpecSodexoRegistration)
                    .contentType("application/json; charset=utf-8")
                    .body("{\n" +
                            "  \"token\" : \""+token+"\"\n" +
                            "}\n")
                    .when()
                    .post("references/checkCardByToken")
                    .then().log().all()
                    .statusCode(200);
        }

    @Test(priority = 3)
    public void test_WebServices_v1_references_verifyFestivalPhone(){
        given()
                .spec(app.requestSpecSodexoRegistration)
                .queryParam("phone", phone)
                .when()
                .get("references/verifyFestivalPhone")
                .then()
                .log().all()
                .statusCode(200)
                .body("isValid", equalTo(true),
                        "isRegistered", equalTo(false),
                        "isMigrated", equalTo(false));
    }

    @Test(priority = 4)
    public void test_WebServices_v1_registration_sendSMSCodeForPhone(){
        given()
                .spec(app.requestSpecSodexoRegistration)
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"langId\" : "+langId+",\n" +
                        "  \"phoneNumber\" : "+phone+"\n" +
                        "}\n")
                .when()
                .post("registration/sendSMSCodeForPhone")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void test_WebServices_v1_registration_checkCodeForPhone() throws SQLException, ClassNotFoundException {
        smsCode = app.getDbHelper().getSMSCodeFromDB(phone, site);
        given()
                .spec(app.requestSpecSodexoRegistration)
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"langId\" : "+langId+",\n" +
                        "  \"phoneNumber\" : \""+phone+"\",\n" +
                        "  \"code\" : \""+smsCode+"\"\n" +
                        "}\n")
                .when()
                .post("registration/checkCodeForPhone")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void test_WebServices_v1_references_questions() {
        given()
                .spec(app.requestSpecSodexoRegistration)
                .queryParam("langId", langId)
                .queryParam("countryId", countryId)
                .when()
                .get("references/questions")
                .then()
                .log().all()
                .statusCode(200)
                .body("checkboxList.typeId", hasItems("SODEXO_PROFILING", "SODEXO_CONTACT_BY_EMAIL", "SODEXO_CONTACT_BY_PHONE"));
    }

    @Test(priority = 7)
    public void test_WebServices_v1_references_getRegisterInfoByCard_() {
        given()
                .spec(app.requestSpecSodexoRegistration)
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"langId\" : "+langId+",\n" +
                        "  \"token\" : \""+token+"\"\n" +
                        "}\n")
                .when()
                .post( "references/getRegisterInfoByCard")
                .then()
                .log().all()
                .statusCode(200)
                .body("firstName", equalTo(firstName),
                        "lastName", equalTo(lastName),
                        "email", equalTo(email));
    }

    @Test(priority = 8)
    public void test_WebServices_v1_registration_registerFestivalClient() {
        given()
                .spec(app.requestSpecSodexoRegistration)
                .contentType("application/json")
                .body("{\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"firstName\" : \""+firstName+"\",\n" +
                        "  \"lastName\" : \""+lastName+"\",\n" +
                        "  \"mainPhone\" : \""+phone+"\",\n" +
                        "  \"email\" : \""+email+"\",\n" +
                        "  \"ccy\" : \"PLN\",\n" +
                        "  \"birthDateAsDate\" : \"1992-09-04\",\n" +
                        "  \"pin\" : \"pasword1\",\n" +
                        "  \"address\" : {\n" +
                        "    \"countryId\" : "+countryId+"\n" +
                        "  },\n" +
                        "  \"token\" : \""+token+"\",\n" +
                        "  \"attachedCardsList\" : [ ],\n" +
                        "  \"checkboxList\" : [ {\n" +
                        "    \"typeId\" : \"SODEXO_PROFILING\",\n" +
                        "    \"selected\" : true\n" +
                        "  } ],\n" +
                        "  \"address1\" : {\n" +
                        "    \"countryId\" : "+countryId+"\n" +
                        "  },\n" +
                        "  \"attachedCardIds\" : [ ]\n" +
                        "}\n")
                .when()
                .post("registration/registerFestivalClient")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 9)
    public void test_WebServices_v1_registration_sendTermsAndConditionsAnonymous() {
        given()
                .spec(app.requestSpecSodexoRegistration)
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"email\" : \""+email+"\",\n" +
                        "  \"url\" : \"https://sodexo-test.dipocket.org/en/cabinet?rui=true\",\n" +
                        "  \"site\" : \""+site+"\"\n" +
                        "}\n")
                .when()
                .post( "registration/sendTermsAndConditionsAnonymous")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test(priority = 10)
    public void testEmailLink() throws InterruptedException, SQLException, ClassNotFoundException {
        String link = EmailIMAPHelper.getLinkFromEmailAfterRegistrationSodexo(email, "pasword12!");
        System.out.println("link_link " + link);
        given()
                .when()
                .get(link)
                .then().log().all()
                .statusCode(200)
                .body("html.body.div.div.div.div.div.div.div.h1", equalTo("Login"));

        assertTrue(app.getDbHelper().isClientExistInDB(phone, site));
    }
}