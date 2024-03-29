package tests.uiTests.bo.boOperations;

import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CreatCorporateClientTests extends UITestBase {
    String currency = "EUR";
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testOpeningAPageForCreatingACorporateClient() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoCreateCorporateClientTab();

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//app-select-async[@ng-reflect-name='clientType']", "//app-input[@ng-reflect-name='companyName']",
                "//app-input[@ng-reflect-name='identifyCode']", "//app-select-async[@ng-reflect-name='clientSite']", "//app-select-async[@ng-reflect-name='lang']",
                "//app-select-async[@ng-reflect-name='currency']", "//app-select-async[@ng-reflect-name='ddStatus']",
        "//app-select-async[@ng-reflect-name='feeTariffPlan']", "//app-select-async[@ng-reflect-name='defCardProgram']", "//app-select-async[@ng-reflect-name='operLimitPlan']",
        "//app-select-async[@ng-reflect-name='limitPlan']", "//app-select-async[@ng-reflect-name='contractCountryId']"}), "Fields verifications");
    }

    @Test
    public void testCreationOfACorporateClientFillingInTheDataOfTheFirstSecondThirdFourthPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoCreateCorporateClientTab();
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheFirstPage("Corporate", "Predict", "12345678909", Site.DIPOCKET.toString(), "English", currency, "FDD", "United Kingdom - standard", "DiPocket", "Unlimited", "Unlimited", "United Kingdom");
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheSecondPage("Poland", "2123123", "Krakiv", "Gagarina ave", "62", true, "");
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheThirdPage("Poland", "2123123", "Krakiv", "Gagarina ave", "62", false);
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheFourthPage("Test Test", "No GPS");

        String fourhPageCurrency = app.getUiboHelper().getAttributeValue(By.xpath("//app-input[@ng-reflect-name='currency'] //input"));
        app.getUiboHelper().clickWithJS(By.xpath("//p-button[@ng-reflect-label='Next']"));

        softAssert.assertEquals(fourhPageCurrency, currency, "Currency");

        app.getUiboHelper().waitFor(By.xpath("//p-button[@ng-reflect-label='Create']"));

        List<String> actualText = app.getUiboHelper().getActualText(By.xpath("//app-confirmation-step //tbody //tr"));
        List<String> expectedText = app.getUiboHelper().getDateFromFile("files/bo/boOperations/creationOfACorporateClient.txt");

        softAssert.assertEquals(actualText, expectedText, "5 page data");

        app.getUiboOperationsHelper().createCorporateClientWithMessage("Corporate client was created successfully");

        List<String> actualClientDetails = app.getUiboHelper().getActualText(By.xpath("//app-corp-client-details-info //div[3] //p"));
        List<String> expectedClientDetails = app.getUiboHelper().getDateFromFile("files/bo/boOperations/creationOfACorporateClientClientDitails.txt");

        softAssert.assertEquals(actualClientDetails, expectedClientDetails, "client datails page");
    }

    @Test
    public void testCreationOfACorporateClientIfTheClientsRegistrationAddressIsInTheUSA() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoCreateCorporateClientTab();
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheFirstPage("Corporate", "Predict", "12345678909", Site.DIPOCKET.toString(), "English", currency, "FDD", "United Kingdom - standard", "DiPocket", "Unlimited", "Unlimited", "United Kingdom");
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheSecondPage("United States", "2123123", "Krakiv", "Gagarina ave", "62", false, "Test");
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheFourthPage("Test Test", "No GPS");

        app.getUiboHelper().clickWithJS(By.xpath("//p-button[@ng-reflect-label='Next']"));

        app.getUiboOperationsHelper().createCorporateClientWithMessage("Corporate client was created successfully");
    }

    @Test
    public void testCreatingACorporateClientWithoutAnAccount() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoCreateCorporateClientTab();
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheFirstPage("Corporate", "Predict", "12345678909", Site.DIPOCKET.toString(), "English", currency, "FDD", "United Kingdom - standard", "DiPocket", "Unlimited", "Unlimited", "United Kingdom");
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheSecondPage("Poland", "2123123", "Krakiv", "Gagarina ave", "62", true, "");
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheThirdPage("Poland", "2123123", "Krakiv", "Gagarina ave", "62", false);
        app.getUiboOperationsHelper().setNoAccount();
        app.getUiboOperationsHelper().verifyInvisibilityOfTheFieldsOnFourthPageAfterSetNoAccount();

        app.getUiboHelper().clickWithJS(By.xpath("//p-button[@ng-reflect-label='Next']"));

        app.getUiboOperationsHelper().createCorporateClientWithMessage("Corporate client was created successfully");
    }
}