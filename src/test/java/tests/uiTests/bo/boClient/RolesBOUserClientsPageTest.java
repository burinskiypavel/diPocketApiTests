package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RolesBOUserClientsPageTest extends UITestBase {

    @Test()
    public void testRolesBOUserClientsPage() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Client')]")));
        assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Card')]")));
        assertTrue(isDefault2(By.id("p-tabpanel-0-label")));
        assertFalse(!isElementPresent(By.xpath("//app-input-number[@ng-reflect-name='id']")));
        assertFalse(!isElementPresent(By.xpath("//app-input[@ng-reflect-name='email']")));
        assertFalse(!isElementPresent(By.xpath("//app-input[@ng-reflect-name='mainPhone']")));
        assertFalse(!isElementPresent(By.xpath("//app-input[@ng-reflect-name='firstName']")));
        assertFalse(!isElementPresent(By.xpath("//app-input[@ng-reflect-name='lastName']")));
        assertFalse(isElementPresent(By.xpath("//span[@class='p-calendar-w-btn']")));
        assertFalse(!isElementPresent(By.xpath("//app-input[@ng-reflect-name='mailingAddress']")));
        assertFalse(!isElementPresent(By.xpath("//app-input[@ng-reflect-name='companyName']")));
    }
}
