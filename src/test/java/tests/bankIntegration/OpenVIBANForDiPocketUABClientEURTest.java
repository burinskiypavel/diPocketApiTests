package tests.bankIntegration;

import appmanager.HelperBase;
import appmanager.Login_RegistrationHelper;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.pojo.client.ClientAddress;
import com.cs.dipocketback.pojo.customer.CardActivateRequest;
import com.cs.dipocketback.pojo.customer.CardActivateResponse;
import com.cs.dipocketback.pojo.registration.RegSavepointData;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class OpenVIBANForDiPocketUABClientEURTest extends TestBase {
    String cookie = null;
    String username = "PAVELB_BO";
    int ticketId = 0;
    String actualTypeName = null;
    String  boUserLogin = "PavelB_BO";
    String boUserPass = "vVahVkR";
    String sms = null;
    String tomorrow = null;
    String clientId = null;
    String actualClientId = null;
    int currencyId = 978;
    int countryId = 440;
    int clientIdSandbox = 0;
    String currencyCodeEUR = "EUR";
    String countryCode = "LT";
    String sandboxLogin = "SANDBOX";
    String sandboxPass = "W6qQnx7";
    String token = null;
    String pass = "password1";
    String cliSessionId = null;
    String actualVIbanFromMobileApp = null;
    String actualVIbanFromBO = null;
    String actualVIbanFromDB = null;
    String actualVIbanSandboxFromDB = null;
    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();


    Gson gson = new Gson();
    CardActivateRequest cardActivateRequest = new CardActivateRequest();


    @Test(priority = 1)
    public void testRegistration() throws SQLException, InterruptedException, ClassNotFoundException, ParseException {
        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        login_registrationHelper.dipocketRegistration(countryId, currencyId, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", pass, "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "test");
    }

    @Test(priority = 2)
    public void test_BOServices_v1_auth_authentication() throws SQLException, ClassNotFoundException {
        clientId = app.getDbHelper().getClientIdFromTestDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication_test(boUserLogin, boUserPass, username);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_ticket_take() throws SQLException, ClassNotFoundException {
        String message = app.getDbHelper().getBOLoginSMSCodeFromTestDB();
        sms = message.substring(13);
        ticketId = app.getBOHelper().takeSDDTicketFromTest(cookie, sms, clientId, tomorrow);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_client_clientID_update() {
        given()
                .spec(app.requestSpecBOTest)
                .pathParam("clientId", clientId)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .when()
                .body("{\n" +
                        "  \"id\" : "+clientId+",\n" +
                        "  \"mainPhone\" : \"380685448615\",\n" +
                        "  \"firstName\" : \"Pavel\",\n" +
                        "  \"lastName\" : \"Burinsky\",\n" +
                        "  \"birthDate\" : \"04.09.1992\",\n" +
                        "  \"email\" : \"testdipocket@gmail.com\",\n" +
                        "  \"emailIsVerified\" : false,\n" +
                        "  \"stateId\" : 1,\n" +
                        "  \"stateName\" : \"Active\",\n" +
                        "  \"currencyId\" : "+currencyId+",\n" +
                        "  \"currencyCode\" : \"PLN\",\n" +
                        "  \"langId\" : 4,\n" +
                        "  \"langCode\" : \"rus\",\n" +
                        "  \"langName\" : \"Russian\",\n" +
                        "  \"photoIdTypeId\" : 1,\n" +
                        "  \"photoIdTypeName\" : \"Passport\",\n" +
                        "  \"photoIdNo\" : \"234234324324\",\n" +
                        "  \"photoIdCountryId\" : "+countryId+",\n" +
                        "  \"photoIdCountryName\" : \"Poland\",\n" +
                        "  \"gender\" : \"M\",\n" +
                        "  \"ddStatus\" : \"PSDD\",\n" +
                        "  \"cardHolderName\" : \"Pavel Burinsky\",\n" +
                        "  \"identifyCode\" : \"13124244234\",\n" +
                        "  \"clientType\" : \"I\",\n" +
                        "  \"site\" : \"DIPOCKET\",\n" +
                        "  \"registeredAddrAsMail\" : true,\n" +
                        "  \"residenceCountryId\" : "+countryId+",\n" +
                        "  \"feeTariffPlanId\" : 1,\n" +
                        "  \"feeTariffPlanName\" : \"EUR - standard\",\n" +
                        "  \"age\" : 30,\n" +
                        "  \"migrated\" : false,\n" +
                        "  \"skippedReg\" : false\n" +
                        "}")
                .post("/v1/client/{clientId}/update")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void test_BOServices_v1_client_clientId_approveSDD(){
        given()
                .spec(app.requestSpecBOTest)
                .pathParam("clientId", clientId)
                .header("bo-auth-token", sms)
                .queryParam("ticketId", ticketId)
                .cookie(cookie)
                .post("/v1/client/{clientId}/approveSDD")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_clientImage_uploadDocs(){
        app.getBoRequestsHelper().boServices_v1_clientImage_uploadDoc_test(cookie, Integer.parseInt(clientId), 2, sms, "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");
        app.getBoRequestsHelper().boServices_v1_clientImage_uploadDoc_test(cookie, Integer.parseInt(clientId), 3, sms, "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");
        app.getBoRequestsHelper().boServices_v1_clientImage_uploadDoc_test(cookie, Integer.parseInt(clientId), 5, sms, "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");
    }
    @Test(priority = 7)
    public void test_BOServices_v1_ticket_take_() {
        ticketId = app.getBOHelper().takeFDDTicketFromTest(cookie, sms, clientId, tomorrow);
    }

    @Test(priority = 8)
    public void test_BOServices_v1_client_clientId_approveFDD(){
        given()
                .spec(app.requestSpecBOTest)
                .pathParam("clientId", clientId)
                .header("bo-auth-token", sms)
                .queryParam("ticketId", ticketId)
                .cookie(cookie)
                .post("/v1/client/{clientId}/approveFDD")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 9)
    public void test_verifyFDDStatus() throws SQLException, ClassNotFoundException {
        String actualClientStatus = app.getDbHelper().getClientDDStatusFromTestDB(clientId);
        assertEquals(actualClientStatus, "FDD");
    }

    @Test(priority = 10)
    public void test_verifyVirtualIBANCreation() throws SQLException, ClassNotFoundException, InterruptedException {
        actualVIbanFromDB = app.getDbHelper().getVirtualIBANFromTestDB();
        assertThat(actualVIbanFromDB, notNullValue());
    }

    @Test(priority = 11)
    public void test_verifyStatusRequest() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualStatusRequest = app.getDbHelper().getvIbanStatusRequestFromTestDB();
        assertThat(actualStatusRequest, equalTo("D"));
    }

    @Test(priority = 12)
    public void test_verifyIbanFromMobileApp() throws SQLException, ClassNotFoundException {
        cliSessionId = login_registrationHelper.loginDipocket_test(HelperBase.prop.getProperty("mobile.registration.phoneNumber"), pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
        String response = given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .header("clisessionid", ""+cliSessionId+"")
                .auth().basic(HelperBase.prop.getProperty("mobile.registration.phoneNumber"), pass)
                .get("https://http.dipocket.site/ClientServices/v1/clientProfile/paymentDetails")
                .then().log().all()
                .statusCode(200).extract().response().asString();


        JsonPath jsonPath = new JsonPath(response);
        actualVIbanFromMobileApp = jsonPath.getString("paymentDetailsList[0].accountNo");
        System.out.println("actualVIbanFromMobileApp : " + actualVIbanFromMobileApp);

        assertThat(actualVIbanFromDB, equalTo(actualVIbanFromMobileApp));
    }

    @Test(priority = 13)
    public void test_verifyIbanFromBO(){
        Response response = given()
                .spec(app.requestSpecBOTest)
                .pathParam("clientId", clientId)
                .header("bo-auth-token", sms)
                .cookie(cookie)
                .get("/v1/client/{clientId}/paymentDetails");

                response.then().log().all().statusCode(200);

        actualVIbanFromBO = String.valueOf(response.jsonPath().getList("accountNo").get(0));
        System.out.println("actualVIbanFromBO : " + actualVIbanFromBO);

        assertThat(actualVIbanFromDB, equalTo(actualVIbanFromBO));
    }


    @Test(priority = 14)
    public void test_customerServices_v1_client_register(){
        String response = given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(sandboxLogin, sandboxPass)
                .body("{\n" +
                        "  \"requestId\" : \"d1f202fe-df2e-46da-94ba-"+app.generateRandomString(12)+"\",\n" +
                        "  \"langCode\" : \"en\",\n" +
                        "  \"firstName\" : \"QA\",\n" +
                        "  \"lastName\" : \"Test\",\n" +
                        "  \"cardHolderName\" : \"cardHolderName\",\n" +
                        "  \"email\" : \"testqa"+app.generateRandomString(5)+"@gmail.com\",\n" +
                        "  \"mainPhone\" : "+app.generateRandomNumber(12)+",\n" +
                        "  \"dob\" : \"1990-08-31\",\n" +
                        "  \"ddStatus\" : \"FDD\",\n" +
                        "  \"currencyCode\" : \""+ currencyCodeEUR +"\",\n" +
                        "  \"rStreetLine1\" : \"StreetLine1\",\n" +
                        "  \"rStreetLine2\" : \"StreetLine2\",\n" +
                        "  \"rCity\" : \"City\",\n" +
                        "  \"rState\" : \"State\",\n" +
                        "  \"rZip\" : \"Zip\",\n" +
                        "  \"rCountryCode\" : \""+countryCode+"\",\n" +
                        "  \"mStreetLine1\" : \"StreetLine1\",\n" +
                        "  \"mStreetLine2\" : \"StreetLine2\",\n" +
                        "  \"mCity\" : \"City\",\n" +
                        "  \"mState\" : \"State\",\n" +
                        "  \"mZip\" : \"Zip\",\n" +
                        "  \"mCountryCode\" : \""+countryCode+"\"\n" +
                        "}")
                .post("https://api.dipocket.site/CustomerServices/v1/client/register")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        clientIdSandbox = jsonPath.getInt("clientId");
    }

    @Test(priority = 15)
    public void test_CustomerServices_v1_card_create(){
        String response = given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(sandboxLogin, sandboxPass)
                .body("{\n" +
                        "    \"requestId\":  \"fea3af96-50b5-48c2-9456-"+app.generateRandomString(12)+"\",\n" +
                        "    \"clientId\": \""+clientIdSandbox+"\",\n" +
                        "    \"program\":  \"Sandbox\",\n" +
                        "    \"currencyCode\":  \""+ currencyCodeEUR +"\",\n" +
                        "    \"cardType\":  \"PLASTIC\",\n" +
                        "    \"accFeeTariffPlanId\":  \"2000\",\n" +
                        "    \"ePin\": \"1111\",\n" +
                        "    \"accountId\": \"\"\n" +
                        "}")
                .post("https://api.dipocket.site/CustomerServices/v1/card/create")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        token = jsonPath.getString("token");
    }

    @Test(priority = 16)
    public void test_CustomerServicesDev_v1_card_activate(){
        cardActivateRequest.setRequestId("fea3af96-50b5-48c2-9456-"+app.generateRandomString(12)+"");
        cardActivateRequest.setClientId(Long.valueOf(clientIdSandbox));
        cardActivateRequest.setToken(token);

        String json = gson.toJson(cardActivateRequest);
        System.out.println(json);

        given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().basic(sandboxLogin, sandboxPass)
                .body(json)
//                .body("{\n" +
//                        "    \"requestId\":  \"fea3af96-50b5-48c2-9456-"+app.generateRandomString(12)+"\",\n" +
//                        "    \"clientId\": \""+clientIdSandbox+"\",\n" +
//                        "    \"token\":  \""+token+"\"\n" +
//                        "}")
                .post("https://api.dipocket.site/CustomerServices/v1/card/activate")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 17)
    public void test_verifyVirtualIBANCreation_() throws SQLException, ClassNotFoundException, InterruptedException {
        actualVIbanSandboxFromDB = app.getDbHelper().getVirtualIBANFromTestDB();
        assertThat(actualVIbanSandboxFromDB, notNullValue());
    }

    @Test(priority = 18)
    public void test_verifyStatusRequest_() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualStatusRequest = app.getDbHelper().getvIbanStatusRequestFromTestDB();
        assertThat(actualStatusRequest, equalTo("D"));
    }

    @Test(priority = 19)
    public void test_verifyIbanFromBO_sandbox() {
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










    //    public void takeSDDTicketFromTest(String cookie, String sms, String clientId, String date) {
//        int count = 0;
//        for(int i = 0; i < 27; i++) {
//            count++;
//            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take_test(cookie, sms);
//            String response = res.then().extract().response().asString();
//
//            JsonPath js = new JsonPath(response);
//            ticketId = js.getInt("id");
//            actualTypeName = js.getString("typeName");
//            actualClientId = js.getString("clientId");
//
//            if(actualTypeName.equals("SDD check") && actualClientId.equals(clientId)){
//                break;
//            }
//
//            if(!actualTypeName.equals("SDD check")){
//                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone_test(cookie, ticketId, date, sms);
//            }
//
//            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take_test(cookie, sms);
//            String response2 = res2.then().extract().response().asString();
//
//            JsonPath js2 = new JsonPath(response2);
//            ticketId = js2.getInt("id");
//            actualTypeName = js2.getString("typeName");
//        }
//
//        System.out.println("count: " + count);
//
//        assertEquals(actualTypeName, "SDD check");
//    }

    //    private void takeFDDTicketFromTest() {
//        int count = 0;
//        for(int i = 0; i < 27; i++) {
//            count++;
//            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take_test(cookie, sms);
//            String response = res.then().extract().response().asString();
//
//            JsonPath js = new JsonPath(response);
//            ticketId = js.getInt("id");
//            actualTypeName = js.getString("typeName");
//            actualClientId = js.getString("clientId");
//
//            if(actualTypeName.equals("FDD check") && actualClientId.equals(clientId)){
//                break;
//            }
//
//            if(!actualTypeName.equals("FDD check")){
//                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone_test(cookie, ticketId, tomorrow, sms);
//            }
//
//            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take_test(cookie, sms);
//            String response2 = res2.then().extract().response().asString();
//
//            JsonPath js2 = new JsonPath(response2);
//            ticketId = js2.getInt("id");
//            actualTypeName = js2.getString("typeName");
//        }
//
//        System.out.println("count: " + count);
//
//        assertEquals(actualTypeName, "FDD check");
//    }
}