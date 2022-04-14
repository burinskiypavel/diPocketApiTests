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
}