package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginBOUserRolesBOTest extends UITestBase {

    @Test
    public void testLoginBOUserRolesBO() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        assertFalse(!isElementPresent(By.xpath("//p[contains(text(), 'Search')]")));
        assertFalse(!isElementPresent(By.xpath("//p[contains(text(), 'Take Ticket')]")));
    }
}