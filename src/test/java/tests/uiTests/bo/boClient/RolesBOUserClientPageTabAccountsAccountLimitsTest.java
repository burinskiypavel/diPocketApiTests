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
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='Bbh']"));
        app.getUiboHelper().click(By.xpath("//span[contains(text(), 'Account limits')]"));
        app.getUiboHelper().waitFor(By.xpath("//th[contains(text(), 'Max amount')]"));
        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//th[contains(text(), 'Name')]", "//th[contains(text(), 'Type')]", "//th[contains(text(), 'Currency')]", "//th[contains(text(), 'Max amount')]", "//th[contains(text(), 'Limit amount')]"}));
    }
}