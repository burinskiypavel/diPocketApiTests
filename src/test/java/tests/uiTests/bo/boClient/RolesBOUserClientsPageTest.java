package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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

        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        assertFalse(!isElementPresent(By.cssSelector("td[ng-reflect-text='380634413376']")));
        assertFalse(!isElementPresent(By.cssSelector("td[ng-reflect-text='vikarez20@gmail.com']")));

        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));


        String actualUsername = getText(By.cssSelector("p.user-name"));
        String actualEmail = getText(By.cssSelector("p.email"));


        String actualState = getText(By.xpath("//*[contains(text(), 'State:')]"));
        String actualSite = getText(By.xpath("//*[contains(text(), 'Site:')]"));

        String actualRisk = getText(By.xpath("//*[contains(text(), 'Risk')]"));
        String actualRegistryAdd = getText(By.xpath("//*[contains(text(), 'Registry add:')]"));
        String actualMailingAdd = getText(By.xpath("//*[contains(text(), 'Mailing add:')]"));

        assertFalse(!areElementsPresent(new String[]{
                "//*[contains(text(), '06.10.1976 (45)')]", "//*[contains(text(), '380634413376')]", "//*[contains(text(), '33217')]",
                "//*[contains(text(), 'FDD')]", "//*[contains(text(), 'EUR - standart')]", "//*[contains(text(), 'EUR')]",
                "//*[contains(text(), 'English')]",}));

        assertEquals(actualUsername, "Nona Qwerty");
        assertEquals(actualEmail, "vikarez20@gmail.com (verified)");
        assertEquals(actualState, "State: Active");
        assertEquals(actualSite, "Site: DIPOCKET");
        assertEquals(actualRisk, "Risk: 3");
        assertEquals(actualRegistryAdd, "Registry add: Address44, City, UA");
        assertEquals(actualMailingAdd, "Mailing add: Address, City, PL");
    }
}
