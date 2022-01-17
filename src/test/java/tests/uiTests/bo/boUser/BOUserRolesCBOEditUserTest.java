package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOEditUserTest extends UITestBase {
    String random = app.generateRandomNumber(4);

    @Test
    public void testBOUserRolesCBOEditUser() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoAllUsersTab();
        type(By.cssSelector("p-tabpanel[header='All users'] p-columnfilter[field='username'] input[type='text']"), "PAVELB");

        Actions actions = new Actions(driver);
        Action seriesOfActions = actions
                .sendKeys(Keys.ENTER).build();
        seriesOfActions.perform() ;

        click(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='Burinskiy']"));
        waitFor(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Edit']"));
        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Edit']"));

        waitForSeveralItems(new String[]{"Role:", "Site:", "Firstname:",
                "Lastname:", "Phone:", "Email:", "Login (Username):",
                "Portal client(optional):", "Portal clients for management (optional):", "Upload Photo:"});

        assertTrue(isButtonEnabled(By.cssSelector("span.p-fileupload-choose span.p-button-label")));
        assertTrue(isButtonEnabled(By.cssSelector("app-button[ng-reflect-label='Edit user")));

        type(By.cssSelector("app-input[ng-reflect-label='Firstname'] input[type='text']"), "Pavel" + random);
        Thread.sleep(1200);
        click(By.cssSelector("app-button[ng-reflect-label='Edit user']"));
        waitFor(By.xpath("//*[contains(text(), 'User updated successfully')]"));
        waitFor(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='Pavel" + random+"']"));
    }
}