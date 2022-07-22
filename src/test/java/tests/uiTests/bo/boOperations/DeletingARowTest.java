package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

public class DeletingARowTest extends UITestBase {

    @Test
    public void testDeletingARown() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        selectFromDropDown("name", "United Kingdom - standard");
        Thread.sleep(1000);
        selectDropDownFilter("ruleName", "Apple Pay bonus");

        addRow("Apple Pay bonus", "feePercent", "GBP", "GBP", "0", "0", "0");

        deleteRow(1);
    }
}