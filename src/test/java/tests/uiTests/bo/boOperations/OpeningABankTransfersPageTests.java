package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpeningABankTransfersPageTests extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testOpeningABankTransfersPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoBankTransfersTab();

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//table //th[contains(text(), 'Tran id')]",
                "//table //th[contains(text(), 'State')]", "//table //th[contains(text(), 'Payer id')]",
                "//table //th[contains(text(), 'Payer')]", "//table //th[contains(text(), 'Older date')]"}), "Incorrect headers");

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//p-columnfilter[@field='tranId']", "//p-columnfilter[@field='stateName']",
                "//p-columnfilter[@field='payerId']", "//p-columnfilter[@field='payer']"}), "Incorrect filters");

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled(By.xpath("//p-button[@label='Search']")), "Search button is not present");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//p-button[@label='Check operation'][@ng-reflect-disabled='true']")), "Button Check operation is not disabled");
        softAssert.assertAll();
    }
}