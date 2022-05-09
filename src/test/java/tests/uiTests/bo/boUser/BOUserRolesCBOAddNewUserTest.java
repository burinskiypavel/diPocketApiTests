package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewUserTest extends UITestBase {
    String username = "PAVELB1";

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

        click(By.cssSelector("app-select-async[ng-reflect-name='role']"));
        waitFor(By.xpath("//ul[@role='listbox'] //span[contains(text(), 'CBO')]"));
        click(By.xpath("//ul[@role='listbox'] //span[contains(text(), 'CBO')]"));

        click(By.cssSelector("app-select-async[ng-reflect-name='site']"));
        waitFor(By.xpath("//ul[@role='listbox'] //span[contains(text(), 'SODEXO')]"));
        click(By.xpath("//ul[@role='listbox'] //span[contains(text(), 'SODEXO')]"));

        fillBOUserFieldsInPopup("Pavel", "Burinskiy", "380685448615", "burinskiypavel@gmail.com", username);
        uploadFile(By.cssSelector("input[type='file']"), "C:/Work/Files/self.jpg");

        Thread.sleep(500);
        click(By.cssSelector("app-button[ng-reflect-label='Add user']"));
        waitFor(By.xpath("//*[contains(text(), 'User created successfully')]"));

        assertTrue(app.getDbHelper().isBOUserExistInDB(username));

        if(app.getDbHelper().isBOUserExistInDB(username)){
            app.getDbHelper().deleteBOUserFromDB(username);
        }
    }
}