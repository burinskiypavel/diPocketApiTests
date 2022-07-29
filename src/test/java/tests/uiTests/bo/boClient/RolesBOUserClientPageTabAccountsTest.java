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
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();

        app.getUiboHelper().setClientPageFilter("accountName", "Bbh");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Bbh']")));
        assertFalse(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Hhh']")));
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='accountName'] input[type='text']"));

        app.getUiboHelper().setDropDownClientPageFilter("stateName", "Active");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Active']")));
        assertFalse(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Frozen']")));
        app.getUiboHelper().clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        app.getUiboHelper().setDropDownClientPageFilter("ccyCode", "EUR");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='EUR']")));
        assertFalse(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='GBR']")));
        app.getUiboHelper().clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='Bbh']"));
        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//span[contains(text(), 'Block account')]", "//span[contains(text(), 'Account limits')]", "//span[contains(text(), 'Overdraft limit')]"}));
    }
}