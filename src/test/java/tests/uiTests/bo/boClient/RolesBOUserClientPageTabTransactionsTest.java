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
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToTransactionTab();
        waitFor(By.xpath("//thead //th[contains(text(), 'TranItemId')]"));

        assertTrue(areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'TranItemId')]", "//thead //th[contains(text(), 'Account name')]",
                "//thead //th[contains(text(), 'Type name')]", "//thead //th[contains(text(), 'Amount')]",
                "//thead //th[contains(text(), 'Currency')]", "//thead //th[contains(text(), 'Receiver')]",
                "//thead //th[contains(text(), 'Event date')]", "//thead //th[contains(text(), 'State')]",
                "//thead //th[contains(text(), 'Fee Amount')]"}));
    }

    @Test
    public void testRolesBOUserClientPageTabTransactionsDetailsTest() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToTransactionTab();
        waitFor(By.xpath("//thead //th[contains(text(), 'TranItemId')]"));

        click(By.cssSelector("p-dropdown[optionlabel='value']"));
        click(By.cssSelector("li[aria-label='All']"));

        click(By.cssSelector("app-button[label='Search']"));

        waitFor(By.cssSelector("td[ng-reflect-text='629314']"));
        performContextClick(By.cssSelector("td[ng-reflect-text='629314']"));

        click(By.xpath("//li //span[contains(text(), 'Details')]"));

        assertTrue(areElementsPresent(new String[]{
                "//td[contains(text(), 'Account name:')]", "//td[contains(text(), 'Account amount:')]",
                "//td[contains(text(), 'Account currency:')]", "//td[contains(text(), 'Type:')]",
                "//td[contains(text(), 'State')]"}));
    }
}