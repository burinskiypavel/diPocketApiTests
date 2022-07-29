package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class BOUserRolesCBOBlockUserAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOBlockUserAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboHelper().gotoAllUsersTab();
        app.getUiboHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        app.getUiboHelper().click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Block user']"));

        app.getUiboHelper().waitFor(By.cssSelector("div[role='dialog']"));
        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));
        app.getUiboHelper().closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));

        assertFalse(app.getUiboHelper().isElementPresent(By.cssSelector("div[role='dialog']")));
    }
}