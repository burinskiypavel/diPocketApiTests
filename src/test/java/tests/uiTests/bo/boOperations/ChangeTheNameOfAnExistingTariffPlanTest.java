package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class ChangeTheNameOfAnExistingTariffPlanTest extends UITestBase {
    String randomNumber = app.generateRandomNumber(4);

    @Test
    public void testChangeTheNameOfAnExistingTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("randomNumber: " + randomNumber);
        String feeTariffPlanName = app.getDbHelper().getFeeTariffPlanFromDB("123456789");
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown(By.xpath("//p-dropdown[@ng-reflect-option-label='name']"), By.cssSelector("p-dropdownitem li[aria-label*='"+feeTariffPlanName+"']"));

        app.getUiboOperationsHelper().renameTariffPlan("QA_autotest_name_" + randomNumber);
    }

    @Test
    public void testTheUserChangedHisMindAboutChangeTheNameOfAnExistingTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown("name", "1436137 QA_autotest_name_1");
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Rename tariff plan']"));
        app.getUiboHelper().closePopUp(By.cssSelector("button.p-dialog-header-icon"));

        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
    }
}