package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

public class OpeningATariffPlanTest extends UITestBase {

    @Test
    public void testOpeningATariffPlan() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        selectFromDropDown("name", "United Kingdom - standard");
    }
}
