package tests.bankIntegration;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class LHVNegativeTestCaseOpenVIBANForCorporateClientUnderDipocketUABInEURCurrencyForSiteSANDBOXTests extends TestBase {
    String  cboUserLogin = "PavelB_CBO";
    String cboUserPass = "CGc22S0";
    String username = "PAVELB_CBO";
    String cookie = null;
    String sms = null;
    String site = "SANDBOX";
    int currencyId = 978;
    int countryId = 616;
    int lastVIbanIdBeforeTest = 0;
    int vIbanIdAfterCorpClientCreation = 0;
    String firstName = "Pavel";
    String lastName = "Burinskiy";
    int corpClientId = 0;
    String ddStatus = "FDD";
    String city = "London";
    int individualClientId = 55669;


    @Test(priority = 0)
    public void test_getIdOfLastVIbanFromTestDB() throws SQLException, ClassNotFoundException {
         lastVIbanIdBeforeTest = app.getDbHelper().getLastVIbanIdFromLHV_EE_VIBAN_REQUESTFromTestDB();
    }

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(cboUserLogin, cboUserPass, username);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_corpClient_checkSysParam_site() throws SQLException, ClassNotFoundException {
        String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        sms = message.substring(13);

        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .pathParam("key", site)
                .when()
                .get( "/v1/user/corpClient/checkSysParam/site/{key}")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo(false));
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_corpClients_create(){
        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .body("{\n" +
                        "  \"site\" : \""+site+"\",\n" +
                        "  \"clientType\" : \"C\",\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"companyName\" : \"CorporateTest\",\n" +
                        "  \"currencyId\" : "+currencyId+",\n" +
                        "  \"ddStatus\" : \"FDD\",\n" +
                        "  \"feeTariffPlanId\" : 2,\n" +
                        "  \"defCardProgramId\" : 1,\n" +
                        "  \"limitPlanId\" : 2,\n" +
                        "  \"operLimitPlanId\" : 1,\n" +
                        "  \"streetLine1Reg\" : \"Gagarina ave\",\n" +
                        "  \"streetLine2Reg\" : \"62\",\n" +
                        "  \"cityReg\" : \"Krakiv\",\n" +
                        "  \"zipReg\" : \"2123123\",\n" +
                        "  \"countryIdReg\" : "+countryId+",\n" +
                        "  \"registeredAddrAsMail\" : false,\n" +
                        "  \"streetLine1Mail\" : \"Gagarina ave\",\n" +
                        "  \"streetLine2Mail\" : \"62\",\n" +
                        "  \"cityMail\" : \"Krakiv\",\n" +
                        "  \"zipMail\" : \"2123123\",\n" +
                        "  \"countryIdMail\" : "+countryId+",\n" +
                        "  \"contractCountryId\" : "+countryId+"\n" +
                        "}")
                .when()
                .post( "/v1/user/corpClients/create")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_representative_createScreened() throws SQLException, ClassNotFoundException, InterruptedException {
        //String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        //sms = message.substring(13);
        corpClientId = app.getDbHelper().getClientIdFromClientFromTestDB("C", "Predict");

        given()
                .spec(app.requestSpecBOTest)
                .cookie(cookie)
                .header("bo-auth-token", sms)
                .contentType("application/json")
                .body("{\n" +
                        "  \"corpClientId\" : "+ corpClientId +",\n" +
                        "  \"firstName\" : \""+firstName+"\",\n" +
                        "  \"lastName\" : \""+lastName+"\",\n" +
                        "  \"cardholderName\" : \"Pavel Burinskiy\",\n" +
                        "  \"birthDate\" : \"14.02.1992\",\n" +
                        "  \"phoneNumber\" : \"38068"+app.generateRandomNumber(7)+"\",\n" +
                        "  \"email\" : \"pavelburinskiy"+app.generateRandomNumber(7)+"@gmail.com\",\n" +
                        "  \"ddStatus\" : \""+ddStatus+"\",\n" +
                        "  \"currencyId\" : "+currencyId+",\n" +
                        "  \"langId\" : 1,\n" +
                        "  \"identifyCode\" : \"13124124124\",\n" +
                        "  \"citizenshipCountryId\" : "+countryId+",\n" +
                        "  \"residenceCountryId\" : "+countryId+",\n" +
                        "  \"streetLine1\" : \"Address\",\n" +
                        "  \"streetLine2\" : \"Address\",\n" +
                        "  \"city\" : \""+city+"\",\n" +
                        "  \"zip\" : \"12314124124124\"\n" +
                        "}")
                .post("/v1/representative/createScreened")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_representative_link(){
        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .body("{\n" +
                        "  \"clientId\" : "+individualClientId+",\n" +
                        "  \"corpClientId\" : "+ corpClientId +"\n" +
                        "}")
                .post("/v1/representative/link")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_representative_legalClientId_(){
        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .pathParam("legalClientId", corpClientId)
                .get("/v1/representative/{legalClientId}")
                .then().log().all()
                .statusCode(200)
                .body("firstName", hasItem(firstName),
                        "lastName", hasItem(lastName));
    }

    @Test(priority = 7)
    public void test_verifyVirtualIBANCreation() throws SQLException, ClassNotFoundException, InterruptedException {
        //corpClientId = app.getDbHelper().getClientIdFromClientFromTestDB("C", "Predict");
        app.getDbHelper().isRowWithSRCIDPresentInTheTableLHV_EE_VIBAN_REQUESTFromTestDB(corpClientId);

        vIbanIdAfterCorpClientCreation = app.getDbHelper().getLastVIbanIdFromLHV_EE_VIBAN_REQUESTFromTestDB();
        assertThat(lastVIbanIdBeforeTest,equalTo(vIbanIdAfterCorpClientCreation));
    }
}