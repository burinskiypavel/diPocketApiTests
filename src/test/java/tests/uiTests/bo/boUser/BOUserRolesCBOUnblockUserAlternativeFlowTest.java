package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BOUserRolesCBOUnblockUserAlternativeFlowTest extends UITestBase {
    String boUser = "PAVELB";
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testBOUserRolesCBOUnblockUserAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoAllUsersTab();
        app.getUiboUserHelper().searchAndSelectBOUser("All users", "username", boUser);
        app.getUiboUserHelper().restoreBackUnblockUserIfUserIsBlocked(boUser);

        softAssert = app.getUiboUserHelper().verifyButtonsAreEnabled(true, true, true);
        app.getUiboUserHelper().blockUser("test");
        app.getUiboUserHelper().selectBOUser(boUser);
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Unblock user']")), "Unblock user");
        softAssert.assertFalse(app.getUiboHelper().isButtonEnabled3(By.cssSelector("p-button[ng-reflect-label='Block user']")), "Block user 2");
        app.getUiboUserHelper().pressUnblockUser();
        app.getUiboUserHelper().closePopUpAndVirifyPopUpClosing();

        app.getUiboUserHelper().restoreBackUnblockUserIfUserIsBlocked(boUser);
        softAssert.assertAll();
    }
}