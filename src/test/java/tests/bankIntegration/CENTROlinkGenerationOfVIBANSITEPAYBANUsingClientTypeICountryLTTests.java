package tests.bankIntegration;

import base.TestBase;
import com.cs.dipocketback.pojo.card.CardType;
import com.cs.dipocketback.pojo.customer.CardActivateRequest;
import com.cs.dipocketback.pojo.customer.CardCreateRequest;
import com.cs.dipocketback.pojo.customer.ClientRegisterRequest;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CENTROlinkGenerationOfVIBANSITEPAYBANUsingClientTypeICountryLTTests extends TestBase {
    String cookie = null;
    String sms = null;
    int clientId = 0;
    String currencyCodeEUR = "EUR";
    String countryCode = "LT";
    String token = null;
    String program = "PAYBAN_EUR";
    String actualVIbanFromBO = null;
    String actualVIbanPaybanFromDB = null;
    String username = "PAVELB_BO";
    Gson gson = new Gson();
    CardCreateRequest cardCreateRequest = new CardCreateRequest();
    ClientRegisterRequest clientRegisterRequest = new ClientRegisterRequest();

    @Test(priority = 1)
    public void test_CustomerServices_v1_client_register(){
        clientRegisterRequest.setRequestId("d1f202fe-df2e-46da-94ba-"+app.generateRandomString(12)+"");
        clientRegisterRequest.setLangCode("en");
        clientRegisterRequest.setFirstName("QA");
        clientRegisterRequest.setLastName("Test");
        clientRegisterRequest.setCardHolderName("cardHolderName");
        clientRegisterRequest.setEmail("testqa"+app.generateRandomString(5)+"@gmail.com");
        clientRegisterRequest.setMainPhone("616"+app.generateRandomNumber(12));
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

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_client_register_test(app.testPaybanLogin, app.testPaybanPass, json);

        JsonPath jsonPath = new JsonPath(response);
        clientId = jsonPath.getInt("clientId");
    }

    @Test(priority = 2)
    public void test_CustomerServices_v1_card_create(){
        cardCreateRequest.setRequestId("fea3af96-50b5-48c2-9456"+app.generateRandomString(12)+"");
        cardCreateRequest.setClientId(Long.valueOf(clientId));
        cardCreateRequest.setProgram(program);
        cardCreateRequest.setCurrencyCode(currencyCodeEUR);
        cardCreateRequest.setCardType(CardType.VIRTUAL);
        cardCreateRequest.setAccFeeTariffPlanId(Long.valueOf(1010));
        cardCreateRequest.setePin(Long.valueOf(1111));
        cardCreateRequest.setAccountId(null);
        cardCreateRequest.setePin(1111l);
        cardCreateRequest.setCardHolderName("payban test");
        cardCreateRequest.setComment("GBP IBAN generation test");
        String json = gson.toJson(cardCreateRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_card_create_test(app.testPaybanLogin, app.testPaybanPass, json);

        JsonPath jsonPath = new JsonPath(response);
        token = jsonPath.getString("token");
    }

    @Test(priority = 3)
    public void test_verifyVirtualIBANCreation() throws SQLException, ClassNotFoundException {
        actualVIbanPaybanFromDB = app.getDbHelper().getIbanFromIBANFromTestDB(String.valueOf(clientId));
        assertThat(actualVIbanPaybanFromDB, notNullValue());
    }

    @Test(priority = 4)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(app.boUserLogin_test, app.boUserPass_test, username);
    }

    @Test(priority = 5)
    public void test_verifyIbanFromBO_sandbox() throws SQLException, ClassNotFoundException {
        String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        sms = message.substring(13);

        Response response = app.getBoRequestsHelper().boServices_v1_client_clientId_paymentDetails(cookie, sms, clientId);

        actualVIbanFromBO = String.valueOf(response.jsonPath().getList("accountNo").get(0));
        System.out.println("actualVIbanFromBO : " + actualVIbanFromBO);

        assertThat(actualVIbanPaybanFromDB, equalTo(actualVIbanFromBO));
    }
}