package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BOUserRolesCBOUnblockUserAlternativeFlowTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testBOUserRolesCBOUnblockUserAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboHelper().gotoAllUsersTab();
        app.getUiboHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        if(app.getUiboHelper().isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']"))){
            app.getUiboHelper().unblockUser();
            app.getUiboHelper().selectBOUser("PAVELB");
        }

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled2(By.cssSelector("p-button[ng-reflect-label='Edit']")));
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Reset password']")));
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Block user']")));

        app.getUiboHelper().blockUser("test");

        app.getUiboHelper().selectBOUser("PAVELB");
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']")));
        softAssert.assertFalse(app.getUiboHelper().isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Block user']")));

        app.getUiboHelper().click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Unblock user']"));
        app.getUiboHelper().waitFor(By.cssSelector("div[role='dialog']"));
        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Are you sure want to unblock user')]"));

        app.getUiboHelper().closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
        softAssert.assertFalse(app.getUiboHelper().isElementPresent(By.cssSelector("div[role='dialog']")));

        if(app.getUiboHelper().isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']"))){
            app.getUiboHelper().unblockUser();
        }
        softAssert.assertAll();
    }
}