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

    String city = "Vilnius";
    String login = "APIOLENA";
    String pass = "pU9N1Lu";
    int feeAmount = 0;
    String currencyCode = "PLN";
    int accountId = 116413;
    Gson gson = new Gson();
    AccountBankTransferPlnInPolandRequest accountBankTransferPlnInPolandRequest = new AccountBankTransferPlnInPolandRequest();
    CalculateBankTransferRequest calculateBankTransferRequest = new CalculateBankTransferRequest();

    @Test(priority = 1)
    public void test_CustomerServices_v1_account_calculateBankTransfer_plnInPoland(){
        calculateBankTransferRequest.setAccountId(accountId);
        calculateBankTransferRequest.setRequestId("d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"");
        calculateBankTransferRequest.setCurrencyCode(currencyCode);
        calculateBankTransferRequest.setAmount(10);
        String json = gson.toJson(calculateBankTransferRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_account_calculateBankTransfer_plnInPoland(login, pass, json);

        JsonPath jsonPath = new JsonPath(response);
        feeAmount = jsonPath.getInt("feeAmount");
    }

    @Test(priority = 2)
    public void test_CustomerServices_v1_account_bankTransfer_plnInPoland(){
        accountBankTransferPlnInPolandRequest.setAccountId(accountId);
        accountBankTransferPlnInPolandRequest.setAmount(1000);
        accountBankTransferPlnInPolandRequest.setBeneficiaryAccount("EE617777000011780546");
        accountBankTransferPlnInPolandRequest.setBeneficiaryType("COMPANY");
        accountBankTransferPlnInPolandRequest.setName("OCORPTEST");
        accountBankTransferPlnInPolandRequest.setCurrencyCode("PLN");
        accountBankTransferPlnInPolandRequest.setFeeAmount(feeAmount);
        accountBankTransferPlnInPolandRequest.setFeeCurrencyCode("EUR");
        accountBankTransferPlnInPolandRequest.setReference("test");
        accountBankTransferPlnInPolandRequest.setRequestId("d1f202fe-df2e"+app.generateRandomString(16));
        String json = gson.toJson(accountBankTransferPlnInPolandRequest);

        app.getCustomerServicesRequestsHelper().customerServices_v1_account_bankTransfer_plnInPoland(login, pass, json);
    }

    @Test(priority = 3)
    public void test_verifyStatusPTSFromPTS_OUT_TRAN() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualPTSStatus = app.getDbHelper().getStatusPTSFromTestDB();
        assertThat(actualPTSStatus, equalTo("INPRCS"));
    }
}