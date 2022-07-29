package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BOUserRolesCBOEditUserTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String random = app.generateRandomNumber(4);

    @Test // moved to api
    public void testBOUserRolesCBOEditUser() throws InterruptedException {
        System.out.println("Random : " + random);
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboHelper().gotoAllUsersTab();
        app.getUiboHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        app.getUiboHelper().click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Edit']"));
        app.getUiboHelper().waitForSeveralItems(new String[]{"Role:", "Site:", "Firstname:",
                "Lastname:", "Phone:", "Email:", "Login (Username):",
                "Portal client(optional):", "Portal clients for management (optional):", "Upload Photo:"});
        softAssert.assertTrue(isButtonEnabled(By.cssSelector("span.p-fileupload-choose span.p-button-label")));
        softAssert.assertTrue(isButtonEnabled(By.cssSelector("p-button[ng-reflect-label='Edit user")));
        app.getUiboHelper().editUser("Pavel" + random);
        app.getUiboHelper().waitFor(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='Pavel" + random+"']"));

        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='Pavel" + random+"']")));
        softAssert.assertAll();
    }
}