package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        type(By.cssSelector("app-input[ng-reflect-label='Firstname'] input[type='text']"), "Pavel");
        type(By.cssSelector("app-input[ng-reflect-label='Lastname'] input[type='text']"), "Burinskiy");
        type(By.cssSelector("app-input[ng-reflect-label='Email'] input[type='text']"), "burinskiypavel@gmail.com");
        type(By.cssSelector("app-input-number[ng-reflect-label='Phone'] input.p-inputtext"), "12345678");

        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys("C:/Work/Files/self.jpg");
    }
}