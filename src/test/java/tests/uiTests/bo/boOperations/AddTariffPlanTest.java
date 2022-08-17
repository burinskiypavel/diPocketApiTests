package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AddTariffPlanTest extends UITestBase {
    String id = "14361371";
    String name = "QA_autotest_name";

    @Test
    public void testAddTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(id, name);
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboOperationsHelper().addTarifPlan(id, name);

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Tariff plan added successfully')]"));
    }

    @Test
    public void testTheUserChangedHisMindAboutAddRariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Add tariff plan']"));
        app.getUiboHelper().closePopUp(By.cssSelector("div.p-dialog-header-icons"));

        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//*[@app-add-tariff-plan-modal]"));
    }
}