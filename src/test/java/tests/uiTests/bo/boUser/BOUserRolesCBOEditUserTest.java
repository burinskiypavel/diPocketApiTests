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
        app.getUiboUserHelper().gotoAllUsersTab();
        app.getUiboUserHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        app.getUiboHelper().click(By.cssSelector("div.buttons-wrap p-button[ng-reflect-label='Edit']"));
        app.getUiboHelper().waitForSeveralItems(new String[]{"Role:", "Site:", "First name:",
                "Last name:", "Phone:", "Email:", "Login (Username):",
                "Portal client:", "Portal clients for management:", "Upload Photo:"});
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled(By.cssSelector("span.p-fileupload-choose span.p-button-label")));
        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled(By.cssSelector("p-button[ng-reflect-label='Confirm")));
        app.getUiboUserHelper().editUser("Pavel" + random);
        app.getUiboHelper().waitFor(By.cssSelector("p-tabpanel[header='All users'] td span[ng-reflect-text='Pavel" + random+"']"));

        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-tabpanel[header='All users'] td span[ng-reflect-text='Pavel" + random+"']")));
        softAssert.assertAll();
    }
}