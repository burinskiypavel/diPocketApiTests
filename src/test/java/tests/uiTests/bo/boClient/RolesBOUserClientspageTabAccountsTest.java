package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RolesBOUserClientspageTabAccountsTest extends UITestBase {

    @Test
    public void testRolesBOUserClientspageTabAccounts() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));
        click(By.id("p-tabpanel-8-label"));
    }
}
