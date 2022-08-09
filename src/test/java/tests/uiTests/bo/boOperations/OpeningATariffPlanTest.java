package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class OpeningATariffPlanTest extends UITestBase {

    @Test
    public void testOpeningATariffPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown("name", "United Kingdom - standard");
        Thread.sleep(1000);
        List<String> actualElementsText = app.getUiboHelper().getActualText2(By.xpath("//table //tbody //tr"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile2("files/bo/boOperations/openingATariffPlan.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }
}