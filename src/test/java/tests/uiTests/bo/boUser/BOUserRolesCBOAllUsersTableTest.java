package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAllUsersTableTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOAllUsersTable() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoAllUsersTab();

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//a[@id='p-tabpanel-1-label'][@aria-selected='true']")));
        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//div[@id='p-tabpanel-1'][@aria-hidden='false']")));
        assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("table")));
    }
}