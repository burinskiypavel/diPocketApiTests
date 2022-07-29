package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginBOUserRolesBOTest extends UITestBase {

    @Test
    public void testLoginBOUserRolesBO() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//p[contains(text(), 'Search')]")));
        assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//p[contains(text(), 'Take Ticket')]")));
    }
}