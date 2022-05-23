package tests.uiTests.bo.boSearch;

import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOSearchByClientClientIDTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOSearchByClientClientID() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();

        softAssert.assertTrue(isTabPresent(By.xpath("//a[@role='tab'] //span[contains(text(), 'Client')]")), "Is tab present");
        softAssert.assertTrue(isTabPresent(By.xpath("//a[@role='tab'] //span[contains(text(), 'Card')]")), "Is tab present");

        softAssert.assertTrue(isTabActiveAndSelected(By.xpath("//a[@id='p-tabpanel-0-label'][@aria-selected='true']")), "Is tab Client active and selected");

        softAssert.assertTrue(areElementsPresent(new String[]{"//app-input-number[@ng-reflect-name='id']", "//app-input[@ng-reflect-name='email']", "//app-input[@ng-reflect-name='mainPhone']",
                "//app-input[@ng-reflect-name='firstName']", "//app-input[@ng-reflect-name='lastName']", "//app-input[@ng-reflect-name='mailingAddress']",
                "//app-calendar[@ng-reflect-name='birthDate']"}), "Are following options(fields) available");

        search("id", "33217");

        softAssert.assertTrue(areElementsPresent(new String[]{"//td[@ng-reflect-text='380634413376']", "//td[@ng-reflect-text='"+ Site.DIPOCKET.toString()+"']"}), "Are search results displays");
        softAssert.assertAll();
    }
}