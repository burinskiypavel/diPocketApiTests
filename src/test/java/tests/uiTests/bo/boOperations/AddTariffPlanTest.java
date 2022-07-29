package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AddTariffPlanTest extends UITestBase {
    String id = "123456789";
    String name = "QA_autotest_name";

    @Test
    public void testAddTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(id, name);
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        addTarifPlan(id, name);

        waitFor(By.xpath("//*[contains(text(), 'Tariff plan added successfully')]"));
    }

    @Test
    public void testTheUserChangedHisMindAboutAddRariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        click(By.xpath("//p-button[@ng-reflect-label='Add tariff plan']"));
        closePopUp(By.cssSelector("div.p-dialog-header-icons"));

        waitForInvisibilityOfElement(By.xpath("//*[@app-add-tariff-plan-modal]"));
    }
}