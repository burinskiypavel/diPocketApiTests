package tests.bankIntegration.aspspApi.pis;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.aspsp.Account;
import model.aspsp.ConfirmationOfFundsRequest;
import model.aspsp.CreateConsentRequest;
import model.aspsp.pis.*;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PisTests extends APIUITestBase {
    String partnerId = "654321";
    String actualPaymentId = null;
    String href = null;
    String paymentId = "94647f10-c4d6-4009-84dd-dcbf49a082e3";
    String x_request_ID = "ded9c406-b701-4963-9b68-5d8d7a2b3041";
    String apiTransactionCode = null;
    int notifyId = 0;
    String site = Site.DIPOCKET.toString();
    String uiTransactionCode = null;
    Gson gson = new Gson();
    CreateConsentRequest createConsentRequest = new CreateConsentRequest();
    Account account = new Account();
    DashBoardNotifyDetails3Request dashBoardNotifyDetails3Request = new DashBoardNotifyDetails3Request();
    ConfirmationOfFundsRequest confirmationOfFundsRequest = new ConfirmationOfFundsRequest();
    InstructedAmount instructedAmount = new InstructedAmount();
    PaymentsCrossBorderCreditTransfersRequest paymentsCrossBorderCreditTransfersRequest = new PaymentsCrossBorderCreditTransfersRequest();
    CreditorAddress creditorAddress = new CreditorAddress();
    CreditorAddress creditorAddressForSepaPayment = new CreditorAddress();
    CreditorAccount creditorAccount = new CreditorAccount();
    PaymentsDomesticCreditTransfersRequest paymentsDomesticCreditTransfersRequest = new PaymentsDomesticCreditTransfersRequest();
    PaymentSepaCreditTransfersRequest paymentSepaCreditTransfersRequest = new PaymentSepaCreditTransfersRequest();

    @Test(priority = 1)
    public void test_pisGetPaymentRequest() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_payments_sepa_credit_transfers_paymentId(x_request_ID, partnerId, paymentId);
        String stResponse = response.then().extract().response().asString();

        response.then()
                .body("transactionStatus", equalTo("ACSC"),
                        "paymentId", notNullValue(),
                        "paymentDetails.instructedAmount.currency", equalTo("PLN"),
                        "paymentDetails.instructedAmount.amount", equalTo("9.00"),
                        "paymentDetails.creditorName", equalTo("some guy"),
                        "paymentDetails.creditorAccount.iban", equalTo("EE657777000047856985"),
                        "paymentDetails.creditorType", equalTo("INDIVIDUAL"),
                        "paymentDetails.remittanceInformationUnstructured", equalTo("domestic transfer test DPB-453 retest v1"));

        actualPaymentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(stResponse, "paymentId");
    }

    @Test(priority = 2)
    public void test_PISGetPaymentRequestStatus(){
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_payments_sepa_credit_transfers_paymentId_status(x_request_ID, partnerId, paymentId);
        response.then().body("transactionStatus", equalTo("ACSC"));
    }

    @Test(priority = 3)
    public void test_PISInitiatePaymentSWIFT(){
        instructedAmount.setCurrency("EUR");
        instructedAmount.setAmount("1.50");

        creditorAddress.setStreetName("Sörnäistenlaituri");
        creditorAddress.setBuildingNumber("3");
        creditorAddress.setTownName("Helsinki");
        creditorAddress.setPostCode("00540");
        creditorAddress.setCountry("FI");

        creditorAccount.setIban("DE02100100109307118603");

        paymentsCrossBorderCreditTransfersRequest.setInstructedAmount(instructedAmount);
        paymentsCrossBorderCreditTransfersRequest.setCreditorName("Merchant123");
        paymentsCrossBorderCreditTransfersRequest.setCreditorType("INDIVIDUAL");
        paymentsCrossBorderCreditTransfersRequest.setCreditorAddress(creditorAddress);
        paymentsCrossBorderCreditTransfersRequest.setCreditorAgent("SBANFIHH");
        paymentsCrossBorderCreditTransfersRequest.setCreditorAccount(creditorAccount);
        paymentsCrossBorderCreditTransfersRequest.setRemittanceInformationUnstructured("SWIFT payment test");
        String json = gson.toJson(paymentsCrossBorderCreditTransfersRequest);

        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_payments_cross_border_credit_transfers(x_request_ID, partnerId, json);
        String stResponse = response.then().extract().response().asString();
        response.then().body("transactionStatus", equalTo("RCVD"));

        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(stResponse, "_links.scaRedirect.href");
    }

    @Test(priority = 4)
    public void test_webConfirmaton() {
        uiTransactionCode = appUi.getUiAspspHelper().webConfirmaton(href, prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"));
    }

    @Test(priority = 5)
    public void test_mobileConfirmation() throws SQLException, ClassNotFoundException {
        String cliSessionId = app.getLogin_registrationHelper().loginDipocket_test(prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"), prop.getProperty("mobile.login.deviceuuid"));
        Response response = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyList2(prop.getProperty("mobile.test.base.url"), prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"), cliSessionId);
        String responseString = response.then().body("notificationList[0].notifyTypeName", equalTo("ASPSP Authorization")).extract().response().asString();
        notifyId = app.getResponseValidationHelper().getIntFromResponseJsonPath(responseString, "notificationList[0].notifyId");

        dashBoardNotifyDetails3Request.setTypeId(55);
        dashBoardNotifyDetails3Request.setNotifyId(notifyId);
        dashBoardNotifyDetails3Request.setDetailsRef("");
        String json = gson.toJson(dashBoardNotifyDetails3Request);
        Response response2 = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyDetails3(prop.getProperty("mobile.test.base.url"), json, prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"), cliSessionId);
        String responseStringNotifyDetails3 = response2.then().body("notifyTypeName", equalTo("ASPSP Authorization"),
                "hint", equalTo("Please confirm your authentication attempt only if you see the same PIN at authentication webpage")).extract().response().asString();
        apiTransactionCode = app.getResponseValidationHelper().getStringFromResponseJsonPath(responseStringNotifyDetails3, "dtails");

        app.getClientServicesRequestsHelper().clientServices_v1_aspsp_notifyId_approve(prop.getProperty("mobile.test.base.url"), notifyId, prop.getProperty("mobile.login.homePage.loginPhone"), prop.getProperty("mobile.login.homePage.pass"), cliSessionId);

        assertThat(uiTransactionCode, equalTo(apiTransactionCode));
    }

    @Test(priority = 6)
    public void test_PISInitiatePaymentDomestic(){
        instructedAmount.setCurrency("PLN");
        instructedAmount.setAmount("9.00");

        creditorAccount.setIban("EE657777000012110759");

        paymentsDomesticCreditTransfersRequest.setInstructedAmount(instructedAmount);
        paymentsDomesticCreditTransfersRequest.setCreditorName("Marek Testing");
        paymentsDomesticCreditTransfersRequest.setCreditorType("INDIVIDUAL");
        paymentsDomesticCreditTransfersRequest.setCreditorAccount(creditorAccount);
        paymentsDomesticCreditTransfersRequest.setRemittanceInformationUnstructured("domestic transfer test version1");
        String json = gson.toJson(paymentsDomesticCreditTransfersRequest);

        String stResponse = given()
                .spec(app.requestSpecASPSPTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "ded9c406-b701-4963-9b68-5d8d7a2b3041")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
                .post("/{partnerId}/bg/v1/payments/domestic-credit-transfers")
                .then().log().all()
                .statusCode(200)
                .body("transactionStatus", equalTo("RCVD"))
                .extract().response().asString();

        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(stResponse, "_links.scaRedirect.href");
    }

    @Test(priority = 7)
    public void test_PISInitiatePaymentSEPA(){
        instructedAmount.setCurrency("EUR");
        instructedAmount.setAmount("1.10");

        creditorAccount.setIban("DE02100100109307118603");
        creditorAddressForSepaPayment.setCountry("FI");

        paymentSepaCreditTransfersRequest.setInstructedAmount(instructedAmount);
        paymentSepaCreditTransfersRequest.setCreditorName("Merchant123");
        paymentSepaCreditTransfersRequest.setCreditorType("INDIVIDUAL");
        paymentSepaCreditTransfersRequest.setCreditorAddress(creditorAddressForSepaPayment);
        paymentSepaCreditTransfersRequest.setCreditorAgent("SBANFIHH");
        paymentSepaCreditTransfersRequest.setCreditorAccount(creditorAccount);
        paymentSepaCreditTransfersRequest.setRemittanceInformationUnstructured("SEPA payment test full payment v1");
        String json = gson.toJson(paymentSepaCreditTransfersRequest);

        String stResponse = given()
                .spec(app.requestSpecASPSPTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "ded9c406-b701-4963-9b68-5d8d7a2b3041")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
                .post("/{partnerId}/bg/v1/payments/sepa-credit-transfers")
                .then().log().all()
                .statusCode(200)
                .body("transactionStatus", equalTo("RCVD"))
                .extract().response().asString();

        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(stResponse, "_links.scaRedirect.href");
    }
}