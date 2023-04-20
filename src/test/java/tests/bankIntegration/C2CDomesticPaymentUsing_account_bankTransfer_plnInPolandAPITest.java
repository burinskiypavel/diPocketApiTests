package tests.bankIntegration;

import appmanager.HelperBase;
import base.TestBase;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import model.customerServices.AccountBankTransferPlnInPolandRequest;
import model.customerServices.CalculateBankTransferRequest;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class C2CDomesticPaymentUsing_account_bankTransfer_plnInPolandAPITest extends TestBase {
    int feeAmount = 0;
    String currencyCode = "PLN";
    int accountId = 116413;
    String accountNoDomestic = null;
    String beneficiaryAccount = "42109010560000000150296424";
    Gson gson = new Gson();
    AccountBankTransferPlnInPolandRequest accountBankTransferPlnInPolandRequest = new AccountBankTransferPlnInPolandRequest();
    CalculateBankTransferRequest calculateBankTransferRequest = new CalculateBankTransferRequest();

    @Test(priority = 0)
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

    @Test(priority = 1)
    public void test_CustomerServices_v1_account_calculateBankTransfer_plnInPoland(){
        calculateBankTransferRequest.setAccountId(accountId);
        calculateBankTransferRequest.setRequestId("d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"");
        calculateBankTransferRequest.setCurrencyCode(currencyCode);
        calculateBankTransferRequest.setAmount(10);
        String json = gson.toJson(calculateBankTransferRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_account_calculateBankTransfer_plnInPoland(app.bankIntegrationPaymentsLogin, app.bankIntegrationPaymentPass, json);

        JsonPath jsonPath = new JsonPath(response);
        feeAmount = jsonPath.getInt("feeAmount");
    }

    @Test(priority = 2)
    public void test_CustomerServices_v1_account_bankTransfer_plnInPoland(){
        accountBankTransferPlnInPolandRequest.setAccountId(accountId);
        accountBankTransferPlnInPolandRequest.setAmount(800);
        accountBankTransferPlnInPolandRequest.setBeneficiaryAccount(accountNoDomestic);
        accountBankTransferPlnInPolandRequest.setBeneficiaryType("INDIVIDUAL");
        accountBankTransferPlnInPolandRequest.setName("Ltd Test");
        accountBankTransferPlnInPolandRequest.setCurrencyCode("PLN");
        accountBankTransferPlnInPolandRequest.setFeeAmount(feeAmount);
        accountBankTransferPlnInPolandRequest.setFeeCurrencyCode("EUR");
        accountBankTransferPlnInPolandRequest.setReference("test");
        accountBankTransferPlnInPolandRequest.setRequestId("d1f202fe-df2e"+app.generateRandomString(16));
        String json = gson.toJson(accountBankTransferPlnInPolandRequest);

        app.getCustomerServicesRequestsHelper().customerServices_v1_account_bankTransfer_plnInPoland(app.bankIntegrationPaymentsLogin, app.bankIntegrationPaymentPass, json);
    }

    @Test(priority = 3)
    public void test_verifyStatusPTSFromPTS_OUT_TRAN() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualPTSStatus = app.getDbHelper().getStatusPTSFromTestDB();
        assertThat(actualPTSStatus, equalTo("INPRCS"));
    }
}