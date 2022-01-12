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

    public void editUserRole(String roleName) {
        click(By.cssSelector("app-button[label='Edit']"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), roleName);
        click(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']"));
    }
}