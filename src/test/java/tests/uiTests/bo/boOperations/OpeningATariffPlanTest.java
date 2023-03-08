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
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown(By.xpath("//p-dropdown[@ng-reflect-option-label='name']"), By.cssSelector("p-dropdownitem[ng-reflect-label='2 United Kingdom - standard']"));
        Thread.sleep(1000);
        List<String> actualElementsText = app.getUiboHelper().getActualText2(By.xpath("//table //tbody //tr"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile2("files/bo/boOperations/openingATariffPlan.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }
}