package tests.bankIntegration;

import base.TestBase;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.customerServices.CompanyRegisterRequest;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.nullValue;

public class LHVOpenVIBANForLegalEntityUnderDipocketUABInEURCurrencyForSITSANDBOXTest extends TestBase {
    String  cboUserLogin = "PavelB_CBO";
    String cboUserPass = "CGc22S0";
    String username = "PAVELB_CBO";
    String legalClientId = null;
    String cookie = null;
    String sms = null;
    String firstName = "Pavel";
    String lastName = "Burinsky";
    int individualClientId = 55669;
    int currencyId = 978;
    int countryId = 440;
    String city = "Vilnius";
    String countryCode = "LT";
    String ddStatus = "FDD";
    Gson gson = new Gson();
    CompanyRegisterRequest companyRegisterRequest = new CompanyRegisterRequest();

    @Test(priority = 1)
    public void test_CustomerServices_v1_company_register() throws SQLException, ClassNotFoundException {
        companyRegisterRequest.setRequestId(app.getBOHelper().generateRandomString(8) + "-dc36-462d-87f7-"+app.getBOHelper().generateRandomString(12)+"");
        companyRegisterRequest.setLangCode("en");
        companyRegisterRequest.setCompanyName("LegalTest");
        companyRegisterRequest.setrStreetLine1("155 Stehr Squares");
        companyRegisterRequest.setrStreetLine2("4925 Cremin Branch");
        companyRegisterRequest.setrCity(city);
        companyRegisterRequest.setrState("");
        companyRegisterRequest.setrZip(660820);
        companyRegisterRequest.setrCountryCode(countryCode);
        companyRegisterRequest.setmStreetLine1("393 Willis Ridges");
        companyRegisterRequest.setmStreetLine2("1299 Marianne Junctions");
        companyRegisterRequest.setmCity(city);
        companyRegisterRequest.setmState("");
        companyRegisterRequest.setmZip(81101);
        companyRegisterRequest.setmCountryCode(countryCode);
        companyRegisterRequest.setDdStatus(ddStatus);
        companyRegisterRequest.setCurrencyCode("EUR");
        companyRegisterRequest.setType("LEGAL_ENTITY");
        String json = gson.toJson(companyRegisterRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_company_register_test(app.sandboxLogin, app.sandboxPass, json);

//                .body("{ \n" +
//                        "\n" +
//                        "  \"requestId\" : \"47"+app.getBOHelper().generateRandomString(8)+"-dc36-462d-87f7-"+app.getBOHelper().generateRandomString(12)+"\", \n" +
//                        "  \"langCode\" : \"en\", \n" +
//                        "  \"companyName\" : \"LegalTest\", \n" +
//                        "  \"rStreetLine1\" : \"155 Stehr Squares\", \n" +
//                        "  \"rStreetLine2\" : \"4925 Cremin Branch\", \n" +
//                        "  \"rCity\" : \""+city+"\", \n" +
//                        "  \"rState\" : \"\", \n" +
//                        "  \"rZip\" : \"660820\", \n" +
//                        "  \"rCountryCode\" : \""+countryCode+"\", \n" +
//                        "  \"mStreetLine1\" : \"393 Willis Ridges\", \n" +
//                        "  \"mStreetLine2\" : \"1299 Marianne Junctions\", \n" +
//                        "  \"mCity\" : \""+city+"\", \n" +
//                        "  \"mState\" : \"\", \n" +
//                        "  \"mZip\" : \"81101\", \n" +
//                        "  \"mCountryCode\" : \""+countryCode+"\", \n" +
//                        "  \"ddStatus\" : \""+ddStatus+"\", \n" +
//                        "  \"currencyCode\" : \"EUR\", \n" +
//                        "  \"type\" : \"LEGAL_ENTITY\" \n" +
//                        "\n" +
//                        "} ")

        JsonPath jsonPath = new JsonPath(response);
        legalClientId = jsonPath.getString("clientId");
        System.out.println("clientId : " + legalClientId);

        app.getDbHelper().updateClientIdintifyCodeFromTestDB("49687542145", legalClientId);
        app.getDbHelper().updateClientCitizenshipCountryIdFromTestDB(countryId, legalClientId);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(cboUserLogin, cboUserPass, username);
        String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        sms = message.substring(13);
    }

    @Test(priority = 3, enabled = false)
    public void test_BOServices_v1_representative_createScreened() {
        given()
                .spec(app.requestSpecBOTest)
                .cookie(cookie)
                .header("bo-auth-token", sms)
                .contentType("application/json")
                .body("{\n" +
                        "  \"corpClientId\" : "+ legalClientId +",\n" +
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

    @Test(priority = 4)
    public void test_BOServices_v1_representative_legalClientId() throws SQLException, ClassNotFoundException {
        app.getDbHelper().createAccountFromTestDB(Integer.parseInt(legalClientId), currencyId, "test acc");
        app.getDbHelper().updateAccountStateIdFromTestDB(20, legalClientId);

        Response response = app.getBoRequestsHelper().boServices_v1_representative_legalClientId_test(cookie, sms, legalClientId);

        response.then().body("isEmpty()", Matchers.is(true));
//        given()
//                .spec(app.requestSpecBOTest)
//                .header("bo-auth-token", sms)
//                .cookie(cookie)
//                .pathParam("legalClientId", legalClientId)
//                .get("/v1/representative/{legalClientId}")
//                .then().log().all()
//                .statusCode(200)
//                .body("isEmpty()", Matchers.is(true));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_representative_link(){
        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .body("{\n" +
                        "  \"clientId\" : "+individualClientId+",\n" +
                        "  \"corpClientId\" : "+ legalClientId +"\n" +
                        "}")
                .post("/v1/representative/link")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_representative_legalClientId_(){
        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .pathParam("legalClientId", legalClientId)
                .get("/v1/representative/{legalClientId}")
                .then().log().all()
                .statusCode(200)
                .body("firstName", hasItem(firstName),
                        "lastName", hasItem(lastName));
    }

    @Test(priority = 8)
    public void test_verifyVirtualIBANCreation_() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualVIbanFromDB = app.getDbHelper().getVirtualIBANFromTestDB(legalClientId);
        String lastSRCID = app.getDbHelper().getLastSCRIDFromLHV_EE_VIBAN_REQUESTFromTestDB();
        assertThat(actualVIbanFromDB, notNullValue());
        assertThat(lastSRCID, equalTo(legalClientId));
    }

    @Test(priority = 9, enabled = false)
    public void test_BOServices_v1_representative_legalClientId_unlink_individualClientId(){
        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .pathParam("legalClientId", legalClientId)
                .pathParam("individualClientId", individualClientId)
                .post("/v1/representative/{legalClientId}/unlink/{individualClientId}")
                .then().log().all()
                .statusCode(200);
    }
}