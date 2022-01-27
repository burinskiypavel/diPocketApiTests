package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOUnblockUserAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOUnblockUserAlternativeFlow() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoAllUsersTab();
        searchAndSelectBOUser("All users", "username", "PAVELB");
        if(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']"))){
            click(By.cssSelector("app-button[ng-reflect-label='Unblock user']"));
            click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
            waitFor(By.xpath("//*[contains(text(), 'User unblocked successfully')]"));
            selectBOUser("PAVELB");
        }

        assertTrue(isButtonEnabled2(By.cssSelector("app-button[ng-reflect-label='Edit']")));
        assertTrue(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Reset password']")));
        assertTrue(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Block user']")));

        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Block user']"));

        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));

        type(By.cssSelector("div[role='dialog'] input[type='text']"), "test");
        Thread.sleep(1000);
        click(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Block user']"));
        waitFor(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitFor(By.cssSelector("td[ng-reflect-text='Blocked']"));
        selectBOUser("PAVELB");
        assertTrue(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']")));
        Assert.assertFalse(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Block user']")));



        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Unblock user']"));
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to unblock user')]"));



        closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));

        assertFalse(isElementPresent(By.cssSelector("div[role='dialog']")));
    }
}