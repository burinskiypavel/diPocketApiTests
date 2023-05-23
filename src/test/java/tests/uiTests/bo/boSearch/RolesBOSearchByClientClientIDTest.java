package tests.uiTests.bo.boSearch;

import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOSearchByClientClientIDTest extends UITestBase {
    String phone = "380634413376";
    String id = "33217";
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOSearchByClientClientID() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();

        softAssert.assertTrue(app.getUiboHelper().isTabPresent(By.xpath("//a[@role='tab'] //span[contains(text(), 'Client')]")), "Is tab present");
        softAssert.assertTrue(app.getUiboHelper().isTabPresent(By.xpath("//a[@role='tab'] //span[contains(text(), 'Card')]")), "Is tab present");

        softAssert.assertTrue(app.getUiboHelper().isTabActiveAndSelected(By.xpath("//a[@id='p-tabpanel-0-label'][@aria-selected='true']")), "Is tab Client active and selected");

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//app-search-clients //input[contains(@id, 'input_id')]", "//app-search-clients //input[contains(@id, 'input_email')]", "//app-search-clients //input[contains(@id, 'input_mainPhone')]",
                "//app-search-clients //input[contains(@id, 'input_firstName')]", "//app-search-clients //input[contains(@id, 'input_lastName')]", "//app-search-clients //input[contains(@id, 'input_mailingAddress')]",
                "//app-search-clients //input[contains(@id, 'icon')]"}), "Are following options(fields) available");

        app.getUiboHelper().search("id", id);

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//td //span[@ng-reflect-text='"+phone+"']", "//td //span[@ng-reflect-text='"+ Site.DIPOCKET.toString()+"']"}), "Are search results displays");
        softAssert.assertAll();
    }
}