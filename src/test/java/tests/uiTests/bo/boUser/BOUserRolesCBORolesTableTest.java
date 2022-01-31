package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BOUserRolesCBORolesTableTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testBOUserRolesCBORolesTable() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoRolesTab();

        softAssert.assertTrue(isTabActiveAndSelected(By.xpath("//a[@id='p-tabpanel-2-label'][@aria-selected='true']")));
        softAssert.assertTrue(isPageOpen(By.xpath("//div[@id='p-tabpanel-2'][@aria-hidden='false']")));

        click(By.cssSelector("p-dropdown[placeholder='Role']"));
        click(By.cssSelector("li[aria-label='1']"));

        softAssert.assertTrue(isButtonEnabled3(By.cssSelector("app-button[label='Edit")));
        softAssert.assertTrue(isButtonEnabled3(By.cssSelector("app-button[label='Delete")));

        softAssert.assertFalse(!areElementsPresent(new String[]{"//th[contains(text(), 'Code')]",
                "//th[contains(text(), 'Name')]", "//th[contains(text(), 'Description')]",
                "//th[contains(text(), 'Checked')]", }));

        softAssert.assertTrue(isButtonEnabled3(By.cssSelector("app-button[label='Update']")));
        softAssert.assertAll();
    }
}