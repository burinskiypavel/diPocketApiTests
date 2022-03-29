package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientPageMessagesTabTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOUserClientPageMessagesTab() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));
        click(By.id("p-tabpanel-3-label"));

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
