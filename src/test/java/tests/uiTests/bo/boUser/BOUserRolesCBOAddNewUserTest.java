package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewUserTest extends UITestBase {
    String username = "PAVELB2";

    @Test
    public void testBOUserRolesCBOAddNewUser() throws InterruptedException, SQLException, ClassNotFoundException {
        if(app.getDbHelper().isBOUserExistInDB(username)){
            app.getDbHelper().deleteBOUserFromDB(username);
        }

        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoBOUsersPage();
        click(By.cssSelector("app-button[ng-reflect-label='Add User']"));
        waitForSeveralItems(new String[]{"Role:", "Site:", "Firstname:",
                "Lastname:", "Phone:", "Email:", "Login (Username):",
                "Portal client(optional):", "Portal clients for management (optional):", "Upload Photo:"});

        assertTrue(isButtonEnabled(By.cssSelector("span.p-fileupload-choose span.p-button-label")));
        assertTrue(isButtonEnabled(By.cssSelector("app-button[ng-reflect-label='Add user")));

        selectFromSelectAddNewUserPage("role", "CBO");
        selectFromSelectAddNewUserPage("site", "SODEXO");
        fillBOUserFieldsInPopup("Pavel", "Burinskiy", "380685448615", "burinskiypavel@gmail.com", username);
        uploadFile(By.cssSelector("input[type='file']"), "C:/Work/Files/self.jpg");

        Thread.sleep(700);
        click(By.cssSelector("app-button[ng-reflect-label='Add user']"));
        waitFor(By.xpath("//*[contains(text(), 'User created successfully')]"));

        assertTrue(app.getDbHelper().isBOUserExistInDB(username));

        if(app.getDbHelper().isBOUserExistInDB(username)){
            app.getDbHelper().deleteBOUserFromDB(username);
        }
    }
}