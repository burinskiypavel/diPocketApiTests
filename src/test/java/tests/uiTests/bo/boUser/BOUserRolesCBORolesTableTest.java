package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BOUserRolesCBORolesTableTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testBOUserRolesCBORolesTable() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboHelper().gotoRolesTab();

        softAssert.assertTrue(app.getUiboHelper().isTabActiveAndSelected(By.xpath("//a[@id='p-tabpanel-2-label'][@aria-selected='true']")));
        softAssert.assertTrue(app.getUiboHelper().isPageOpen(By.xpath("//div[@id='p-tabpanel-2'][@aria-hidden='false']")));

        app.getUiboHelper().click(By.cssSelector("p-dropdown[placeholder='Role']"));
        app.getUiboHelper().click(By.cssSelector("li[aria-label='1']"));

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Edit")));
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Delete")));

        softAssert.assertFalse(!app.getUiboHelper().areElementsPresent(new String[]{"//th[contains(text(), 'Code')]",
                "//th[contains(text(), 'Name')]", "//th[contains(text(), 'Description')]",
                "//th[contains(text(), 'Checked')]", }));

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[label='Update']")));
        softAssert.assertAll();
    }
}