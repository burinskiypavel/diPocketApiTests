package tests.bankIntegration.aspspApi.ais;

import base.APIUITestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.aspsp.*;
import model.clientServices.DashBoardNotifyDetails3Request;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AisTests extends APIUITestBase {
    public String consentId = null;
    public String href = null;
    public String uiTransactionCode = null;
    public String apiTransactionCode = null;
    public int notifyId = 0;
    public String phone = "380980316499";
    public String pass = "reset246740";
    public String iban = "PL42109010560000000150296424";
    public String validUntil = "2023-06-17";
    String[] balances = new String[0];
    String[] transactions = new String[0];
    public String site = Site.DIPOCKET.toString();
    Gson gson = new Gson();
    DashBoardNotifyDetails3Request dashBoardNotifyDetails3Request = new DashBoardNotifyDetails3Request();
    Access access = new Access();
    V1ConsentsRequest v1ConsentsRequest = new V1ConsentsRequest();


    @Test(priority = 1)
    public void test_AISCreateConsentRequest() {
        access.setBalances(balances);
        access.setTransactions(transactions);
        v1ConsentsRequest.setAccess(access);
        v1ConsentsRequest.setRecurringIndicator(true);
        v1ConsentsRequest.setValidUntil(validUntil);
        String json = gson.toJson(v1ConsentsRequest);
        String response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents(json);

        consentId = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "consentId");
        href = app.getResponseValidationHelper().getStringFromResponseJsonPath(response, "_links.scaRedirect.href");
    }

    @Test(priority = 2)
    public void test_webConfirmaton() {
//        appUi.driver.navigate().to(href);
//        appUi.getUiboHelper().waitFor(By.id("phone-number"));
//        appUi.driver.findElement(By.id("phone-number")).sendKeys(phone);
//        appUi.driver.findElement(By.id("password")).sendKeys(pass);
//        appUi.driver.findElement(By.xpath("//button[@data-dip-action='login']")).click();
//        appUi.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Please go to DiPocket Mobile Application to confirm your authorization attempt')]"));
//        uiTransactionCode = appUi.driver.findElement(By.id("transaction-code")).getText();
        uiTransactionCode = appUi.getUiAspspHelper().webConfirmaton(href, phone, pass);
    }

    @Test(priority = 3)
    public void test_mobileConfirmation() throws SQLException, ClassNotFoundException {
        String cliSessionId = app.getLogin_registrationHelper().loginDipocket_test(phone, pass, prop.getProperty("mobile.login.deviceuuid"));
        Response response = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyList2(prop.getProperty("mobile.test.base.url"), phone, pass, cliSessionId);
        String responseString = response.then().body("notificationList[0].notifyTypeName", equalTo("ASPSP Authorization")).extract().response().asString();
        notifyId = app.getResponseValidationHelper().getIntFromResponseJsonPath(responseString, "notificationList[0].notifyId");

        dashBoardNotifyDetails3Request.setTypeId(55);
        dashBoardNotifyDetails3Request.setNotifyId(notifyId);
        dashBoardNotifyDetails3Request.setDetailsRef("");
        String json = gson.toJson(dashBoardNotifyDetails3Request);
        Response response2 = app.getClientServicesRequestsHelper().clientServices_v1_dashBoard_notifyDetails3(prop.getProperty("mobile.test.base.url"), json, phone, pass, cliSessionId);
        String responseStringNotifyDetails3 = response2.then().body("notifyTypeName", equalTo("ASPSP Authorization"),
                        "hint", equalTo("Please confirm your authentication attempt only if you see the same PIN at authentication webpage")).extract().response().asString();
        apiTransactionCode = app.getResponseValidationHelper().getStringFromResponseJsonPath(responseStringNotifyDetails3, "dtails");

        app.getClientServicesRequestsHelper().clientServices_v1_aspsp_notifyId_approve(prop.getProperty("mobile.test.base.url"), notifyId, phone, pass, cliSessionId);

        //appUi.getUiboHelper().waitFor(By.xpath("//button[contains(text(), 'Consent')]"));
        //appUi.driver.findElement(By.xpath("//button[contains(text(), 'Consent')]")).click();
        appUi.getUiAspspHelper().pressConsent();

        assertThat(uiTransactionCode, equalTo(apiTransactionCode));
    }

    @Test(priority = 4)
    public void test_AISGetConsentStatus_showConsentStatus() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds_status(consentId);
        response.then().body("consentStatus", equalTo("valid"));
    }

    @Test(priority = 5)
    public void test_AISGetConsentRequest_showConsentInformation() {
        Response response = app.getConsentsRequestsHelper().partnerId_bg_v1_consents_confirmationOfFunds(consentId);
        response.then().body("validUntil", equalTo(validUntil),
                "consentStatus", equalTo("valid"),
                "recurringIndicator", equalTo(true));
    }
}