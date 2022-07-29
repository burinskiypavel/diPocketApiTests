package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
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
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToMessagesTab();

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//table //th[contains(text(), 'Chanel')]",
                "//table //th[contains(text(), 'Created')]", "//table //th[contains(text(), 'Send')]",
        "//table //th[contains(text(), 'Messages')]", "//table //th[contains(text(), 'Error message')]"}), "Incorrect headers");

        app.getUiboHelper().waitFor(By.cssSelector("td[ng-reflect-text='S']"));
        app.getUiboHelper().setDropDownClientPageFilter("channel", "S");
        softAssert.assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='S']")), "Incorrect channel filter");
        softAssert.assertFalse(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='P']")), "Incorrect channel filter");
        app.getUiboHelper().clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        app.getUiboHelper().setClientPageFilter("message", "Password change code: 839429 (#3)");
        softAssert.assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'Password change code: 839429 (#3)')]")), "Incorrect message filter");
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='message'] input[type='text']"));

        app.getUiboHelper().setClientPageFilter("errMsg", "java");
        softAssert.assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'java.sql.SQLException: ORA-12899')]")), "Incorrect error message filter");
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='errMsg'] input[type='text']"));

        softAssert.assertAll();
    }
}