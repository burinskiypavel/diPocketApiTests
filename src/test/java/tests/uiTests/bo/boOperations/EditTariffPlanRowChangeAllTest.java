package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

public class EditTariffPlanRowChangeAllTest extends UITestBase {


    @Test
    public void testEditTariffPlanRowChangeAll() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        selectFromDropDown("name", "United Kingdom - standard");
        Thread.sleep(1000);
        selectDropDownFilter("ruleName", "Apple Pay bonus");
    }
}
