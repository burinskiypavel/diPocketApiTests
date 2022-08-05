package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DuplicateTariffPlanTests extends UITestBase {
    String id = "1436137";
    String name = "QA_autotest_name_1";

    @Test
    public void testDuplicateTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(id, name);
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().duplicateTarifPlan(id, name);

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Tariff plan duplicated successfully')]"));
    }

    @Test
    public void testTheUserChangedHisMindAboutDuplicatingTheTariff() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Duplicate tariff plan']"));
        app.getUiboHelper().closePopUp(By.cssSelector("div.p-dialog-header-icons"));;

        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//*[@app-add-tariff-plan-modal]"));
    }
}