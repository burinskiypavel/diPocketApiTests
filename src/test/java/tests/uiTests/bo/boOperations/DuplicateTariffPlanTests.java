package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DuplicateTariffPlanTests extends UITestBase {
    String id = "1436137";
    String name = "QA_autotest_name";

    @Test
    public void testDuplicateTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(id, name);
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        duplicateTarifPlan(id, name);

        waitFor(By.xpath("//*[contains(text(), 'Tariff plan duplicated successfully')]"));
    }

    @Test
    public void testTheUserChangedHisMindAboutDuplicatingTheTariff() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        click(By.xpath("//p-button[@ng-reflect-label='Duplicate tariff plan']"));
        closePopUp(By.cssSelector("div.p-dialog-header-icons"));;

        waitForInvisibilityOfElement(By.xpath("//*[@app-add-tariff-plan-modal]"));
    }
}