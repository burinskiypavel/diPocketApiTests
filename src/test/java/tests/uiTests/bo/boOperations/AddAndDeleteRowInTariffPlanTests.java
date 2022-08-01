package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddAndDeleteRowInTariffPlanTests extends UITestBase {

    @Test
    public void testAddAndDeleteARowInTariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown("name", "United Kingdom - standard");
        Thread.sleep(1000);
        app.getUiboHelper().selectDropDownFilter("ruleName", "Fee for cashload");

        app.getUiboHelper().addRow("Fee for cashload", "feePercent", "GBP", "GBP", "0", "0", "0");

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
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Add']"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//small[contains(text(), 'Rule is required')]",
                "//small[contains(text(), 'Fee percent is required')]",
                "//small[contains(text(), 'Currency is required')]",
                "//small[contains(text(), 'Fee currency is required')]",
                "//small[contains(text(), 'Min fee amount is required')]",
                "//small[contains(text(), 'Max fee amount is required')]",
                "//small[contains(text(), 'Currency is required')]",
                "//small[contains(text(), 'Flat fee amount is required')]",}), "Account limits has incorrect headers ");
    }
}