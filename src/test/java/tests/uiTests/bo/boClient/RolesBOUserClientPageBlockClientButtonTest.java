package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RolesBOUserClientPageBlockClientButtonTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageBlockClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        click(By.xpath("//app-button[@ng-reflect-label='Block client']"));
        type(By.cssSelector("app-dynamic-form input[type='text']"), "test");
        Thread.sleep(1500);
        click(By.xpath("//app-button[@ng-reflect-label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Client was blocked successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Blocked')]"));

        WebElement state = driver.findElements(By.cssSelector("p.ng-star-inserted")).get(0);
        String actualState = state.getText();

        assertEquals(actualState, "State: Blocked");
    }
}