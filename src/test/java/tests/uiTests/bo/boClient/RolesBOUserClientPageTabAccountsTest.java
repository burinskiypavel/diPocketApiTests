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
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToAccountsTab();

        setClientPageFilter("accountName", "Bbh");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Bbh']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Hhh']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='accountName'] input[type='text']"));

        setDropDownClientPageFilter("stateName", "Active");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Active']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Frozen']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        setDropDownClientPageFilter("ccyCode", "EUR");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='EUR']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='GBR']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        performContextClick(By.cssSelector("td[ng-reflect-text='Bbh']"));
        assertTrue(areElementsPresent(new String[]{"//span[contains(text(), 'Block account')]", "//span[contains(text(), 'Account limits')]", "//span[contains(text(), 'Overdraft limit')]"}));
    }
}