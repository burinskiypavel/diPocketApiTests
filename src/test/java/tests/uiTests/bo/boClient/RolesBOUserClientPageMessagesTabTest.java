package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientPageMessagesTabTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String phone = "380634413376";

    @Test
    public void testRolesBOUserClientPageMessagesTab() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToMessagesTab();

        softAssert.assertTrue(areElementsPresent(new String[]{"//table //th[contains(text(), 'Chanel')]",
                "//table //th[contains(text(), 'Created')]", "//table //th[contains(text(), 'Send')]",
        "//table //th[contains(text(), 'Messages')]", "//table //th[contains(text(), 'Error message')]"}));

        waitFor(By.cssSelector("td[ng-reflect-text='S']"));
        click(By.cssSelector("p-dropdown[placeholder='All']"));
        waitForElementToBeClickable(By.cssSelector("li[aria-label='S']"));
        click(By.cssSelector("li[aria-label='S']"));

        softAssert.assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='S']")));
        softAssert.assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='P']")));
        softAssert.assertAll();
    }
}