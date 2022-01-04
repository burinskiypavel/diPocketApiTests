package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOEditRoleTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOEditRole() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        click(By.xpath("//p[contains(text(), 'BO Users')]"));
        waitFor(By.id("p-tabpanel-2-label"));
        click(By.id("p-tabpanel-2-label"));

        //click(By.cssSelector("app-button[label='+ Add']"));
        //waitForSeveralItems(new String[]{"Role ID:", "Role name:", "Add Role"});

        //type(By.cssSelector("app-input[ng-reflect-label='Role ID'] input[type='text']"), "testqa");

        //type(By.cssSelector("app-input[ng-reflect-label='Role name'] input[type='text']"), "testqa2");

        //click(By.cssSelector("app-button[ng-reflect-label='Add']"));


        click(By.cssSelector("p-dropdown[placeholder='Role']"));
        click(By.cssSelector("li[aria-label='1']"));

        click(By.cssSelector("app-button[label='Edit']"));

        type(By.cssSelector("div[role='dialog'] input[type='text']"), "test1");

        click(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']"));

        //clickCheckbox(By.cssSelector("div[role='checkbox']"));
        //click(By.cssSelector("app-button[label='Update']"));

        //assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role changed successfully')]")));

        //click(By.cssSelector("app-button[label='Delete']"));
        //click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
    }
}
