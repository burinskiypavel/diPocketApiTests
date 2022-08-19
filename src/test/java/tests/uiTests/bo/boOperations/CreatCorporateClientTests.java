package tests.uiTests.bo.boOperations;

import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CreatCorporateClientTests extends UITestBase {
    String currency = "EUR";

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
    public void testCreationOfACorporateClientFillingInTheDataOfTheFirstSecondThirdPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoCreateCorporateClientTab();
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheFirstPage("Corporate", "Predict", "12345678909", Site.DIPOCKET.toString(), "English", currency, "FDD", "United Kingdom - standard", "DiPocket", "Unlimited", "Unlimited", "United Kingdom");

        app.getUiboHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));

        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheSecondPage("Poland", "2123123", "Krakiv", "Gagarina ave", "62", true);

        app.getUiboHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));

        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheSecondPage("Poland", "2123123", "Krakiv", "Gagarina ave", "62", false);

        app.getUiboHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='accName']"));

        app.getUiboOperationsHelper().setAccountName("Test Test");
        app.getUiboOperationsHelper().setAccountType("No GPS");

        String fourhPagecurrency = app.getUiboHelper().getAttributeValue(By.xpath("//app-input[@ng-reflect-name='currency'] //input"));
        app.getUiboHelper().clickWithJS(By.xpath("//p-button[@ng-reflect-label='Next']"));

        Assert.assertEquals(fourhPagecurrency, currency);

        app.getUiboHelper().waitFor(By.xpath("//p-button[@ng-reflect-label='Create']"));
    }
}