package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class LimitPlanPageTests extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testOpeningALimitPlanPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoLimitPlanTab();

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//h5[contains(text(), 'Limit plan')]",
                "//h5[contains(text(), 'Limit level')]", "//h5[contains(text(), 'Base currency')]"}), "Text Verifications");

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//th[contains(text(), 'Row #')]",
                "//th[contains(text(), 'Group')]", "//th[contains(text(), 'Type')]", "//th[contains(text(), 'Amount')]"}), "Columns verifications");

        softAssert.assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//p-button[@ng-reflect-label='Add limit plan']", "//p-button[@ng-reflect-label='Duplicate limit plan']",
                "//p-button[@ng-reflect-label='Rename limit plan']", "//p-button[@ng-reflect-label='Delete limit plan']", "//p-button[@ng-reflect-label='+ Add row']"}), "Buttons verifications");
        softAssert.assertAll();
    }


    @Test
    public void testOpeningALimitPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoLimitPlanTab();

        app.getUiboHelper().selectFromDropDown(By.xpath("//div[@class='dropdowns'] //p-dropdown[@optionlabel='name']"), "Getsby");
        app.getUiboHelper().selectFromDropDown(By.xpath("//div[@class='dropdowns'] //p-dropdown[@optionlabel='label']"), "FDD");
        app.getUiboHelper().selectFromDropDown(By.xpath("//div[@class='dropdowns'] //p-dropdown[@optionlabel='code']"), "EUR");
        Thread.sleep(1000);
        List<String> actualElementsText = app.getUiboHelper().getActualText2(By.xpath("//app-limit-plan-tab //table //tbody //tr"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile2("files/bo/boOperations/openingALimitPlan.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test
    public void testAddingARowToTheLimitPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoLimitPlanTab();
        app.getUiboHelper().addRowInLimitPlan("100", "Face to Face (Out)", "Max Daily");

        app.getUiboHelper().deleteRow(By.xpath("//app-limit-plan-tab //button[@ng-reflect-icon='pi pi-trash']"), 0);
    }

    @Test
    public void testTheUserChangedHisMindAboutAddingARowToTheLimitPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoLimitPlanTab();
        app.getUiboHelper().click(By.xpath("//app-limit-plan-tab //p-button[@ng-reflect-label='+ Add row']"));
        app.getUiboHelper().closePopUp(By.cssSelector("div.p-dialog-header-icons"));

        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//*[@app-add-limit-plan-modal]"));
    }

    @Test
    public void testEditRowInLimitPlan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoLimitPlanTab();

        app.getUiboHelper().selectFromDropDown(By.xpath("//div[@class='dropdowns'] //p-dropdown[@optionlabel='name']"), "Unlimited");

        app.getUiboHelper().addRowInLimitPlan("150", "Face to Face (Out)", "Max Daily");

        app.getUiboHelper().pressPencilEditButton(By.xpath("//app-limit-plan-tab //button[@icon='pi pi-pencil']"));

        app.getUiboHelper().editLimitPlanRow("All transactions (In)", "Max Monthly", "12");

        app.getUiboHelper().deleteRow(By.xpath("//app-limit-plan-tab //button[@ng-reflect-icon='pi pi-trash']"), 0);
    }
}