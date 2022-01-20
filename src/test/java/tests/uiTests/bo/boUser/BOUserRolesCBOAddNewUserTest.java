package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewUserTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOAddNewUser() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        click(By.cssSelector("app-button[ng-reflect-label='Add User']"));
        waitForSeveralItems(new String[]{"Role:", "Site:", "Firstname:",
                "Lastname:", "Phone:", "Email:", "Login (Username):",
                "Portal client(optional):", "Portal clients for management (optional):", "Upload Photo:"});

        assertTrue(isButtonEnabled(By.cssSelector("span.p-fileupload-choose span.p-button-label")));
        assertTrue(isButtonEnabled(By.cssSelector("app-button[ng-reflect-label='Add user")));

        click(By.cssSelector("app-select-async[ng-reflect-label='Role']"));
        click(By.xpath("//ul[@role='listbox'] //span[contains(text(), 'CBO')]"));

        click(By.cssSelector("app-select-async[ng-reflect-label='Site']"));
        click(By.xpath("//ul[@role='listbox'] //span[contains(text(), 'SODEXO')]"));

        fillBOUserFieldsInPopup("Pavel", "Burinskiy", "380685448615", "burinskiypavel@gmail.com", "PavelB");
        uploadFile(By.cssSelector("input[type='file']"), "C:/Work/Files/self.jpg");

        click(By.cssSelector("app-button[ng-reflect-label='Add user']"));
        waitFor(By.xpath("//*[contains(text(), 'User created successfully')]"));
    }
}