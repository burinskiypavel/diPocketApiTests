package tests.bankIntegration;

import base.TestBase;
import com.cs.dipocketback.pojo.card.CardType;
import com.cs.dipocketback.pojo.customer.CardActivateRequest;
import com.cs.dipocketback.pojo.customer.CardCreateRequest;
import com.cs.dipocketback.pojo.customer.ClientRegisterRequest;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import model.bo.boOperations.CorpClientCreateRequest;
import model.bo.boServices.Client_clientId_update;
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
    int countryId = 440;
    int lastVIbanIdBeforeTest = 0;
    int vIbanIdAfterCorpClientCreation = 0;
    String firstName = "QA";
    String lastName = "Test";
    int corpClientId = 0;
    String ddStatus = "FDD";
    String city = "Vilnius";
    int individualClientId = 55669;
    int clientIdSandbox = 0;
    String currencyCodeEUR = "EUR";
    String countryCode = "LT";
    String token = null;
    String companyName = "CorporateTest";
    Gson gson = new Gson();
    CardActivateRequest cardActivateRequest = new CardActivateRequest();
    CardCreateRequest cardCreateRequest = new CardCreateRequest();
    ClientRegisterRequest clientRegisterRequest = new ClientRegisterRequest();
    CorpClientCreateRequest corpClientCreateRequest = new CorpClientCreateRequest();

    @Test(priority = 0, enabled = false)
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
    public void test_BOServices_v1_user_corpClients_createScreened(){
        corpClientCreateRequest.setAccName("TestAcc");
        corpClientCreateRequest.setAccTypeId(1);
        corpClientCreateRequest.setAccountContractCountryId(countryId);
        corpClientCreateRequest.setIdentifyCode(12132131231l);
        corpClientCreateRequest.setStateMail("String");
        corpClientCreateRequest.setStateReg("String");
        corpClientCreateRequest.setSite(site);
        corpClientCreateRequest.setClientType("C");
        corpClientCreateRequest.setLangId(1);
        corpClientCreateRequest.setCompanyName(companyName);
        corpClientCreateRequest.setCurrencyId(currencyId);
        corpClientCreateRequest.setDdStatus("FDD");
        corpClientCreateRequest.setFeeTariffPlanId(2);
        corpClientCreateRequest.setDefCardProgramId(1);
        corpClientCreateRequest.setLimitPlanId(2);
        corpClientCreateRequest.setOperLimitPlanId(1);
        corpClientCreateRequest.setStreetLine1Reg("Main str");
        corpClientCreateRequest.setStreetLine2Reg("50");
        corpClientCreateRequest.setCityReg("Krakiv");
        corpClientCreateRequest.setZipReg(2123123);
        corpClientCreateRequest.setCountryIdReg(countryId);
        corpClientCreateRequest.setRegisteredAddrAsMail(false);
        corpClientCreateRequest.setStreetLine1Mail("Main str");
        corpClientCreateRequest.setStreetLine2Mail("50");
        corpClientCreateRequest.setCityMail("Krakiv");
        corpClientCreateRequest.setZipMail(2123123);
        corpClientCreateRequest.setCountryIdMail(countryId);
        corpClientCreateRequest.setContractCountryId(countryId);
        corpClientCreateRequest.setCitizenship(countryCode);
        String json = gson.toJson(corpClientCreateRequest);

        app.getBoRequestsHelper().boServices_v1_user_corpClients_createScreened_test(cookie, sms, json);
    }

    @Test(priority = 4)
    public void test_CustomerServices_v1_client_register(){
        clientRegisterRequest.setRequestId("d1f202fe-df2e-46da-94ba-"+app.generateRandomString(12)+"");
        clientRegisterRequest.setLangCode("en");
        clientRegisterRequest.setFirstName("QA");
        clientRegisterRequest.setLastName("Test");
        clientRegisterRequest.setCardHolderName("cardHolderName");
        clientRegisterRequest.setEmail("testqa"+app.generateRandomString(5)+"@gmail.com");
        clientRegisterRequest.setMainPhone(app.generateRandomNumber(12));
        clientRegisterRequest.setDob("1990-08-31");
        clientRegisterRequest.setDdStatus("FDD");
        clientRegisterRequest.setCurrencyCode(currencyCodeEUR);
        clientRegisterRequest.setRStreetLine1("StreetLine1");
        clientRegisterRequest.setRStreetLine2("StreetLine2");
        clientRegisterRequest.setRCity("City");
        clientRegisterRequest.setRState("State");
        clientRegisterRequest.setRZip("Zip");
        clientRegisterRequest.setRCountryCode(countryCode);
        clientRegisterRequest.setMStreetLine1("StreetLine1");
        clientRegisterRequest.setMStreetLine2("StreetLine2");
        clientRegisterRequest.setMCity("City");
        clientRegisterRequest.setMState("State");
        clientRegisterRequest.setMZip("Zip");
        clientRegisterRequest.setMCountryCode(countryCode);
        clientRegisterRequest.setCitizenship(countryCode);
        String json = gson.toJson(clientRegisterRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_client_register_test(app.sandboxLogin, app.sandboxPass, json);

        JsonPath jsonPath = new JsonPath(response);
        clientIdSandbox = jsonPath.getInt("clientId");
    }

    @Test(priority = 5)
    public void test_CustomerServices_v1_card_create(){
        cardCreateRequest.setRequestId("fea3af96-50b5-48c2-9456"+app.generateRandomString(12)+"");
        cardCreateRequest.setClientId(Long.valueOf(clientIdSandbox));
        cardCreateRequest.setProgram("Sandbox");
        cardCreateRequest.setCurrencyCode(currencyCodeEUR);
        cardCreateRequest.setCardType(CardType.PLASTIC);
        cardCreateRequest.setAccFeeTariffPlanId(Long.valueOf(2000));
        cardCreateRequest.setePin(Long.valueOf(1111));
        cardCreateRequest.setAccountId(null);
        String json = gson.toJson(cardCreateRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_card_create_test(app.sandboxLogin, app.sandboxPass, json);

        JsonPath jsonPath = new JsonPath(response);
        token = jsonPath.getString("token");
    }

    @Test(priority = 6)
    public void test_CustomerServices_v1_card_activate(){
        cardActivateRequest.setRequestId("fea3af96-50b5-48c2-9456-"+app.generateRandomString(12)+"");
        cardActivateRequest.setClientId(Long.valueOf(clientIdSandbox));
        cardActivateRequest.setToken(token);
        String json = gson.toJson(cardActivateRequest);

        app.getCustomerServicesRequestsHelper().customerServices_v1_card_activate_test(app.sandboxLogin, app.sandboxPass, json);
    }

//    @Test(priority = 7, enabled = false)
//    public void test_BOServices_v1_representative_createScreened() throws SQLException, ClassNotFoundException, InterruptedException {
//        corpClientId = app.getDbHelper().getClientIdFromClientFromTestDB("C", companyName);
//
//        given()
//                .spec(app.requestSpecBOTest)
//                .cookie(cookie)
//                .header("bo-auth-token", sms)
//                .contentType("application/json")
//                .body("{\n" +
//                        "  \"corpClientId\" : "+ corpClientId +",\n" +
//                        "  \"firstName\" : \""+firstName+"\",\n" +
//                        "  \"lastName\" : \""+lastName+"\",\n" +
//                        "  \"cardholderName\" : \"Pavel Burinskiy\",\n" +
//                        "  \"birthDate\" : \"14.02.1992\",\n" +
//                        "  \"phoneNumber\" : \"38068"+app.generateRandomNumber(7)+"\",\n" +
//                        "  \"email\" : \"pavelburinskiy"+app.generateRandomNumber(7)+"@gmail.com\",\n" +
//                        "  \"ddStatus\" : \""+ddStatus+"\",\n" +
//                        "  \"currencyId\" : "+currencyId+",\n" +
//                        "  \"langId\" : 1,\n" +
//                        "  \"identifyCode\" : \"13124124124\",\n" +
//                        "  \"citizenshipCountryId\" : "+countryId+",\n" +
//                        "  \"residenceCountryId\" : "+countryId+",\n" +
//                        "  \"streetLine1\" : \"Address\",\n" +
//                        "  \"streetLine2\" : \"Address\",\n" +
//                        "  \"city\" : \""+city+"\",\n" +
//                        "  \"zip\" : \"12314124124124\"\n" +
//                        "}")
//                .post("/v1/representative/createScreened")
//                .then().log().all()
//                .statusCode(200);
//    }

    @Test(priority = 8)
    public void test_BOServices_v1_representative_link() throws SQLException, ClassNotFoundException, InterruptedException {
        corpClientId = app.getDbHelper().getClientIdFromClientFromTestDB("C", companyName);
        given()
                .spec(app.requestSpecBOTest)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .body("{\n" +
                        "  \"clientId\" : "+clientIdSandbox+",\n" +
                        "  \"corpClientId\" : "+ corpClientId +"\n" +
                        "}")
                .post("/v1/representative/link")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 9)
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

    @Test(priority = 10)
    public void test_verifyVirtualIBANCreation() throws SQLException, ClassNotFoundException, InterruptedException {
        //corpClientId = app.getDbHelper().getClientIdFromClientFromTestDB("C", "Predict");
        app.getDbHelper().isRowWithSRCIDPresentInTheTableLHV_EE_VIBAN_REQUESTFromTestDB(corpClientId);

        //vIbanIdAfterCorpClientCreation = app.getDbHelper().getLastVIbanIdFromLHV_EE_VIBAN_REQUESTFromTestDB();
        //assertThat(lastVIbanIdBeforeTest,equalTo(vIbanIdAfterCorpClientCreation));
    }
}