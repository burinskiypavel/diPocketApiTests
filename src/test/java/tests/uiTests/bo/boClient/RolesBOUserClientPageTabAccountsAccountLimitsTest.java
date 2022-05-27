package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabAccountsAccountLimitsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTabAccountsAccountLimits() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToAccountsTab();
        performContextClick(By.cssSelector("td[ng-reflect-text='Bbh']"));
        click(By.xpath("//span[contains(text(), 'Account limits')]"));
        assertTrue(areElementsPresent(new String[]{"//th[contains(text(), 'Name')]", "//th[contains(text(), 'Type')]", "//th[contains(text(), 'Currency')]", "//th[contains(text(), 'Max amount')]", "//th[contains(text(), 'Limit amount')]"}));
    }
}