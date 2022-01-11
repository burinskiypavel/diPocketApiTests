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
        click(By.id("p-tabpanel-2-label"));

        click(By.cssSelector("app-button[label='+ Add']"));
        waitForSeveralItems(new String[]{"Role ID:", "Role name:", "Add Role"});

        type(By.cssSelector("app-input[ng-reflect-label='Role ID'] input[type='text']"), "testqa");

        type(By.cssSelector("app-input[ng-reflect-label='Role name'] input[type='text']"), "testqa2");
        Thread.sleep(1000);

        click(By.cssSelector("app-button[ng-reflect-label='Add']"));


        click(By.cssSelector("p-dropdown[placeholder='Role']"));
        //Thread.sleep(1000);
        click(By.cssSelector("li[aria-label='testqa']"));
        Thread.sleep(1000);

        clickCheckbox(By.cssSelector("div[role='checkbox']"));
        click(By.cssSelector("app-button[label='Update']"));
        waitFor(By.xpath("//div[contains(text(), 'User role changed successfully')]"));

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role changed successfully')]")));

        click(By.cssSelector("app-button[label='Delete']"));
        click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
    }
}
