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

        click(By.cssSelector("app-button[label='Edit']"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), "test2");
        click(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']"));


        //assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role changed successfully')]")));

        //click(By.cssSelector("app-button[label='Delete']"));
        //click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
    }
}