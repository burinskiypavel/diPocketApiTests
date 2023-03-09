package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditTariffPlanRowChangeAllTest extends UITestBase {

    @Test
    public void testEditTariffPlanRowChangeAll() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboOperationsHelper().selectFeeTariffPlanAndSelectRuleFilterInTheTable("2 United Kingdom - standard", "50 Fee for cashload");

        app.getUiboOperationsHelper().addRowInTariffPlan("50 Fee for cashload", "0", "GBP", "GBP", "0", "0", "0");

        app.getUiboOperationsHelper().pressPencilEditButton(0);

        app.getUiboOperationsHelper().editTariffPlanRow("190 Fee for Face to Face", "EUR", "1", "EUR", "2", "1", "1");

        app.getUiboOperationsHelper().deleteRow(0);
    }
}