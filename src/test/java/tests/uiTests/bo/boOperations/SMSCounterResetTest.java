package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SMSCounterResetTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testSMSCounterReset() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoResetSMSCounterTab();
        app.getUiboHelper().click(By.xpath("//button[@label='Reset']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'SMS counter was successfully reset')]"));

        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//p-columnfilter[@ng-reflect-field='phone']")), "phone field filter");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//p-columnfilter[@field='site']")), "site");
        softAssert.assertAll();
    }
}