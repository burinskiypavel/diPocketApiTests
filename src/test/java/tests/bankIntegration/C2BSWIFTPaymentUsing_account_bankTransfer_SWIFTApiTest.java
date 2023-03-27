package tests.bankIntegration;

import base.TestBase;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import model.customerServices.AccountBankTransferRequest;
import model.customerServices.CalculateBankTransferRequest;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class C2BSWIFTPaymentUsing_account_bankTransfer_SWIFTApiTest extends TestBase {
    String city = "Vilnius";
    String login = "APIOLENA";
    String pass = "pU9N1Lu";
    int feeAmount = 0;
    String currencyCode = "EUR";
    int accountId = 111231;
    Gson gson = new Gson();
    AccountBankTransferRequest accountBankTransferRequest = new AccountBankTransferRequest();
    CalculateBankTransferRequest calculateBankTransferRequest = new CalculateBankTransferRequest();

    @Test(priority = 1)
    public void test_CustomerServices_v1_account_calculateBankTransfer_SWIFT(){
        calculateBankTransferRequest.setAccountId(accountId);
        calculateBankTransferRequest.setRequestId("d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"");
        calculateBankTransferRequest.setCurrencyCode(currencyCode);
        calculateBankTransferRequest.setAmount(10);
        String json = gson.toJson(calculateBankTransferRequest);

        String response = app.getCustomerServicesRequestsHelper().customerServices_v1_account_calculateBankTransfer_SWIFT_test(login, pass, json);

        JsonPath jsonPath = new JsonPath(response);
        feeAmount = jsonPath.getInt("feeAmount");
    }

    @Test(priority = 2)
    public void test_CustomerServices_v1_account_bankTransfer_SWIFT(){
        accountBankTransferRequest.setAccountId(accountId);
        accountBankTransferRequest.setAmount(148);
        accountBankTransferRequest.setBankId("LHVBEE22");
        accountBankTransferRequest.setBeneficiaryAccount("EE407777000012064164");
        accountBankTransferRequest.setBeneficiaryType("COMPANY");
        accountBankTransferRequest.setCity(city);
        accountBankTransferRequest.setCompanyName("OCORPTEST");
        accountBankTransferRequest.setCountryCode("LT");
        accountBankTransferRequest.setCurrencyCode(currencyCode);
        accountBankTransferRequest.setFeeAmount(feeAmount);
        accountBankTransferRequest.setFeeCurrencyCode(currencyCode);
        accountBankTransferRequest.setFirstName("");
        accountBankTransferRequest.setLastName("");
        accountBankTransferRequest.setReference("test");
        accountBankTransferRequest.setRequestId("d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"");
        accountBankTransferRequest.setStreetLine1("Upes 2");
        accountBankTransferRequest.setStreetLine2("Upes 2");
        accountBankTransferRequest.setZip(11111);
        String json = gson.toJson(accountBankTransferRequest);

        app.getCustomerServicesRequestsHelper().customerServices_v1_account_bankTransfer_SWIFT_test(login, pass, json);
    }

    @Test(priority = 3)
    public void test_verifyStatusPTSFromPTS_OUT_TRAN() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualPTSStatus = app.getDbHelper().getStatusPTSFromTestDB();
        assertThat(actualPTSStatus, equalTo("INPRCS"));
    }
}