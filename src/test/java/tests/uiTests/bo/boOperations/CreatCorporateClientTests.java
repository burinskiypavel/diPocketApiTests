package tests.uiTests.bo.boOperations;

import base.UITestBase;
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

        app.getUiboOperationsHelper().setClientType("Corporate");
        app.getUiboOperationsHelper().setCompanyName("Predict");
        app.getUiboOperationsHelper().setIdentificationCode("12345678909");
        app.getUiboOperationsHelper().setSite("DIPOCKET");
        app.getUiboOperationsHelper().setLanguage("English");
        app.getUiboOperationsHelper().setCurrency("EUR");
        app.getUiboOperationsHelper().setDueDiligenceStatus("FDD");
        app.getUiboOperationsHelper().setFeeTariffPlan("United Kingdom - standard");
        app.getUiboOperationsHelper().setCardProgramByDefault("DiPocket");
        app.getUiboOperationsHelper().setOperationsLimitPlan("Unlimited");
        app.getUiboOperationsHelper().setTransactionsLimitPlan("Unlimited");
        app.getUiboOperationsHelper().setCountryOfContract("United Kingdom");
        Thread.sleep(1500);
        app.getUiboOperationsHelper().pressNext();

        app.getUiboHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));
    }
}