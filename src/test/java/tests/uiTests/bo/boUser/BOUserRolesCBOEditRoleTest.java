package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOEditRoleTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOEditRole() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoRolesTab();
        selectRoleFromDropDown("1");
        editUserRole("test2");

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role edited successfully')]")));
    }
}