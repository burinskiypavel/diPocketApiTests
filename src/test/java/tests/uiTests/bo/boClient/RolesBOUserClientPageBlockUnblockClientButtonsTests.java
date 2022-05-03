package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RolesBOUserClientPageBlockUnblockClientButtonsTests extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageBlockClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unblock client']"))){
            unblockClient();
        }

        blockClient();

        WebElement state = driver.findElements(By.cssSelector("p.ng-star-inserted")).get(0);
        String actualState = state.getText();

        assertEquals(actualState, "State: Blocked");
    }

    @Test
    public void testRolesBOUserClientPageUnblockClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Block client']"))){
            blockClient();
        }

        unblockClient();

        WebElement state = driver.findElements(By.cssSelector("p.ng-star-inserted")).get(0);
        String actualState = state.getText();

        assertEquals(actualState, "State: Active");
    }
}