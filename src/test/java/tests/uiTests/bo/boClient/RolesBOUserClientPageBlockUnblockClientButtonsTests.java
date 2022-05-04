package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
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

        blockClient("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Blocked");
    }

    @Test
    public void testRolesBOUserClientPageUnblockClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Block client']"))){
            blockClient("test");
        }

        unblockClient();
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Active");
    }

    @Test
    public void testRolesBOUserClientPageBanClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }

        banClient("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Banned");

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }
    }

    @Test
    public void testRolesBOUserClientPageBanClientWithoutBlockingClientDevice() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }

        banClientWithoutBlockingClientDevice("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Banned");

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }
    }
}