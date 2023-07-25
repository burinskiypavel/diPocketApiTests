package tests.сlientDelivery.EnhancementAUTOTestsForGetAPIResultsForRequestid;

import base.TestBase;
import com.cs.dipocketback.pojo.card.CardType;
import com.cs.dipocketback.pojo.customer.CardActivateRequest;
import com.cs.dipocketback.pojo.customer.CardCreateRequest;
import com.cs.dipocketback.pojo.customer.CardLoadRequest;
import com.cs.dipocketback.pojo.customer.ClientRegisterRequest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Card_unloadTests extends TestBase {
    int clientIdSandbox = 0;
    String currencyCodeEUR = "EUR";
    String countryCode = "LT";
    String token = null;
    String transactionId = null;
    String transactionId2 = null;
    Gson gson = new Gson();
    CardActivateRequest cardActivateRequest = new CardActivateRequest();
    CardCreateRequest cardCreateRequest = new CardCreateRequest();
    ClientRegisterRequest clientRegisterRequest = new ClientRegisterRequest();
    CardLoadRequest cardLoadRequest = new CardLoadRequest();
    CardLoadRequest cardLoadRequest2 = new CardLoadRequest();
    String requestidForApiResults = app.generateRandomString(12);
    String requestidForApiResults2 = app.generateRandomString(12);

    String requestidForApiResults3 = app.generateRandomString(12);


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

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_client_register_test(app.sandboxLogin, app.sandboxPass, json);

        clientIdSandbox = app.getResponseValidationHelper().getIntFromResponseJsonPath(response, "clientId");
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

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_card_create_test(app.sandboxLogin, app.sandboxPass, json);

        token = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "token");
    }

    @Test(priority = 3)
    public void test_CustomerServices_v1_card_activate(){
        cardActivateRequest.setRequestId(requestidForApiResults);
        cardActivateRequest.setClientId((long) clientIdSandbox);
        cardActivateRequest.setToken(token);
        String json = gson.toJson(cardActivateRequest);

        Response response = app.getCustomerServicesRequestsHelper().customerServices_v1_card_activate_test_(app.sandboxLogin, app.sandboxPass, json);

        response.then().body("results", equalTo(null));
    }

    @Test(priority = 4)
    public void test_CustomerServices_v1_card_load(){
        cardLoadRequest.setRequestId(requestidForApiResults2);
        cardLoadRequest.setToken(token);
        cardLoadRequest.setAmount(1400l);
        cardLoadRequest.setCurrencyCode(currencyCodeEUR);
        cardLoadRequest.setNote("note");
        String json = gson.toJson(cardLoadRequest);

        Response response = app.getCustomerServicesRequestsHelper().customerServices_v1_card_load_test(app.sandboxLogin, app.sandboxPass, json);
        transactionId = response.then().extract().response().asString();

        System.out.println("transactionId: " + transactionId);
    }

    @Test(priority = 5)
    public void test_CustomerServices_v1_card_unload(){
        cardLoadRequest.setRequestId(requestidForApiResults3);
        cardLoadRequest.setToken(token);
        cardLoadRequest.setAmount(10l);
        cardLoadRequest.setCurrencyCode(currencyCodeEUR);
        cardLoadRequest.setNote("note");
        String json = gson.toJson(cardLoadRequest);

        Response response = app.getCustomerServicesRequestsHelper().customerServices_v1_card_unload_test(app.sandboxLogin, app.sandboxPass, json);
        transactionId = response.then().extract().response().asString();

        System.out.println("transactionId: " + transactionId);
    }

    @Test(priority = 6)
    public void test_CustomerServices_v1_card_unload_(){
        cardLoadRequest2.setRequestId(requestidForApiResults3);
        String json = gson.toJson(cardLoadRequest2);

        Response response = app.getCustomerServicesRequestsHelper().customerServices_v1_card_unload_test(app.sandboxLogin, app.sandboxPass, json);
        transactionId2 = response.then().extract().response().asString();

        System.out.println("transactionId2: " + transactionId2);

        assertThat(transactionId, equalTo(transactionId2));
    }
}