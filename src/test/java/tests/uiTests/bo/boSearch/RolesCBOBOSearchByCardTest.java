package tests.uiTests.bo.boSearch;

import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesCBOBOSearchByCardTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOSearchByClientClientID() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        softAssert.assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Client')]")));
        softAssert.assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Card')]")));
        click(By.id("p-tabpanel-1-label"));

        softAssert.assertFalse(!areElementsPresent(new String[]{
                "//app-input-number[@ng-reflect-name='id']", "//app-input[@ng-reflect-name='publicToken']",
                "//app-input[@ng-reflect-name='dipToken']", "//app-input[@ng-reflect-name='pan']",
                "//app-input-number[@ng-reflect-name='clientId']", "//app-input[@ng-reflect-name='cardholderName']",}));

        softAssert.assertAll();
    }

    @Test
    public void testRolesCBOSearchByClientClientID() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoSearchPage();
        softAssert.assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Client')]")));
        softAssert.assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Card')]")));
        click(By.id("p-tabpanel-1-label"));

        softAssert.assertFalse(!areElementsPresent(new String[]{
                "//app-input-number[@ng-reflect-name='id']", "//app-input[@ng-reflect-name='publicToken']",
                "//app-input[@ng-reflect-name='dipToken']", "//app-input[@ng-reflect-name='pan']",
                "//app-input-number[@ng-reflect-name='clientId']", "//app-input[@ng-reflect-name='cardholderName']",}));

        softAssert.assertAll();
    }
}