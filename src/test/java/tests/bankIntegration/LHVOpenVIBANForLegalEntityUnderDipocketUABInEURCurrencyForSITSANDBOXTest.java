package tests.bankIntegration;

import base.TestBase;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.bo.boServices.RepresentativeCreateRequest;
import model.bo.boServices.RepresentativeLinkRequest;
import model.customerServices.CompanyRegisterRequest;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class LHVOpenVIBANForLegalEntityUnderDipocketUABInEURCurrencyForSITSANDBOXTest extends TestBase {
    String legalClientId = null;
    String cookie = null;
    String sms = null;
    String firstName = "Pavel";
    String lastName = "Burinsky";
    int individualClientId = 63719;//55669
    int currencyId = 978;
    int countryId = 440;
    String city = "Vilnius";
    String countryCode = "LT";
    String ddStatus = "FDD";
    Gson gson = new Gson();
    CompanyRegisterRequest companyRegisterRequest = new CompanyRegisterRequest();
    RepresentativeLinkRequest representativeLinkRequest = new RepresentativeLinkRequest();
    RepresentativeCreateRequest representativeCreateRequest = new RepresentativeCreateRequest();

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

        JsonPath jsonPath = new JsonPath(response);
        legalClientId = jsonPath.getString("clientId");
        System.out.println("clientId : " + legalClientId);

        app.getDbHelper().updateClientIdintifyCodeFromTestDB("49687542145", legalClientId);
        app.getDbHelper().updateClientCitizenshipCountryIdFromTestDB(countryId, legalClientId);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(app.cboUserLogin_test, app.cboUserPass_test, app.cboUsername_test);
        String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        sms = message.substring(13);
    }

    @Test(priority = 3, enabled = false)
    public void test_BOServices_v1_representative_createScreened() {
        representativeCreateRequest.setCorpClientId(legalClientId);
        representativeCreateRequest.setFirstName(firstName);
        representativeCreateRequest.setLastName(lastName);
        representativeCreateRequest.setCardholderName("Pavel Burinskiy");
        representativeCreateRequest.setBirthDate("14.02.1992");
        representativeCreateRequest.setPhoneNumber("38068" + app.generateRandomNumber(7));
        representativeCreateRequest.setEmail("pavelburinskiy" + app.generateRandomNumber(7)+"@gmail.com");
        representativeCreateRequest.setDdStatus(ddStatus);
        representativeCreateRequest.setCurrencyId(currencyId);
        representativeCreateRequest.setLangId(1);
        representativeCreateRequest.setIdentifyCode(13124124124l);
        representativeCreateRequest.setCitizenshipCountryId(countryId);
        representativeCreateRequest.setResidenceCountryId(countryId);
        representativeCreateRequest.setStreetLine1("Address");
        representativeCreateRequest.setStreetLine2("Address");
        representativeCreateRequest.setCity(city);
        representativeCreateRequest.setZip(12314124124124l);
        String json = gson.toJson(representativeCreateRequest);

        app.getBoRequestsHelper().boServices_v1_representative_createScreened(cookie, sms, json);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_representative_legalClientId() throws SQLException, ClassNotFoundException {
        app.getDbHelper().createAccountFromTestDB(Integer.parseInt(legalClientId), currencyId, "test acc");
        app.getDbHelper().updateAccountStateIdFromTestDB(20, legalClientId);

        Response response = app.getBoRequestsHelper().boServices_v1_representative_legalClientId_test(cookie, sms, legalClientId);
        response.then().body("isEmpty()", Matchers.is(true));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_representative_link(){
        representativeLinkRequest.setClientId(individualClientId);
        representativeLinkRequest.setCorpClientId(Integer.parseInt(legalClientId));
        String json = gson.toJson(representativeLinkRequest);

        app.getBoRequestsHelper().boServices_v1_representative_link_test(cookie, sms, json);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_representative_legalClientId_(){
        Response response = app.getBoRequestsHelper().boServices_v1_representative_legalClientId_test(cookie, sms, legalClientId);
        response.then().body("firstName", hasItem(firstName), "lastName", hasItem(lastName));
    }

    @Test(priority = 8)
    public void test_verifyVirtualIBANCreation_() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualVIbanFromDB = app.getDbHelper().getVirtualIBANFromTestDB(legalClientId);
        assertThat(actualVIbanFromDB, notNullValue());
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