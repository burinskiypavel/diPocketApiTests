package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabTransactionsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTabTransactionsTest() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToTransactionTab();

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'TranItemId')]", "//thead //th[contains(text(), 'Account name')]",
                "//thead //th[contains(text(), 'Type name')]", "//thead //th[contains(text(), 'Amount')]",
                "//thead //th[contains(text(), 'Currency')]", "//thead //th[contains(text(), 'Receiver')]",
                "//thead //th[contains(text(), 'Event date')]", "//thead //th[contains(text(), 'State')]",
                "//thead //th[contains(text(), 'Fee Amount')]"}));
    }

    @Test
    public void testRolesBOUserClientPageTabTransactionsDetailsTest() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToTransactionTab();
        app.getUiboClientHelper().searchByTransactionTab("All");

        app.getUiboHelper().waitFor(By.cssSelector("td span[ng-reflect-text='629314']"));
        app.getUiboHelper().performContextClick(By.cssSelector("td span[ng-reflect-text='629314']"));

        app.getUiboHelper().waitFor(By.xpath("//li //span[contains(text(), 'Details')]"));
        app.getUiboHelper().click(By.xpath("//li //span[contains(text(), 'Details')]"));
        app.getUiboHelper().waitFor(By.xpath("//td[contains(text(), 'Account name:')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//td[contains(text(), 'Account name:')]", "//td[contains(text(), 'Account amount:')]",
                "//td[contains(text(), 'Account currency:')]", "//td[contains(text(), 'Type:')]",
                "//td[contains(text(), 'State')]"}));
    }
}