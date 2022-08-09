package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditTariffPlanRowChangeAllTest extends UITestBase {

    @Test
    public void testEditTariffPlanRowChangeAll() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFeeTariffPlanAndSelectRuleFilterInTheTable("United Kingdom - standard", "Fee for cashload");

        app.getUiboHelper().addRowInTariffPlan("Fee for cashload", "0", "GBP", "GBP", "0", "0", "0");

        app.getUiboHelper().pressPencilEditButton(0);

        app.getUiboHelper().editTariffPlanRow("Fee for Face to Face", "EUR", "1", "EUR", "2", "1", "1");

        app.getUiboHelper().deleteRow(0);
    }
}