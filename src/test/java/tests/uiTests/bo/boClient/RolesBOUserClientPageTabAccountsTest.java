package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabAccountsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTabAccounts() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();

        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-accounts-tab p-columnfilter[field='accountName'] input[type='text']"), "Bbh", "accountName", By.cssSelector("td[ng-reflect-text='Bbh']"));
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("app-accounts-tab p-columnfilter[ng-reflect-field='stateName'] "), "Active");
        app.getUiboClientHelper().setDropDownClientPageFilter(By.cssSelector("app-accounts-tab p-columnfilter[ng-reflect-field='ccyCode']"), "EUR");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='EUR']")));
        assertFalse(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='GBR']")));
        app.getUiboClientHelper().clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='Bbh']"));
        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//span[contains(text(), 'Block account')]", "//span[contains(text(), 'Account limits')]", "//span[contains(text(), 'Overdraft limit')]"}));
    }
}