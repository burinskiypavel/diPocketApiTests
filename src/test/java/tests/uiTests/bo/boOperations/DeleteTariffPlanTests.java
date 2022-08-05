package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteTariffPlanTests extends UITestBase {
    String id = "111222333";
    String name = "Auto_tarif_plan_for_deletion";

    @Test
    public void testDeleteTariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().addTarifPlan(id, name);
        app.getUiboHelper().selectFromDropDown("name", name);
        app.getUiboHelper().deleteTarifPlan(name);

        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Tariff plan deleted successfully')]"));
    }
}