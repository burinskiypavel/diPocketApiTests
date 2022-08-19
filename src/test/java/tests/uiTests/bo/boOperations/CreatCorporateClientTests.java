package tests.uiTests.bo.boOperations;

import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreatCorporateClientTests extends UITestBase {

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
    public void testCreationOfACorporateClientFillingInTheDataOfTheFirstPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoCreateCorporateClientTab();
        app.getUiboOperationsHelper().creationOfACorporateClientFillingInTheDataOfTheFirstPage("Corporate", "Predict", "12345678909", Site.DIPOCKET.toString(), "English", "EUR", "FDD", "United Kingdom - standard", "DiPocket", "Unlimited", "Unlimited", "United Kingdom");

        app.getUiboHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));
    }
}