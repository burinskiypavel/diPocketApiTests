package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBORolesTableTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testBOUserRolesCBORolesTable() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoRolesTab();

        softAssert.assertTrue(app.getUiboHelper().isTabActiveAndSelected(By.xpath("//a[@id='p-tabpanel-3-label'][@aria-selected='true']")));
        softAssert.assertTrue(app.getUiboHelper().isPageOpen(By.xpath("//div[@id='p-tabpanel-3'][@aria-hidden='false']")));

        app.getUiboHelper().selectFromDropDown("id", "1");

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Edit")));
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Delete")));

        softAssert.assertFalse(!app.getUiboHelper().areElementsPresent(new String[]{"//th[contains(text(), 'Code')]",
                "//th[contains(text(), 'Name')]", "//th[contains(text(), 'Description')]"}));

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Update']")));
        softAssert.assertAll();
    }
}