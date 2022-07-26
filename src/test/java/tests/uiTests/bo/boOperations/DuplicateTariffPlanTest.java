package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DuplicateTariffPlanTest extends UITestBase {
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
}