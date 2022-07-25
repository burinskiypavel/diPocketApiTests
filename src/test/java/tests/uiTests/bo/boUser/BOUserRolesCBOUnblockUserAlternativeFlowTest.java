package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BOUserRolesCBOUnblockUserAlternativeFlowTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testBOUserRolesCBOUnblockUserAlternativeFlow() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoAllUsersTab();
        searchAndSelectBOUser("All users", "username", "PAVELB");
        if(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']"))){
            unblockUser();
            selectBOUser("PAVELB");
        }

        softAssert.assertTrue(isButtonEnabled2(By.cssSelector("p-button[ng-reflect-label='Edit']")));
        softAssert.assertTrue(isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Reset password']")));
        softAssert.assertTrue(isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Block user']")));

        blockUser("test");

        selectBOUser("PAVELB");
        softAssert.assertTrue(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']")));
        softAssert.assertFalse(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Block user']")));

        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Unblock user']"));
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to unblock user')]"));

        closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
        softAssert.assertFalse(isElementPresent(By.cssSelector("div[role='dialog']")));

        if(isButtonEnabled3(By.cssSelector("app-button[ng-reflect-label='Unblock user']"))){
            unblockUser();
        }
        softAssert.assertAll();
    }
}