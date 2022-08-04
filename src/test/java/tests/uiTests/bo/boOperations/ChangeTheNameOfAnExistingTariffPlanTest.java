package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class ChangeTheNameOfAnExistingTariffPlanTest extends UITestBase {
    String randomNumber = app.generateRandomNumber(4);

    @Test
    public void testChangeTheNameOfAnExistingTariffPlan() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("randomNumber: " + randomNumber);
        String feeTariffPlanName = app.getDbHelper().getFeeTariffPlanFromDB("123456789");
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown("name", feeTariffPlanName);

        app.getUiboHelper().renameTariffPlan("QA_autotest_name_" + randomNumber);
    }
}