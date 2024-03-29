package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageMessagesTabTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String phone = "380634413376";

    @Test
    public void testRolesBOUserClientPageMessagesTab() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", "33217", phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToMessagesTab();

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//table //th[contains(text(), 'Chanel')]",
                "//table //th[contains(text(), 'Created')]", "//table //th[contains(text(), 'Send')]",
        "//table //th[contains(text(), 'Messages')]", "//table //th[contains(text(), 'Error message')]"}), "Incorrect headers");

        app.getUiboHelper().waitFor(By.xpath("//td //span[@ng-reflect-text='P']"));
        //app.getUiboClientHelper().setDropDownClientPageFilter("channel", "S");
        app.getUiboClientHelper().setDropDownClientPageFilter_messageTab("S");

        softAssert.assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td //span[contains(text(), 'S')]")), "Incorrect channel filter");
        //softAssert.assertFalse(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'P')]")), "Incorrect channel filter");
        app.getUiboClientHelper().clearFilter(By.cssSelector("timesicon[ng-reflect-style-class='p-dropdown-clear-icon'] svg"));

        //app.getUiboClientHelper().setClientPageFilter("message", "Password change code: 839429 (#3)");
        app.getUiboClientHelper().setClientPageFilter_messageTab("message", "Password change code: 839429 (#3)");

        softAssert.assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td //span[contains(@ng-reflect-text, 'Password change code')]")), "Incorrect message filter");
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("div[id='p-tabpanel-2'] p-columnfilter[ng-reflect-field='message'] input[type='text']"));

        //app.getUiboClientHelper().setClientPageFilter_messageTab("errMsg", "java");
        //softAssert.assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td //span[contains(@ng-reflect-text, 'java.sql.SQLException')]")), "Incorrect error message filter");
        //app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("p-columnfilter[ng-reflect-field='errMsg'] input[type='text']"));

        softAssert.assertAll();
    }
}