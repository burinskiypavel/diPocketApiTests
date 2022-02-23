package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientspageTabAccountsAccountLimitsTest extends UITestBase {

    @Test
    public void testRolesBOUserClientspageTabAccounts() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));
        click(By.id("p-tabpanel-8-label"));
        performContextClick(By.cssSelector("td[ng-reflect-text='Bbh']"));
        click(By.xpath("//span[contains(text(), 'Account limits')]"));
        assertTrue(areElementsPresent(new String[]{"//th[contains(text(), 'Name')]", "//th[contains(text(), 'Type')]", "//th[contains(text(), 'Currency')]", "//th[contains(text(), 'Max amount')]", "//th[contains(text(), 'Limit amount')]"}));
    }
}