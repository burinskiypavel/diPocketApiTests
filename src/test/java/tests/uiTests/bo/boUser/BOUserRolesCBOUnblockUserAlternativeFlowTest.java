package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import padeObjects.bo.boUsers.BOUserHomePage;

public class BOUserRolesCBOUnblockUserAlternativeFlowTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testBOUserRolesCBOUnblockUserAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoAllUsersTab();
        app.getUiboUserHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        if(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Unblock user']"))){
            app.getUiboUserHelper().unblockUser();
            app.getUiboUserHelper().selectBOUser("PAVELB");
        }

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled2(By.cssSelector("p-button[ng-reflect-label='Edit']")));
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Reset password']")));
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Block user']")));

        app.getUiboUserHelper().blockUser("test");

        app.getUiboUserHelper().selectBOUser("PAVELB");
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Unblock user']")));
        softAssert.assertFalse(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Block user']")));

        app.getUiboHelper().click(By.cssSelector("div.buttons-wrap p-button[ng-reflect-label='Unblock user']"));
        app.getUiboHelper().waitFor(By.cssSelector("div[role='dialog']"));
        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Are you sure want to unblock user')]"));

        app.getUiboHelper().closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
        softAssert.assertFalse(app.getUiboHelper().isElementPresent(By.cssSelector("div[role='dialog']")));

        if(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Unblock user']"))){
            app.getUiboUserHelper().unblockUser();
        }
        softAssert.assertAll();
    }
}