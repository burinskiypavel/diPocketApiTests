package tests.bankIntegration;

import appmanager.HelperBase;
import base.TestBase;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import model.customerServices.AccountBankTransferGbpInBritainRequest;
import model.customerServices.CalculateBankTransferRequest;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class C2CDomesticPaymentUsing_account_bankTransfer_gbpInBritainApiTest extends TestBase {
    int feeAmount = 0;
    String currencyCode = "GBP";
    int accountId = 112099;
    String accountNoDomestic = null;
    Gson gson = new Gson();
    AccountBankTransferGbpInBritainRequest accountBankTransferGbpInBritainRequest = new AccountBankTransferGbpInBritainRequest();
    CalculateBankTransferRequest calculateBankTransferRequest = new CalculateBankTransferRequest();

    @Test(priority = 1)
    public void test_CustomerServices_v1_account_accountId_bankDetails(){
        String response = given()
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .basePath("CustomerServices")
                .pathParam("accountId", "118602")
                .auth().basic(app.bankIntegrationPaymentsLogin, app.bankIntegrationPaymentPass)
                .get("/v1/account/{accountId}/bankDetails")
                .then().log().all()
                .statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        accountNoDomestic = jsonPath.getString("accountNoDomestic");
    }

    @Test(priority = 2)
    public void test_CustomerServices_v1_account_calculateBankTransfer_gbpInBritain(){
        calculateBankTransferRequest.setAccountId(accountId);
        calculateBankTransferRequest.setRequestId("d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"");
        calculateBankTransferRequest.setCurrencyCode(currencyCode);
        calculateBankTransferRequest.setAmount(10);
        String json = gson.toJson(calculateBankTransferRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_account_calculateBankTransfer_gbpInBritain(app.bankIntegrationPaymentsLogin, app.bankIntegrationPaymentPass, json);

        JsonPath jsonPath = new JsonPath(response);
        feeAmount = jsonPath.getInt("feeAmount");
    }

    @Test(priority = 3)
    public void test_CustomerServices_v1_account_bankTransfer_gbpInBritain(){
        accountBankTransferGbpInBritainRequest.setAccountId(accountId);
        accountBankTransferGbpInBritainRequest.setAmount(200);
        accountBankTransferGbpInBritainRequest.setSortCode("040328");
        accountBankTransferGbpInBritainRequest.setBeneficiaryAccount("00539021");
        accountBankTransferGbpInBritainRequest.setBeneficiaryType("INDIVIDUAL");
        accountBankTransferGbpInBritainRequest.setCompanyName("DIPOCKET");
        accountBankTransferGbpInBritainRequest.setCurrencyCode("GBP");
        accountBankTransferGbpInBritainRequest.setFeeAmount(feeAmount);
        accountBankTransferGbpInBritainRequest.setFeeCurrencyCode("EUR");
        accountBankTransferGbpInBritainRequest.setFirstName("Ltd");
        accountBankTransferGbpInBritainRequest.setLastName("Test");
        accountBankTransferGbpInBritainRequest.setReference("test");
        accountBankTransferGbpInBritainRequest.setRequestId("d1f101fe-df2e-46da-"+app.generateRandomString(15));
        String json = gson.toJson(accountBankTransferGbpInBritainRequest);

        given()
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .basePath("CustomerServices")
                .contentType("application/json")
                .auth().basic(app.bankIntegrationPaymentsLogin, app.bankIntegrationPaymentPass)
                .body(json)
                .post("/v1/account/bankTransfer/gbpInBritain")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void test_verifyStatusPTSFromPTS_OUT_TRAN() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualPTSStatus = app.getDbHelper().getStatusPTSFromTestDB();
        assertThat(actualPTSStatus, equalTo("INPRCS"));
    }
}