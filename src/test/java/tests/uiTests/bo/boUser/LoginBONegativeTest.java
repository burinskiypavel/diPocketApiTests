package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginBONegativeTest extends UITestBase {

    @Test(enabled = false)
    public void testLoginBONegative() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole("Evgenya", "123456");

        //assertFalse(!isElementPresent(By.xpath("//p[contains(text(), 'Search')]")));
        //assertFalse(!isElementPresent(By.xpath("//p[contains(text(), 'Take Ticket')]")));
    }
}
