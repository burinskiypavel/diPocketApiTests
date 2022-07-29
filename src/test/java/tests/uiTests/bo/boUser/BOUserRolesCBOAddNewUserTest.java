package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewUserTest extends UITestBase {
    String username = "PAVELB2";

    @Test //moved to api
    public void testBOUserRolesCBOAddNewUser() throws InterruptedException, SQLException, ClassNotFoundException {
        if(app.getDbHelper().isBOUserExistInDB(username)){
            app.getDbHelper().deleteBOUserFromDB(username);
        }

        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboHelper().click(By.cssSelector("app-button[ng-reflect-label='Add User']"));
        app.getUiboHelper().waitForSeveralItems(new String[]{"Role:", "Site:", "Firstname:",
                "Lastname:", "Phone:", "Email:", "Login (Username):",
                "Portal client(optional):", "Portal clients for management (optional):", "Upload Photo:"});

        assertTrue(app.getUiboHelper().isButtonEnabled(By.cssSelector("span.p-fileupload-choose span.p-button-label")));
        assertTrue(app.getUiboHelper().isButtonEnabled(By.cssSelector("p-button[ng-reflect-label='Add user")));

        app.getUiboHelper().selectFromSelectAddNewUserPage("role", "CBO");
        app.getUiboHelper().selectFromSelectAddNewUserPage("site", "SODEXO");
        app.getUiboHelper().fillBOUserFieldsInPopup("Pavel", "Burinskiy", "380685448615", "burinskiypavel@gmail.com", username);
        app.getUiboHelper().uploadFile(By.cssSelector("input[type='file']"), "C:/Work/Files/self.jpg");

        Thread.sleep(700);
        app.getUiboHelper().click(By.cssSelector("p-button[ng-reflect-label='Add user']"));
        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'User created successfully')]"));

        assertTrue(app.getDbHelper().isBOUserExistInDB(username));

        if(app.getDbHelper().isBOUserExistInDB(username)){
            app.getDbHelper().deleteBOUserFromDB(username);
        }
    }
}