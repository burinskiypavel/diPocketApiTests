package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOVerifyActiveUsersTableIsDefaultOptionTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOVerifyActiveUsersTableIsDefaultOption() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        app.getUiboHelper().gotoBOUsersPage();

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//span[contains(text(), 'Active users')]")));
        assertTrue(app.getUiboHelper().isDefault(By.xpath("//a[@id='p-tabpanel-0-label'][@aria-selected='true']")));
        assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("table")));
    }
}