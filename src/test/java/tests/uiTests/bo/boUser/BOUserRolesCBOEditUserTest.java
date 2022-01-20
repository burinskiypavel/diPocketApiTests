package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BOUserRolesCBOEditUserTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String random = app.generateRandomNumber(4);

    @Test
    public void testBOUserRolesCBOEditUser() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoAllUsersTab();
        searchAndSelectBOUser("All users", "username", "PAVELB");
        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Edit']"));
        waitForSeveralItems(new String[]{"Role:", "Site:", "Firstname:",
                "Lastname:", "Phone:", "Email:", "Login (Username):",
                "Portal client(optional):", "Portal clients for management (optional):", "Upload Photo:"});
        softAssert.assertTrue(isButtonEnabled(By.cssSelector("span.p-fileupload-choose span.p-button-label")));
        softAssert.assertTrue(isButtonEnabled(By.cssSelector("app-button[ng-reflect-label='Edit user")));
        editUser("Pavel" + random);
        waitFor(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='Pavel" + random+"']"));

        softAssert.assertTrue(isElementPresent(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='Pavel" + random+"']")));
        softAssert.assertAll();
    }
}