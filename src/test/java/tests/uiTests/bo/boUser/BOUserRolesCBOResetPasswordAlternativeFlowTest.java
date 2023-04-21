package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class BOUserRolesCBOResetPasswordAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOResetPasswordAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoAllUsersTab();
        app.getUiboUserHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        app.getUiboUserHelper().pressResetPassword();
        app.getUiboHelper().closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));

        assertFalse(app.getUiboHelper().isElementPresent(By.cssSelector("div[role='dialog']")));
    }
}