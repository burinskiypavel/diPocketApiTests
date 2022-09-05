package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOResetPasswordAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOResetPasswordAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoAllUsersTab();
        app.getUiboUserHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        app.getUiboHelper().click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Reset password']"));
        app.getUiboHelper().waitFor(By.cssSelector("div[role='dialog']"));
        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Are you sure want to reset password and send new one?')]"));
        app.getUiboHelper().closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));

        assertFalse(app.getUiboHelper().isElementPresent(By.cssSelector("div[role='dialog']")));
    }
}