package tests.bankIntegration;

import appmanager.HelperBase;
import base.TestBase;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import model.customerServices.AccountBankTransferRequest;
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
    AccountBankTransferRequest accountBankTransferRequest = new AccountBankTransferRequest();
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
//        accountBankTransferRequest.setAccountId(accountId);
//        accountBankTransferRequest.setAmount(10);
//        accountBankTransferRequest.setBankId("LHVBGB2L");
//        accountBankTransferRequest.setBeneficiaryAccount("GB83LHVB04032900539021");
//        accountBankTransferRequest.setBeneficiaryType("COMPANY");
//        accountBankTransferRequest.setCity(city);
//        accountBankTransferRequest.setCompanyName("OCORPTEST");
//        accountBankTransferRequest.setCountryCode("LT");
//        accountBankTransferRequest.setCurrencyCode(currencyCode);
//        accountBankTransferRequest.setFeeAmount(feeAmount);
//        accountBankTransferRequest.setFeeCurrencyCode(currencyCode);
//        accountBankTransferRequest.setFirstName("");
//        accountBankTransferRequest.setLastName("");
//        accountBankTransferRequest.setReference("test");
//        accountBankTransferRequest.setRequestId("d1f202fe-df2e-46da-94ba"+app.generateRandomString(12)+"");
//        accountBankTransferRequest.setStreetLine1("Upes 2");
//        accountBankTransferRequest.setStreetLine2("Upes 2");
//        accountBankTransferRequest.setZip(11111);
//        String json = gson.toJson(accountBankTransferRequest);

        given()
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .basePath("CustomerServices")
                .contentType("application/json")
                .auth().basic(login, pass)
                .body("{\n" +
                        "    \"accountId\": "+accountId+",\n" +
                        "    \"amount\": 10,\n" +
                        //"    \"zip\": 11111,\n" +
                        //"    \"sortCode\": \"LHVBEE22\",\n" +
                        "    \"beneficiaryAccount\": \"EE617777000011780546\",\n" +
                        "    \"beneficiaryType\": \"COMPANY\",\n" +
                        //"    \"city\": \"Vilnius\",\n" +
                        "    \"name\": \"OCORPTEST\",\n" +
                        //"    \"countryCode\": \"LT\",\n" +
                        "    \"currencyCode\": \"PLN\",\n" +
                        "    \"feeAmount\": "+feeAmount+",\n" +
                        "    \"feeCurrencyCode\": \"EUR\",\n" +
                        //"    \"firstName\": \"\",\n" +
                        //"    \"lastName\": \"\",\n" +
                        "    \"reference\": \"test\",\n" +
                        "    \"requestId\": \"d1f202fe-df2e-46da-94baoA7FnwZ7HiIs\"\n" +
                        //"    \"streetLine1\": \"Upes 2\",\n" +
                        //"    \"streetLine2\": \"Upes 2\"\n" +
                        "}")
                .post("/v1/account/bankTransfer/plnInPoland")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_verifyStatusPTSFromPTS_OUT_TRAN() throws SQLException, ClassNotFoundException, InterruptedException {
        String actualPTSStatus = app.getDbHelper().getStatusPTSFromTestDB();
        assertThat(actualPTSStatus, equalTo("INPRCS"));
    }
}