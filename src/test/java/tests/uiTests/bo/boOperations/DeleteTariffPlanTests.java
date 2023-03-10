package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DeleteTariffPlanTests extends UITestBase {
    String id = "111222333";
    String name = "Auto_tarif_plan_for_deletion";

    @Test
    public void testDeleteTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(id, name);
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboOperationsHelper().addTarifPlan(id, name);
        app.getUiboHelper().selectFromDropDown(By.xpath("//p-dropdown[@ng-reflect-option-label='name']"), By.cssSelector("p-dropdownitem li[aria-label*='"+name+"']"));
        app.getUiboOperationsHelper().deleteTarifPlan(name);

        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Tariff plan deleted successfully')]"));
    }

    @Test
    public void testTheUserChangedHisMindAboutDeleteTariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown(By.xpath("//p-dropdown[@ng-reflect-option-label='name']"), By.cssSelector("p-dropdownitem li[aria-label*='QA_autotest_name_1']"));

        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Delete tariff plan']"));
        app.getUiboHelper().closePopUp(By.cssSelector("div.p-dialog-header-icons"));

        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
    }
}