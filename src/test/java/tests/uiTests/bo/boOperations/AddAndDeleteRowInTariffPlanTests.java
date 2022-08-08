package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class AddAndDeleteRowInTariffPlanTests extends UITestBase {

    @Test
    public void testAddAndDeleteARowInTariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFeeTariffPlanAndSelectRuleFilterInTheTable("United Kingdom - standard", "Fee for cashload");

        app.getUiboHelper().addRowInTariffPlan("Fee for cashload", "0", "GBP", "GBP", "0", "0", "0");

        app.getUiboHelper().deleteRow(0);
    }

    @Test
    public void testTheUserChangedHisMindAboutAddRowInTariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='+ Add row']"));
        app.getUiboHelper().closePopUp(By.cssSelector("div.p-dialog-header-icons"));

        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
    }

    @Test
    public void testAddRowInTariffPlanWithoutFillingInTheRequiredFields() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='+ Add row']"));
        app.getUiboHelper().waitFor(By.cssSelector("p-button[label='Add']"));

        assertFalse(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Add']")));
    }

    @Test
    public void testAddRowInTariffPlanWithNegativeValuesInAmountAndFeePercentFields() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFeeTariffPlanAndSelectRuleFilterInTheTable("United Kingdom - standard", "Fee for cashload");
        app.getUiboHelper().fillTheFieldsForAddRowInTariffPlan("Fee for cashload", "-1", "PLN", "PLN", "-1", "-1", "-1");

        assertFalse(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Add']")));
        app.getUiboHelper().verifyAmountOfTheSameElements(By.xpath("//*[contains(text(), 'This value should be more than 0')]"), 4);
    }
}