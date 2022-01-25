package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class BOUserRolesCBOBlockUserAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOBlockUserAlternativeFlow() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoAllUsersTab();
        searchAndSelectBOUser("All users", "username", "PAVELB");
        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Block user']"));

        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));
        closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));

        assertFalse(isElementPresent(By.cssSelector("div[role='dialog']")));
    }
}