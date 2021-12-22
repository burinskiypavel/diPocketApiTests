package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAllUsersTableTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOAllUsersTable() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        click(By.xpath("//p[contains(text(), 'BO Users')]"));
        waitFor(By.id("p-tabpanel-1-label"));
        click(By.id("p-tabpanel-1-label"));

        assertTrue(isElementPresent(By.xpath("//a[@id='p-tabpanel-1-label'][@aria-selected='true']")));
        assertTrue(isElementPresent(By.xpath("//div[@id='p-tabpanel-1'][@aria-hidden='false']")));
        assertTrue(isElementPresent(By.cssSelector("table")));
    }
}