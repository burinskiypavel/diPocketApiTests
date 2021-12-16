package tests.uiTests.bo;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginBOUserRolesBOTest extends UITestBase {

    @Test
    public void testLoginBOUserRolesBO() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole("Evgenya", "7RTwTUP");

        assertFalse(!isElementPresent(By.xpath("//p[contains(text(), 'Search')]")));
        assertFalse(!isElementPresent(By.xpath("//p[contains(text(), 'Take Ticket')]")));
    }
}
