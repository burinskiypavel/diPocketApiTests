package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

public class AddAndDeleteRowInTariffPlanTest extends UITestBase {

    @Test
    public void testDeletingARown() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown("name", "United Kingdom - standard");
        Thread.sleep(1000);
        app.getUiboHelper().selectDropDownFilter("ruleName", "Fee for cashload");

        app.getUiboHelper().addRow("Fee for cashload", "feePercent", "GBP", "GBP", "0", "0", "0");

        app.getUiboHelper().deleteRow(1);
    }
}