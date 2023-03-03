package tests.bankIntegration;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
                        "  \"companyName\" : \"Predict\",\n" +
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
    public void test_verifyVirtualIBANCreation() throws SQLException, ClassNotFoundException, InterruptedException {
        vIbanIdAfterCorpClientCreation = app.getDbHelper().getLastVIbanIdFromLHV_EE_VIBAN_REQUESTFromTestDB();
        assertThat(lastVIbanIdBeforeTest,equalTo(vIbanIdAfterCorpClientCreation));
    }
}