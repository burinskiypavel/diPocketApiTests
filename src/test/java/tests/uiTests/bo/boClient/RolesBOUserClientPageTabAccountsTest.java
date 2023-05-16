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

        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-accounts p-columnfilter[ng-reflect-field='accountName'] input"), "Bbh", "accountName", By.cssSelector("td span[ng-reflect-text='Bbh']"));
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='accStateNameExt']"), "Active");
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='ccyCode']"), "EUR", "GBR");

        app.getUiboHelper().performContextClick(By.cssSelector("td span[ng-reflect-text='Bbh']"));
        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//span[contains(text(), 'Block account')]", "//span[contains(text(), 'Account limits')]", "//span[contains(text(), 'Overdraft limit')]"}));
    }
}