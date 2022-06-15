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
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToMessagesTab();

        softAssert.assertTrue(areElementsPresent(new String[]{"//table //th[contains(text(), 'Chanel')]",
                "//table //th[contains(text(), 'Created')]", "//table //th[contains(text(), 'Send')]",
        "//table //th[contains(text(), 'Messages')]", "//table //th[contains(text(), 'Error message')]"}), "Incorrect headers");

        waitFor(By.cssSelector("td[ng-reflect-text='S']"));
        setDropDownClientPageFilter("channel", "S");
        softAssert.assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='S']")), "Incorrect channel filter");
        softAssert.assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='P']")), "Incorrect channel filter");
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        setClientPageFilter("message", "Password change code: 839429 (#3)");
        softAssert.assertTrue(areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'Password change code: 839429 (#3)')]")), "Incorrect message filter");
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='message'] input[type='text']"));

        setClientPageFilter("errMsg", "java");
        softAssert.assertTrue(areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'java.sql.SQLException: ORA-12899')]")), "Incorrect error message filter");
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='errMsg'] input[type='text']"));

        softAssert.assertAll();
    }
}