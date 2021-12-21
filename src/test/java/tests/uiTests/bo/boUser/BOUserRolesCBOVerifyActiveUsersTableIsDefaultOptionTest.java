package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOVerifyActiveUsersTableIsDefaultOptionTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOVerifyActiveUsersTableIsDefaultOption() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        click(By.xpath("//p[contains(text(), 'BO Users')]"));

        assertTrue(isElementPresent(By.xpath("//span[contains(text(), 'Active users')]")));
        assertTrue(isDefault(By.xpath("//a[@id='p-tabpanel-0-label'][@aria-selected='true']")));
        assertTrue(isElementPresent(By.cssSelector("table")));
    }
}