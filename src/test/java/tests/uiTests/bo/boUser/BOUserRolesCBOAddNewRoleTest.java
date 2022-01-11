package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewRoleTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOAddNewRole() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoRolesTab();
        addRole("testqa1", "testqa2");
        selectRoleFromDropDown("testqa1");

        clickCheckbox(By.cssSelector("div[role='checkbox']"));
        click(By.cssSelector("app-button[label='Update']"));
        waitFor(By.xpath("//div[contains(text(), 'User role changed successfully')]"));

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role changed successfully')]")));

        click(By.cssSelector("app-button[label='Delete']"));
        click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
    }
}