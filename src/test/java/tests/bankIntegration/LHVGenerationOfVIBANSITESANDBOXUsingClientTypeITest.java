package tests.bankIntegration;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.pojo.card.CardType;
import com.cs.dipocketback.pojo.customer.CardActivateRequest;
import com.cs.dipocketback.pojo.customer.CardCreateRequest;
import com.cs.dipocketback.pojo.customer.ClientRegisterRequest;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.bo.boServices.Client_clientId_update;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LHVGenerationOfVIBANSITESANDBOXUsingClientTypeITest extends TestBase {
    String cookie = null;
    String sms = null;
    int clientIdSandbox = 0;
    String currencyCodeEUR = "EUR";
    String countryCode = "LT";
    String sandboxLogin = "SANDBOX";
    String sandboxPass = "W6qQnx7";
    String token = null;
    String program = "Sandbox";
    String actualVIbanFromBO = null;
    String actualVIbanSandboxFromDB = null;
    String  boUserLogin = "PavelB_BO";
    String boUserPass = "vVahVkR";
    String username = "PAVELB_BO";

    Gson gson = new Gson();
    CardActivateRequest cardActivateRequest = new CardActivateRequest();
    CardCreateRequest cardCreateRequest = new CardCreateRequest();
    ClientRegisterRequest clientRegisterRequest = new ClientRegisterRequest();
    Client_clientId_update client_clientId_update = new Client_clientId_update();

    @Test(priority = 1)
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

        String response = given()
                .contentType("application/json")
                .spec(app.requestSpecCustomerServicesTest)
                .auth().basic(sandboxLogin, sandboxPass)
                .body(json)
//                .body("{\n" +
//                        "  \"requestId\" : \"d1f202fe-df2e-46da-94ba-"+app.generateRandomString(12)+"\",\n" +
//                        "  \"langCode\" : \"en\",\n" +
//                        "  \"firstName\" : \"QA\",\n" +
//                        "  \"lastName\" : \"Test\",\n" +
//                        "  \"cardHolderName\" : \"cardHolderName\",\n" +
//                        "  \"email\" : \"testqa"+app.generateRandomString(5)+"@gmail.com\",\n" +
//                        "  \"mainPhone\" : "+app.generateRandomNumber(12)+",\n" +
//                        "  \"dob\" : \"1990-08-31\",\n" +
//                        "  \"ddStatus\" : \"FDD\",\n" +
//                        "  \"currencyCode\" : \""+ currencyCodeEUR +"\",\n" +
//                        "  \"rStreetLine1\" : \"StreetLine1\",\n" +
//                        "  \"rStreetLine2\" : \"StreetLine2\",\n" +
//                        "  \"rCity\" : \"City\",\n" +
//                        "  \"rState\" : \"State\",\n" +
//                        "  \"rZip\" : \"Zip\",\n" +
//                        "  \"rCountryCode\" : \""+countryCode+"\",\n" +
//                        "  \"mStreetLine1\" : \"StreetLine1\",\n" +
//                        "  \"mStreetLine2\" : \"StreetLine2\",\n" +
//                        "  \"mCity\" : \"City\",\n" +
//                        "  \"mState\" : \"State\",\n" +
//                        "  \"mZip\" : \"Zip\",\n" +
//                        "  \"mCountryCode\" : \""+countryCode+"\",\n" +
//                        "  \"citizenship\" : \""+countryCode+"\"\n" +
//                        "}")
                .post("/v1/client/register")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        clientIdSandbox = jsonPath.getInt("clientId");
    }

    @Test(priority = 2)
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

        String response = given()
                .spec(app.requestSpecCustomerServicesTest)
                .contentType("application/json")
                .auth().basic(sandboxLogin, sandboxPass)
                .body(json)
//                .body("{\n" +
//                        "    \"requestId\":  \"fea3af96-50b5-48c2-9456-"+app.generateRandomString(12)+"\",\n" +
//                        "    \"clientId\": \""+clientIdSandbox+"\",\n" +
//                        "    \"program\":  \""+program+"\",\n" +
//                        "    \"currencyCode\":  \""+ currencyCodeEUR +"\",\n" +
//                        "    \"cardType\":  \"PLASTIC\",\n" +
//                        "    \"accFeeTariffPlanId\":  \"2000\",\n" +
//                        "    \"ePin\": \"1111\",\n" +
//                        "    \"accountId\": \"\"\n" +
//                        "}")
                .post("/v1/card/create")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        token = jsonPath.getString("token");
    }

    @Test(priority = 3)
    public void test_CustomerServices_v1_card_activate(){
        cardActivateRequest.setRequestId("fea3af96-50b5-48c2-9456-"+app.generateRandomString(12)+"");
        cardActivateRequest.setClientId(Long.valueOf(clientIdSandbox));
        cardActivateRequest.setToken(token);
        String json = gson.toJson(cardActivateRequest);

        given()
                .spec(app.requestSpecCustomerServicesTest)
                .contentType("application/json")
                .auth().basic(sandboxLogin, sandboxPass)
                .body(json)
//                .body("{\n" +
//                        "    \"requestId\":  \"fea3af96-50b5-48c2-9456-"+app.generateRandomString(12)+"\",\n" +
//                        "    \"clientId\": \""+clientIdSandbox+"\",\n" +
//                        "    \"token\":  \""+token+"\"\n" +
//                        "}")
                .post("/v1/card/activate")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_verifyVirtualIBANCreation() throws SQLException, ClassNotFoundException, InterruptedException {
        actualVIbanSandboxFromDB = app.getDbHelper().getVirtualIBANFromTestDB(String.valueOf(clientIdSandbox));
        assertThat(actualVIbanSandboxFromDB, notNullValue());
    }

    @Test(priority = 5)
    public void test_verifyStatusRequest() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualStatusRequest = app.getDbHelper().getvIbanStatusRequestFromTestDB2(clientIdSandbox);
        assertThat(actualStatusRequest, equalTo("D"));
    }

    @Test(priority = 6)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(boUserLogin, boUserPass, username);
    }

    @Test(priority = 7)
    public void test_verifyIbanFromBO_sandbox() throws SQLException, ClassNotFoundException {
        String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        sms = message.substring(13);

        Response response = given()
                .spec(app.requestSpecBOTest)
                .pathParam("clientId", clientIdSandbox)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .get("/v1/client/{clientId}/paymentDetails");

        response.then().log().all().statusCode(200);

        actualVIbanFromBO = String.valueOf(response.jsonPath().getList("accountNo").get(0));
        System.out.println("actualVIbanFromBO : " + actualVIbanFromBO);

        assertThat(actualVIbanSandboxFromDB, equalTo(actualVIbanFromBO));
    }
}