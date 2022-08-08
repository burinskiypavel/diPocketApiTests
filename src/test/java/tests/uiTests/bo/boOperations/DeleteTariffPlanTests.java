package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DeleteTariffPlanTests extends UITestBase {
    String id = "111222333";
    String name = "Auto_tarif_plan_for_deletion";

    @Test
    public void testDeleteTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getDbHelper().deleteFeeTariffPlanDB(id, name);
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().addTarifPlan(id, name);
        app.getUiboHelper().selectFromDropDown("name", name);
        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//div[contains(text(), 'Tariff plan added successfully')]"));
        app.getUiboHelper().deleteTarifPlan(name);

        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Tariff plan deleted successfully')]"));
    }

    @Test
    public void TheUserChangedHisMindAboutDeleteTariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown("name", "QA_autotest_name_1");
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Delete tariff plan']"));
        app.getUiboHelper().closePopUp(By.cssSelector("div.p-dialog-header-icons"));

        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
    }
}